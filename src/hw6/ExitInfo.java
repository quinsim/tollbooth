package hw6;

/**
 * A class that encapsulate the toll schedule for cars travelling on
 * the NY Thruway.
 *
 * @author James Heliotis
 */
public class ExitInfo {

    /**
     * Last exit = Number of exits - 1 because we count from 0
     */
    public final static int LAST_EXIT = 62;

    /**
     * Toll rate in dollars per mile
     */
    public final static double CENTS_PER_MILE = 0.04;

    private static Exit[] EXIT_INFO = new Exit[]{
            new Exit( 0,
                          "New York City Line - Major Deegan Expressway (I-87)",
                          0.0
            ),
            new Exit( 1, "Hall Place - McLean Avenue", 0.48 ),
            new Exit( 2, "Yonkers Avenue - Raceway", 0.92 ),
            new Exit( 3, "Mile Square Road", 1.77 ),
            new Exit( 4, "Cross County Parkway - Mile Square Road", 2.18 ),
            new Exit( 5,
                          "White Plains - Central Park Avenue (NY Route 100)",
                          2.7
            ),
            new Exit( 6, "Yonkers - Bronxville - Tuckahoe Road", 4.00 ),
            new Exit( 7, "Ardsley - NY Route 9A", 7.58 ),
            new Exit( 8,
                          "White Plains - Rye - Cross Westchester Expressway " +
                          "(I-287)",
                          11.31
            ),
            new Exit( 9, "Tarrytown - Sleepy Hollow - US Route 9", 12.65 ),
            new Exit( 10, "Nyack - South Nyack - US Route 9W", 16.75 ),
            new Exit( 11, "Nyack - South Nyack - US Route 9W", 17.63 ),
            new Exit( 12,
                          "West Nyack - NY Route 303 - Palisades Center Drive",
                          18.76
            ),
            new Exit( 13,
                          "New Jersey - Palisades Interstate Parkway - Bear " +
                          "Mountain State Park",
                          20.94
            ),
            new Exit( 14, "Spring Valley - Nanuet - NY Route 59", 22.80 ),
            new Exit( 15, "New Jersey - I-287 - NJ Route 17 South", 30.17 ),
            new Exit( 16, "Harriman - US Route 6 - NY Route 17", 45.20 ),
            new Exit( 17,
                          "Newburgh - Scranton - I-84 - NY Routes 17K & 300",
                          60.10
            ),
            new Exit( 18, "New Paltz - Poughkeepsie - NY Route 299",
                          76.01
            ),
            new Exit( 19,
                          "Kingston - NY Route 28 - Kingston-Rhinecliff Bridge",
                          91.37
            ),
            new Exit( 20, "Saugerties - Woodstock - NY Route 32", 101.25 ),
            new Exit( 21, "Catskill - Cairo - NY Route 23", 113.89 ),
            new Exit( 22, "Selkirk - NY Routes 144 & 396", 134.93 ),
            new Exit( 23,
                          "Albany (Downtown) - Troy - Rensselaer - I-787 - US" +
                          " Route 9W",
                          141.92
            ),
            new Exit( 24, "Albany - Montreal - I-90 East - I-87 North",
                          148.15
            ),
            new Exit( 25, "Schenectady - I-890 - NY Routes 7 & 146",
                          153.83
            ),
            new Exit( 26, "Schenectady - Scotia - I-890 - NY Routes 5 & 5S",
                          162.22
            ),
            new Exit( 27, "Amsterdam - NY Route 30", 173.59 ),
            new Exit( 28, "Fultonville - Fonda - NY Route 30A", 182.17 ),
            new Exit( 29, "Canajoharie - Sharon Springs - NY Route 10",
                          194.10
            ),
            new Exit( 30, "Herkimer - Mohawk - NY Route 28", 219.70 ),
            new Exit( 31, "Utica - I-790 - NY Routes 8 & 12", 232.85 ),
            new Exit( 32, "Westmoreland - Rome - NY Route 233", 243.37 ),
            new Exit( 33, "Verona - Rome - Oneida - NY Route 365", 252.71 ),
            new Exit( 34, "Canastota - Oneida - Chittenango - NY Route 13",
                          261.50
            ),
            new Exit( 35, "Syracuse - East Syracuse - NY Route 298",
                          278.93
            ),
            new Exit( 36, "Watertown - Binghamton - I-81", 282.93 ),
            new Exit( 37, "Syracuse - Liverpool - Electronics Parkway",
                          283.79
            ),
            new Exit( 38, "Syracuse - Liverpool - County Route 57",
                          285.95
            ),
            new Exit( 39, "Syracuse - Fulton - I-690 - NY Route 690",
                          289.53
            ),
            new Exit( 40, "Weedsport - Auburn - NY Route 34", 304.19 ),
            new Exit( 41, "Waterloo - Clyde - NY Route 414", 320.41 ),
            new Exit( 42, "Geneva - Lyons - NY Route 14", 327.10 ),
            new Exit( 43, "Manchester - Palmyra - NY Route 21", 340.15 ),
            new Exit( 44, "Canandaigua - Victor - NY Route 332", 347.13 ),
            new Exit( 45, "Rochester - Victor - I-490", 350.99 ),
            new Exit( 46, "Rochester - Corning - I-390", 362.44 ),
            new Exit( 47, "Rochester - LeRoy - I-490 - NY Route 19",
                          378.56
            ),
            new Exit( 48, "Batavia - NY Route 98", 390.13 ),
            new Exit( 49, "Depew - Lockport - NY Route 78", 417.27 ),
            new Exit( 50, "Niagara Falls - I-290", 420.34 ),
            new Exit( 51, "Buffalo - NY Route 33 - Airport", 421.57 ),
            new Exit( 52, "Buffalo - Cheektowaga - Walden Avenue", 423.19 ),
            new Exit( 53,
                          "Buffalo (Downtown) - Canada - Niagara Falls - I-190",
                          426.17
            ),
            new Exit( 54, "West Seneca - East Aurora - NY Routes 400 & 16",
                          427.94
            ),
            new Exit( 55,
                          "Springville - Orchard Park - Lackawanna - West " +
                          "Seneca - US Route 219 - Ridge Road",
                          429.47
            ),
            new Exit( 56,
                          "Blasdell - Orchard Park - Mile Strip Road (NY " +
                          "Route 179)",
                          432.45
            ),
            new Exit( 57, "Hamburg - East Aurora - NY Route 75", 436.22 ),
            new Exit( 58, "Silver Creek - Irving - NY Routes 5, 20 & 438",
                          455.54
            ),
            new Exit( 59, "Dunkirk - Fredonia - NY Route 60", 467.74 ),
            new Exit( 60, "Westfield - Mayville - NY Route 394", 485.00 ),
            new Exit( 61, "Ripley - Shortman Road", 494.92 ),
            new Exit( 62, "Pennsylvania State Line (I-90)", 496.00 )
    };

