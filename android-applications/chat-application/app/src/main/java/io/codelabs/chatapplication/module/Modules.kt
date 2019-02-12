package io.codelabs.chatapplication.module

import io.codelabs.chatapplication.room.ChatAppDatabase
import io.codelabs.chatapplication.room.factory.UserViewModelFactory
import io.codelabs.chatapplication.room.repository.UserRepository
import io.codelabs.chatapplication.room.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { ChatAppDatabase.getInstance(get()) }
}

val roomModule = module {
    single { UserViewModelFactory(get()) }
    single { UserRepository(get()) }
    viewModel { UserViewModel(get()) }
}

val firebaseModule = module {

}