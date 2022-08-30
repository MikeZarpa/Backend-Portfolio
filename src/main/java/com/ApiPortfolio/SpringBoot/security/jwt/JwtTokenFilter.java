
package com.ApiPortfolio.SpringBoot.security.jwt;

import com.ApiPortfolio.SpringBoot.security.service.UserDetailsServiceImpl;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtTokenFilter extends OncePerRequestFilter{

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
    
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = getToken(request);
            if(token != null && jwtProvider.validateToken(token)){
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,null,null);
                SecurityContextHolder.getContext().setAuthentication(auth);                
            }
        }
        catch(Exception e){
            logger.error("Fail en el método doFilterInternal");
        }
        filterChain.doFilter(request, response);
    }
    private String getToken(HttpServletRequest request){
        //Nuestros tokens vienen en el header de forma: 'Authorization': 'Bearer TOKEN'
        //De ser posible devolvemos el TOKEN
        String TOKEN = request.getHeader("Authorization");
        if(TOKEN!=null && TOKEN.startsWith("Bearer")){
            return TOKEN.replace("Bearer ","");
        }
        return TOKEN;
    }    
}
