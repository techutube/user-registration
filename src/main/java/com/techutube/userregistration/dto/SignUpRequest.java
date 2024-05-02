package com.techutube.userregistration.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String password;
}
