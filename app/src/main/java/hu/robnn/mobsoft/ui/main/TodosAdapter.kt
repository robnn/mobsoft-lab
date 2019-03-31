package hu.robnn.mobsoft.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import hu.robnn.mobsoft.R
import hu.robnn.mobsoft.model.Todo
import kotlinx.android.synthetic.main.card_todo.view.*

class TodosAdapter constructor(
        private val context: Context,
        private var todos: List<Todo>) : RecyclerView.Adapter<TodosAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card_todo, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = todos[position]

        holder.description.text = todo.description
        holder.creationDate.text = todo.creationDate!!.toString()
    }

    override fun getItemCount() = todos.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var description: TextView = view.description
        var creationDate: TextView = view.creationDate
    }
}
