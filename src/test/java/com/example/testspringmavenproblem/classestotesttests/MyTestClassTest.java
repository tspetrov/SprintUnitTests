package com.example.testspringmavenproblem.classestotesttests;

import com.example.testspringmavenproblem.classestotest.MyTestClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MyTestClassTest {

    public static final String CONTAINS_AT_LEAST_TWO_DIGITS_REGEX = ".*[0-9].*[0-9].*";
    public static final String CONTAINS_AT_LEAST_ONE_CAPITAL_REGEX = ".*[A-Z].*";
    public static final String VERIFY_PASS_ALL_CONDITIONS = "(?=.*[A-Z].*)(?=.*[0-9].*[0-9].*)(?=.*_.*)(?=^.{7}$).*";

    private static Stream<Arguments> getPasswords() {
        return Stream.of(
                Arguments.of("1ce_dA2"),
                Arguments.of("cEc_3a3"),
                Arguments.of("cEs_334")
        );
    }

    @ParameterizedTest
    @MethodSource("getPasswords")
    public void testPasswordLength(String password) {
        assertEquals(7, password.length());
    }

    @ParameterizedTest
    @MethodSource("getPasswords")
    public void testPasswordContainsOneUnderscore(String password) {
        assertTrue(password.contains("_"));
    }

    @ParameterizedTest
    @MethodSource("getPasswords")
    public void testPasswordContainsAtleast2Digits(String password) {
        assertTrue(Pattern.compile(CONTAINS_AT_LEAST_TWO_DIGITS_REGEX).matcher(password).matches());
    }

    @ParameterizedTest
    @MethodSource("getPasswords")
    public void testPasswordContainsAtleast1CapitalLetter(String password) {
        assertTrue(Pattern.compile(CONTAINS_AT_LEAST_ONE_CAPITAL_REGEX).matcher(password).matches());
    }

    @ParameterizedTest
    @MethodSource("getPasswords")
    public void verifyPasswordAllConditions(String password) {
        assertTrue(Pattern.compile(VERIFY_PASS_ALL_CONDITIONS).matcher(password).matches());
    }

    @Test
    public void verifyNoNumbersReturned() {
        assertEquals(0, MyTestClass.getAllNumbersFromString("abc 12").size());
    }

    @Test
    public void verifyNumbersReturnedExist() {
        assertEquals(1, MyTestClass.getAllNumbersFromString("cdefg 345 12bb23").size());
        assertEquals(345, MyTestClass.getAllNumbersFromString("cdefg 345 12bb23").get(0));
    }

    @Test
    public void verifyNumbersReturnedExistMutiple() {
        assertEquals(2, MyTestClass.getAllNumbersFromString("cdefg 3456 12bbb33 678tt").size());
        assertEquals(3456, MyTestClass.getAllNumbersFromString("cdefg 3456 12bbb33 678tt").get(0));
        assertEquals(678, MyTestClass.getAllNumbersFromString("cdefg 345 12bbb33 678tt").get(1));
    }

}
