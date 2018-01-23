package xyz.einandartun.news.viewpods;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.einandartun.news.R;
import xyz.einandartun.news.data.models.LoginUserModel;
import xyz.einandartun.news.delegates.BeforeLoginDelegate;
import xyz.einandartun.news.delegates.LoginUserDelegate;
import xyz.einandartun.news.events.SuccessLogInEvent;
import xyz.einandartun.news.events.UserLogoutEvent;

/**
 * Created by einandartun on 1/21/18.
 */

public class AccountControlViewPod extends FrameLayout {

    @BindView(R.id.vp_login_user)
    LoginUserViewPod vpLoginUser;

    @BindView(R.id.vp_before_login)
    BeforeLoginUserViewPod vpBeforeLogin;

    public AccountControlViewPod(@NonNull Context context) {
        super(context);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
        refreshUserSession();

        EventBus.getDefault().register(this);
    }

    private void refreshUserSession(){
        if (LoginUserModel.getsObjInstance().isUserLogin()){
            vpBeforeLogin.setVisibility(View.GONE);
            vpLoginUser.setVisibility(View.VISIBLE);
        } else {
            vpBeforeLogin.setVisibility(View.VISIBLE);
            vpLoginUser.setVisibility(View.GONE);
        }
    }

    public void setDelegate(BeforeLoginDelegate beforeLoginDelegate){
        vpBeforeLogin.setmDelegate(beforeLoginDelegate);
    }

    public void setDelegate(LoginUserDelegate loginUserDelegate){
        vpLoginUser.setDelegate(loginUserDelegate);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLogInEvent event){
        vpBeforeLogin.setVisibility(View.GONE);
        vpLoginUser.setVisibility(View.VISIBLE);

        vpLoginUser.bindData(event.getLoginUserVO());
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLogoutUser(UserLogoutEvent event){
        vpBeforeLogin.setVisibility(View.VISIBLE);
        vpLoginUser.setVisibility(View.GONE);
    }
}
