import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        Date date = new Date();
//        long time = date.getTime();
//        calendar.setTimeInMillis(time);
//        System.out.println(calendar.getTime());
//        System.out.println(calendar.toInstant());
        TodoFileOps.listAllTodos();
        //List<String> lines = new ArrayList<>();
        //lines.add("Start Training");
        //lines.add("DO pushups");
        //Date date = new Date();
        //Todo new_todo = new Todo("Go practise",date.getTime(),lines);
        //new_todo.saveTodo();
        //List<Todo> todos = TodoFileOps.getAllTodos();
        //for(Todo todo : todos){
        //    todo.printTodo();
        //}
        //Todo oneTodo = Todo.createTodo();
        //TodoFileOps.saveTodo(oneTodo);

        //Todo secondTodo = Todo.createTodo();
        //TodoFileOps.saveTodo(secondTodo);

        Todo newTodo = Todo.createTodo();
        newTodo.saveTodo();

        Todo anotherNewTodo = Todo.createTodo();
        anotherNewTodo.saveTodo();
        List<Todo> todos = TodoFileOps.getAllTodos();
        Collections.sort(todos);
        for(Todo todo : todos){
            todo.printTodo();
        }


    }
}
