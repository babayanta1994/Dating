package ru.trueip.hhproject11.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    @SerializedName("searchSessionId")
    @Expose
    private String searchSessionId;
    @SerializedName("cnt")
    @Expose
    private Object cnt;
    @SerializedName("users")
    @Expose
    private List<User> users = null;

    public String getSearchSessionId() {
        return searchSessionId;
    }

    public void setSearchSessionId(String searchSessionId) {
        this.searchSessionId = searchSessionId;
    }

    public Object getCnt() {
        return cnt;
    }

    public void setCnt(Object cnt) {
        this.cnt = cnt;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
