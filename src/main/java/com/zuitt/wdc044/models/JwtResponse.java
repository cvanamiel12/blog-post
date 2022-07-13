package com.zuitt.wdc044.models;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    //JwtResponse create model for token response
    private static final long serialVersionUID = -8091879091924046844L;

    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }

}
