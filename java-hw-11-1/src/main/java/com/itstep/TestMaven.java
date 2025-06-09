package com.itstep;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class TestMaven {
    public static void main(String[] args) throws IOException {
        // Test Lists utility
        List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi");
        fruits.forEach(System.out::println);

        List<String> reverseFruits = Lists.reverse(fruits);
        reverseFruits.forEach(System.out::println);

        // Test Multimap
        Multimap<String, String> map = ArrayListMultimap.create();
        map.put("key", "firstValue");
        map.put("key", "secondValue");
        System.out.println(map);

        Properties prop = new Properties();
        prop.load(TestMaven.class.getClassLoader().getResourceAsStream("config.properties"));
        System.out.println(prop.getProperty("props.local.hello"));
        System.out.println(prop.getProperty("props.mvn.hello"));
    }
}