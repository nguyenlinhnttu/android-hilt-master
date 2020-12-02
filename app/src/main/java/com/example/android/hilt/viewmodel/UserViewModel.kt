package com.example.android.hilt.viewmodel

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.android.koinlibrary.model.User
import com.example.android.hilt.data.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by NguyenLinh on 12,November,2020
 */
class UserViewModel @ViewModelInject constructor(
    private val repo: UserRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    private val _data = MutableLiveData<List<User>>()
    val data: LiveData<List<User>>
        get() = _data

    fun fetchData() {
        repo.getAllUsers().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d("onFailure", t.message)
            }

            override fun onResponse(
                call: Call<List<User>>,
                response: Response<List<User>>
            ) {
                if (response.isSuccessful) {
                    _data.postValue(response.body())
                }
            }

        })
    }

}