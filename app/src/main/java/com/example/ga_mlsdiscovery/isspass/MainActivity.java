package com.example.ga_mlsdiscovery.isspass;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ga_mlsdiscovery.isspass.apis.IssApiService;
import com.example.ga_mlsdiscovery.isspass.pojos.ISS;
import com.example.ga_mlsdiscovery.isspass.pojos.IssResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Inject
    IssApiService issApiService;
    private TextView textView;
    private ListView listView;
    private ArrayAdapter<IssResponse> issArrayAdapter;

    private List<IssResponse> issResponseList;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        textView = findViewById(R.id.text);
        listView = findViewById(R.id.listview);
        issResponseList = new ArrayList<>();
        //dagger
        ((IssApplication)getApplication()).getAppComponent().inject(this);

        Call<ISS> call = issApiService.getIssPass();
        call.enqueue(new Callback<ISS>() {
            @Override
            public void onResponse(Call<ISS> call, Response<ISS> response) {
                if(response.isSuccessful()){
                    Log.d("IssResponse-", "onResponse: "+response.body().getResponse());
                    issResponseList.clear();
                    issResponseList.addAll(response.body().getResponse());
                    issArrayAdapter.notifyDataSetChanged();
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


        issArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, issResponseList);
        listView.setAdapter(issArrayAdapter);
    }

}
