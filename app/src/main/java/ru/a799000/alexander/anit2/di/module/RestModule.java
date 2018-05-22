package ru.a799000.alexander.anit2.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import ru.a799000.alexander.anit2.repo.rest.RestClient;
import ru.a799000.alexander.anit2.repo.rest.methods.contractors.ContractorsGetApi;
import ru.a799000.alexander.anit2.repo.rest.methods.test.TestGetApi;


@Module
public class RestModule {
    private RestClient mRestClient;


    public RestModule() {
        mRestClient = new RestClient();
    }


    @Provides
    @Singleton
    public RestClient provideRestClient() {
        return mRestClient;
    }



    @Provides
    @Singleton
    public TestGetApi provideTestGetApi() {
        return mRestClient.createService(TestGetApi.class);
    }

    @Provides
    @Singleton
    public ContractorsGetApi provideContractorsGetApi() {
        return mRestClient.createService(ContractorsGetApi.class);
    }


}
