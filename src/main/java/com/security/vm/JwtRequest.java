package com.security.vm;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 592648583005150707L;
    private String username;
    private String password;
}
