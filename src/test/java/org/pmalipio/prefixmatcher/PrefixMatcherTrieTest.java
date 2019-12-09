/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
 */
package org.pmalipio.prefixmatcher;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class PrefixMatcherTrieTest {

    @Test
    public void basicTest() {
        final PrefixMatcherTrie trie = PrefixMatcherTrie.builder(
                "aabbcc",
                "aabbdd",
                "bbccdd",
                "abcdbc"
        );

        Collection<Integer> aab = trie.match("aab");

        assertTrue(aab.contains(0));
        assertTrue(aab.contains(1));
    }

    @Test
    public void compareFullMatchWithHashmap() {
        final int size = 100000;
        String[] array = new String[size];
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String s = RandomStringUtils.randomAlphabetic(20);
            array[i] = s;
            map.put(s, s);
        };

        PrefixMatcherTrie compiled = PrefixMatcherTrie.builder(array);
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Collection<Integer> acac = compiled.match(array[i]);
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

