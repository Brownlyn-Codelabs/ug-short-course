package io.codelabs.chatapplication.core

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.google.firebase.FirebaseApp
import io.codelabs.chatapplication.module.appModule
import io.codelabs.chatapplication.module.firebaseModule
import io.codelabs.chatapplication.module.roomModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChatApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        // Init Firebase
        FirebaseApp.initializeApp(this)

        // Init Koin
        startKoin {
            androidContext(this@ChatApplication)

            modules(appModule, roomModule, firebaseModule)

        }

    }
}