package ru.a799000.alexander.anit2.ui.fragment;


import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.a799000.alexander.anit2.R;
import ru.a799000.alexander.anit2.moxy.presenter.BaseFeedPresenter;
import ru.a799000.alexander.anit2.moxy.presenter.ContractorsPresenter;
import ru.a799000.alexander.anit2.moxy.presenter.TasksPresenter;
import ru.a799000.alexander.anit2.ui.fragment.base.BaseFeedFragment;


public class TasksFeedFragment extends BaseFeedFragment {

    @InjectPresenter
    TasksPresenter mTasksPresenter;

    public static TasksFeedFragment getNewInstance() {
        TasksFeedFragment fragment = new TasksFeedFragment();
        return fragment;
    }


    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        return mTasksPresenter;
    }

    @Override
    protected void onSwipe() {
        mPresenter.OnSwipe();
    }

    @Override
    protected void onScroll() {

    }

    
    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_tasks;
    }




    @Override
    public void showMessage(String str) {
        Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();
    }


}
