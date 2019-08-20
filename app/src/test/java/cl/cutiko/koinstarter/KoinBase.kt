package cl.cutiko.koinstarter

import cl.cutiko.koinstarter.viewmodeldoc.HelloRepositoryImpl
import cl.cutiko.koinstarter.viewmodeldoc.HelloViewmodel
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject

//You have to create a special module otherwise using the viewmodel with inject wont work
val testModule = module {
    single { HelloRepositoryImpl() }
    single { HelloViewmodel(get<HelloRepositoryImpl>()) }
}

@RunWith(JUnit4::class)
abstract class KoinBaseTest : KoinTest {

    val helloViewmodel: HelloViewmodel by inject()
    val helloRepository by inject<HelloRepositoryImpl>()

    @Before
    fun before() {
        startKoin {
            modules(testModule)
        }
    }

    @After
    fun after() {
        stopKoin()
    }

}