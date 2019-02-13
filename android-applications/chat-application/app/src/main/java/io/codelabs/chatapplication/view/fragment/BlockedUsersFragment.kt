package io.codelabs.chatapplication.view.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.Query
import io.codelabs.chatapplication.R
import io.codelabs.chatapplication.data.BaseDataModel
import io.codelabs.chatapplication.data.Chat
import io.codelabs.chatapplication.util.BaseActivity
import io.codelabs.chatapplication.util.BaseFragment
import io.codelabs.chatapplication.util.USER_CHATS_REF
import io.codelabs.chatapplication.util.debugLog
import io.codelabs.chatapplication.view.adapter.UserAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class BlockedUsersFragment : BaseFragment(), UserAdapter.ItemClickListener {
    override fun getLayoutId(): Int = R.layout.fragment_main

    override fun onViewCreated(instanceState: Bundle?, view: View, rootActivity: BaseActivity) {
        val adapter = UserAdapter(rootActivity, this)
        grid.adapter = adapter
        val layoutManager = LinearLayoutManager(rootActivity)
        grid.layoutManager = layoutManager
        grid.setHasFixedSize(true)

        try {
            rootActivity.firestore.collection(String.format(USER_CHATS_REF, rootActivity.database.key))
                .orderBy("createdAt", Query.Direction.ASCENDING)
                .whereEqualTo("blocked", true)
                .addSnapshotListener(rootActivity) { snapshot, exception ->
                    if (exception != null) {
                        debugLog("Cause: ${exception.cause}")
                        debugLog(exception.localizedMessage)
                        return@addSnapshotListener
                    }

                    val users = snapshot?.toObjects(Chat::class.java)
                    if (users != null) adapter.addData(users.toMutableList())

                }
        } catch (e: Exception) {
            debugLog(e.cause)
        }
    }

    override fun onClick(item: BaseDataModel) {
        //todo: unblock user

    }
}
