package hu.robnn.todos.api

import java.util.*
import java.util.Random



class Todo(var creationDate: Date? = null,
           var description: String? = null)

class TodosResponse(var todos: MutableList<Todo> = mutableListOf()) {
    companion object {
        private fun randomDate(): Date {
            val rnd = Random()
            val ms = -946771200000L + Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000)

            return Date(ms)
        }
        fun getRandomTodos() : TodosResponse{
            val resp = TodosResponse()
            for(i in 1..10) {
                val todo = Todo()
                todo.creationDate = randomDate()
                todo.description = "Description $i"
                resp.todos.add(todo)
            }
            return resp
        }
    }
}