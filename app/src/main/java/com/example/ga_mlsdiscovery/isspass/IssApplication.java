package com.example.ga_mlsdiscovery.isspass;

import android.app.Application;

import com.example.ga_mlsdiscovery.isspass.di.components.AppComponent;
import com.example.ga_mlsdiscovery.isspass.di.components.DaggerAppComponent;
import com.example.ga_mlsdiscovery.isspass.di.modules.ApplicationModule;

public class IssApplication extends Application {
    private AppComponent appComponent;
    private static IssApplication issApplication;

    @Override
    public void onCreate() {
        issApplication = this;
        super.onCreate();
        appComponent = DaggerAppComponent.builder().applicationModule(new ApplicationModule(this)).build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
