package com.nikolaenko.playground

import android.app.Application
import com.nikolaenko.feed.di.feedModules
import com.nikolaenko.playground.di.appModules
import com.nikolaenko.profile.di.profileModules
import com.nikolaenko.settings.di.settingsModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PlaygroundApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@PlaygroundApp)
            modules(appModules + feedModules + profileModules + settingsModules)
        }
    }
}
