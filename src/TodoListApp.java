public class TodoListApp {

    public static String[] todos = new String[7];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static String getInput(String description) {
        System.out.print(description + "\t: ");
        String todo = scanner.nextLine();
        return todo;
    }

    public static void testGetInput() {
       String aTodo = getInput("Ketik task mu");
       System.out.println(aTodo);
    }

    public static void viewTodos() {
        while(true){
            String choosedMenu = "";

            getTodos();

            System.out.println("\nMenu\t:");
            System.out.println("1.\t[+] ke List.");
            System.out.println("2.\t[-] dari list.");
            System.out.println("0.\t[x] keluar.\n");

            choosedMenu = getInput("Pilih Salah satu");

            if (choosedMenu.equals("1")) {
                viewAddTodo();
            } else if (choosedMenu.equals("2")) {
                viewDelTodo();
            } else if (choosedMenu.equals("0")) {
                System.out.println("Thanks for trying.");
                break;
            } else {
                System.out.println("Input tidak valid dengan Menu,\nPilih [1] atau [2].\n[0] Untuk keluar.\n");
            }
        }
    }

    public static void testViewTodos() {
        addTodo("Ayo makan");
        addTodo("Jangan lupa minum air");
        addTodo("Tidur siang 15 menit");
        viewTodos();
    }

    public static void viewAddTodo() {
        String newTodo = getInput("\nKetikkan task baru.\n[0] Batal Menambah task.\n");

        if (newTodo.equals("0")) {

        } else {
            addTodo(newTodo);
        }
    }

    public static void testViewAddTodo() {
        addTodo("Ayo makan");
        addTodo("Jangan lupa minum air");
        addTodo("Tidur siang 15 menit");
        viewTodos();
//        viewAddTodo();
    }

    public static void viewDelTodo() {
        getTodos();
        String todoId = getInput("\nMasukkan nomor [n] task.\n[0] Batal Menghapus task.\n");

        if (todoId.equals("0")) {

        } else {
            boolean isSuccess = delTodo(Integer.valueOf(todoId));
            if(!isSuccess) {
                System.out.println("Gagal menghapus untuk\n" + "task id " + "[" + todoId + "]\n");
            }
        }
    }

    public static void testViewDelTodo() {
        addTodo("Ayo makan");
        addTodo("Jangan lupa minum air");
        addTodo("Tidur siang 15 menit");
        viewTodos();
    }

    public static void getTodos() {
        System.out.println("\nTodolist saat ini\t:");
        for (int i =0; i < todos.length; i++) {
            var todo = todos[i];
            var todoNo = i + 1;

            if (todo != null ) {
                System.out.println(todoNo + ". " + todo);
            }
        }
    }

    public static void testGetTodos () {
        getTodos();
    }

    public static void addTodo(String todo){

        var hasEmptyIndex = false;

        for (int index = 0; index < todos.length; index++) {
            if (todos[index] == null) {
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

        for (int index = 0; index < todos.length; index++) {
            if (todos[index] == null) {
                todos[index] = todo;
                break;
            }
        }
    }

    public static void testAddTodo() {
        for (int index = 0; index < 7; index++) {
            addTodo("This todo task : " + (index + 1));
        }
    }

    public static boolean delTodo(Integer todoIndex){
       if ((todoIndex - 1) >= todos.length || todos[todoIndex - 1] == null) {
           return false;
       } else {
           for (int index = (todoIndex - 1); index < todos.length; index++){
               if (index == (todos.length - 1)) {
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

    public static void main(String[] args) {
        viewTodos();
//        testViewDelTodo();
//        testViewAddTodo();
//        testViewTodos();
//        testGetInput();
//        testDelTodo();
//        testAddTodo();
//        testGetTodos();
    }
}
