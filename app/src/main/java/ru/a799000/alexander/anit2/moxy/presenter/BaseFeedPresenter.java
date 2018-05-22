package ru.a799000.alexander.anit2.moxy.presenter;

import com.arellomobile.mvp.MvpPresenter;

import java.util.Date;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.a799000.alexander.anit2.App;
import ru.a799000.alexander.anit2.common.BaseAdapter;
import ru.a799000.alexander.anit2.model.view.BaseFeedViewModel;
import ru.a799000.alexander.anit2.model.view.BaseViewModel;
import ru.a799000.alexander.anit2.moxy.view.BaseFeedView;


public abstract class BaseFeedPresenter<V extends BaseFeedView> extends MvpPresenter<V> {

    BaseAdapter mAdapter;

    public static final int START_PAGE_SIZE = 40;
    public static final int NEXT_PAGE_SIZE = 40;

    private final CompositeDisposable disposables = new CompositeDisposable();




    public BaseFeedPresenter() {
        mAdapter = new BaseAdapter();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadData(START_PAGE_SIZE,0,"",true);
    }

    public void onStart() {

    }

    private void loadData(int count, int offset, String filterNmae,boolean refresh) {
        onCreateLoadDataObservable(count, offset, filterNmae)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    getViewState().showMessage("Загрузка " + new Date().toString());
                })
                .doFinally(() -> {
                    //getViewState().showMessage("Конец " + new Date().toString());
                    getViewState().hideRefreshing();
                })
                .subscribe(baseFeedViewModel -> {
                    if (refresh == true){
                        mAdapter.setItems(baseFeedViewModel.getViewModelList(), baseFeedViewModel.getFullSizeRs());
                    }else{
                        mAdapter.addItems(baseFeedViewModel.getViewModelList(), baseFeedViewModel.getFullSizeRs());
                    }
                    getViewState().setTextSizeList("" + mAdapter.getRealItemCount() + "/" + baseFeedViewModel.getFullSizeRs());
                }, error -> {
                    getViewState().showMessage("ошибка " + new Date().toString() + "\n " + error.getMessage());

                });
    }

    public void onStop() {

    }

    public void OnSwipe() {
        loadData(START_PAGE_SIZE,0,"",true);
    }


    public void onScroll() {
        if (mAdapter.getItemCount()>0){
            loadData(NEXT_PAGE_SIZE,mAdapter.getItemCount(),"",false);
        }
    }

    public BaseAdapter getAdapter() {
        return mAdapter;
    }

    abstract Single<BaseFeedViewModel<BaseViewModel>> onLoadViewModelObservableTest();

    abstract Single<BaseFeedViewModel<BaseViewModel>> onCreateLoadDataObservable(int count, int offset, String filterName);


}
