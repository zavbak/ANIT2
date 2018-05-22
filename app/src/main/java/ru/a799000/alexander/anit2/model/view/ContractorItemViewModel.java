package ru.a799000.alexander.anit2.model.view;

import android.view.View;

import ru.a799000.alexander.anit2.model.ContractorMod;
import ru.a799000.alexander.anit2.ui.holder.ContractorsItemHolder;


public class ContractorItemViewModel extends BaseViewModel {


    private String mName;
    private String mCode;



    public ContractorItemViewModel(ContractorMod contractor) {
        this.mCode = contractor.code;
        this.mName = contractor.name;
    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.ContractorItem;
    }

    @Override
    public ContractorsItemHolder onCreateViewHolder(View view) {
        return new ContractorsItemHolder(view);
    }


    public String getName() {
        return mName;
    }

    public String getCode() {
        return mCode;
    }

    @Override
    public boolean isItemDecorator() {
        return false;
    }
}
