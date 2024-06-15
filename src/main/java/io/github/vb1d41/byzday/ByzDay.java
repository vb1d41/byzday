/*
 * Copyright 2024 vb1d41
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.vb1d41.byzday;

import io.github.vb1d41.byzcal.ByzDate;

import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * @version 1.0.2
 */
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
        return Arrays.stream(args).anyMatch(s -> s.equals("-h") || s.equals("--help"));
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

