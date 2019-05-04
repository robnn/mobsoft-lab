package hu.robnn.mobsoft.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "todo_table")
data class Todo(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "creation_date")
    @SerializedName("creationDate")
    var creationDate: Date? = null,

    @NonNull
    @SerializedName("description")
    var description: String? = null
)