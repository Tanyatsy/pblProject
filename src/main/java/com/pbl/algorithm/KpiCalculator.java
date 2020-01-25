package com.pbl.algorithm;

import com.pbl.controllers.StudentController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class KpiCalculator {

    @Autowired
    private static StudentController sc;

    public static void setController(StudentController controller){
        sc = controller;
    }

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

    public static double calculateKpi(double mark, double amountOfAbsence, double activity ){
       double kpiIndexMarks = 0.5*100/mark;
       double kpiIndexAbsencce = 0.3*100/amountOfAbsence;
       double kpiIndexActivity = 0.2*100/activity;

       return kpiIndexMarks + kpiIndexAbsencce + kpiIndexActivity;
    }

}
