package org.example;

import java.util.ArrayList;
import java.util.List;

public class NumberUtils {
    public static int getSum(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }

        return total;
    }

    public static List<Integer> multiplyOddNumber(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        if (!numbers.isEmpty()) {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) % 2 != 0) {
                    result.add(numbers.get(i) * 2);
                }
            }
        }
        return result;
    }
}