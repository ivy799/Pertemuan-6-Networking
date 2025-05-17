package com.example.pertemuan_6.data.network;

import com.example.pertemuan_6.data.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("users")
    Call<UserResponse> getListUsers(@Query("page") int page);
}
