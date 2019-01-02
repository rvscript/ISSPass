package com.example.ga_mlsdiscovery.isspass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ga_mlsdiscovery.isspass.apis.IssApiService;
import com.example.ga_mlsdiscovery.isspass.pojos.ISS;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Inject
    IssApiService issApiService;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);

        //dagger
        ((IssApplication)getApplication()).getAppComponent().inject(this);

        Call<ISS> call = issApiService.getIssPass();
        call.enqueue(new Callback<ISS>() {
            @Override
            public void onResponse(Call<ISS> call, Response<ISS> response) {
                response.body().getResponse();
                Log.i("results:", "onResponse: "+response.body().getResponse());
            }

            @Override
            public void onFailure(Call<ISS> call, Throwable t) {

            }
        });
    }

}
