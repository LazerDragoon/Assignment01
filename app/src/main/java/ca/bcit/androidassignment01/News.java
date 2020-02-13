package ca.bcit.androidassignment01;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {
    @SerializedName("source")
    @Expose
    private String[] source;
    public String[] getSource() {
        return source;
    }
    public void setStatus(String source[]) {
        this.source = source;
    }

    @SerializedName("author")
    @Expose
    private String author;
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @SerializedName("title")
    @Expose
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("description")
    @Expose
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("url")
    @Expose
    private String url;
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("pictureUrl")
    @Expose
    private String pictureUrl;
    public String getPictureUrl() {
        return pictureUrl;
    }
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @SerializedName("content")
    @Expose
    private String content;
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
