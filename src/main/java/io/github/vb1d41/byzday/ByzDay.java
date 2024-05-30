package io.github.vb1d41.byzday;

import io.github.vb1d41.byzcal.ByzDate;

import java.time.format.DateTimeParseException;
import java.time.LocalDate;

public class ByzDay {
    public static void main(String[] args) {
        System.exit(process(args));
    }

    private static int process(String[] args) {
        if (helpRequested(args))
            return printHelp();

        return printDate(args);
    }

    private static boolean helpRequested(String[] args) {
        for (String arg : args)
            if (arg.equals("-h") || arg.equals("--help"))
                return true;

        return false;
    }

    private static int printHelp() {
        System.out.println("Usage: byzday [DATE]");
        System.out.println("Shows the current or custom date in the Byzantine calendar.");
        System.out.println("DATE - the Gregorian date represented as YYYY-MM-DD");
        return 0;
    }
    
    private static int printDate(String[] args) {
        try {
            var date = args.length > 0 ? LocalDate.parse(args[0]) : LocalDate.now();
            System.out.println(ByzDate.fromGregorian(date));
            return 0;
        }
        catch (DateTimeParseException e) {
            System.err.println("Cannot parse date.");
            return 1;
        }
    }
}

