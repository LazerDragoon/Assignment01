package ca.bcit.androidassignment01;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseNews {
    @SerializedName("News")
    @Expose
    private ArrayList<News> news = new ArrayList<>();

    public ArrayList<News> getNews() {
        return news;
    }

    public void setNews(ArrayList<News> news) {
        this.news = news;
    }
}
