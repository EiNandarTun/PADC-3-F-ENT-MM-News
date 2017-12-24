package xyz.einandartun.news.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.einandartun.news.R;
import xyz.einandartun.news.adapters.ImagesInNewsDetailsAdapter;

/**
 * Created by einandartun on 12/9/17.
 */

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_details_images)
            ViewPager vpNewsDetailsImages;

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
    }
}
