package com.example.spinner.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DealerModel {

    @SerializedName("SubDealerName")
    @Expose
    private String SubDealerName;
    @SerializedName("SubDealerCode")
    @Expose
    private String SubDealerCode;
    @SerializedName("SubDealerBalance")
    @Expose
    private double SubDealerBalance;
    @SerializedName("ErrorMessge")
    @Expose
    private String ErrorMessge;


    public String getSubDealerName() {
        return SubDealerName;
    }

    public void setSubDealerName(String subDealerName) {
        SubDealerName = subDealerName;
    }

    public String getSubDealerCode() {
        return SubDealerCode;
    }

    public void setSubDealerCode(String subDealerCode) {
        SubDealerCode = subDealerCode;
    }

    public double getSubDealerBalance() {
        return SubDealerBalance;
    }

    public void setSubDealerBalance(double subDealerBalance) {
        SubDealerBalance = subDealerBalance;
    }

    public String getErrorMessge() {
        return ErrorMessge;
    }

    public void setErrorMessge(String errorMessge) {
        ErrorMessge = errorMessge;
    }
}