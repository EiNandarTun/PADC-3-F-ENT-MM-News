package xyz.einandartun.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.einandartun.news.R;
import xyz.einandartun.news.delegates.NewsActionDelegate;
import xyz.einandartun.news.viewholders.ItemNewsViewHolder;

/**
 * Created by htoo on 12/3/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter {
    private NewsActionDelegate mNewsActionDeligate;

    public NewsAdapter(NewsActionDelegate newsActionDelegate) {
        mNewsActionDeligate = newsActionDelegate;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View newsItemView = inflater.inflate(R.layout.item_news, parent, false);
        ItemNewsViewHolder itemNewsViewHolder = new ItemNewsViewHolder(newsItemView, mNewsActionDeligate);

        return itemNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 16;
    }
}
