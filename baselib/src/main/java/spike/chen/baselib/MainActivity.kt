package spike.chen.baselib

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.calories_row.view.*
import kotlinx.android.synthetic.main.serving_row.view.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  @Inject
  lateinit var dataManager: DataManager

  @Inject
  lateinit var a: A
  @Inject
  lateinit var b: B
  @Inject
  lateinit var c: C

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

    Log.d("main", "${a.countAData} ${b.countBData} ${c.countCData}")


    nutritionContainer.addView(
      layoutInflater.inflate(R.layout.serving_row, nutritionContainer, false).apply {
        serving_title.text = "Serving Size"
        serving_value.text = "1 oz(28g)"
      }
    )

    nutritionContainer.addView(layoutInflater.inflate(R.layout.divider_thin, nutritionContainer, false))

    nutritionContainer.addView(
      layoutInflater.inflate(R.layout.calories_row, nutritionContainer, false).apply {
        calories_label.text = "Calories"
        calories_value.text = "140"
        fat_label.text = "Calories from Fat"
        fat_value.text = "70"
      }
    )

    nutritionContainer.addView(
      layoutInflater.inflate(R.layout.daily_value_header, nutritionContainer, false)
    )

    allergenContainer.addView(
      layoutInflater.inflate(R.layout.serving_row, allergenContainer, false).apply {
        serving_title.text = "Allergen"
        serving_value.text = "Peanut"
      }
    )

  }
}