package hw6;

import java.util.Scanner;

public class TollReport {

    private TollRoadDatabase database;

    private void run_report(String file) {
        database = new TollRoadDatabase(file);
        System.out.println(database.on_road_report());
        System.out.println(database.speeder_report());
        System.out.println(database.billing_report());
    }
    
    private void get_console() {
        System.out.println(String.format(
        "'b <string>' to see bill for license tag\n"
        + "'e <number>' to see activity at exit\n"
        + "'q' to quit"));
    }
    
    private void run_terminal() {
        String choice;
        Scanner scanner = new Scanner(System.in);
        do {
            this.get_console();
            choice = scanner.nextLine();
            String[] choice_parts = choice.split(" ");
            if (choice_parts[0].length() != 1) {
                System.out.println("Illegal command. Try again");
            } else if (choice_parts[0].charAt(0) == 'b') {
                System.out.println(database.customer_report(choice_parts[1]));
            } else if (choice_parts[0].charAt(0) == 'e') {
                System.out.println(database.exit_activity_report(Integer.valueOf(choice_parts[1])));
            } else if (!(choice_parts[0].charAt(0) == 'q')) {
                System.out.println("Illegal command. Try again");
            }
        } while (!(choice.equals("q")));
    }
    public static void main(String[] args) {
        TollReport report = new TollReport();
        report.run_report("src/resource/data/5guys.txt");
        report.run_terminal();
    }
}