package xyz.einandartun.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.einandartun.news.R;
import xyz.einandartun.news.viewholders.ItemSportNewsViewHolder;

/**
 * Created by einandartun on 1/10/18.
 */

public class SportNewsAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View sportNewsView = inflater.inflate(R.layout.item_news_by_sports,parent,false);
        ItemSportNewsViewHolder itemSportNewsViewHolder = new ItemSportNewsViewHolder(sportNewsView);
        return itemSportNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
