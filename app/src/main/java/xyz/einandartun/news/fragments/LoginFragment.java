package xyz.einandartun.news.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.einandartun.news.R;
import xyz.einandartun.news.data.models.LoginUserModel;
import xyz.einandartun.news.data.vo.LoginUserVO;
import xyz.einandartun.news.events.SuccessLogInEvent;

/**
 * Created by einandartun on 1/20/18.
 */

public class LoginFragment extends Fragment {

    @BindView(R.id.btn_to_login)
    Button btnToLogin;

    @BindView(R.id.et_email_or_phone)
    EditText etEmailOrPhone;

    @BindView(R.id.et_password)
    EditText etPassword;

    private LoginUserVO mLoginUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container,false);
        ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.btn_to_login)
    public void onClickToLogin(View view) {
        String phoneNo = etEmailOrPhone.getText().toString();
        String password = etPassword.getText().toString();

        LoginUserModel.getsObjInstance().logInUser(phoneNo,password);

//        Snackbar.make(view, "Clicked Login", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLogInEvent event){
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
