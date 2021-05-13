package com.example.spinner.apiservice;

import com.example.spinner.model.DealerModel;
import com.example.spinner.model.DealerModelList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("get-list-of-dealer-agents")
    Call<DealerModelList<DealerModel>> dealerResponse (@Query("providercode") String providercode,
                                                       @Query("dealercode") String dealercode,
                                                       @Query("APIKey") String APIKey);

}
