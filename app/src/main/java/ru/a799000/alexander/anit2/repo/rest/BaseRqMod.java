package ru.a799000.alexander.anit2.repo.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public abstract class BaseRqMod {


    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        map.put("date",dateFormat.format( new Date() ));
        onMapCreate(map);

        return map;
    }

    public abstract void onMapCreate(Map<String, String> map);
}
