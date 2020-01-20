package com.pbl.algorithm;

import com.pbl.models.RegisterInfo;

import java.util.List;


public class KpiCalculator {

    public static double calculateAverageMark(List<Integer> marks){

        double average = marks.stream().mapToInt(Integer::intValue).sum()/marks.size();
        System.out.println(average);
        System.out.println(marks.stream().mapToInt(Integer::intValue).sum());
        System.out.println(marks.size());
        return average;
    }
}
