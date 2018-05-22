package ru.a799000.alexander.anit2.repo.rest.methods.test;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

import ru.a799000.alexander.anit2.repo.rest.BaseRsMod;


public interface TestGetApi {
    @GET("test.get/")
    Observable<BaseRsMod<TestGetRsMod>> getData(
            @QueryMap Map<String, String> map,
            @Header("Authorization") String auth);
}
