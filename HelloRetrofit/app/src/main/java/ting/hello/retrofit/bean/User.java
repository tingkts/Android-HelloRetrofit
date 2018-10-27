package ting.hello.retrofit.bean;

import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("objectId")
    @Expose
    private String objectId;

    @SerializedName("sessionToken")
    @Expose
    private String sessionToken;

    @SerializedName("timezone")
    @Expose
    private Long timezone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    @NonNull
    @Override
    public String toString() {
        return "username: " + username + "\n"
                + "objectId: " + objectId + "\n"
                + "phone: " + phone + "\n"
                + "timezone: " + timezone + "\n"
                + "createdAt: " + createdAt + "\n"
                + "updatedAt: " + updatedAt + "\n"
                + "sessionToken: " + sessionToken + "\n";
    }
}