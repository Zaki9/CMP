package koin

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import viewmodel.BaseViewModel

actual val viewModelModule = module {
    singleOf(::BaseViewModel)
}