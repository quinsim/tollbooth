package hw6;

/**
 * An interface that contains useful constants for classes in the Tolls R Us
 * simulation. Classes  may simply refer to the constants here (i.e.
 * <tt>TollsRUs.INCOMPLETE_TOLL_FORMAT</tt> or may implement the interface
 * to access the constants directly.<P>
 *
 * Note that none of the constants are marked as <tt>public static final</tt>
 * because all variables in an interface are implicitly public, static, and
 * final.
 */
public interface TollsRUs {
    /**
     * The string format for incomplete toll records (including exit number,
     * arrival exit number, and arrival time).
     * using {@link String#format(String, Object...)}
     */
    String INCOMPLE_TOLL_RECORD_FORMAT =
            "[%11s] on #%2d, time %5d";

    /**
     * The string format for complete toll records (including exit number,
     * arrival exit number, arrival time, departure exit number, and departure
     * time).
     */
    String COMPLETE_TOLL_RECORD_FORMAT =
            INCOMPLE_TOLL_RECORD_FORMAT + "; off #%2d, time %5d";

    /**
     * Value used for uninitialized integer fields.
     */
    int UNINITIALIZED = -1;

    /**
     * The string format for values in dollar/cents format. Example:
     * <tt>System.out.println( String.format( DOLLAR_FORMAT, 10.5 );
     * // $10.50</tt>
     */
    String DOLLAR_FORMAT = "$%5.2f";

    /**
     * The string format for speeds. Example:
     * <tt>System.out.println(String.format(SPEED_FORMAt, 88); // ___88.0</tt>
     */
    String SPEED_FORMAT = "%5.1f MpH";

    /**
     * System-specific newline character.
     */
    String NL = System.lineSeparator();

    /**
     * Conversion constant from minutes to hours.
     */
    double MINUTES_PER_HOUR = 60.0;

    /**
     * This toll road's speed limit, in miles per hour
     */
    double SPEED_LIMIT = 65.0;
}
