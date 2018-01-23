package xyz.einandartun.news.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


import xyz.einandartun.news.data.vo.LoginUserVO;
import xyz.einandartun.news.events.SuccessLogInEvent;
import xyz.einandartun.news.events.UserLogoutEvent;
import xyz.einandartun.news.network.NewsDataAgent;
import xyz.einandartun.news.network.RetrofitDataAgent;

/**
 * Created by einandartun on 1/20/18.
 */

public class LoginUserModel {

    private static LoginUserModel sObjInstance;

    private NewsDataAgent mDataAgent;

    private LoginUserVO mLoginUser;

    private LoginUserModel(){
        mDataAgent = RetrofitDataAgent.getsObjInstance();

        EventBus.getDefault().register(this);
    }

    public static LoginUserModel getsObjInstance(){
        if(sObjInstance == null){
            sObjInstance = new LoginUserModel();
        }
        return  sObjInstance;
    }


    public void logInUser(String phoneNo, String password){
        mDataAgent.logInUser(phoneNo,password);
    }

    public boolean isUserLogin(){
        return mLoginUser != null;
    }

    public void logout(){
        mLoginUser = null;
        UserLogoutEvent event = new UserLogoutEvent();
        EventBus.getDefault().post(event);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoginUserSuccess(SuccessLogInEvent event){
        mLoginUser = event.getLoginUserVO();
    }
}
