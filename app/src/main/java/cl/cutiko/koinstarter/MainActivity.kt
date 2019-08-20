package cl.cutiko.koinstarter

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import cl.cutiko.koinstarter.viewmodeldoc.HelloViewmodel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val koinInjectable : KoinInjectable by inject()
    val viewmodel : HelloViewmodel by viewModel()
    val lazyString : String by lazy {
        Log.d("CUTIKO_TAG", "${this::javaClass.get().simpleName}: starting the string")
        "hello world"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val hello = viewmodel.sayHello()
            koinInjectable.snakSomething(
                view = view,
                text = hello
            )
            if (lazyString != null) {
                Log.d("CUTIKO_TAG", "${this::javaClass.get().simpleName}: is not null")
            } else {
                Log.d("CUTIKO_TAG", "${this::javaClass.get().simpleName}: is null")
            }

        }

        //Log.d("CUTIKO_TAG", "${this::javaClass.get().simpleName}: $logger")

    }
}
