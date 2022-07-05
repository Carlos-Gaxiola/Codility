package com.encora.codility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TimeSleeping {
    public int longestTimeSleeping(String schedule){
        String[] meetings = schedule.split("\n");
        int longestTimeSleeping = 0;
        List<String> days = new ArrayList<>();
        List<String> beginHour = new ArrayList<>();
        List<String> endHour = new ArrayList<>();

        for(String x: meetings){
            days.add(x);
        }

        days.sort(Comparator.comparing(day -> List.of("Mon","Tue","Wed","Thu","Fri","Sat","Sun").indexOf(day.toString().substring(0, 3))).thenComparing((day -> day.toString().substring(5, 10))));

        for(String x: days){
            String hours = x.substring(4);
            beginHour.add(hours.split("-")[0]);
            endHour.add(hours.split("-")[1]);
        }

        try{
            for(int i = 0; i < beginHour.size(); i++){
                int minutes = 0;
                int startHours = Integer.parseInt(endHour.get(i).split(":")[0]);
                int startMinutes = Integer.parseInt(endHour.get(i).split(":")[1]);

                int endHours = 0;
                int endMinutes = 0;

                if((i + 1) < beginHour.size()){
                    String currentDay = days.get(i).substring(0,3);
                    String nextDay = days.get((i + 1)).substring(0,3);

                    endHours = Integer.parseInt(beginHour.get(i + 1).split(":")[0]);
                    endMinutes = Integer.parseInt(beginHour.get(i + 1).split(":")[1]);

                    if(currentDay.equals(nextDay)){
                        minutes = (60 * ((endHours) - startHours)) - (startMinutes + endMinutes);
                    }else{
                        minutes = (60 * ((24 - startHours) + endHours)) - (startMinutes + endMinutes);
                    }

                }else{
                    minutes = (60 * ((24 - startHours))) - (startMinutes + endMinutes);
                }
                if(minutes > longestTimeSleeping){
                    longestTimeSleeping = minutes;
                }

            }

        }catch(IndexOutOfBoundsException ex){
            System.out.println("These are all the meetings");
        }

        return longestTimeSleeping;
    }
}
