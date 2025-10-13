//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }



        // Declaration
        int age;
        String name;

        // Initialization
        age = 25;
        name = "Ali";

        // Declaration + Initialization
        double salary = 5000.50;
        boolean isActive = true;

        System.out.println("İsim: " + name);
        System.out.println("Yaş: " + age);
        System.out.println("Maaş: " + salary);
        System.out.println("Aktif: " + isActive);
    }

}
