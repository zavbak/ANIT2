package ru.a799000.alexander.anit2.model.view;

import android.view.View;

import java.util.Date;

import ru.a799000.alexander.anit2.model.ContractorMod;
import ru.a799000.alexander.anit2.model.TaskMod;
import ru.a799000.alexander.anit2.ui.holder.ContractorsItemHolder;
import ru.a799000.alexander.anit2.ui.holder.TaskItemHolder;


public class TaskItemViewModel extends BaseViewModel {


    private String mDescription;
    private Date mDate;



    public TaskItemViewModel(TaskMod taskMod) {
        this.mDescription = taskMod.description;
        this.mDate = taskMod.date;
    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.TaskItem;
    }



    @Override
    public TaskItemHolder onCreateViewHolder(View view) {
        return new TaskItemHolder(view);
    }


    public String getDescription() {
        return mDescription;
    }

    public Date getDate() {
        return mDate;
    }

    @Override
    public boolean isItemDecorator() {
        return false;
    }
}
