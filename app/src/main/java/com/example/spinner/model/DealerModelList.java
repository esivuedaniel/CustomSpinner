package com.example.spinner.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DealerModelList<T> {

    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("ResponseMessage")
    List<T> ResponseMessage;

    public DealerModelList(int responseCode, List<T> responseMessage) {
        ResponseCode = responseCode;
        ResponseMessage = responseMessage;
    }

    public int getResponseCode() {
        return ResponseCode;
    }

    public List<T> getResponseMessage() {
        return ResponseMessage;
    }
}
