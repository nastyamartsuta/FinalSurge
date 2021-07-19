package models;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WorkoutFullAddFactory {

    public static WorkoutFullAdd get() {
        Faker faker = new Faker();
        return WorkoutFullAdd.builder()
                .workoutDate("7/15/2021")
                .timeOfDay("06:00 PM")
                .workoutName(faker.name().name())
                .workoutDescription(faker.toString())
                .plannedDistance("10")
                .pDistType("km")
                .plannedDuration("50:00:00")
                .distance("10")
                .distType("km")
                .duration("60:15:43")
                .pace("100")
                .paceType("min/100m")
                .overallPlace("3")
                .ageGroupPlace("2")
                .howIFelt("Good")
                .perceivedEffort("4 (Moderate)")
                .minHR("64")
                .avgHR("89")
                .maxHR("132")
                .caloriesBurned("532")
                .build();
    }
}
