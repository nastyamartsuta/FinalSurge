package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class IntensityCalculator {

    @Builder.Default
    public static String hoursIntensity = "1";
    @Builder.Default
    public static String minutesIntensity = "30";
    @Builder.Default
    public static String secondsIntensity = "00";
}
