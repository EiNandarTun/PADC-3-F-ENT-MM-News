package xyz.einandartun.news.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.einandartun.news.R;
import xyz.einandartun.news.adapters.ImagesInNewsDetailsAdapter;
import xyz.einandartun.news.data.models.NewsModel;
import xyz.einandartun.news.data.vo.NewsVO;

/**
 * Created by einandartun on 12/9/17.
 */

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_details_images)
            ViewPager vpNewsDetailsImages;

    @BindView(R.id.tv_news_details)
    TextView tvNewsDetails;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    private ImagesInNewsDetailsAdapter mImagesInNewsDetails;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this, this);

        /*
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();// get action bat to disable title in tool bar from actionbar
        actionBar.setDisplayShowTitleEnabled(false); //disable title in tool bar from actionbar
        */

        mImagesInNewsDetails = new ImagesInNewsDetailsAdapter();
        vpNewsDetailsImages.setAdapter(mImagesInNewsDetails);

        String newsId = getIntent().getStringExtra("news_id");
        NewsVO news = NewsModel.getsObjInstance().getNewsById(newsId);

        bindData(news);
    }

    private void bindData(NewsVO news){
        Glide.with(ivPublicationLogo.getContext())
                .load(news.getPublication().getLogo())
                .into(ivPublicationLogo);
        tvPublicationTitle.setText(news.getPublication().getTitle());
        tvPostedDate.setText(news.getPostedDate());
        tvNewsDetails.setText(news.getDetails());
    }
}
