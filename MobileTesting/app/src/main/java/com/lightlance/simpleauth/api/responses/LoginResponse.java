package com.lightlance.simpleauth.api.responses;

import com.lightlance.simpleauth.api.model.User;

public class LoginResponse {
    private String status;
    private User user;

    public String getStatus() {
        return status;
    }
}
