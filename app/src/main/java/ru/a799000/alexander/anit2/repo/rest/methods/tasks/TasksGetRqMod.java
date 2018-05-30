package ru.a799000.alexander.anit2.repo.rest.methods.tasks;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

import ru.a799000.alexander.anit2.repo.rest.BaseRqMod;

public class TasksGetRqMod extends BaseRqMod {

    @Override
    public void onMapCreate(Map<String, String> map) {
        map.put("my_task", String.valueOf(true));
    }

}
