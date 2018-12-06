import java.util.*;

public class Todo implements Comparable<Todo> {
    private final String title;
    private final long timeInserted;
    private List<String> content;

    public Todo(String title,List<String> content, boolean fromFile){
        this(title,Long.parseLong(content.get(0)),content);
    }
    public Todo(String title, List<String> content) {
        this(title, new Date().getTime(), content);

    }

    public Todo(String title, long timeInserted, List<String> content) {
        this.title = title;
        this.timeInserted = timeInserted;
        this.content = content;
    }

    public void setContent(List<String> content){
        this.content = content;
    }

    @Override
    public int compareTo(Todo otherTodo) {
        if(timeInserted > otherTodo.getTimeInserted()){
            return 1;
        }
        else if(timeInserted == otherTodo.getTimeInserted()) return 0;
        return -1;
    }

    public static Todo createTodo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Todo Title: ");
        String title = scanner.nextLine();
        ArrayList<String> lines = new ArrayList<>();

        System.out.println("Enter Todo Content (q to stop): ");
        String line = scanner.nextLine();
        while (!line.equals("q")){
            lines.add(line);
            line = scanner.nextLine();
        }
        return new Todo(title,lines);
    }
    public Date getTimeCreated(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInserted);
        return calendar.getTime();
    }

    public void printTodo(){
        System.out.println("******************\n"+title + " " + getTimeCreated() + "\n##################################\n");
        boolean isFirstLine = true;
        for(String line: content){
            if(isFirstLine) {
                isFirstLine = false;
                continue;
            }
            System.out.println(line);
        }
        System.out.println("\n#####################################");
    }
    private String getTodoSaveFormat(){
        return "";
    }
    public boolean saveTodo(){
        return TodoFileOps.saveTodo(this);
    }

    public String getTitle() {
        return title;
    }

    public long getTimeInserted() {
        return timeInserted;
    }
    public List<String> getContent() {
        return content;
    }
}
