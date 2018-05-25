package ru.a799000.alexander.anit2.moxy.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Date;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.a799000.alexander.anit2.common.BaseAdapter;
import ru.a799000.alexander.anit2.model.view.BaseFeedViewModel;
import ru.a799000.alexander.anit2.model.view.BaseViewModel;
import ru.a799000.alexander.anit2.moxy.view.BaseFeedView;


public abstract class BaseFeedPresenter<V extends BaseFeedView> extends MvpPresenter<V> {

    BaseAdapter mAdapter;

    public static final int START_PAGE_SIZE = 40;
    public static final int NEXT_PAGE_SIZE = 40;



    String mFilter;
    String mTextCount;



    public BaseFeedPresenter() {
        mAdapter = new BaseAdapter();
        this.mFilter = "";
        this.mTextCount = "";
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadData(START_PAGE_SIZE,0,true);
    }

    public void onStart() {

    }

    private void loadData(int count, int offset,boolean refresh) {

        onCreateLoadDataObservable(count, offset, mFilter)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    getViewState().showMessage("Загрузка " + new Date().toString());
                })
                .doFinally(() -> {
                    //getViewState().showMessage("Конец " + new Date().toString());
                    getViewState().hideRefreshing();
                    getViewState().setTextSizeList();
                })
                .subscribe(baseFeedViewModel -> {
                    if (refresh == true){
                        mAdapter.setItems(baseFeedViewModel.getViewModelList(), baseFeedViewModel.getFullSizeRs());
                    }else{
                        mAdapter.addItems(baseFeedViewModel.getViewModelList(), baseFeedViewModel.getFullSizeRs());
                    }

                    mTextCount = "" + mAdapter.getRealItemCount() + "/" + baseFeedViewModel.getFullSizeRs();


                }, error -> {
                    getViewState().showMessage("ошибка " + new Date().toString() + "\n " + error.getMessage());
                    mTextCount = "";

                });
    }

    public String getTextCount() {
        return mTextCount;
    }

    public void onStop() {

    }

    public String getFilter() {
        return mFilter;
    }

    public void OnSwipe() {
        loadData(START_PAGE_SIZE,0,true);
    }


    public void onScroll() {
        if (mAdapter.getItemCount()>0){
            loadData(NEXT_PAGE_SIZE,mAdapter.getItemCount(),false);
        }
    }

    public BaseAdapter getAdapter() {
        return mAdapter;
    }

    abstract Single<BaseFeedViewModel<BaseViewModel>> onLoadViewModelObservableTest();

    abstract Single<BaseFeedViewModel<BaseViewModel>> onCreateLoadDataObservable(int count, int offset, String filterName);


    public void setFilter(String filter) {
        this.mFilter = filter;
        loadData(START_PAGE_SIZE,0,true);
    }

    abstract void setTextSizeList();
}
