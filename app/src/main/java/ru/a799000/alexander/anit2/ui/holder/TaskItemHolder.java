package ru.a799000.alexander.anit2.ui.holder;


import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.a799000.alexander.anit2.R;
import ru.a799000.alexander.anit2.model.view.ContractorItemViewModel;
import ru.a799000.alexander.anit2.model.view.TaskItemViewModel;

public class TaskItemHolder extends BaseViewHolder<TaskItemViewModel> {

    @BindView(R.id.tv_task_description)
    public TextView tvDecription;

    @BindView(R.id.tv_task_date)
    public TextView tvDate;



    public TaskItemHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(TaskItemViewModel item) {
        tvDecription.setText(item.getDescription());
        tvDate.setText(item.getDate().toString());
    }

    @Override
    public void unbindViewHolder() {
        tvDecription.setText(null);
        tvDate.setText(null);
    }
}