    /**
     * This is a completely static class and should not be constructed.
     * A private constructor is provided to enforce this rule.
     */
    private ExitInfo() {}

    /**
     * Get the cost of the toll for traveling between an arrival exit and a
     * departure exit
     *
     * @param arrival The number of the exit at which a vehicle arrived on the
     *                highway.
     * @param departure The number of the exit at which a vehicle departed
     *                  from the highway.
     * @return The cost of the toll for traveling between the two exits.
     */
    public static double getToll(int arrival, int departure ) {
        return Math.abs( EXIT_INFO[ arrival ].getMileMarker() -
                         EXIT_INFO[ departure ].getMileMarker() ) *
               ExitInfo.CENTS_PER_MILE;
    }

    /**
     * Determines whether or not the given exit number is valid.
     *
     * @param exit The number of the exit in question.
     * @return True iff the exit number is in the range
     * [0-{@link ExitInfo#LAST_EXIT}]
     */
    public static boolean isValid( int exit ) {
         return exit >= 0 && exit <= ExitInfo.LAST_EXIT;
    }

    /**
     * Given an exit number, returns the exit's official name.
     *
     * @param exit The exit number.
     * @return The official name of the exit.
     */
    public static String getName(int exit ) {
        return ExitInfo.EXIT_INFO[ exit ].getName();
    }

    /**
     * Given an exit number, returns the exit's mile marker on the road, i.e
     * the distance from the highway's origin.
     *
     * @param exit The exit number.
     * @return The exit's mile marker.
     */
    public static double getMileMarker(int exit ) {
        return ExitInfo.EXIT_INFO[ exit ].getMileMarker();
    }
}
