package hu.robnn.mobsoft.ui.main

import hu.robnn.mobsoft.model.Todo

interface TodosScreen {
    fun showTodos(todos: List<Todo>?)
    fun showNetworkError(errorMsg: String)
}
