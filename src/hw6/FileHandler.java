package hw6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that provides utility methods for reading data from text files.
 *
 * A static import is recommended: import static hw6.FileHandler.*;
 */
public class FileHandler {
    /**
     * Opens the file with the specified name and returns the contents as an
     * {@link Iterable} of strings where each element is a line from the file.
     *
     * This means that the method can be used in a for each loop like so:
     *
     * <tt>for(String line : FileHandler.open("afile.txt")) {...}</tt>
     *
     * Or, with <tt>import static hw6.FileHandler.*;</tt>:
     *
     * <tt>for(String line : open("afile.txt")) {...}</tt>
     *
     * @param filename The name of the file to open.
     * @return An {@link Iterable} of lines in the file.
     */
    public static Iterable<String> open(String filename) {
        // safely open the file for reading...
        try(InputStream input = new FileInputStream(filename);
            Reader reader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(reader)) {

            // copy the file line-by-line into a list...
            List<String> lines = new ArrayList<>();
            bufferedReader.lines().forEach(lines::add);
            // return the list
            return lines;
        } catch(Exception e) {
            // if there is an error opening the file, print a message
            // and exit the program
            System.err.println("Error opening file: " + filename);
            e.printStackTrace();
            System.exit(1); // exit the program with an error
            return null; // never executes
        }
    }
}
