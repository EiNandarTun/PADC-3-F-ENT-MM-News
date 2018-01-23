package xyz.einandartun.news.network;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.einandartun.news.events.LoadedNewsEvent;
import xyz.einandartun.news.events.SuccessLogInEvent;
import xyz.einandartun.news.network.responses.GetNewsResponse;
import xyz.einandartun.news.network.responses.LogInResponse;

/**
 * Created by htoo on 1/6/2018.
 */

public class RetrofitDataAgent implements NewsDataAgent {

    private static RetrofitDataAgent sObjInstance;

    private NewsApi mNewsApi;

    private RetrofitDataAgent() {
        OkHttpClient httpClient = new OkHttpClient.Builder() //1
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder() //2
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mNewsApi = retrofit.create(NewsApi.class);
    }

    public static RetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new RetrofitDataAgent();
        }
        return sObjInstance;
    }

    @Override
    public void loadNews() {
        Call<GetNewsResponse> getNewsResponseCall = mNewsApi.getNews(1,"b002c7e1a528b7cb460933fc2875e916");
        getNewsResponseCall.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                GetNewsResponse getNewsResponse = response.body();

                if(getNewsResponse != null){
                    LoadedNewsEvent event = new LoadedNewsEvent(getNewsResponse.getMmNews());
                    EventBus.getDefault().post(event);
                }

            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void logInUser(String phoneNo , String password) {
        Call<LogInResponse> getLogInResponse = mNewsApi.getLogInRespone(phoneNo,password);
        getLogInResponse.enqueue(new Callback<LogInResponse>() {
            @Override
            public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {
                LogInResponse getLogInResponse = response.body();

                if(getLogInResponse != null){
                    SuccessLogInEvent event = new SuccessLogInEvent(getLogInResponse.getLoginUserVO());
                    EventBus.getDefault().post(event);
                }

            }

            @Override
            public void onFailure(Call<LogInResponse> call, Throwable t) {

            }
        });
    }
}