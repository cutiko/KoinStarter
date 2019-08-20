package cl.cutiko.koinstarter.viewmodeldoc

import androidx.lifecycle.ViewModel

class HelloViewmodel(private val helloRepository: HelloRepository) : ViewModel() {

    fun sayHello() = "${helloRepository.getHello()} from $this"

}