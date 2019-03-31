package hu.robnn.mobsoft.model

import com.google.gson.annotations.SerializedName

data class TodoResult(
    @SerializedName("todo")
    var todo: Todo
)