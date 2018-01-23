package xyz.einandartun.news.network.responses;

import com.google.gson.annotations.SerializedName;

import xyz.einandartun.news.data.vo.LoginUserVO;

/**
 * Created by einandartun on 1/21/18.
 */

public class LogInResponse {

    private int code;
    private String message;

    @SerializedName("login_user")
    private LoginUserVO loginUserVO;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LoginUserVO getLoginUserVO() {
        return loginUserVO;
    }
}
