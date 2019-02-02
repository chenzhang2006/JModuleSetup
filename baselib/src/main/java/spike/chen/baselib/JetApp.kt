package spike.chen.baselib

import android.app.Application
import javax.inject.Inject

class JetApp : Application() {

  @Inject
  lateinit var dataManager: DataManager

  lateinit var baseLibComponent: BaseLibComponent

  override fun onCreate() {
    super.onCreate()

    instance = this
    baseLibComponent = DaggerBaseLibComponent.builder().baseLibModule(BaseLibModule(this)).build()

    baseLibComponent.inject(this)
    println("field injection in JetApp: ${dataManager.greetings}")
  }

  companion object {
    lateinit var instance: JetApp
      private set
  }

}
