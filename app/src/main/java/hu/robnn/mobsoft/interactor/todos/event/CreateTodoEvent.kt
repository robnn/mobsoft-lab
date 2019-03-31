package hu.robnn.mobsoft.interactor.todos.event

import hu.robnn.mobsoft.model.Todo

data class CreateTodoEvent(var code: Int = 0,
                           var todo: Todo? = null,
                           var throwable: Throwable? = null)