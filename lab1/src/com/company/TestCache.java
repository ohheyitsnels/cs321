package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestCache {
    public void testFirstLevelCache(int cacheSize, String cacheSource){
        cache<String> cache = new cache<>(cacheSize);
        File file = new File(cacheSource);

        try {
            int hits = 0;
            int refs = 0;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                refs++;
                if (cache.getObject(scanner.next()) != null) {
                    hits++;
                }
            }
            System.out.println(hits + " hits\n" + refs + " refs");
            System.out.println("HR of " + (double)hits/refs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

    public void testSecondLevelCache(int firstLevelSize, int secondLevelSize, String cacheSource){
        SecondLevelCache<String> cache = new SecondLevelCache<>(firstLevelSize, secondLevelSize);
        File file = new File(cacheSource);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                if (cache.getObject(scanner.next()) != null) {
                }
            }
            int hits1 = cache.getHits1();
            int hits2 = cache.getHits2();
            int refs1 = cache.getRefs1();
            int refs2 = cache.getRefs2();
            int hits = hits1 + hits2;
            System.out.println(hits1 + " first level hits\n" + hits2 + " second level hits\n" + hits + " total hits");
            System.out.println(refs1 + " total/first level references\n" + refs2 + " second level references");
            System.out.println("HR1 of " + (double)hits1/refs1 + "\nHR2 of " + (double)hits2/refs2);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
