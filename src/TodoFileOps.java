import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoFileOps {
    public static String todosDirectoryStringPath = System.getProperty("user.dir")+"//src//Todos";
    public static File todosDirectoryPath = new File(todosDirectoryStringPath);


    public static void listAllTodos(){
        List<File> files = getTodoFilesObjectsList();
        if(files != null){
            System.out.println("Listing All Todos: ");
            for(File file : files){
                System.out.println("\t- "+getFileName(file)); //Print only file name without extension
            }
        }
    }
    public static String getFileName(File file){
        if(file == null) return null;
        String[] nameAndExt = file.getName().split("[.]"); //splitting file name to name and extension
        return nameAndExt[0];
    }
    public static List<File> getTodoFilesObjectsList(){
        try {
            return new ArrayList<File>(Arrays.asList(todosDirectoryPath.listFiles()));

        } catch (NullPointerException e){
            System.out.println("no such directory!");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<String> getFileContent(File file){
        Path path = Paths.get(todosDirectoryStringPath,file.getName());
        try{
            List<String> lines = Files.readAllLines(path);
            return lines;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static List<Todo> getAllTodos(){
        List<File> files = getTodoFilesObjectsList();
        if(files == null) return null;
        ArrayList<Todo> todos = new ArrayList<>();
        for(File file : files){
            String filename = getFileName(file);
            todos.add(new Todo(filename,getFileContent(file),true));
        }
        return todos;
    }
    public static boolean saveTodo(Todo todo){
        try{
            PrintWriter writer = new PrintWriter(todosDirectoryStringPath+"//"+todo.getTitle()+".txt", "UTF-8");
            List<String> todoContent = todo.getContent();
            writer.println(todo.getTimeInserted() );
            for(String line: todoContent){
                writer.println(line);
            }
            writer.close();
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
