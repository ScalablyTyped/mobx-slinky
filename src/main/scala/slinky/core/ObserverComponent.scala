package slinky.core

import com.olvind.mobx.facade.mobxReact.mod.observer
import slinky.core.facade.ReactElement

object ObserverComponent {
  def apply[P](fn: P => ReactElement)(implicit name: FunctionalComponentName): FunctionalComponent[P] = {
    val base = FunctionalComponent(fn)
    new FunctionalComponent(observer(base.component))
  }
}
