package ru.a799000.alexander.anit2.repo.rest.methods.contractors;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

import ru.a799000.alexander.anit2.repo.rest.BaseRqMod;


public class ContractorsGetRqMod extends BaseRqMod {

    @SerializedName("offset")
    int offset;

    @SerializedName("count")
    int count;

    @SerializedName("filter_name")
    String filterName;

    public ContractorsGetRqMod(int count, int offset, String filterName) {
        this.offset = offset;
        this.count = count;
        this.filterName = filterName;
    }


    @Override
    public void onMapCreate(Map<String, String> map) {
           map.put("offset", String.valueOf(offset));
           map.put("count", String.valueOf(count));
           map.put("filter_name",filterName);
    }
}
