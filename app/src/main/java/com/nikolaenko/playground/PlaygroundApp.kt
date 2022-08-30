package com.nikolaenko.playground

import android.app.Application
import com.nikolaenko.playground.auth.di.authModules
import com.nikolaenko.playground.chat.di.chatModules
import com.nikolaenko.playground.feed.di.feedModules
import com.nikolaenko.playground.core.di.coreModules
import com.nikolaenko.playground.di.appModules
import com.nikolaenko.playground.profile.di.profileModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PlaygroundApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PlaygroundApp)
            modules(
                appModules
                        + coreModules
                        + authModules
                        + feedModules
                        + profileModules
                        + chatModules
            )
        }
    }
}
