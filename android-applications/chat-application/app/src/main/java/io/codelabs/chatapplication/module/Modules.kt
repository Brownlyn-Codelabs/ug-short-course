package io.codelabs.chatapplication.module

import io.codelabs.chatapplication.room.ChatAppDatabase
import org.koin.dsl.module

val appModule = module {
    single { ChatAppDatabase.getInstance(get()) }
}

val roomModule = module {

}

val firebaseModule = module {

}