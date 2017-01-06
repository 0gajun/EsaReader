package io.github.a0gajun.esareader.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by Junya on 1/6/17.
 */

public class PostEntity {
    @SerializedName("number")
    private int postNumber;

    @SerializedName("name")
    private String title;

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName("category")
    private String category;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("wip")
    private boolean isWip;

    @SerializedName("body_md")
    private String mdBody;

    @SerializedName("body_html")
    private String htmlBody;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("message")
    private String updateMessage;

    @SerializedName("revision_number")
    private int revisionNumber;

    @SerializedName("created_by")
    private UserEntity createdBy;

    @SerializedName("updated_by")
    private UserEntity updatedBy;

    @SerializedName("kind")
    private String kind;

    @SerializedName("comments_count")
    private int commentsCount;

    @SerializedName("tasks_count")
    private int tasksCount;

    @SerializedName("done_tasks_count")
    private int doneTasksCount;

    @SerializedName("stargazers_count")
    private int stargazersCount;

    @SerializedName("watchers_count")
    private int watchersCount;

    @SerializedName("star")
    private boolean isStared;

    @SerializedName("watch")
    private boolean isWatching;

    public PostEntity() {
    }

    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isWip() {
        return isWip;
    }

    public void setWip(boolean wip) {
        isWip = wip;
    }

    public String getMdBody() {
        return mdBody;
    }

    public void setMdBody(String mdBody) {
        this.mdBody = mdBody;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdateMessage() {
        return updateMessage;
    }

    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
    }

    public int getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(int revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public UserEntity getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserEntity updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getTasksCount() {
        return tasksCount;
    }

    public void setTasksCount(int tasksCount) {
        this.tasksCount = tasksCount;
    }

    public int getDoneTasksCount() {
        return doneTasksCount;
    }

    public void setDoneTasksCount(int doneTasksCount) {
        this.doneTasksCount = doneTasksCount;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public int getWatchersCount() {
        return watchersCount;
    }

    public void setWatchersCount(int watchersCount) {
        this.watchersCount = watchersCount;
    }

    public boolean isStared() {
        return isStared;
    }

    public void setStared(boolean stared) {
        isStared = stared;
    }

    public boolean isWatching() {
        return isWatching;
    }

    public void setWatching(boolean watching) {
        isWatching = watching;
    }
}
