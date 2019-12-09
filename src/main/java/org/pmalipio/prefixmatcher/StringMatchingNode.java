package org.pmalipio.prefixmatcher;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class StringMatchingNode {
    private Character ch;
    private Collection<Integer> idxs;
    private HashMap<Character, StringMatchingNode> children;

    public StringMatchingNode(final Character ch) {
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

    public StringMatchingNode getChild(final Character ch) {
        try {
            return children.get(ch);
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        }
    }

    public void addChild(final StringMatchingNode node) {
        children.put(node.ch, node);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }
}
