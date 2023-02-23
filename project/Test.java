import java.util.*;

public class Test{
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter your name: ");
String name = sc.nextLine();
System.out.println("Welcome " + name + "!");

Registration registration = new Registration();
registration.register();
sc.close();
}
}