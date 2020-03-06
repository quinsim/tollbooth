/*
 * OrderByTagArivalTime.java
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

import java.util.Comparator;

/**
 * A class that creates a implementation of the comparator
 * interfacce for Toll Records that orders them by first
 * by tag name then by arival time
 * 
 * @author Quinten Simet
 * @author Andy Lok
 */
class OrderByTagArivalTime implements Comparator<TollRecord> {

	public int compare(TollRecord obj1, TollRecord obj2) {
		if (obj1.getTag().compareTo(obj2.getTag()) == 0 ) {
            if (obj1.getArrivalTime() > obj2.getArrivalTime()) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return obj1.getTag().compareTo(obj2.getTag());
        }
	}
}