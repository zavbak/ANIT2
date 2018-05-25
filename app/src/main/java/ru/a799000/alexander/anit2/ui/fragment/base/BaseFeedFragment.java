package ru.a799000.alexander.anit2.ui.fragment.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.TextView;

import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerView;
import com.jakewharton.rxbinding2.support.v7.widget.RxSearchView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.a799000.alexander.anit2.R;
import ru.a799000.alexander.anit2.common.MyLinearLayoutManager;
import ru.a799000.alexander.anit2.moxy.presenter.BaseFeedPresenter;
import ru.a799000.alexander.anit2.moxy.view.BaseFeedView;


public abstract class BaseFeedFragment extends BaseFragment implements BaseFeedView {

    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;

    @BindView(R.id.tv_size)
    TextView tvSize;

    @BindView(R.id.swipe_refresh)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    protected BaseFeedPresenter mPresenter;

    String mSearchString;



    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = onCreateFeedPresenter();
        setUpSwipeToRefreshLayout(view);
        setUpRecyclerView();


        mPresenter.onStart();
        setUpAdapter();
    }

    @Override
    public void setTextSizeList() {
        tvSize.setText(mPresenter.getTextCount());
    }

    @Override
    public void showRefreshing() {
    }

    @Override
    public void hideRefreshing() {
        mSwipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void showListProgress() {
        //mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideListProgress() {
        //mProgressBar.setVisibility(View.GONE);
    }


    private void setUpRecyclerView() {
        MyLinearLayoutManager mLinearLayoutManager = new MyLinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        RxRecyclerView.scrollEvents(mRecyclerView)
                .skip(1)
                .debounce(300, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(recyclerViewScrollEvent -> {
                    if (mLinearLayoutManager.isOnNextPagePosition()) {
                        onScroll();
                    }
                });

        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        SearchView searchView = (SearchView) mToolbar.getMenu().findItem(R.id.action_search).getActionView();
        searchView.getQuery().toString();
        outState.putString("key", searchView.getQuery().toString());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mSearchString = savedInstanceState.getString("key");
        }

    }

    @Override
    public void setupToolbarToolBar() {
        mToolbar.getMenu().findItem(R.id.action_search).setVisible(true);
        SearchView searchView = (SearchView) mToolbar.getMenu().findItem(R.id.action_search).getActionView();


        if (mSearchString != null && !mSearchString.isEmpty()) {
            mToolbar.getMenu().findItem(R.id.action_search).expandActionView();
            searchView.setQuery(mSearchString, true);
            searchView.clearFocus();
        }


        RxSearchView.queryTextChanges(searchView)
                .skip(1)
                .debounce(400, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .filter(S->S.length()>2 || S.length() == 0)
                //.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s->{
                    mPresenter.setFilter(s);
                });

    }


    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    protected void setUpAdapter() {
        mRecyclerView.setAdapter(mPresenter.getAdapter());
    }


    private void setUpSwipeToRefreshLayout(View rootView) {
        mSwipeRefreshLayout.setOnRefreshListener(() -> onSwipe());
    }

    protected abstract BaseFeedPresenter onCreateFeedPresenter();

    protected abstract void onSwipe();

    protected abstract void onScroll();


}
