package xyz.einandartun.news.data.models;

import xyz.einandartun.news.network.HttpUrlConnectionDataAgent;
import xyz.einandartun.news.network.NewsDataAgent;

/**
 * Created by einandartun on 12/23/17.
 */

public class NewsModel {

    private static NewsModel sObjInstance;

    private NewsDataAgent mDataAgent;

    private  NewsModel(){
        mDataAgent = HttpUrlConnectionDataAgent.getsObjInstance();
    }

    public static NewsModel getsObjInstance(){
        if(sObjInstance == null){
            sObjInstance = new NewsModel();
        }
        return  sObjInstance;
    }

    /**
     * Get News from network api.
     */
    public  void loadNews(){
        mDataAgent.loadNews();
    }
}
