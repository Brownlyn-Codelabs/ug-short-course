package io.codelabs.chatapplication.view.fragment

import android.os.Bundle
import android.view.View
import io.codelabs.chatapplication.R
import io.codelabs.chatapplication.util.BaseActivity
import io.codelabs.chatapplication.util.BaseFragment
import io.codelabs.chatapplication.util.debugLog

class ProfileFragment : BaseFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun onViewCreated(instanceState: Bundle?, view: View, rootActivity: BaseActivity) {
        val key = rootActivity.database.key
        debugLog(key)
    }
}