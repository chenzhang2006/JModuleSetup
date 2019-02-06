package spike.chen.baselib

import javax.inject.Inject

data class CountData(val count: Int)

open class A @Inject constructor() {
  @Inject
  lateinit var countAData: CountData
}

open class B @Inject constructor() : A() {
  init {
    //call field inject anywhere in class hierarchy : https://github.com/google/dagger/issues/73
    JetApp.instance.baseLibComponent.inject(this)
  }

  @Inject
  lateinit var countBData: CountData

}

class C @Inject constructor() : B() {
  @Inject
  lateinit var countCData: CountData
}