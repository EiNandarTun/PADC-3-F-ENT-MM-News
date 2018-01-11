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
import xyz.einandartun.news.adapters.InternationalNewsAdapter;

/**
 * Created by einandartun on 1/7/18.
 */

public class NewsByInternationalFragment extends Fragment {

    @BindView(R.id.rv_news_by_international)
    RecyclerView rvNewsByInternational;

    private InternationalNewsAdapter mInternationalNewsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_by_international,container,false);
        ButterKnife.bind(this,view);

        mInternationalNewsAdapter = new InternationalNewsAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvNewsByInternational.setLayoutManager(linearLayoutManager);
        rvNewsByInternational.setAdapter(mInternationalNewsAdapter);
        return view;
    }
}
