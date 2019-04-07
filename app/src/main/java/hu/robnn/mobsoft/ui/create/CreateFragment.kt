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
import kotlinx.android.synthetic.main.fragment_todos.*
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

    override fun closeCreateScreen() {
        //TODO close create screen
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
