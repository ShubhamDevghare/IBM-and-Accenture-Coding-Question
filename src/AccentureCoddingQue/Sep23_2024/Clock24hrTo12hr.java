package AccentureCoddingQue.Sep23_2024;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock24hrTo12hr {
    public static void main(String[] args) {
        String inputTime = "15:30"; // Given 24-hour format time

        try {
            // Step 1: Create a SimpleDateFormat object to parse the 24-hour format time
            SimpleDateFormat inputFormat = new SimpleDateFormat("HH:mm");

            // Step 2: Parse the 24-hour format time into a Date object
            Date date = inputFormat.parse(inputTime);

            // Step 3: Create another SimpleDateFormat object to format the Date object into 12-hour format
            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");

            // Step 4: Format the Date object into a 12-hour format string with AM/PM
            String outputTime = outputFormat.format(date);

            // Step 5: Output the result
            System.out.println("Time in 12-hour format: " + outputTime);
        } catch (Exception e) {
            System.out.println("Invalid time format. Please use HH:mm format.");
        }
    }
}

