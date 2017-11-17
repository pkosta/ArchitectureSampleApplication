package architecture.sample.reusable.com.architecturesampleapplication.repo.mapper;

/*
 * Created by 849501 on 11/15/2017.
 */

import architecture.sample.reusable.com.architecturesampleapplication.datamodel.RecallModel;
import architecture.sample.reusable.com.architecturesampleapplication.repo.RecallRepoModel;

public class RepoToUiMapper implements Mapper<RecallRepoModel, RecallModel> {
    @Override
    public RecallModel map(RecallRepoModel s) {
        return new RecallModel(s.getAppVersion(), s.getAppURL());
    }
}
