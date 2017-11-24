package architecture.sample.reusable.com.architecturesampleapplication

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import architecture.sample.reusable.com.architecturesampleapplication.databinding.ActivityHomeActivtyBinding
import architecture.sample.reusable.com.architecturesampleapplication.datamodel.RecallKotlinModel
import architecture.sample.reusable.com.architecturesampleapplication.datamodel.printData
import architecture.sample.reusable.com.architecturesampleapplication.di.ViewModelFactory
import architecture.sample.reusable.com.architecturesampleapplication.viewmodel.HomeViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelProvider: ViewModelFactory;

    var bindingLayout: ActivityHomeActivtyBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        bindingLayout = DataBindingUtil.setContentView(this, R.layout.activity_home_activty)

        val viewModel: HomeViewModel = ViewModelProviders.of(this, viewModelProvider)
                .get(HomeViewModel::class.java)
        viewModel.recallModel.observe(this, Observer { model ->
            // update UI.
            Log.d("BUGS", "Observer Update UI Called ")
            if (this.bindingLayout != null && model != null) {

                bindingLayout?.tvVersionNumberValue?.setText(model.version)
                bindingLayout?.tvDownloadUrlValue?.setText(model.downloadUrl)

                // dummy...
                val kotlinModel = RecallKotlinModel(model.version,
                        model.downloadUrl)
                kotlinModel.printData();

            }
        })
    }
}
