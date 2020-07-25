package com.acrylic.version_latest.Utils;

import com.acrylic.version_latest.Messages.ChatUtils;

public class Time {

    private String week = "w";
    private String day = "d";
    private String hour = "h";
    private String min = "m";
    private String sec = "s";

    private String colorNumber = "&f";
    private String colorText = "&7";

    public Time() { }

    public Time setWeek(String week) {
        this.week = week;
        return this;
    }

    public Time setDay(String day) {
        this.day = day;
        return this;
    }

    public Time setHour(String hour) {
        this.hour = hour;
        return this;
    }

    public Time setMinute(String minute) {
        this.min = minute;
        return this;
    }

    public Time setSecond(String second) {
        this.sec = second;
        return this;
    }

    public Time setColorScheme(String colorNumber, String colorText) {
        this.colorNumber = colorNumber;
        this.colorText = colorText;
        return this;
    }

    public String convert(double timeInMills) {
        timeInMills /= 1000;

        StringBuilder timeAsString = new StringBuilder("");

        if (timeInMills >= 604800) {
            timeAsString.append(" " + colorNumber + ((int) Math.floor(timeInMills / 604800)) + colorText + week);
            timeInMills = timeInMills % 604800;
        }if (timeInMills >= 86400) {
            timeAsString.append(" " + colorNumber + ((int) Math.floor(timeInMills / 86400)) + colorText + day);
            timeInMills = timeInMills % 86400;
        }if (timeInMills >= 3600) {
            timeAsString.append(" " + colorNumber + ((int) Math.floor(timeInMills / 3600)) + colorText + hour);
            timeInMills = timeInMills % 3600;
        }if (timeInMills >= 60) {
            timeAsString.append(" " + colorNumber + ((int) Math.floor(timeInMills / 60)) + colorText + min);
            timeInMills = timeInMills % 60;
        }if (timeInMills >= 0) {
            timeAsString.append(" " + colorNumber + ((int) Math.floor(timeInMills)) + colorText + sec);
        }
        return ChatUtils.get(timeAsString.toString().replaceFirst(" ",""));
    }


}
