package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class WorkoutFullAdd {
    String workoutDate;
    String timeOfDay;
    String workoutName;
    String workoutDescription;
    String plannedDistance;
    String pDistType;
    String plannedDuration;
    String distance;
    String distType;
    String duration;
    String pace;
    String paceType;
    String overallPlace;
    String ageGroupPlace;
    String howIFelt;
    String perceivedEffort;
    String minHR;
    String avgHR;
    String maxHR;
    String caloriesBurned;
}
