package com.jahu.githubviewer.data.users;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private final String name;
    private final String login;
    @SerializedName("avatar_url")
    private final String avatarUrl;
    private final String company;
    private final String location;
    @SerializedName("public_repos")
    private final int repositoriesCount;
    @SerializedName("created_at")
    private final Date createdAt;
    @SerializedName("followers")
    private final int followersCount;

    public User(String name, String login, String avatarUrl, String company, String location, int repositoriesCount, Date createdAt, int followersCount) {
        this.name = name;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.company = company;
        this.location = location;
        this.repositoriesCount = repositoriesCount;
        this.createdAt = createdAt;
        this.followersCount = followersCount;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public int getRepositoriesCount() {
        return repositoriesCount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getFollowersCount() {
        return followersCount;
    }
}
