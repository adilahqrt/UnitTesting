package com.lightlance.simpleauth.api;

import com.lightlance.simpleauth.api.model.LoginUser;
import com.lightlance.simpleauth.api.model.RegisterUser;
import com.lightlance.simpleauth.api.responses.LoginResponse;
import com.lightlance.simpleauth.api.responses.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("auth/login")
    Call<LoginResponse> login(@Body LoginUser loginUser);

    @POST("auth/register")
    Call<RegisterResponse> register(@Body RegisterUser registerUser);
}
