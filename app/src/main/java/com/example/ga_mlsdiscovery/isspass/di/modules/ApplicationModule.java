package com.example.ga_mlsdiscovery.isspass.di.modules;

import android.content.Context;

import com.example.ga_mlsdiscovery.isspass.apis.IssApiService;
import com.example.ga_mlsdiscovery.isspass.pojos.IssResponse;
import com.example.ga_mlsdiscovery.isspass.view.ListAdapterWithRecyclerView;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {
    private Context context;
    private String mBaseUrl = "http://api.open-notify.org/";

    public ApplicationModule(Context context){
        this.context = context;
    }

    @Provides
    Context contextProvider(){
        return this.context;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient providesOKHttpClient(){
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        return client.build();
        //TODO : add cache and loggin interceptor and Authentication
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    IssApiService providesIssApiService(Retrofit retrofit){
        return retrofit.create(IssApiService.class);
    }

    @Provides
    @Singleton
    ListAdapterWithRecyclerView providesListAdapterWithRecyclerView(Context context){
        this.context = context;
        return new ListAdapterWithRecyclerView(context);
    }

}
