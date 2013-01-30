/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfhotfolder;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

import com.jtheory.jdring.*;


/**
  * This class run a bunch of tests.
  *
  * @author  Olivier Dedieu
  * @version 1.1, 09/13/1999
  */
public class Schedule {
  public static void main(String[] args) throws Exception {

    AlarmManager mgr = new AlarmManager();

    long current = System.currentTimeMillis();
    System.out.println("Current date is " + new Date(current));

    AlarmListener listener = new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007fixed date alarm : " + entry);
      }
    };

    /*
    // Date alarm
    mgr.addAlarm(new Date(current + (60 * 1000)), listener);
    mgr.addAlarm(new Date(current + (30 * 1000)), listener);
    mgr.addAlarm(new Date(current + (40 * 1000)), listener);
    mgr.addAlarm(new Date(current + (20 * 1000)), listener);
    mgr.addAlarm(new Date(current + (10 * 1000)), listener);
    mgr.addAlarm(new Date(current + (50 * 1000)), listener);

    mgr.addAlarm(new Date(System.currentTimeMillis() + 300000),
                 new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007Fixed date 5 minutes later");
      }
    });

    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.WEEK_OF_YEAR, 1);
    mgr.addAlarm(cal.getTime(), new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007Fixed date one week later");
      }
    });


    // Elapsed-time alarm
    mgr.addAlarm(1, true, new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007Relative 1 min (" + new Date() + ")");
      }
    });

    // Elapsed-time alarm 10,000 minutes
    mgr.addAlarm(10000, true, new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007Relative 10,000 min (" + new Date() + ")");
      }
    });


    // Cron-like alarm (minute, hour, day of month, month, day of week, year)
    mgr.addAlarm(-1, -1, -1, -1, -1, -1, new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007Cron every minute (" + new Date() + ")");
      }
    });


    // Cron-like alarm (minute, hour, day of month, month, day of week, year)
    mgr.addAlarm(new int[]{26,27,29}, new int[]{12}, new int[]{19,27}, new int[]{-1}, new int[]{Calendar.MONDAY}, -1, new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007Cron complex1 (" + new Date() + ")");
      }
    });
    */

    // Cron-like alarm (minute, hour, day of month, month, day of week, year)
    
    mgr.addAlarm(new Date(System.currentTimeMillis() + 300000),
                 new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007Fixed date 5 minutes later");
      }
    });
    
    /*
    mgr.addAlarm("ComplexCron2",new int[]{03,17,18}, new int[]{15}, new int[]{-1}, new int[]{-1}, new int[]{-1}, -1, new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007Cron complex2 (" + new Date() + ")");
      }
    });

    
    mgr.addAlarm(3, -1, -1, -1, -1, -1, new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007Every hour at 03' (" + new Date() + ")");
      }
    });

    mgr.addAlarm(00, 12, -1, -1, -1, -1, new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007Lunch time (" + new Date() + ")");
      }
    });

    mgr.addAlarm(24, 15, 11, Calendar.AUGUST, -1, -1, new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007Valerie's birthday");
      }
    });

    mgr.addAlarm(30, 9, 1, -1, -1, -1, new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007On the first of every month at 9:30");
      }
    });

    mgr.addAlarm(00, 18, -1, -1, Calendar.FRIDAY, -1, new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007On every Friday at 18:00");
      }
    });

    mgr.addAlarm(0, 0, 1, Calendar.JANUARY, -1, 2001,  new AlarmListener() {
      public void handleAlarm(AlarmEntry entry) {
        System.out.println("\u0007Does it work ?");
      }
    });*/

    System.out.println("Here are the registered alarms: ");
    System.out.println("----------------------------");
    List list = mgr.getAllAlarms();
    for(Iterator it = list.iterator(); it.hasNext();) {
      System.out.println("- " + it.next());
    }
    System.out.println("----------------------------");
  }
}

