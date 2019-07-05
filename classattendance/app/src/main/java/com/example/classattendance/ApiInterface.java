package com.example.classattendance;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("registeruser.php")
    Call<User> performRegistration(@Query("name") String name,@Query("user_type") String user_type,@Query("user_name") String user_name,@Query("password") String password);

    @GET("loginuser.php")
    Call<User> performUserLogin(@Query("user_name") String user_name,@Query("password") String password);
}
