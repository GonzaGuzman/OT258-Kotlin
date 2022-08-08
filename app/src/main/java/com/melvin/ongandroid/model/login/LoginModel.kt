package com.melvin.ongandroid.model.login

import com.google.gson.annotations.SerializedName

data class LoginModel<T>(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("data")
    var data: List<Login>,
    @SerializedName("message")
    var message: String?
        )