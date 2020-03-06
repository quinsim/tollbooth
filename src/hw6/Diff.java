package hw6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Diff {
    /**
     * Utility that compares the contents of two files and prints an error
     * message the first time a mismatch is found.
     * @param args Command line arguments; should specify two filenames to
     *             compare.
     * @throws FileNotFoundException If one or the other file doesn't exist.
     */
    public static void main(String[] args) throws FileNotFoundException {
        if(args.length != 2) {
            System.err.println("Usage: java Diff file1 file2");
            System.exit(1);
        }

        Scanner file1 = new Scanner(new FileInputStream(args[0]));
        Scanner file2 = new Scanner(new FileInputStream(args[1]));

        int line = 1;

        while(file1.hasNext() && file2.hasNext()) {
            String line1 = file1.nextLine().trim();
            String line2 = file2.nextLine().trim();

            if(!line1.equals(line2)) {
                System.err.println("Found mismatch on line " + line);
                System.err.println("  expected: >" + line1 + "<");
                System.err.println("  actual:   >" + line2 + "<");
                System.exit(1);
            }
            line++;
        }

        System.out.println("Matched " + line + " lines.");

        if(file1.hasNext()) {
            System.out.println("File 2 ended before File 1.");
        } else if(file2.hasNext()) {
            System.out.println("File 1 ended before File 2.");
        }
    }
}
