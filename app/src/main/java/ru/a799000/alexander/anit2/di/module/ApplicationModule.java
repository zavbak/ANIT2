package ru.a799000.alexander.anit2.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.a799000.alexander.anit2.di.scope.ActivityScope;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class ApplicationModule {

    private Application mApplication;


    public ApplicationModule(Application application) {
        mApplication = application;

    }

    @Singleton
    @Provides
    public Context provideContext() {
        return mApplication;
    }



}
