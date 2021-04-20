package com.example.testspringmavenproblem.classestotest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTestClass {

    public static final String CONTAINS_TREE_OR_MORE_DIGITS = "[0-9]{3,}";

    public static List<Integer> getAllNumbersFromString(String input) {
        List<Integer> result = new ArrayList<Integer>();
        Matcher matcher = Pattern.compile(CONTAINS_TREE_OR_MORE_DIGITS).matcher(input);
        while (matcher.find()) {
            result.add(new Integer(matcher.group(0)));
        }
        return result;
    }
}
