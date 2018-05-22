package ru.a799000.alexander.anit2.repo.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {


    private Retrofit mRetrofit;

    public RestClient() {


        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();



        mRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson)) //Конвертер, необходимый для преобразования JSON'а в объекты
                .baseUrl(ConstantsRest.BASE_URL)
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }
}
