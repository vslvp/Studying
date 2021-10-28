package Main;

import Main.model.ToDoList;
import Main.model.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Controller
public class DefaultController {

    @Autowired
    ToDoRepository toDoRepository;

    @RequestMapping("/")
    public String index(Model model){
        Iterable<ToDoList> toDoListIterable = toDoRepository.findAll();
        ArrayList<ToDoList> toDos = new ArrayList<>();
        for (ToDoList toDo : toDoListIterable){
            toDos.add(toDo);
        }
        model.addAttribute("toDos", toDos);
        model.addAttribute("toDosCount", toDos.size());
        return "index";
    }
}
