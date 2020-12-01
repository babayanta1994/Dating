package ru.trueip.hhproject11.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("urlBig")
    @Expose
    private String urlBig;
    @SerializedName("photo_id")
    @Expose
    private int photoId;
    @SerializedName("liked")
    @Expose
    private Object liked;
    @SerializedName("likedCount")
    @Expose
    private Object likedCount;
    @SerializedName("descr")
    @Expose
    private Object descr;
    @SerializedName("status")
    @Expose
    private Object status;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlBig() {
        return urlBig;
    }

    public void setUrlBig(String urlBig) {
        this.urlBig = urlBig;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public Object getLiked() {
        return liked;
    }

    public void setLiked(Object liked) {
        this.liked = liked;
    }

    public Object getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(Object likedCount) {
        this.likedCount = likedCount;
    }

    public Object getDescr() {
        return descr;
    }

    public void setDescr(Object descr) {
        this.descr = descr;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }
}
