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

import static hw6.FileHandler.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class TollRoadDatabase {
    
    private final String toll_event_data_file;

    private ArrayList<TollRecord> database = new ArrayList<>();
    private HashSet<String> tag_set = new HashSet<String>(); 
    public TollRoadDatabase(String toll_event_data_file) {
        this.toll_event_data_file = toll_event_data_file;
        this.decode_data_file();
    }

    private void decode_data_file() {
        // Odd numbered events for a given tag indicates an arrival  
        // Even numbered events for a given tag indicates an departure

        // data format: time, tag, exit

        TollRecord record;
        for (String line : open(this.toll_event_data_file)) {
            String[] record_info = line.split(",");
            int time = Integer.valueOf(record_info[0]);
            String tag = record_info[1];
            int exit_number = Integer.valueOf(record_info[2]);

            record = new TollRecord(tag, exit_number, time);
            if (tag_set.contains(tag)) {
                tag_set.remove(tag);
                for (int index=0; index < this.database.size(); index++) {
                    if (database.get(index).getTag().equals(tag) & (!database.get(index).is_record_completed())) {
                        database.get(index).complete_record(exit_number, time);
                    }
                }
            } else {
                tag_set.add(tag);
                database.add(record);
            }
        }
    }
    
    public int get_completed_trips() {
        int completed = 0;
        for (TollRecord record : database) {
            if (record.is_record_completed()) {
                completed++;
            }
        }
        return completed;
    }
    public String on_road_report() {
        System.out.println(String.format("%s commpleted trips\n", this.get_completed_trips()));
        System.out.println("On-Road Report");
        System.out.println("==============");
        StringBuffer on_road_report = new StringBuffer();
        // Format : [width=11 tag] on #arrival_exit_number, time
        TreeSet <TollRecord> on_road = new TreeSet<TollRecord>(new OrderByTagArivalTime());
        for (int index=0; index < this.database.size(); index++) {
            if (!(database.get(index).is_record_completed())) {
                on_road.add(database.get(index));
            }
        }
        for (TollRecord record : on_road) {
            on_road_report.append(String.format(TollsRUs.INCOMPLE_TOLL_RECORD_FORMAT + TollsRUs.NL, record.getTag(), record.getArrivalExitNumber(), record.getArrivalTime()));
        } 
        on_road_report.append(TollsRUs.NL + TollsRUs.NL);
        return on_road_report.toString();
    }

    public String billing_report() {
        System.out.println("BILLING INFORMATION");
        System.out.println("===================");
        double total = 0.0;
        StringBuffer billing_report = new StringBuffer();
        // Format : [width=11 tag] on #arrival_exit_number, time
        TreeSet <TollRecord> billing = new TreeSet <TollRecord>(new OrderByTagArivalTime());
        for (int index=0; index < this.database.size(); index++) {
            if (database.get(index).is_record_completed()) {
                billing.add(database.get(index));
            }
        }
        for (TollRecord record : billing) {
            total += record.getToll();
            billing_report.append(String.format(
                TollsRUs.COMPLETE_TOLL_RECORD_FORMAT + ": " + TollsRUs.DOLLAR_FORMAT + TollsRUs.NL, 
                record.getTag(), record.getArrivalExitNumber(), record.getArrivalTime(), 
                record.getDepartureExitNumber(), record.getDepartureTime(), record.getToll()));
        }
        billing_report.append(String.format("Total: " + TollsRUs.DOLLAR_FORMAT, total));

        billing_report.append(TollsRUs.NL);
        return billing_report.toString();
    }

    public String speeder_report() {
        System.out.println("SPEEDER REPORT");
        System.out.println("==============");
        StringBuffer speeder_report = new StringBuffer();
        // Format : [width=11 tag] on #arrival_exit_number, time
        TreeSet <TollRecord> speeder = new TreeSet <TollRecord>(new OrderByTagArivalTime());
        for (int index=0; index < this.database.size(); index++) {
            if (database.get(index).is_record_completed()) {
                if (database.get(index).getSpeed() > TollsRUs.SPEED_LIMIT) {
                    speeder.add(database.get(index));
                }
            }
        }
        for (TollRecord record : speeder) {
            speeder_report.append(String.format(
            "Vehicle %s, starting at time %s" + TollsRUs.NL
            + "    from %s" + TollsRUs.NL
            + "    to %s" + TollsRUs.NL
            + "    " + TollsRUs.SPEED_FORMAT + TollsRUs.NL, 
            record.getTag(), record.getArrivalTime(), ExitInfo.getName(record.getArrivalExitNumber()), 
            ExitInfo.getName(record.getDepartureExitNumber()), record.getSpeed()));
        } 
        speeder_report.append(TollsRUs.NL);
        return speeder_report.toString();
    }
    public String customer_report(String customer) {
        double total = 0.0;
        StringBuffer customer_report = new StringBuffer();
        TreeSet <TollRecord> customer_list = new TreeSet <TollRecord>(new OrderByArivalTime());
        for (int index=0; index < this.database.size(); index++) {
            if (database.get(index).getTag().equals(customer) & database.get(index).is_record_completed()) {
                customer_list.add(database.get(index));
            }
        }
        for (TollRecord record : customer_list) {
            total+= record.getToll();
            customer_report.append(String.format(
                TollsRUs.COMPLETE_TOLL_RECORD_FORMAT + ": " + TollsRUs.DOLLAR_FORMAT + TollsRUs.NL, 
                record.getTag(), record.getArrivalExitNumber(), record.getArrivalTime(), 
                record.getDepartureExitNumber(), record.getDepartureTime(), record.getToll()));
        }
        customer_report.append(String.format(TollsRUs.NL + "Vehicle total due: " + TollsRUs.DOLLAR_FORMAT + TollsRUs.NL, total));
        return customer_report.toString();
    }

    public String exit_activity_report(int exit) {
        System.out.println(String.format(TollsRUs.NL + "EXIT %s REPORT", exit));
        System.out.println("==============");
        StringBuffer exit_report = new StringBuffer();
        TreeSet <TollRecord> exit_data = new TreeSet <TollRecord>(new OrderByTagArivalTime());
        for (int index=0; index < this.database.size(); index++) {
            if (database.get(index).getArrivalExitNumber() == exit | database.get(index).getDepartureExitNumber() == exit) {
                exit_data.add(database.get(index));
            }
        }
        for (TollRecord record : exit_data) {
            if (record.is_record_completed()) {
                exit_report.append(String.format(TollsRUs.COMPLETE_TOLL_RECORD_FORMAT + TollsRUs.DOLLAR_FORMAT + TollsRUs.NL, record.getTag(), record.getArrivalExitNumber(), record.getArrivalTime(), record.getDepartureExitNumber(), record.getDepartureTime(), record.getToll()));
            } else {
                exit_report.append(String.format(TollsRUs.INCOMPLE_TOLL_RECORD_FORMAT + TollsRUs.NL, record.getTag(), record.getArrivalExitNumber(), record.getArrivalTime()));
            }
        } 
            
        return exit_report.toString();
    }

}