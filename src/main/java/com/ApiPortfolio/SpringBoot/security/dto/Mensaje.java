
package com.ApiPortfolio.SpringBoot.security.dto;

import lombok.Getter;

@Getter
public class Mensaje {
       private String mensaje;

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
       
}
