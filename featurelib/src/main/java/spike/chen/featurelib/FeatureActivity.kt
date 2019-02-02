package spike.chen.featurelib

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import spike.chen.baselib.DataManager
import spike.chen.baselib.JetApp
import javax.inject.Inject

class FeatureActivity : FeatureBaseActivity() {

  @Inject
  lateinit var featureGreetings: String

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    featureComponent?.inject(this)

    setContentView(R.layout.activity_feature)

    val textView = findViewById<TextView>(R.id.featureText)
    textView.text = "$featureGreetings ${dataManager.greetings}"
  }



  override fun onDestroy() {
    featureComponent = null //may not be necessary since instance variable should be GCed together with lifecycle components
    super.onDestroy()
  }

}