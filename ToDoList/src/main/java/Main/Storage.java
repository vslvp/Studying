package Main;

import Main.model.ToDoList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static int currentId = 1;
    private static HashMap<Integer, ToDoList> toDoLists = new HashMap<>();

    public static List<ToDoList> getAllToDos(){
        ArrayList<ToDoList> doLists = new ArrayList<>();
        doLists.addAll(toDoLists.values());
        return doLists;
    }

    public static int addToDo(ToDoList toDoList){
        int id = currentId++;
        toDoList.setId(id);
        toDoLists.put(id, toDoList);
        return id;
    }

    public static ToDoList getToDo(int toDoId){
        if (toDoLists.containsKey(toDoId)){
            return toDoLists.get(toDoId);
        }
        return null;
    }
}
