package ru.a799000.alexander.anit2.di.component;

import dagger.Subcomponent;
import ru.a799000.alexander.anit2.di.module.MainActivityModule;
import ru.a799000.alexander.anit2.di.module.NavigationModule;
import ru.a799000.alexander.anit2.di.scope.ActivityScope;
import ru.a799000.alexander.anit2.ui.activity.MainActivity;

@ActivityScope
@Subcomponent(
        modules = {MainActivityModule.class}
)
public interface MainActivityComponent {
    MainActivity inject(MainActivity mainActivity);
}
