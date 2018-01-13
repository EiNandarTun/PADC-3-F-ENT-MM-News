package xyz.einandartun.news.delegates;

import xyz.einandartun.news.data.vo.NewsVO;

/**
 * Created by einandartun on 12/21/17.
 */

public interface NewsActionDelegate {

    void onTapNewsItems(NewsVO tappedNews);
    void onTapCommentItems();
    void onTapSentToButton();
    void onTapFavoriteButton();
}