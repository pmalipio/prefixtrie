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

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StringTrieNode {
    private Character ch;
    private Collection<Integer> idxs;
    private Map<Character, StringTrieNode> children;

    public StringTrieNode(final Character ch) {
        this.ch = ch;
        idxs = new HashSet<>();
        children = new HashMap<>();
    }

    public void addIdx(final int idx) {
        idxs.add(idx);
    }

    public Collection<Integer> getIdxs() {
        return idxs;
    }

    public StringTrieNode getChild(final Character ch) {
        try {
            return children.get(ch);
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        }
    }

    public void addChild(final StringTrieNode node) {
        children.put(node.ch, node);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }
}
