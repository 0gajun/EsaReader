package io.github.a0gajun.esareader.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Junya on 1/7/17.
 */

public class PostsEntity {
    @SerializedName("posts")
    private List<PostEntity> posts;

    @SerializedName("prev_page")
    private int prev_page;

    @SerializedName("next_page")
    private int next_page;

    @SerializedName("total_count")
    private int total_count;

    @SerializedName("page")
    private int page;

    @SerializedName("per_page")
    private int per_page;

    @SerializedName("max_per_page")
    private int max_per_page;

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }

    public int getPrev_page() {
        return prev_page;
    }

    public void setPrev_page(int prev_page) {
        this.prev_page = prev_page;
    }

    public int getNext_page() {
        return next_page;
    }

    public void setNext_page(int next_page) {
        this.next_page = next_page;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getMax_per_page() {
        return max_per_page;
    }

    public void setMax_per_page(int max_per_page) {
        this.max_per_page = max_per_page;
    }
}
