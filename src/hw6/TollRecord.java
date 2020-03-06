/*
 * TollRecord.java
 *
 * Version:
 *     1.1
 *
 * Revisions:
 *     v1.0 03-01-20 - Initial write-up
 *     v1.1 03-03-20 - Javadoc commenting
 * 
 */
package hw6;

/**
 * Class that creates a toll record for a given car.
 * Each toll record must inialize with a tag (license plate),
 * arrival exit number, and arrival time.
 * 
 * @author Quinten Simet
 * @author Andy Lok
 */
public class TollRecord {
    
    /**
     * The license plate tag
     */
    private final String tag;

    /**
     * the arival exit number the car entered the highway on
     */
    private final int arrival_exit_number;

    /**
     * the time the car entered the highway
     */
    private final int arrival_time;

    /**
     * the departure exit number the car exited the highway off of
     */
    private int departure_exit_number = TollsRUs.UNINITIALIZED;

    /**
     * the time the car exited the highway
     */
    private int departure_time = TollsRUs.UNINITIALIZED;

    /**
     * Class constructor inializing the class attributes
     * 
     * @param tag the license plate of the car
     * @param arrival_exit_number the exit the car entered the highway on
     * @param arrival_time the time the car entered the highway
     */
    public TollRecord(String tag, int arrival_exit_number, int arrival_time) {
        this.tag = tag;
        this.arrival_exit_number = arrival_exit_number;
        this.arrival_time = arrival_time;
    }
    
    /**
     * This class completes the toll record when the car exits the highway
     * 
     * @param departure_exit_number the exit the car exited th highway off of
     * @param departure_time the time the car exited the highway
     */
    public void complete_record(int departure_exit_number, int departure_time) {
        this.departure_exit_number = departure_exit_number;
        this.departure_time = departure_time;
    }

    /**
     * This class determines if the toll record is complete
     * (i.e if the car is currently on the highway)
     * 
     * @return True if the car has left the highway, false otherwise
     */
    public boolean is_record_completed() {
        return (this.departure_exit_number != -1 && this.departure_time != -1);
    }
    
    /**
     * Gets the records tag ID
     * 
     * @return the tag ID
     */
    public String getTag() { return this.tag; }

    /**
     * Gets the records arrival exit number
     * 
     * @return the exit the car entered the highway on
     */
    public int getArrivalExitNumber() { return this.arrival_exit_number; }

    /**
     * Gets the time the car entered the highway on
     * 
     * @return the time the car entered the highway on
     */
    public int getArrivalTime() { return this.arrival_time; }

    /**
     * Gets the exit the car exited the highway on
     * 
     * @return the exit the car exited the highway on
     */
    public int getDepartureExitNumber() { return this.departure_exit_number; }

    /**
     * Gets the time the car exited the highway
     * 
     * @return the time the car exited the higway
     */
    public int getDepartureTime() { return this.departure_time; }

    /**
     * Retuns the report o the record
     * 
     * @return the report
     */
    public String getReport() {
        return String.format("[%s] on %s, time %s; off %s, time %s", this.tag, this.arrival_exit_number, this.arrival_time, this.departure_exit_number, this.departure_time);
    }

    /**
     * Calculates the toll cost for a given report
     * 
     * @return the cost of the toll
     */
    public double getToll() {
        return ExitInfo.getToll(this.arrival_exit_number, this.departure_exit_number);
    }

    /**
     * Gets the average speed the car drove at during its trip on the highway
     * 
     * @return the average speed
     */
    public double getSpeed() {
        double miles = Math.abs( ExitInfo.getMileMarker(this.arrival_exit_number) -
                                 ExitInfo.getMileMarker(this.departure_exit_number));
        double minutes = Math.abs( this.arrival_time - this.departure_time);
        double speed = (miles/minutes)*TollsRUs.MINUTES_PER_HOUR;
        return speed;
    }

    /**
     * Overrides the hashcode so that equal tickets will register equal hash codes
     * 
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return this.tag.hashCode() + this.arrival_exit_number + this.arrival_time + 
        this.departure_exit_number + this.departure_time;
    }
    
    /**
     * Overrides the equals method to ensure equal tickets will return true
     * @param record the record to compare with
     * @return True if equal, false otherwise
     */
    public boolean equals(TollRecord record) {
        if (this.tag.equals(record.getTag()) && 
        this.arrival_exit_number == record.getArrivalExitNumber() && 
        this.getArrivalTime() == record.getArrivalTime() &&
        this.departure_exit_number == record.getDepartureExitNumber() && 
        this.getDepartureTime() == record.getDepartureTime()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Overrides the to string method to return the record in a readable format
     */
    @Override
    public String toString() {
        if (this.is_record_completed()) {
            return String.format("[%s] {(%s, %s), (%s, %s)}", this.tag, this.arrival_exit_number, this.arrival_time, this.departure_exit_number, this.departure_time);
        } else {
            return String.format("[%s] {(%s, %s)}", this.tag, this.arrival_exit_number, this.arrival_time);
        }
    }
}