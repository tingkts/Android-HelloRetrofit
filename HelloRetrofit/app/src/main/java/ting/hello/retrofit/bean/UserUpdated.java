package ting.hello.retrofit.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class UserUpdated {

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("role")
    @Expose
    private Role role;

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("updatedAt", updatedAt).append("role", role).toString();
    }

    public class Role {

        @SerializedName("__op")
        @Expose
        private String op;

        public String getOp() {
            return op;
        }

        public void setOp(String op) {
            this.op = op;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("op", op).toString();
        }

    }
}