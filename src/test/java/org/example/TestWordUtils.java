package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TestWordUtils {

    private static List<String> list, list1;
    private static String str, str1, str2;

    private static HashMap<String, Integer> map, map1;

    @BeforeAll
    static void createLists() {
        list = new ArrayList<>();
        list1 = new ArrayList<>(Arrays.asList("Bob", "Samanta", "Ra", "Bender", "Rodriguez"));
        str = null;
        str1 = "";
        str2 = "four three two one four three two four three four";

        map = new HashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);

        map1 = new HashMap<>();

        map1.put("one", 1);
        map1.put("two", 2);
        map1.put("three", 3);
        map1.put("five", 5);
    }

    @Test
    void shouldGetShortestWordThrowExceptionIfEmptyList() {
        Throwable throwable = catchThrowable(() -> WordUtils.getShortestWord(list));
        assertThat(throwable).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void shouldGetShortestWordWorksWell() {
        assertThat(WordUtils.getShortestWord(list1)).
                isEqualTo("Ra");
    }

    @Test
    void shouldCountEachWordThrowException() {
        Throwable throwable = catchThrowable(() -> WordUtils.countEachWord(str));
        assertThat(throwable).isInstanceOf(NullPointerException.class);
    }

    @Test
    void shouldCountEachWordReturnEmptyMapIfStringLengthZero() {
        HashMap<String, Integer> map = WordUtils.countEachWord(str1);
        assertThat(map).isEmpty();
    }

    @Test
    void shouldCountEachWordWorksWell() {
        assertEquals(WordUtils.countEachWord(str2), map);
    }

    @Test
    void shouldCountEachWordReturnTrueComparingKeys() {
        assertEquals(WordUtils.countEachWord(str2).keySet(), map.keySet());
    }

    @Test
    void shouldCountEachWordReturnTrueComparingValues() {
        assertTrue(WordUtils.countEachWord(str2).values().containsAll(map.values()));
    }

    @Test
    void shouldCountEachWordReturnFalseComparingKeys() {
        assertNotEquals(WordUtils.countEachWord(str2).keySet(), map1.keySet());
    }

    @Test
    void shouldCountEachWordReturnFalseComparingValues() {
        assertNotEquals(WordUtils.countEachWord(str2).values(), map1.values());
    }
}