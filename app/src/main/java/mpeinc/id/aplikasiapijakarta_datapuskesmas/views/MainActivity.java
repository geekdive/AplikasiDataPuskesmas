package mpeinc.id.aplikasiapijakarta_datapuskesmas.views;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mpeinc.id.aplikasiapijakarta_datapuskesmas.R;
import mpeinc.id.aplikasiapijakarta_datapuskesmas.adapter.AdapterDataPuskesmas;
import mpeinc.id.aplikasiapijakarta_datapuskesmas.models.DataItem;
import mpeinc.id.aplikasiapijakarta_datapuskesmas.models.ResponseDataPuskesmas;
import mpeinc.id.aplikasiapijakarta_datapuskesmas.network.ApiServices;
import mpeinc.id.aplikasiapijakarta_datapuskesmas.network.InitRetrofitPuskesmas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvListPuskesmas)
    RecyclerView rvListPuskesmas;
    @BindView(R.id.swlayoutMain)
    SwipeRefreshLayout swlayoutMain;
    @BindView(R.id.linearLayoutMain)
    LinearLayout linearLayoutMain;

    public static String CODE_AUTH = "ocg/wGKdhjxFa4dqb12eglMN9JB38XZPa17BXEEzsxDVpa7i+oNhWKeCxcPSZJbuRNtZGsA3sh/UwEa0CMv8+g==";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rvListPuskesmas = (RecyclerView) findViewById(R.id.rvListPuskesmas);
        rvListPuskesmas.setHasFixedSize(true);
        rvListPuskesmas.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        tampilkanDataPuskesmas();

        swlayoutMain.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                tampilkanDataPuskesmas();
                swlayoutMain.setRefreshing(false);
            }
        });
    }

    private void tampilkanDataPuskesmas() {
        ApiServices api = InitRetrofitPuskesmas.getInstance();
        Call<ResponseDataPuskesmas> dataPuskesmasCall = api.datapuskesman(CODE_AUTH);

        dataPuskesmasCall.enqueue(new Callback<ResponseDataPuskesmas>() {

            @Override
            public void onResponse(Call<ResponseDataPuskesmas> call, Response<ResponseDataPuskesmas> response) {
                if (response.isSuccessful()) {
                    List<DataItem> dataItemsPuskesmas = response.body().getData();

                    AdapterDataPuskesmas adapter = new AdapterDataPuskesmas(MainActivity.this, dataItemsPuskesmas);
                    rvListPuskesmas.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDataPuskesmas> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
