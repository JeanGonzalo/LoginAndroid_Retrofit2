package com.example.remote;

import com.example.modelo.Usuario;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST("login.php")
    Call<Usuario> login(
            @Field("correo") String correo,
            @Field("password") String password
    );


}
