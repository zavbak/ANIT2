package ru.a799000.alexander.anit2.repo.rest.methods.tasks;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;
import ru.a799000.alexander.anit2.repo.rest.BaseRsMod;
import ru.a799000.alexander.anit2.repo.rest.methods.contractors.ContractorsGetRsMod;


public interface TasksGetApi {
    @GET("tasks.get/")
    Single<BaseRsMod<TasksGetRsMod>> getData(
            @QueryMap Map<String, String> map,
            @Header("Authorization") String auth);
}
