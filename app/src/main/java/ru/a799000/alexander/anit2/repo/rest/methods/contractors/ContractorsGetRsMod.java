package ru.a799000.alexander.anit2.repo.rest.methods.contractors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.a799000.alexander.anit2.model.ContractorMod;


public class ContractorsGetRsMod {

    @SerializedName("Контрагенты")
    @Expose
    public List<ContractorMod> contractors;

    @SerializedName("ВсегоЭлементов")
    @Expose
    public int fullSize;

    public List<ContractorMod> getContractors() {
        return contractors;
    }

    public int getFullSize() {
        return fullSize;
    }

    public void setFullSize(int fullSize) {
        this.fullSize = fullSize;
    }

    @Override
    public String toString() {
        return "ContractorsGetRsMod{" +
                "contractors=" + contractors +
                '}';
    }


}
