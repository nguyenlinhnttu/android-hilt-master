package com.example.android.hilt.data

import com.example.android.hilt.api.ApiInterface
import javax.inject.Inject

/**
 * Created by NguyenLinh on 12,November,2020
 */
class UserRepository @Inject constructor(private val apiInterface: ApiInterface) {
    fun getAllUsers() = apiInterface.getUsers()
}