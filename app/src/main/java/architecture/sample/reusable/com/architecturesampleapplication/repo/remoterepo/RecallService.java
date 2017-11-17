package architecture.sample.reusable.com.architecturesampleapplication.repo.remoterepo;

/*
 * Created by 849501 on 11/15/2017.
 */

import org.json.JSONArray;
import org.json.JSONObject;

import architecture.sample.reusable.com.architecturesampleapplication.datamodel.RecallModel;
import architecture.sample.reusable.com.architecturesampleapplication.repo.RecallRepoModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RecallService {

    @GET("dashboard/download/recall.json")
    Call<RecallRepoModel> fetchRecallModel();

}
