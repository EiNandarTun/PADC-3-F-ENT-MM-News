package xyz.einandartun.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.einandartun.news.R;
import xyz.einandartun.news.data.vo.NewsVO;
import xyz.einandartun.news.delegates.NewsActionDelegate;

/**
 * Created by einandartun on 12/3/2017.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    private NewsActionDelegate mNewsActionDelegate;

    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    @BindView(R.id.tv_news_brief)
    TextView tvNewsBrief;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

    @BindView(R.id.iv_news)
    ImageView ivNews;


    private NewsVO mNews;

    public ItemNewsViewHolder(View itemView, NewsActionDelegate newsActionDelegate) {

        super(itemView);
        ButterKnife.bind(this, itemView);

        mNewsActionDelegate = newsActionDelegate;
    }

    @OnClick(R.id.cv_news_item_root)
    public  void onNewsItemTap(View view){
        //Toast.makeText(view.getContext(), "Newa Item Click", Toast.LENGTH_LONG).show();
        mNewsActionDelegate.onTapNewsItems(mNews);
    }

    public void setNews(NewsVO news){
        mNews = news;

        tvPublicationTitle.setText(news.getPublication().getTitle());
        tvPostedDate.setText(news.getPostedDate());
        tvNewsBrief.setText(news.getBrief());

        Glide.with(ivPublicationLogo.getContext())
                .load(news.getPublication().getLogo())
                .into(ivPublicationLogo);


        if(news.getImages() != null) {
            Glide.with(ivNews.getContext())
                    .load(news.getImages().get(0))
                    .into(ivNews);
        }else{
            ivNews.setVisibility(View.GONE);
        }

    }
}
