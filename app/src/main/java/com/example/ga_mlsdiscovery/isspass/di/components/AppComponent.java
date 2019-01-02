package com.example.ga_mlsdiscovery.isspass.di.components;

import com.example.ga_mlsdiscovery.isspass.MainActivity;
import com.example.ga_mlsdiscovery.isspass.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {ApplicationModule.class})
public interface AppComponent {
    void inject(MainActivity ma);
}
