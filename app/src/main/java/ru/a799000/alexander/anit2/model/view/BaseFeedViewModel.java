package ru.a799000.alexander.anit2.model.view;

import java.util.List;

public class BaseFeedViewModel<T extends BaseViewModel> {
    int fullSizeRs;

    List<T> mViewModelList;

    public int getFullSizeRs() {
        return fullSizeRs;
    }

    public void setFullSizeRs(int fullSizeRs) {
        this.fullSizeRs = fullSizeRs;
    }

    public List<T> getViewModelList() {
        return mViewModelList;
    }

    public void setViewModelList(List<T> viewModelList) {
        mViewModelList = viewModelList;
    }
}
