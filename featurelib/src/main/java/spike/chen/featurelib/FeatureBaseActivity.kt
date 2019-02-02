package spike.chen.featurelib

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import spike.chen.baselib.DataManager
import spike.chen.baselib.JetApp
import javax.inject.Inject

open class FeatureBaseActivity : AppCompatActivity() {
  @Inject
  lateinit var dataManager: DataManager

  protected var featureComponent: FeatureComponent? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    inject()
  }

  private fun inject() {
    val app = application as JetApp
    featureComponent = DaggerFeatureComponent.builder()
      .baseLibComponent(app.baseLibComponent)
      .build()
//      .apply {
//        inject(this@FeatureBaseActivity)
//      }
  }
}