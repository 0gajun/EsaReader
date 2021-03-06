package io.github.a0gajun.esareader.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Junya on 1/6/17.
 */

public class UserEntity {

    @SerializedName("name")
    private String name;

    @SerializedName("screen_name")
    private String screenName;

    @SerializedName("icon")
    private String iconUrl;

    public UserEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screen_name) {
        this.screenName = screen_name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
