package cl.cutiko.koinstarter

import cl.cutiko.koinstarter.viewmodeldoc.HelloRepository
import cl.cutiko.koinstarter.viewmodeldoc.HelloRepositoryImpl
import cl.cutiko.koinstarter.viewmodeldoc.HelloViewmodel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModule = module {
    single { KoinInjectable() }
    single<HelloRepository> { HelloRepositoryImpl() }
    viewModel { HelloViewmodel(get()) }
}