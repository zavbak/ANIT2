package ru.a799000.alexander.anit2.moxy.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import ru.a799000.alexander.anit2.App;
import ru.a799000.alexander.anit2.common.AuthManager;
import ru.a799000.alexander.anit2.model.ContractorMod;
import ru.a799000.alexander.anit2.model.TaskMod;
import ru.a799000.alexander.anit2.model.view.BaseFeedViewModel;
import ru.a799000.alexander.anit2.model.view.BaseViewModel;
import ru.a799000.alexander.anit2.model.view.ContractorItemViewModel;
import ru.a799000.alexander.anit2.model.view.TaskItemViewModel;
import ru.a799000.alexander.anit2.moxy.view.BaseFeedView;
import ru.a799000.alexander.anit2.repo.rest.methods.contractors.ContractorsGetApi;
import ru.a799000.alexander.anit2.repo.rest.methods.contractors.ContractorsGetRqMod;
import ru.a799000.alexander.anit2.repo.rest.methods.contractors.ContractorsGetRsMod;
import ru.a799000.alexander.anit2.repo.rest.methods.tasks.TasksGetApi;
import ru.a799000.alexander.anit2.repo.rest.methods.tasks.TasksGetRqMod;
import ru.a799000.alexander.anit2.repo.rest.methods.tasks.TasksGetRsMod;


@InjectViewState
public class TasksPresenter extends BaseFeedPresenter<BaseFeedView> {


    @Inject
    TasksGetApi mTasksGetApi;

    public TasksPresenter() {
        App.getApplicationComponent().inject(this);
    }

    @Override
    Single<BaseFeedViewModel<BaseViewModel>> onLoadViewModelObservableTest() {
        return null;
    }


    @Override
    public Single<BaseFeedViewModel<BaseViewModel>> onCreateLoadDataObservable(int count, int offset, String filterName) {

       return mTasksGetApi.getData(new TasksGetRqMod().toMap(),
                AuthManager.getAuthStr())
                .map(tasksGetRsModBaseRsMod -> tasksGetRsModBaseRsMod.response)
                .map(tasksGetRsMod -> transformModelBaseFeedViewModel(tasksGetRsMod));

    }

    @Override
    void setTextSizeList() {
        getViewState().setTextSizeList();
    }

    BaseFeedViewModel<BaseViewModel> transformModelBaseFeedViewModel(TasksGetRsMod tasksGetRsMod){

        BaseFeedViewModel<BaseViewModel> baseFeedViewModel = new BaseFeedViewModel();
        List<TaskMod> list = tasksGetRsMod.getTasks();

        List<BaseViewModel> litConItemVM = new ArrayList<>();
        for (TaskMod item : list) {
            litConItemVM.add(new TaskItemViewModel(item));
        }

        baseFeedViewModel.setFullSizeRs(tasksGetRsMod.getFullSize());

        baseFeedViewModel.setViewModelList(litConItemVM);
        return baseFeedViewModel;
    }

}
