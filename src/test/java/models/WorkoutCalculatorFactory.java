package models;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WorkoutCalculatorFactory {

    public static WorkoutCalculator get() {
        Faker faker = new Faker();
        return WorkoutCalculator.builder()
                .selectEvent("10Km")
                .hoursIntensity("1")
                .minutesIntensity("23")
                .secondsIntensity("59")

                .raceDist("10k")
                .distanceHansons("10")
                .distType("km")
                .hoursHansons("1")
                .minutesHansons("44")
                .secondsHansons("20")
                .temperature("36")
                .tempType("°C")
                .humidity("85")
                .windSpeed("1")
                .speedType("kph")

                .distanceMillan("1600m")
                .hoursMillan("1")
                .minutesMillan("42")
                .secondsMillan("50")

                .raceDistance("1200 meters")
                .hoursTinman("1")
                .minutesTinman("23")
                .secondsTinman("24")
                .gender(" Female")

                .CP("150")
                .RWC("20")
                .build();
    }
}
