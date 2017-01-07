package io.github.a0gajun.esareader.domain.model;

/**
 * Created by Junya on 1/6/17.
 */

public class User {
    private String name;
    private String screenName;
    private String iconUrl;

    public User() {
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

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
