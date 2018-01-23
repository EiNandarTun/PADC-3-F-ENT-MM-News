package xyz.einandartun.news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.einandartun.news.R;
import xyz.einandartun.news.adapters.NewsByCategoryAdapter;
import xyz.einandartun.news.fragments.NewsByCategoryFragment;
import xyz.einandartun.news.fragments.NewsByInternationalFragment;
import xyz.einandartun.news.fragments.NewsBySportsFragment;

/**
 * Created by einandartun on 1/7/18.
 */

public class NewsByCategoryActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_by_category)
    ViewPager vpNewsByCategory;

    @BindView(R.id.tb_news_by_category)
    TabLayout tbNewsByCategory;

    private NewsByCategoryAdapter mNewsByCategoryAdapter;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, NewsByCategoryActivity.class);
        return intent;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_by_category);
        ButterKnife.bind(this,this);

        //set tool bar to action bar
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.title_news_by_category); //add title to action bar
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mNewsByCategoryAdapter = new NewsByCategoryAdapter(getSupportFragmentManager());
        vpNewsByCategory.setAdapter(mNewsByCategoryAdapter);

        mNewsByCategoryAdapter.addTab("Local News",new NewsByCategoryFragment());
        mNewsByCategoryAdapter.addTab("International News",new NewsByInternationalFragment());
        mNewsByCategoryAdapter.addTab("Sports News",new NewsBySportsFragment());

        tbNewsByCategory.setupWithViewPager(vpNewsByCategory);
        vpNewsByCategory.setOffscreenPageLimit(mNewsByCategoryAdapter.getCount());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
