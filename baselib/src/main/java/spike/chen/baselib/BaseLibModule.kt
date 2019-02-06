package spike.chen.baselib

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlin.random.Random

@Module
class BaseLibModule(private val app: JetApp) {

  @Provides
  @Singleton
  fun provideApplication(): JetApp {
    return app
  }

  @Provides
  @Singleton
  fun provideDataManager(): DataManager {
    return DataManager("data manager from baselib")
  }

  @Provides
  fun provideCountData(): CountData {
    return CountData(Random.nextInt())
  }
}
