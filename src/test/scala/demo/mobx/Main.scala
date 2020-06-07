package demo.mobx

import com.olvind.mobx.facade.mobx.mod.{action, observable}
import com.olvind.mobx.facade.mobx.observablevalueMod.IObservableValue
import org.scalajs.dom.document
import slinky.core.{FunctionalComponent, ObserverComponent}
import slinky.web.ReactDOM
import slinky.web.html._

import scala.scalajs.js

object Main {

  class Store(initialValue: Int) {
    val state: IObservableValue[Int] = observable.box(initialValue)
    val setState: js.Function1[Int, Unit] = action("setState", state.set(_))
  }

  val Main: FunctionalComponent[Store] = ObserverComponent[Store] { store =>
    div(
      "state: ",
      store.state.get(),
      button(onClick := (() => store.state.set(store.state.get() + 1)), "increment")
    )
  }

  def main(args: Array[String]): Unit = {
    val store = new Store(1)
    ReactDOM.render(Main(store), document.getElementById("container"))
  }
}
