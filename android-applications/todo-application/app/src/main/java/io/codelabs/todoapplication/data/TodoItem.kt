package io.codelabs.todoapplication.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "todos")
@Parcelize
data class TodoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var content: String,
    var timestamp: Long = System.currentTimeMillis(),
    var completed: Boolean = false
) : BaseDataModel {

    /**
     * The room persistence library escapes this constructor as its default constructor
     */
    @Ignore
    constructor(content: String) : this(0, content)

}