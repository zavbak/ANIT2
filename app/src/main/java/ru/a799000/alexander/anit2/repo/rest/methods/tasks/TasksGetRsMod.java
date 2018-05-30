package ru.a799000.alexander.anit2.repo.rest.methods.tasks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.a799000.alexander.anit2.model.ContractorMod;
import ru.a799000.alexander.anit2.model.TaskMod;


public class TasksGetRsMod {

    @SerializedName("Задачи")
    @Expose
    public List<TaskMod> tasks;

    @SerializedName("ВсегоЭлементов")
    @Expose
    public int fullSize;

    public List<TaskMod> getTasks() {
        return tasks;
    }

    public int getFullSize() {
        return fullSize;
    }

    public void setFullSize(int fullSize) {
        this.fullSize = fullSize;
    }

    @Override
    public String toString() {
        return "TasksGetRsMod{" +
                "tasks=" + tasks +
                ", fullSize=" + fullSize +
                '}';
    }
}
