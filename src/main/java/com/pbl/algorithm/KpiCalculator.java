package com.pbl.algorithm;

import java.util.List;


public class KpiCalculator {


    public static double calculateAverageMark(List<Integer> marks) {

        double average = marks.stream().mapToDouble(Integer::intValue).sum() / marks.size();
        return average;
    }

    public static double calculateAmountOfAbsence(List<Boolean> absence) {
        long absenceCount = absence.stream().filter(num -> num.equals(true)).count();
        return absenceCount;
    }

    public static double calculateActualMarkResult(double average) {
        return average * 100 / 10;
    }

    public static double calculateActualAbsenceResult(double absenceCount, List<Integer> nrOfLessons) {
        return absenceCount * 100 / nrOfLessons.size();
    }

    public static double calculateActualActivityResult(List<String> activity) {
       double goodActivity = activity.stream().filter(s -> s.contains("good")).count();
       double wellActivity = activity.stream().filter(s -> s.contains("well")).count();
       double badActivity = activity.stream().filter(s -> s.contains("bad")).count();

       double badPoints = -1*badActivity;
       double wellPoints = 2*wellActivity;

       double allActivities = (goodActivity + badActivity)*2 + wellPoints;
       double actualActivities = badPoints + goodActivity + wellPoints;

       return actualActivities*100/allActivities;
    }


}
