package xyz.einandartun.news.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.einandartun.news.network.responses.GetNewsResponse;
import xyz.einandartun.news.network.responses.LogInResponse;

/**
 * Created by einandartun on 1/6/18.
 */

public interface NewsApi {

    @FormUrlEncoded
    @POST("getMMNews.php")
    Call<GetNewsResponse> getNews(@Field("page") int page,
                                  @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("login.php")
    Call<LogInResponse> getLogInRespone(@Field("phoneNo") String phoneNo,
                                @Field("password") String password);
}
