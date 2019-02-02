package spike.chen.baselib

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_base.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  @Inject
  lateinit var dataManager: DataManager

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    JetApp.instance.baseLibComponent.inject(this)

    setContentView(R.layout.activity_base)

    baseLibText.text = dataManager.greetings

    baseLibButton.setOnClickListener {
      val intent = Intent().apply {
        component = ComponentName(applicationContext.packageName, "spike.chen.featurelib.FeatureActivity")
      }

      this.startActivity(intent)
    }

  }
}