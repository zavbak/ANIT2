package ru.a799000.alexander.anit2.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.a799000.alexander.anit2.di.module.ApplicationModule;
import ru.a799000.alexander.anit2.di.module.MainActivityModule;
import ru.a799000.alexander.anit2.di.module.NavigationModule;
import ru.a799000.alexander.anit2.di.module.RestModule;
import ru.a799000.alexander.anit2.moxy.presenter.BaseFeedPresenter;
import ru.a799000.alexander.anit2.moxy.presenter.ContractorsPresenter;
import ru.a799000.alexander.anit2.ui.activity.BaseActivity;


@Singleton
@Component(modules = {ApplicationModule.class, RestModule.class})
public interface AppComponent {

    MainActivityComponent plus(MainActivityModule module);

    void inject(ContractorsPresenter contractorsPresenter);
}
