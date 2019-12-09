package org.pmalipio.prefixmatcher;

import org.pmalipio.prefixmatcher.CompiledStrings;
import org.pmalipio.prefixmatcher.PrefixMatcherTrie;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PrefixMatcherTrieTest {

    @Test
    public void compareWithHashmap() {
        final int size = 100000;
        String[] array = new String[size];
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String s = RandomStringUtils.randomAlphabetic(20);
            array[i] = s;
            map.put(s, s);
        };

        CompiledStrings compiled = PrefixMatcherTrie.compile(array);
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Collection<Integer> acac = compiled.matches(array[i]);
        }
        long total = System.currentTimeMillis() - start;
        System.out.println("My string matcher: " + total);

        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            String acac = map.get(array[i]);
        }
        total = System.currentTimeMillis() - start;
        System.out.println("Hash map matcher: " + total);
    }
}

