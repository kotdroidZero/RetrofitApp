package pk.error_found.com.retrofitapp;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView recyclerView;
    private List<Example> basePojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        hitApi();

    }

    private void hitApi() {

        final ProgressDialog dialog=new ProgressDialog(this);
        dialog.setMessage("please wait");
        dialog.create();
        dialog.show();
        RestClient.getClient().repoForUser("pushkar256").enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {


                if (response.isSuccessful())
                {Log.e("tag error",response.body().toString());
                     basePojo=response.body();
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                    recyclerView.setAdapter(new RecyclerAdapter(basePojo,MainActivity.this));
                    dialog.dismiss();
                }
                else
                {
                    try {
                        Log.e("tag error",response.errorBody().string());
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "error !", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                Log.e("tag","failre"+t.toString());
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void init() {
        ButterKnife.bind(this);
    }
}
