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
public class Task2b {
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
                "Jacob"
        );

        for(int i = 0; i < topNames2017.size(); i++){
            String topNames = topNames2017.get(i);
            String[] topName = topNames.split("\\s+");
            StringBuilder string = new StringBuilder();
            for(int j = 0; j < topName.length; j++){
                if(j != 0) {
                    string.append(' ');
                }
                string.append(Character.toUpperCase(topName[j].charAt(0)));
                string.append(topName[j].substring(1).toLowerCase());
            }
            topNames2017.set(i, string.toString());
        }

        Collections.sort(topNames2017, String::compareTo);
        for(String temp : topNames2017) {
            System.out.println(temp);
        }
    }
}