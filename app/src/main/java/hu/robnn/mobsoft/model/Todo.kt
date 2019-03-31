package hu.robnn.mobsoft.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Todo(
    @SerializedName("creationDate")
    var creationDate: Date? = null,
    @SerializedName("description")
    var description: String? = null
)