package architecture.sample.reusable.com.architecturesampleapplication.repo;

/*
 * Created by 849501 on 11/15/2017.
 */

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class RecallRepoModel {

    @PrimaryKey
    @ColumnInfo(name = "app_version")
    @SerializedName("appVersion")
    @NonNull
    @Expose                         // Gson
    private String appVersion;

    @ColumnInfo(name = "app_revoke")
    @SerializedName("appRevoke")
    @Expose
    private Boolean appRevoke;

    @ColumnInfo(name = "force_update")
    @SerializedName("forceUpdate")
    @Expose
    private Boolean forceUpdate;

    @ColumnInfo(name = "app_url")
    @SerializedName("appURL")
    @Expose
    private String appURL;

    @NonNull
    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(@NonNull String appVersion) {
        this.appVersion = appVersion;
    }

    public Boolean getAppRevoke() {
        return appRevoke;
    }

    public void setAppRevoke(Boolean appRevoke) {
        this.appRevoke = appRevoke;
    }

    public Boolean getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(Boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public String getAppURL() {
        return appURL;
    }

    public void setAppURL(String appURL) {
        this.appURL = appURL;
    }

    @Override
    public String toString() {
        return appURL + appVersion;

    }
}
