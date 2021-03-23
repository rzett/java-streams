package com.softwarecrafter.samples;

import java.util.*;
import java.util.stream.Collectors;

public class MapSample {

    public static void main(String[] args) {

        /**
         * Partition a collection by predicates
         */
        Set<Integer> integers = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        Map<Boolean, List<Integer>> distIntegers = integers.stream().collect(
                Collectors.partitioningBy(integer -> integer > 5 && integer < 8));

        List<Integer> biggerFiveSmallerEight = distIntegers.get(true);
        List<Integer> smallerFiveBiggerEight = distIntegers.get(false);

        biggerFiveSmallerEight.forEach(System.out::println);
        System.out.println(" --- --- --- --- --- --- --- --- ");
        smallerFiveBiggerEight.forEach(System.out::println);

    }



}
