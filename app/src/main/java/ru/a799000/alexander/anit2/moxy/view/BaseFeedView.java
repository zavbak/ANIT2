package ru.a799000.alexander.anit2.moxy.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface BaseFeedView extends MvpView {
    @StateStrategyType(SkipStrategy.class)
    void showMessage(String str);

    @StateStrategyType(SingleStateStrategy.class)
    void showRefreshing();

    @StateStrategyType(SingleStateStrategy.class)
    void hideRefreshing();

    @StateStrategyType(SingleStateStrategy.class)
    void showListProgress();

    @StateStrategyType(SingleStateStrategy.class)
    void hideListProgress();

    @StateStrategyType(SingleStateStrategy.class)
    void setTextSizeList();
}
