package org.pmalipio.prefixmatcher;


import java.util.Collection;
import java.util.Collections;

public class CompiledStrings {

    StringMatchingNode root = new StringMatchingNode('_');

    public CompiledStrings(String... strings) {
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            StringMatchingNode prevNode = root;
            for (int j = 0; j < str.length(); j ++) {
                StringMatchingNode n = prevNode.getChild(str.charAt(j));
                if (n == null) {
                    n = new StringMatchingNode(str.charAt(j));
                    prevNode.addChild(n);
                }
                n.addIdx(i);
                prevNode = n;
            }
        }
    }

    public Collection<Integer> matches(final String match) {
        StringMatchingNode prevNode = root;
        if (root.isLeaf()) {
            return Collections.emptySet();
        }
        for (int j = 0; j < match.length(); j ++) {
            Character c = match.charAt(j);
            StringMatchingNode n = prevNode.getChild(c);
            if (n == null) {
                return Collections.emptySet();
            }
            prevNode = n;
        }
        return prevNode.getIdxs();
    }
}
