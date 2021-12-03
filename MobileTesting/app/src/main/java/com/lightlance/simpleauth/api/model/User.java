package com.lightlance.simpleauth.api.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id_user")
    private String id;
    private String email;
    private String password;
    @SerializedName("fullname")
    private String fullName;
    private String gender;
    @SerializedName("alamat")
    private String address;
    @SerializedName("no_telp")
    private String phone;
    @SerializedName("saldo")
    private String balance;
}
