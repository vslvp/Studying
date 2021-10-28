package Main;

import Main.model.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Main.model.ToDoList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/todos/")
    public List<ToDoList> list(){
        Iterable<ToDoList> toDoListIterable = toDoRepository.findAll();
        ArrayList<ToDoList> toDos = new ArrayList<>();
        for (ToDoList todo : toDoListIterable){
            toDos.add(todo);
        }
        return toDos;
    }

    @PostMapping("/todos/")
    public int add(ToDoList toDo){
        ToDoList newToDo = toDoRepository.save(toDo);
        return newToDo.getId();
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity get(@PathVariable int id){
        Optional<ToDoList> optionalToDoList = toDoRepository.findById(id);
        if (!optionalToDoList.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalToDoList.get(), HttpStatus.OK);
    }
}
