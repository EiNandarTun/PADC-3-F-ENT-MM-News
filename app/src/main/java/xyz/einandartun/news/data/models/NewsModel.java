package xyz.einandartun.news.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import xyz.einandartun.news.data.vo.NewsVO;
import xyz.einandartun.news.events.LoadedNewsEvent;
import xyz.einandartun.news.network.HttpUrlConnectionDataAgent;
import xyz.einandartun.news.network.NewsDataAgent;
import xyz.einandartun.news.network.OkHttpDataAgent;
import xyz.einandartun.news.network.RetrofitDataAgent;

/**
 * Created by einandartun on 12/23/17.
 */

public class NewsModel {

    private static NewsModel sObjInstance;

    private NewsDataAgent mDataAgent;

    private Map<String, NewsVO> mNews;

    private  NewsModel(){
        //mDataAgent = HttpUrlConnectionDataAgent.getsObjInstance();
       // mDataAgent = OkHttpDataAgent.getObjInstance();
        mDataAgent = RetrofitDataAgent.getsObjInstance();

        mNews = new HashMap<>();
        EventBus.getDefault().register(this);
    }

    public static NewsModel getsObjInstance(){
        if(sObjInstance == null){
            sObjInstance = new NewsModel();
        }
        return  sObjInstance;
    }

    /**
     * Get news object by id
     */
    public NewsVO getNewsById(String newsId){
        return mNews.get(newsId);
    }



    /**
     * Get News from network api.
     */
    public  void loadNews(){
        mDataAgent.loadNews();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNewsLoaded(LoadedNewsEvent event){
        for (NewsVO news : event.getNewsList()){
            mNews.put(news.getNewsId(), news );
        }
    }
}
