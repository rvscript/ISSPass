package com.example.ga_mlsdiscovery.isspass.apis;

import com.example.ga_mlsdiscovery.isspass.pojos.ISS;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IssApiService {
    @GET("iss-pass.json?lat=39.961178&lon=-82.998795")
    Call<ISS> getIssPass();
}
