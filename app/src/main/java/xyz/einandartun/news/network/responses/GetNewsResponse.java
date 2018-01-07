package xyz.einandartun.news.network.responses;

import java.util.List;

import xyz.einandartun.news.data.vo.NewsVO;

/**
 * Created by einandartun on 12/24/17.
 */

public class GetNewsResponse {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<NewsVO> mmNews;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<NewsVO> getMmNews() {
        return mmNews;
    }
}
