package models;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WorkoutQuickAddFactory {

    public static WorkoutQuickAdd get() {
        Faker faker = new Faker();
        return WorkoutQuickAdd.builder()
                .workoutDate("7/15/2021")
                .timeOfDay("06:00 PM")
                .activityType("    -Run: Long Run")
                .workoutName(faker.name().name())
                .workoutDescription(faker.toString())
                .plannedDistance("10")
                .pDistType("km")
                .plannedDuration("50:00:00")
                .distance("10")
                .distType("km")
                .duration("60:15:43")
                .pace("10:20")
                .paceType("min/100m")
                .howIFelt("Good")
                .perceivedEffort("4 (Moderate)")
                .postWorkoutNotesResults("Next time I run better")
                .overallPlace("3")
                .ageGroupPlace("2")
                .build();
    }
}
