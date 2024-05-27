package koin

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import viewmodel.BaseViewModel

actual val viewModelModule = module {
    viewModelOf(::BaseViewModel)
}