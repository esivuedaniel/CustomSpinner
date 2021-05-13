package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spinner.apiservice.Api;
import com.example.spinner.apiservice.RetrofitClient;
import com.example.spinner.model.DealerModel;
import com.example.spinner.model.DealerModelList;
import com.example.spinner.viewmodel.CustomAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.security.AccessController.getContext;

public class SpinnerActivity extends AppCompatActivity {

    Spinner mspinner_tv_plan;
    ProgressBar progressBar;
    List<DealerModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        progressBar=findViewById(R.id.progressBarLogin);
        mspinner_tv_plan=findViewById(R.id.spinner_tv_plan);

        fetchJSON();
    }



    private void fetchJSON() {

        Call<DealerModelList<DealerModel>> call =RetrofitClient.getInstance().getApi().dealerResponse("ekedc","EK0064", "c2ecc60e-f1cd-4fa4-b62d-2b1ca5665685");
        showDialog();
        call.enqueue(new Callback<DealerModelList<DealerModel>>() {
            @Override
            public void onResponse(Call<DealerModelList<DealerModel>> call, Response<DealerModelList<DealerModel>> response) {
                dissmis();
                if (response.isSuccessful()){

                    list=response.body().getResponseMessage();
                    Log.d("TAG", "list= " + list);

                    CustomAdapter adapter = new CustomAdapter(SpinnerActivity.this, R.layout.custom_row_gotv, R.id.title, list);

                    //setting adapter to spinner
                    mspinner_tv_plan.setAdapter(adapter);
                    mspinner_tv_plan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                             Toast.makeText(getApplicationContext(),"You selected "+list.get(position).getSubDealerName(), Toast.LENGTH_LONG).show();

                            //You can save your selected item in a sharedPreference
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                }else {
                    Toast.makeText(SpinnerActivity.this, "Something went wrong, please try again later", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<DealerModelList<DealerModel>> call, Throwable t) {
                dissmis();
                Toast.makeText(getApplicationContext(),"Error in model or network connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void dissmis() {
        if (progressBar.getVisibility()==View.VISIBLE)
        {progressBar.setVisibility(View.INVISIBLE);}
    }


    private void showDialog() {
        progressBar.setVisibility(View.VISIBLE);
    }


}