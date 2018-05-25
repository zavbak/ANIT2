package ru.a799000.alexander.anit2.ui.fragment;



import android.support.v7.widget.SearchView;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.jakewharton.rxbinding2.support.v7.widget.RxSearchView;


import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.a799000.alexander.anit2.R;
import ru.a799000.alexander.anit2.common.BaseAdapter;
import ru.a799000.alexander.anit2.moxy.presenter.BaseFeedPresenter;
import ru.a799000.alexander.anit2.moxy.presenter.ContractorsPresenter;
import ru.a799000.alexander.anit2.moxy.view.BaseFeedView;
import ru.a799000.alexander.anit2.ui.fragment.base.BaseFeedFragment;


public class ContractorsFeedFragment extends BaseFeedFragment {

    @InjectPresenter
    ContractorsPresenter mContractorsPresenter;

    public static ContractorsFeedFragment getNewInstance() {
        ContractorsFeedFragment fragment = new ContractorsFeedFragment();
        return fragment;
    }


    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        return mContractorsPresenter;
    }

    @Override
    protected void onSwipe() {
        mPresenter.OnSwipe();
        //mContractorsPresenter.onLoadViewModelObservable();
    }

    @Override
    protected void onScroll() {
        mPresenter.onScroll();
    }

    
    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_contractors;
    }




    @Override
    public void showMessage(String str) {
        Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();
    }


}
