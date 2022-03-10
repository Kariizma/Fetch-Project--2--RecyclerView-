package com.example.fetchproject;

import com.example.fetchproject.Hiring;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface HiringAPI {
    @GET("hiring.json")
    Call<List<Hiring>> getHiring();
}
