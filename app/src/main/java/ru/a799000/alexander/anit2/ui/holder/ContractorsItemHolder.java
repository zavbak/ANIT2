package ru.a799000.alexander.anit2.ui.holder;


import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.a799000.alexander.anit2.R;
import ru.a799000.alexander.anit2.model.view.ContractorItemViewModel;

public class ContractorsItemHolder extends BaseViewHolder<ContractorItemViewModel> {

    @BindView(R.id.tv_contractor_name)
    public TextView tvName;

    @BindView(R.id.tv_contractor_code)
    public TextView tvCode;



    public ContractorsItemHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(ContractorItemViewModel item) {
        tvName.setText(item.getName());
        tvCode.setText(item.getCode());
    }

    @Override
    public void unbindViewHolder() {
        tvName.setText(null);
        tvCode.setText(null);
    }
}
