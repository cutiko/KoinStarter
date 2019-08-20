package cl.cutiko.koinstarter

import android.view.View
import com.google.android.material.snackbar.Snackbar

class KoinInjectable {

    fun snakSomething(view: View, listener: View.OnClickListener? = null, text : String = "Injected Snack") =
        Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .apply {
                if (listener != null) {
                    this.setAction("Action", listener)
                }
            }
            .let { it.show() }
}