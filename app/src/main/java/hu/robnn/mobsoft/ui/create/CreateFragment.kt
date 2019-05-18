package hu.robnn.mobsoft.ui.create

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hu.robnn.mobsoft.R
import hu.robnn.mobsoft.injector
import hu.robnn.mobsoft.model.Todo
import kotlinx.android.synthetic.main.fragment_create.*
import kotlinx.android.synthetic.main.fragment_todos.*
import java.util.*
import javax.inject.Inject

class CreateFragment : Fragment(), CreateScreen {

    @Inject
    lateinit var createPresenter: CreatePresenter


    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        createPresenter.attachScreen(this)
    }

    override fun onDetach() {
        createPresenter.detachScreen()
        super.onDetach()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_save.setOnClickListener {
            val todo = Todo()
            todo.creationDate = Date()
            todo.description = description_text.text.toString()
            createPresenter.createTodo(todo)
            closeCreateScreen()
        }
    }

    override fun closeCreateScreen() {
        this.activity?.finish()
    }

    override fun showNetworkError(errorMsg: String) {
        swipeRefreshLayoutTodos.isRefreshing = false
        Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show()
    }

    companion object {

        fun newInstance(): CreateFragment {
            val fragment = CreateFragment()
            val bundle = Bundle()

            fragment.arguments = bundle
            return fragment
        }
    }
}
