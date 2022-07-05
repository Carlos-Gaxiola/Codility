package com.encora.codility;

public class Main {
    public static void main(String[] args) {
        TimeSleeping ts = new TimeSleeping();
        int longestTimeSleeping = ts.longestTimeSleeping("Mon 01:00-02:00\nTue 01:00-23:00\nMon 03:00-10:12\nThu 01:00-23:00\nFri 01:00-23:00\nSat 01:00-23:00\nSun 01:00-21:00");
        System.out.println(longestTimeSleeping);
    }
}
