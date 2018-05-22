package ru.a799000.alexander.anit2.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.a799000.alexander.anit2.R;
import ru.a799000.alexander.anit2.ui.activity.MainActivity;

import static ru.a799000.alexander.anit2.ui.navigate.MainActivityActions.DETAIL_ACTION;


public class TestNavFragment extends MvpAppCompatFragment {

    public static TestNavFragment getNewInstance() {
        TestNavFragment fragment = new TestNavFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.test_nav_fragment, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.avatar_imageView)
    public void submit(View view) {
        ((MainActivity)getActivity()).getRouter().navigateTo(DETAIL_ACTION);
    }
}
