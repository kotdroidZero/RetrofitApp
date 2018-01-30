package pk.error_found.com.retrofitapp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 27/7/17.
 */

public class RestClient {

    private static API REST_API;

    public static API getClient()
    {
        if(REST_API==null)
        {
            createClient();
        }
        return REST_API;
    }

    private static void createClient() {

        Retrofit.Builder mBuilder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL).
                        addConverterFactory(GsonConverterFactory.create());
        REST_API=mBuilder.build().create(API.class);
    }
 /* //
    OkHttpClient.Builder httpClientBuilder=new OkHttpClient.Builder();
    Retrofit.Builder retrofitBuilder=new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit=retrofitBuilder.client(httpClientBuilder.build()).build();
    API api=retrofit.create(API.class);



    //way 2
    *//*OkHttpClient httpClient=new OkHttpClient.Builder().build();
    Retrofit retrofit=new Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(httpClient)
            .addConverterFactory(GsonConverterFactory.create()).build();*/

}
