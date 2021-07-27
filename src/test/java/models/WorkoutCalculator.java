package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class WorkoutCalculator {
    //    INTENSITY
    String selectEvent;
    String hoursIntensity;
    String minutesIntensity;
    String secondsIntensity;

    //    HANSONS
    String raceDist;
    String distanceHansons;
    String distType;
    String hoursHansons;
    String minutesHansons;
    String secondsHansons;
    String temperature;
    String tempType;
    String humidity;
    String windSpeed;
    String speedType;

    //    McMillan
    String distanceMillan;
    String hoursMillan;
    String minutesMillan;
    String secondsMillan;

    //    Tinman
    String raceDistance;
    String hoursTinman;
    String minutesTinman;
    String secondsTinman;
    String gender;

    String CP;
    String RWC;


}
