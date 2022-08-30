
package com.ApiPortfolio.SpringBoot.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class JwtDto {
    private String token;
    private String bearer = "Bearer ";

    public JwtDto(String token) {
        this.token = token;
    }
    public JwtDto() {
        
    }
    
    
}
