package ru.trueip.hhproject11.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nick")
    @Expose
    private String nick;
    @SerializedName("iurl")
    @Expose
    private String iurl;
    @SerializedName("iurl_600")
    @Expose
    private String iurl600;
    @SerializedName("iurl_200")
    @Expose
    private String iurl200;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;
    @SerializedName("online")
    @Expose
    private boolean online;
    @SerializedName("pcnt")
    @Expose
    private int pcnt;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("aim")
    @Expose
    private String aim;
    @SerializedName("photo_id")
    @Expose
    private int photoId;
    @SerializedName("moderator")
    @Expose
    private boolean moderator;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("greeting")
    @Expose
    private String greeting;
    @SerializedName("lastVisit")
    @Expose
    private String lastVisit;
    @SerializedName("sex")
    @Expose
    private int sex;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIurl() {
        return iurl;
    }

    public void setIurl(String iurl) {
        this.iurl = iurl;
    }

    public String getIurl600() {
        return iurl600;
    }

    public void setIurl600(String iurl600) {
        this.iurl600 = iurl600;
    }

    public String getIurl200() {
        return iurl200;
    }

    public void setIurl200(String iurl200) {
        this.iurl200 = iurl200;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public int getPcnt() {
        return pcnt;
    }

    public void setPcnt(int pcnt) {
        this.pcnt = pcnt;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public boolean isModerator() {
        return moderator;
    }

    public void setModerator(boolean moderator) {
        this.moderator = moderator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
