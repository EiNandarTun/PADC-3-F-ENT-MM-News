package xyz.einandartun.news.delegates;

/**
 * Created by einandartun on 12/21/17.
 */

public interface NewsActionDelegate {

    void onTapNewsItems();
    void onTapCommentItems();
    void onTapSentToButton();
    void onTapFavoriteButton();
}