package com.antra.phonepad.combination.dao;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Repository
public class WordHashSetImpl implements WordHashSet {
    Set<String> wordsSet = new HashSet<>();

    public WordHashSetImpl() throws IOException {
        Scanner file = new Scanner(new File("src/main/resources/words.txt"));
        while (file.hasNext()) {
            wordsSet.add(file.next().trim().toLowerCase());
        }
    }

    @Override
    public boolean isValidWord(String word) {
        return wordsSet.contains(word);
    }
}
