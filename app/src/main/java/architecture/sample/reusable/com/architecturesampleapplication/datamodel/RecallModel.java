package architecture.sample.reusable.com.architecturesampleapplication.datamodel;

/*
 * Created by 849501 on 11/14/2017.
 */

public class RecallModel {

    private String version;

    private String downloadUrl;

    public RecallModel(String version, String downloadUrl) {
        this.version = version;
        this.downloadUrl = downloadUrl;
    }

    public String getVersion() {
        return version;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }
}
