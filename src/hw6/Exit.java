package hw6;

/**
 * Information about a single exit. It is a utility class used by
 * {@link ExitInfo} to store information about the setup of exits on a
 * particular highway
 *
 * @author James Heliotis
 */
public class Exit {

    /**
     * The number of this exit.
     */
    private int exitNum;

    /**
     * The official long-winded name of this exit.
     */
    private String name;

    /**
     * The distance of this exit from the origin of the toll road.
     */
    private double mileMarker;

    /**
     * Creates a new exit with the specified data.
     * @param exitNum The number of this exit.
     * @param name The official long-winded name of this exit.
     * @param mileMarker Distance of this exit from the origin of the toll
     *                   road.
     */
    public Exit(int exitNum, String name, double mileMarker) {
        this.exitNum = exitNum;
        this.name = name;
        this.mileMarker = mileMarker;
    }

    /**
     * Return the exit number.
     *
     * @return This exit's number.
     */
    public int getExitNum() {
        return exitNum;
    }

    /**
     * Return the full name of the exit, e.g. <tt>"Cross County Parkway - Mile
     * Square Road"</tt>.
     *
     * @return The full name of the exit.
     */
    public String getName() {
        return name;
    }

    /**
     * Return the exit's mile marker, i.e. its distance from the highway's
     * origin.
     *
     * @return The exit's mile marker.
     */
    public double getMileMarker() {
        return mileMarker;
    }
}
