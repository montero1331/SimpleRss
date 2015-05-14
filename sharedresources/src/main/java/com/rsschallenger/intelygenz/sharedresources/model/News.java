package com.rsschallenger.intelygenz.sharedresources.model;

/**
 * Created by Jose Luis on 14/05/2015.
 */
public class News {
    private String title;
    private String description;
    private String releasedDate;
    private String imageUrl;
    private String webUrl;

    public News(String title, String description, String releasedDate, String imageUrl, String webUrl) {
        this.title = title;
        this.description = description;
        this.releasedDate = releasedDate;
        this.imageUrl = imageUrl;
        this.webUrl = webUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

}
