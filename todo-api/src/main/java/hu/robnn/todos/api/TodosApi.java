package hu.robnn.todos.api;


import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@RestController("/todos")
@RequestMapping(path = "/todos")
@CrossOrigin
public class TodosApi {

    private static final TodosResponse TODOS = TodosResponse.Companion.getRandomTodos();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<TodosResponse> getTodos(){
        return new ResponseEntity<>(TODOS, HttpStatus.OK);
    }

}
