package ru.a799000.alexander.anit2.ui.fragment.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import butterknife.ButterKnife;


public abstract class BaseFragment extends MvpAppCompatFragment {

    @LayoutRes
    protected abstract int getMainContentLayout();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(getMainContentLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    public String createToolbarTitle(Context context) {
        return context.getString(onCreateToolbarTitle());
    }

    @StringRes
    public abstract int onCreateToolbarTitle();


}
