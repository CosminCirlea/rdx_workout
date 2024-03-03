package com.evolutionsoftware.auther

import android.content.Context
import com.evolutionsoftware.auther.data.MainRepositoryImpl
import com.evolutionsoftware.auther.domain.repository.MainRepository
import com.evolutionsoftware.auther.presentation.checkPin.CheckPinViewModel
import com.evolutionsoftware.auther.presentation.credentials.CredentialsViewModel
import com.evolutionsoftware.auther.presentation.main.MainViewModel
import com.evolutionsoftware.auther.presentation.personalInfo.PersonalInfoViewModel
import com.evolutionsoftware.auther.presentation.pin.PinViewModel
import com.evolutionsoftware.auther.presentation.splash.SplashViewModel
import com.evolutionsoftware.auther.presentation.termsOfService.TermsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.logger.Level
import org.koin.dsl.module

object KoinModules {
    private val koinModules = module {
        //repos
        single<MainRepository> { MainRepositoryImpl(androidContext()) }

        //viewModels
        viewModel { MainViewModel(get()) }
        viewModel { TermsViewModel() }
        viewModel { CredentialsViewModel(get()) }
        viewModel { PersonalInfoViewModel(get()) }
        viewModel { PinViewModel(get()) }
        viewModel { SplashViewModel(get()) }
        viewModel { CheckPinViewModel(get()) }
    }

    fun startKoin(androidContext: Context) {
        org.koin.core.context.startKoin {
            androidLogger(Level.ERROR)
            androidContext(androidContext)
            modules(koinModules)
        }
    }
}