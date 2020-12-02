package com.example.android.hilt.api

import com.android.koinlibrary.model.User
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by NguyenLinh on 12,November,2020
 */
interface ApiInterface {

    @GET("users")
    fun getUsers(): Call<List<User>>

}