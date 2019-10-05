package by.bsuir.PresentationLayer;

public class View {

    public static Object[] getUserData(){
        String name, password;

        System.out.println("\n1. Manager\n2.Customer");
        int res = ConsoleReader.getInt();
        System.out.print("\nEnter your name :");
        ConsoleReader.getString();
        name = ConsoleReader.getString();
        System.out.print("Enter your password :");
        password = ConsoleReader.getString();
        return new Object[] {res, name, password};
    }

    public static void ShowMessage(String message){
        System.out.println(message);
    }

    public static int getAction(){
        System.out.print("\nInput command('3' to see more info): ");
        return ConsoleReader.getInt();
    }

    public static void printAvailableActions(){
        System.out.println("1. Exit");
        System.out.println("2. Log out");
        /*System.out.println("/show -  Show books catalog");
        System.out.println("/findt - Find book by title");
        System.out.println("/finda - Find book by author");
        System.out.println("/finde - Find electronic books");
        System.out.println("/findp - Find paper books");
        System.out.println("/mod - Modify book");
        System.out.println("/add - Add book");
        System.out.println("/delete - Delete book");
        System.out.println("/allusers - Show all users");
        System.out.println("/udelete - Delete user");*/
    }
}
