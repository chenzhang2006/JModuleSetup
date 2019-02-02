package spike.chen.featurelib

import dagger.Component
import spike.chen.baselib.BaseLibComponent
import spike.chen.baselib.BaseLibModule

@FeatureScope
@Component(dependencies = [BaseLibComponent::class], modules = [FeatureModule::class])
interface FeatureComponent {

//  fun inject(featureBaseActivity: FeatureBaseActivity)
  fun inject(featureActivity: FeatureActivity)

}
