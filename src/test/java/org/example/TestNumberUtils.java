package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TestNumberUtils {

    private static List<Integer> list, list1, list2, list3;

    @BeforeAll
    static void createLists() {
        list = new ArrayList<>();
        list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        list2 = new ArrayList<>(Arrays.asList(1, -2, -3));
        list3 = new ArrayList<>(Arrays.asList(0, 0, 0));
    }

    @Test
    void shouldGetSumReturnZeroIfEmptyList() {
        assertThat(NumberUtils.getSum(list)).isZero();
    }

    @Test
    void testGetSumNotEmptyArray() {
        assertThat(NumberUtils.getSum(list1)).isEqualTo(6);
        assertThat(NumberUtils.getSum(list2)).isEqualTo(-4);
        assertThat(NumberUtils.getSum(list3)).isZero();
    }

    @Test
    void testMultiplyOddNumberReturnEmptyList() {
        assertThat(NumberUtils.multiplyOddNumber(list)).isEmpty();
        assertThat(NumberUtils.multiplyOddNumber(list3)).isEmpty();
    }

    @Test
    void shouldMultiplyOddNumberWorkWell() {
        assertThat(NumberUtils.multiplyOddNumber(list1)).containsExactly(2, 6);
        assertThat(NumberUtils.multiplyOddNumber(list2)).containsExactly(2, -6);
    }
}
