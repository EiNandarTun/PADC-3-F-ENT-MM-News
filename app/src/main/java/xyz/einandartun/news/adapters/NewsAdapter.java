package xyz.einandartun.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.einandartun.news.R;
import xyz.einandartun.news.data.vo.NewsVO;
import xyz.einandartun.news.delegates.NewsActionDelegate;
import xyz.einandartun.news.viewholders.ItemNewsViewHolder;

/**
 * Created by einandartun on 12/3/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<ItemNewsViewHolder> {

    private NewsActionDelegate mNewsActionDeligate;
    private List<NewsVO> mNewsList;

    public NewsAdapter(NewsActionDelegate newsActionDelegate) {
        mNewsActionDeligate = newsActionDelegate;
        mNewsList = new ArrayList<>();
    }

    @Override
    public ItemNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View newsItemView = inflater.inflate(R.layout.item_news, parent, false);
        ItemNewsViewHolder itemNewsViewHolder = new ItemNewsViewHolder(newsItemView, mNewsActionDeligate);

        return itemNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemNewsViewHolder holder, int position) {
        holder.setNews(mNewsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void setNews(List<NewsVO> newsList){
        mNewsList = newsList;
        notifyDataSetChanged();
    }
}
