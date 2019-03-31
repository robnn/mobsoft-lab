package hu.robnn.mobsoft.model

import com.google.gson.annotations.SerializedName

data class TodosResult(
    @SerializedName("todos")
    var todos: List<Todo>
)