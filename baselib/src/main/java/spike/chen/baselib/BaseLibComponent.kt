package spike.chen.baselib

import dagger.Component
import javax.inject.Singleton

@Component(modules = [BaseLibModule::class])
@Singleton
interface BaseLibComponent {

  fun inject(jetApp: JetApp)
  fun inject(mainActivity: MainActivity)
  fun inject(b: B)

  fun dataManager(): DataManager

}
