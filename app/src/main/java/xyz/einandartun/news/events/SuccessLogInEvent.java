package xyz.einandartun.news.events;

import xyz.einandartun.news.data.vo.LoginUserVO;

/**
 * Created by einandartun on 1/21/18.
 */

public class SuccessLogInEvent {

    private LoginUserVO loginUserVO;

    public SuccessLogInEvent(LoginUserVO loginUserVO){
        this.loginUserVO = loginUserVO;
    }

    public LoginUserVO getLoginUserVO() {
        return loginUserVO;
    }
}
