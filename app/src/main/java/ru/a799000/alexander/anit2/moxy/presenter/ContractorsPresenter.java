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
import ru.a799000.alexander.anit2.model.view.BaseFeedViewModel;
import ru.a799000.alexander.anit2.model.view.BaseViewModel;
import ru.a799000.alexander.anit2.model.view.ContractorItemViewModel;
import ru.a799000.alexander.anit2.moxy.view.BaseFeedView;
import ru.a799000.alexander.anit2.repo.rest.methods.contractors.ContractorsGetApi;
import ru.a799000.alexander.anit2.repo.rest.methods.contractors.ContractorsGetRqMod;
import ru.a799000.alexander.anit2.repo.rest.methods.contractors.ContractorsGetRsMod;


@InjectViewState
public class ContractorsPresenter extends BaseFeedPresenter<BaseFeedView> {


    @Inject
    ContractorsGetApi mContractorsGetApi;

    public ContractorsPresenter() {
        App.getApplicationComponent().inject(this);
    }

    @Override
    Single<BaseFeedViewModel<BaseViewModel>> onLoadViewModelObservableTest() {
        return Observable.range(1, 100)
                .map(integer -> {
                    ContractorMod contractorMod = new ContractorMod();
                    contractorMod.code = integer.toString();
                    contractorMod.name = "name " + integer;
                    return contractorMod;
                })
                .map(contractorMod -> new ContractorItemViewModel(contractorMod))
                .reduce(new ArrayList<>(), (list, item) -> {
                    list.add(item);
                    return list;
                })
                .map(contractorItemViewModels -> {
                    BaseFeedViewModel baseFeedViewModel = new BaseFeedViewModel();
                    baseFeedViewModel.setViewModelList(contractorItemViewModels);
                    return baseFeedViewModel;
                });
    }


    @Override
    public Single<BaseFeedViewModel<BaseViewModel>> onCreateLoadDataObservable(int count, int offset, String filterName) {

       return mContractorsGetApi.getData(new ContractorsGetRqMod(count, offset, filterName).toMap(),
                AuthManager.getAuthStr())
                .map(contractorsGetRsModBaseRsMod -> contractorsGetRsModBaseRsMod.response)
                .map(contractorsGetRsMod -> transformModelBaseFeedViewModel(contractorsGetRsMod));

    }

    @Override
    void setTextSizeList() {
        getViewState().setTextSizeList();
    }

    BaseFeedViewModel<BaseViewModel> transformModelBaseFeedViewModel(ContractorsGetRsMod contractorsGetRsMod){

        BaseFeedViewModel<BaseViewModel> baseFeedViewModel = new BaseFeedViewModel();
        List<ContractorMod> list = contractorsGetRsMod.getContractors();

        List<BaseViewModel> litConItemVM = new ArrayList<>();
        for (ContractorMod item : list) {
            litConItemVM.add(new ContractorItemViewModel(item));
        }

        baseFeedViewModel.setFullSizeRs(contractorsGetRsMod.getFullSize());

        baseFeedViewModel.setViewModelList(litConItemVM);
        return baseFeedViewModel;
    }

}
