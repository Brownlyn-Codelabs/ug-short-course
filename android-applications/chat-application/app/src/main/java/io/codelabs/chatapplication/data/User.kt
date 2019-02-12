package io.codelabs.chatapplication.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


/**
 * [User] data model
 */
@Parcelize
@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = false)
    override var key: String,
    override var name: String,
    var profile: String? = null,
    var timestamp: Long = System.currentTimeMillis(),
    var lastSeen: Long = System.currentTimeMillis(),
    var status: String = ""
) : BaseDataModel {

    @Ignore
    constructor() : this("", "")

}

