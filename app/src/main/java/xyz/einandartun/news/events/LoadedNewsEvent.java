package xyz.einandartun.news.events;

import java.util.List;

import xyz.einandartun.news.data.vo.NewsVO;

/**
 * Created by einandartun on 12/24/17.
 */

public class LoadedNewsEvent {

    private List<NewsVO> newsList;

    public LoadedNewsEvent(List<NewsVO> newsList) {
        this.newsList = newsList;
    }

    public List<NewsVO> getNewsList() {
        return newsList;
    }
}
