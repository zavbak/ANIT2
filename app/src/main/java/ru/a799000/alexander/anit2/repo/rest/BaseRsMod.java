package ru.a799000.alexander.anit2.repo.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class BaseRsMod<T> {
    @SerializedName("Пришел")
    @Expose
    public Date received;

    @SerializedName("Подготовлен")
    @Expose
    public Date prepared;

    @SerializedName("Ошибка")
    @Expose
    public Boolean error;

    @SerializedName("ОписаниеОшибки")
    @Expose
    public String description_error;

    @SerializedName("Ответ")
    @Expose
    public T response;

    @Override
    public String toString() {
        return "BaseRsMod{" +
                "received=" + received +
                ", prepared=" + prepared +
                ", error=" + error +
                ", description_error='" + description_error + '\'' +
                ", response=" + response +
                '}';
    }
}
