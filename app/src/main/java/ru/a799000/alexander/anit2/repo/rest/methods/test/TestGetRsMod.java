package ru.a799000.alexander.anit2.repo.rest.methods.test;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestGetRsMod {
    @SerializedName("HTTPМетод")
    @Expose
    public String method;

    @SerializedName("БазовыйURL")
    @Expose
    public String baseUrl;

    @SerializedName("ОтносительныйURL")
    @Expose
    public String relativeUrl;

    @SerializedName("Заголовки")
    @Expose
    public JsonObject heder;

    @SerializedName("ПараметрыURL")
    @Expose
    public JsonObject paramsUrl;

    @SerializedName("ПараметрыЗапроса")
    @Expose
    public JsonObject paramsRq;

    @SerializedName("Тело")
    @Expose
    public String body;

    @Override
    public String toString() {
        return "TestGetRsMod{" +
                "method='" + method + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                ", relativeUrl='" + relativeUrl + '\'' +
                ", heder='" + heder + '\'' +
                ", paramsUrl='" + paramsUrl + '\'' +
                ", paramsRq='" + paramsRq + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
