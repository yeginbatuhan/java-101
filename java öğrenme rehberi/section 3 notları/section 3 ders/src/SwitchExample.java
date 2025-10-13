public class SwitchExample {
    public static void main(String[] args) {
        String day = "Monday";

        // Modern switch (Java 14+)
        String dayType = switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
            case "Saturday", "Sunday" -> "Weekend";
            default -> "Invalid day";
        };

        System.out.println(dayType);

        // Klasik switch
        int month = 3;
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("Winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            default:
                System.out.println("Fall");
        }
    }
}
