package ru.a799000.alexander.anit2.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.a799000.alexander.anit2.App;
import ru.a799000.alexander.anit2.R;
import ru.a799000.alexander.anit2.di.module.MainActivityModule;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
    }

    @Override
    protected void setupActivityComponent() {
       App.getApplicationComponent()
                .plus(new MainActivityModule(this))
                .inject(this);
    }

    public void setToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
