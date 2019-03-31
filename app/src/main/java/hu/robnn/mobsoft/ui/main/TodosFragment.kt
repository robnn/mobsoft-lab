package hu.robnn.mobsoft.ui.main

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hu.robnn.mobsoft.ui.utils.hide
import hu.robnn.mobsoft.ui.utils.show
import hu.robnn.mobsoft.R
import hu.robnn.mobsoft.injector
import hu.robnn.mobsoft.model.Todo
import kotlinx.android.synthetic.main.fragment_todos.*
import javax.inject.Inject

class TodosFragment : Fragment(), TodosScreen {

    private val displayedTodos: MutableList<Todo> = mutableListOf()
    private var todosAdapter: TodosAdapter? = null

    @Inject
    lateinit var todosPresenter: MainPresenter


    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        todosPresenter.attachScreen(this)
    }

    override fun onDetach() {
        todosPresenter.detachScreen()
        super.onDetach()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_todos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerViewTodos.layoutManager = llm

        todosAdapter = TodosAdapter(context!!, displayedTodos)
        recyclerViewTodos.adapter = todosAdapter

        swipeRefreshLayoutTodos.setOnRefreshListener {
            todosPresenter.refreshTodos()
        }
    }

    override fun onResume() {
        super.onResume()
        todosPresenter.refreshTodos()
    }

    override fun showTodos(todos: List<Todo>?) {
        swipeRefreshLayoutTodos.isRefreshing = false
        displayedTodos.clear()
        if (todos != null) {
            displayedTodos.addAll(todos)
        }
        todosAdapter?.notifyDataSetChanged()

        if (displayedTodos.isEmpty()) {
            recyclerViewTodos.hide()
            tvEmpty.show()
        } else {
            recyclerViewTodos.show()
            tvEmpty.hide()
        }

    }

    override fun showNetworkError(errorMsg: String) {
        swipeRefreshLayoutTodos.isRefreshing = false
        Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show()
    }

    companion object {

        fun newInstance(): TodosFragment {
            val fragment = TodosFragment()
            val bundle = Bundle()

            fragment.arguments = bundle
            return fragment
        }
    }
}
