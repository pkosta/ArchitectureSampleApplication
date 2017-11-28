@file:JvmName("ConverterUtils")

package architecture.sample.reusable.com.architecturesampleapplication.repo.mapper

import architecture.sample.reusable.com.architecturesampleapplication.datamodel.RecallKotlinModel
import architecture.sample.reusable.com.architecturesampleapplication.datamodel.RecallModel
import architecture.sample.reusable.com.architecturesampleapplication.repo.RecallRepoModel

/*
 * Created by 849501 on 11/24/2017.
 */

/**
 * Usually you use apply when you need to do something with an object and return it
 * And when you need to perform some operations on an object and return some other object you can use with.
*/
fun getRecallModelWithRepoModel(repoModel: RecallRepoModel) : RecallModel {
    return with(repoModel) {
        RecallModel(appVersion, appURL);
    }
}