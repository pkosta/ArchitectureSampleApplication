package architecture.sample.reusable.com.architecturesampleapplication.datamodel

import android.util.Log

/*
 * Created by 849501 on 11/24/2017.
 */
data class RecallKotlinModel (var version: String, var downloadUrl: String)

// extension function for RecallKotlinModel
// just for dummy purpose...this is build in toString function in the data class
fun RecallKotlinModel.printData() {
    Log.d("BUGS","PRint Data from Extension Function");
}