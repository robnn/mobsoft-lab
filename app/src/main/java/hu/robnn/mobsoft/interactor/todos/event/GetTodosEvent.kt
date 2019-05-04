package hu.robnn.mobsoft.interactor.todos.event

import hu.robnn.mobsoft.model.Todo

data class GetTodosEvent(var code: Int = 0,
                         var todos: MutableList<Todo>? = null,
                         var throwable: Throwable? = null)