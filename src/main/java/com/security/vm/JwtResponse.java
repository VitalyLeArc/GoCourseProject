package com.security.vm;

import lombok.Data;

@Data
public class JwtResponse {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;
}
