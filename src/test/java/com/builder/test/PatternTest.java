package com.builder.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

    public static void main(String[] args) {
        String regex = "@\\w+@";
        String str = "12312@fdsa@12312";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.end());
            System.out.println(matcher.start());
        }

    }
}
