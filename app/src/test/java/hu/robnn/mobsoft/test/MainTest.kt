package hu.robnn.mobsoft.test

import hu.robnn.mobsoft.dao.TodoDatabase
import hu.robnn.mobsoft.interactor.todos.event.GetTodosEvent
import hu.robnn.mobsoft.mock.MockTodosApi
import hu.robnn.mobsoft.model.Todo
import hu.robnn.mobsoft.testInjector
import hu.robnn.mobsoft.ui.main.MainPresenter
import hu.robnn.mobsoft.ui.main.TodosScreen
import hu.robnn.mobsoft.utils.argumentCaptor
import hu.robnn.mobsoft.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import java.lang.Exception
import java.util.*
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class MainTest {
    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var mainScreen: TodosScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun `meghivodik a fuggveny a refresh hatasara`() {
        mainPresenter.refreshTodos()
        verify(mainScreen).showTodos(MockTodosApi.todosResult?.todos)
    }

    @Test
    fun `esemeny altal megjelenitett lista 1 elemu`() {
        val event = GetTodosEvent()
        event.todos = ArrayList()
        event.todos!!.add(Todo(Date(), "test tescription"))
        event.code = 200

        val list = argumentCaptor<List<Todo>>()
        mainPresenter.onEventMainThread(event)
        verify(mainScreen).showTodos(list.capture())
        assert(list.value?.size == 1)
    }

    @Test
    fun `mock api altal vissza adott lista 1 elemu`() {
        mainPresenter.refreshTodos()
        val list = argumentCaptor<List<Todo>>()
        verify(mainScreen).showTodos(list.capture())
        assert(list.value?.size == 1)
    }

    @After
    fun cleanup() {
        mainPresenter.detachScreen()
        TodoDatabase.close()
        TodoDatabase.resetInstance()
    }
}