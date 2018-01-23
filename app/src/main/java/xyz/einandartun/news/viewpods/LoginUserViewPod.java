package xyz.einandartun.news.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.einandartun.news.R;
import xyz.einandartun.news.data.vo.LoginUserVO;
import xyz.einandartun.news.delegates.LoginUserDelegate;

/**
 * Created by einandartun on 1/14/18.
 */

public class LoginUserViewPod extends RelativeLayout {

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_phone)
    TextView tvPhone;

    @BindView(R.id.iv_background)
    ImageView ivBackground;

    @BindView(R.id.iv_profile)
    ImageView ivProfile;

    private LoginUserDelegate mDelegate;


    public LoginUserViewPod(Context context) {
        super(context);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);

    }

    public void bindData(LoginUserVO loginUser){

        Glide.with(ivBackground.getContext())
                .load(loginUser.getCoverUrl())
                .into(ivBackground);

        Glide.with(ivProfile.getContext())
                .load(loginUser.getProfileUrl())
                .into(ivProfile);

        tvName.setText(loginUser.getName());
        tvPhone.setText(loginUser.getPhoneNo());
    }

    public void setDelegate(LoginUserDelegate loginUserDelegate){
        mDelegate = loginUserDelegate;
    }

    @OnClick(R.id.btn_logout)
    public void onTapLogout(View view){
        mDelegate.onTapLogout();
    }
}
