package ru.a799000.alexander.anit2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class TaskMod {
    @SerializedName("Важность")
    @Expose
    public int importance;

    @SerializedName("Номер")
    @Expose
    public String number;

    @SerializedName("Дата")
    @Expose
    public Date date;

    @SerializedName("Контрагент")
    @Expose
    public String contractor;

    @SerializedName("ОкончаниеСобытия")
    @Expose
    public Date endDate;

    @SerializedName("ОписаниеСобытия")
    @Expose
    public String description;

    @SerializedName("Ответственный")
    @Expose
    public String responsible;

    @SerializedName("ПостановщикЗадачи")
    @Expose
    public String director;

    @SerializedName("Контроллер")
    @Expose
    public String controller;

    @SerializedName("Группа")
    @Expose
    public String group;

    @Override
    public String toString() {
        return "TaskMod{" +
                "importance=" + importance +
                ", number='" + number + '\'' +
                ", date=" + date +
                ", contractor='" + contractor + '\'' +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", responsible='" + responsible + '\'' +
                ", director='" + director + '\'' +
                ", controller='" + controller + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
