public class TodoListApp {

    public static String[] todos = new String[7];

    public static void getTodos() {
        for(int i =0; i < todos.length; i++) {
            var todo = todos[i];
            var todoNo = i + 1;

            if(todo != null ) {
                System.out.println(todoNo + ". " + todo);
            }
        }
    }

    public static void testGetTodos () {
        getTodos();
    }

    public static void addTodo(String todo){

        var hasEmptyIndex = false;

        for(int index = 0; index < todos.length; index++) {
            if(todos[index] == null) {
               hasEmptyIndex = true;
               break;
            }
        }

        if(!hasEmptyIndex) {
            var currentTodos = todos;
            todos = new String[todos.length * 2];

            for (int index = 0; index < currentTodos.length; index++) {
                todos[index] = currentTodos[index];
            }
        }

        for(int index = 0; index < todos.length; index++) {
            if(todos[index] == null) {
                todos[index] = todo;
                break;
            }
        }
    }

    public static void testAddTodo() {
        for(int index = 0; index < 7; index++) {
            addTodo("This todo task : " + (index + 1));
        }
    }

    public static boolean delTodo(Integer todoIndex){
       if((todoIndex - 1) >= todos.length || todos[todoIndex - 1] == null) {
           return false;
       } else {
           for(int index = (todoIndex - 1); index < todos.length; index++){
               if(index == (todos.length - 1)) {
                   todos[index] = null;
               } else {
                   todos[index] = todos[index + 1];
               }
           }
           return true;
       }
    }

    public static void testDelTodo() {
        var validDeleteTodo = delTodo(3);
        validDeleteTodo = delTodo(5);
        System.out.println(validDeleteTodo);
    }

    public static void viewTodos() {

    }

    public static void viewAddTodo() {

    }

    public static void viewDelTodo() {

    }

    public static void main(String[] args) {
        testAddTodo();
        testDelTodo();
        testGetTodos();
    }
}
