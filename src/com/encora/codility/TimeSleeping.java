package com.encora.codility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TimeSleeping {
    public int longestTimeSleeping(String schedule){
        List<String> meetings = new ArrayList<>(List.of(schedule.split("\n")));
        int longestTimeSleeping = 0;
        List<String> beginHour = new ArrayList<>();
        List<String> endHour = new ArrayList<>();

        meetings.sort(Comparator.comparing(day -> List.of("Mon","Tue","Wed","Thu","Fri","Sat","Sun").indexOf(day.toString().substring(0, 3))).thenComparing((day -> day.toString().substring(4, 6))));

        for(String x: meetings){
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
                    String currentDay = meetings.get(i).substring(0,3);
                    String nextDay = meetings.get((i + 1)).substring(0,3);

                    endHours = Integer.parseInt(beginHour.get(i + 1).split(":")[0]);
                    endMinutes = Integer.parseInt(beginHour.get(i + 1).split(":")[1]);


                    if(currentDay.equals(nextDay)){
                        if(startHours == endHours && startMinutes == endMinutes){
                            minutes = 0;
                        }else{
                            minutes = (60 * ((endHours) - startHours)) + (startMinutes + endMinutes);
                        }
                    }else{
                        minutes = (60 * ((24 - startHours) + endHours)) - startMinutes + endMinutes;
                    }

                }else{
                    minutes = (60 * ((24 - startHours))) + (startMinutes + endMinutes);
                }
                if(minutes > longestTimeSleeping){
                    longestTimeSleeping = minutes;
                }

            }

        }catch(IndexOutOfBoundsException ex){
            System.out.println("These are all the meetings");
        }
        System.out.println(meetings);
        return longestTimeSleeping;
    }
}
