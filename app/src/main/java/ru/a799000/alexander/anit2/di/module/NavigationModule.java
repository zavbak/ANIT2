package ru.a799000.alexander.anit2.di.module;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import ru.a799000.alexander.anit2.di.scope.ActivityScope;
import ru.a799000.alexander.anit2.ui.navigate.NavigateManager;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by terrakok 24.11.16
 */

@Module
public class NavigationModule {
    private Cicerone<Router> cicerone;
    private AppCompatActivity mActivity;


    public NavigationModule(AppCompatActivity activity) {
        cicerone = Cicerone.create();
        this.mActivity = activity;
    }


    @Provides
    @ActivityScope
    NavigateManager provideNavigateManager(){
            return new NavigateManager(mActivity);
    }

    @Provides
    @ActivityScope
    Navigator provideNavigator(NavigateManager navigateManager){
        return navigateManager.getNavigator();
    }

    @Provides
    @ActivityScope
    Router provideRouter() {
        return cicerone.getRouter();
    }

    @Provides
    @ActivityScope
    NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }
}
