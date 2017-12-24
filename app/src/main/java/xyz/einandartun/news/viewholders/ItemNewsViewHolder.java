package xyz.einandartun.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.einandartun.news.R;
import xyz.einandartun.news.delegates.NewsActionDelegate;

/**
 * Created by htoo on 12/3/2017.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    private NewsActionDelegate mNewsActionDelegate;

    public ItemNewsViewHolder(View itemView, NewsActionDelegate newsActionDelegate) {

        super(itemView);
        ButterKnife.bind(this, itemView);

        mNewsActionDelegate = newsActionDelegate;
    }

    @OnClick(R.id.cv_news_item_root)
    public  void onNewsItemTap(View view){
        //Toast.makeText(view.getContext(), "Newa Item Click", Toast.LENGTH_LONG).show();
        mNewsActionDelegate.onTapNewsItems();
    }
}
