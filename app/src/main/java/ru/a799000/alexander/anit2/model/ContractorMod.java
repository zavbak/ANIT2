package ru.a799000.alexander.anit2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContractorMod {

    @SerializedName("Наименование")
    @Expose
    public String name;

    @SerializedName("Код")
    @Expose
    public String code;

    @Override
    public String toString() {
        return "ContractorMod{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
