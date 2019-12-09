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
