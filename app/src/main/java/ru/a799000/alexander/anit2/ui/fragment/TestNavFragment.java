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
import ru.a799000.alexander.anit2.ui.fragment.base.BaseFragment;

import static ru.a799000.alexander.anit2.ui.navigate.MainActivityActions.DETAIL_ACTION;


public class TestNavFragment extends BaseFragment {

    public static TestNavFragment getNewInstance() {
        TestNavFragment fragment = new TestNavFragment();
        return fragment;
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.test_nav_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view =  inflater.inflate(R.layout.test_nav_fragment, container, false);
//        ButterKnife.bind(this, view);
//
//        return view;
//    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_test;
    }

    @Override
    public void setupToolbarToolBar() {
        mToolbar.getMenu().findItem(R.id.action_search).setVisible(false);
    }

    @OnClick(R.id.avatar_imageView)
    public void submit(View view) {
        ((MainActivity)getActivity()).getRouter().navigateTo(DETAIL_ACTION);
    }
}
