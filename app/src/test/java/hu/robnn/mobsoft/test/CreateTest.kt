package hu.robnn.mobsoft.test

import hu.robnn.mobsoft.dao.TodoDatabase
import hu.robnn.mobsoft.model.Todo
import hu.robnn.mobsoft.testInjector
import hu.robnn.mobsoft.ui.create.CreatePresenter
import hu.robnn.mobsoft.ui.create.CreateScreen
import hu.robnn.mobsoft.ui.main.TodosScreen
import hu.robnn.mobsoft.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import java.lang.Exception
import java.util.*
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class CreateTest {
    @Inject
    lateinit var createPresenter: CreatePresenter
    private lateinit var createScreen: CreateScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        createScreen = mock()
        createPresenter.attachScreen(createScreen)
    }

    @Test
    fun `meghivodik a close screen fuggveny`() {
        val todo = Todo()
        todo.creationDate = Date()
        todo.description = "test description"
        createPresenter.createTodo(todo)
        verify(createScreen).closeCreateScreen()
    }

    @After
    fun cleanup() {
        createPresenter.detachScreen()
        TodoDatabase.close()
        TodoDatabase.resetInstance()
    }

}