package spike.chen.featurelib

import dagger.Module
import dagger.Provides

@Module
class FeatureModule {

  @Provides
  @FeatureScope
  internal fun provideFeatureString(): String {
    return "Feature String"
  }
}
