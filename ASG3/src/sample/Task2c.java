package sample;
/**********************************************

 Workshop #3

 Course:JAC444 - 4th

 Last Name:Carvalho

 First Name:Pedro Henrique

 ID:118495167

 Section:SCD

 This assignment represents my own work in accordance with Seneca Academic Policy.

 Pedro Henrique Carvalho
 Date:12/07/2018

 **********************************************/
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.io.*;
import java.util.*;

public class Task2c {

    public static void main(String[] args) {
        List<String> topNames2017 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob");
        topNames2017
                .stream()
                .map(topName -> Character.toUpperCase(topName.charAt(0))+topName.substring(1))
                .sorted()
                .forEach(System.out::println);

    }
}
