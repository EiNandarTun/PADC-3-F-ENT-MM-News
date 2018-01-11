package xyz.einandartun.news.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.einandartun.news.R;
import xyz.einandartun.news.adapters.SportNewsAdapter;


/**
 * Created by einandartun on 1/7/18.
 */

public class NewsBySportsFragment extends Fragment {

    @BindView(R.id.rv_news_by_sports)
    RecyclerView rvNewsBySports;

    private SportNewsAdapter mSportNewsAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news_by_sports,container,false);

        ButterKnife.bind(this,view);

        mSportNewsAdapter = new SportNewsAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvNewsBySports.setLayoutManager(linearLayoutManager);
        rvNewsBySports.setAdapter(mSportNewsAdapter);
        return view;
    }
}
