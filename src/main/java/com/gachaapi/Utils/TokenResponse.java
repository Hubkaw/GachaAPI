package com.gachaapi.Utils;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenResponse {

    private String token;
    private String tokenType;

}
