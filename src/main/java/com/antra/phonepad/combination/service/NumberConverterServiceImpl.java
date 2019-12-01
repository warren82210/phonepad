package com.antra.phonepad.combination.service;

import com.antra.phonepad.combination.dao.LetterCombinations;
import com.antra.phonepad.combination.dao.WordHashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class NumberConverterServiceImpl implements NumberConverterService {
    @Autowired
    LetterCombinations letterCombinations;
    @Autowired
    WordHashSet wordHashSet;
    @Override
    public List<String> numberConverter(String number) {
        List<String> answer = new LinkedList<>();
        List<String> list = letterCombinations.combinations(number);
        for (String str : list) {
            if (wordHashSet.isValidWord(str.substring(0,3))
                    && wordHashSet.isValidWord(str.substring(3,6))
                    && wordHashSet.isValidWord(str.substring(6))) {
                answer.add(str);
            }
        }
        return answer;
    }
}
