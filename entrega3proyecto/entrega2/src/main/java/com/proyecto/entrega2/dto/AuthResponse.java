
package com.proyecto.entrega2.dto;

import com.proyecto.entrega2.entity.User;
import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private User user;

    public AuthResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    // Getters y Setters
}
