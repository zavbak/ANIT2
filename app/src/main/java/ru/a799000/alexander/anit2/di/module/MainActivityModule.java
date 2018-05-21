package ru.a799000.alexander.anit2.di.module;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import ru.a799000.alexander.anit2.di.scope.ActivityScope;
import ru.a799000.alexander.anit2.ui.activity.MainActivity;
import ru.a799000.alexander.anit2.ui.navigate.NavigateManager;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class MainActivityModule {

    MainActivity mMainActivity;
    private Cicerone<Router> cicerone;


    public MainActivityModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
        cicerone = Cicerone.create();
    }

    @Provides
    @ActivityScope
    AppCompatActivity provideAppCompatActivity(){
        return mMainActivity;
    }

    @Provides
    @ActivityScope
    NavigateManager provideNavigateManager(){
        return new NavigateManager(mMainActivity);
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
