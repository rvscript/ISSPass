package com.example.ga_mlsdiscovery.isspass.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ga_mlsdiscovery.isspass.IssApplication;
import com.example.ga_mlsdiscovery.isspass.R;
import com.example.ga_mlsdiscovery.isspass.apis.IssApiService;
import com.example.ga_mlsdiscovery.isspass.pojos.ISS;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Inject
    IssApiService issApiService;

    @Inject
    ListAdapterWithRecyclerView issRecyclerview;

    private RecyclerView recyclerView;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        //Recyclerview
        recyclerView = findViewById(R.id.rv_main);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //dagger
        ((IssApplication)getApplication()).getAppComponent().inject(this);

        recyclerView.setAdapter(issRecyclerview);
        Call<ISS> call = issApiService.getIssPass();
        call.enqueue(new Callback<ISS>() {
            @Override
            public void onResponse(Call<ISS> call, Response<ISS> response) {
                if(response.isSuccessful()){
                    Log.d("IssResponse-", "onResponse: "+response.body().getResponse());
                    issRecyclerview.setData(response.body().getResponse());
                    //For debug purposes
//                    for (IssResponse ir: issResponseList) {
//                        textView.append("\n"+"riseTime:"+ir.getRisetime()
//                        +"\n"+"duration:"+ir.getDuration());
//                    }

                } else {
                    Log.e("onResponseError-", "onResponse: ");
                }
            }

            @Override
            public void onFailure(Call<ISS> call, Throwable t) {
                Log.e("onFailure-", "onFailure: "+getLocalClassName());
            }
        });

    }

}
