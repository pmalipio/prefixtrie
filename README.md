# prefixtrie

Usage examples:

```
final PrefixMatcherTrie trie = PrefixMatcherTrie.builder(
                "aabbcc",
                "aabcdd",
                "bbccdd",
                "abcdbc"
    );

final Collection<Integer> aab = trie.match("aab");
assertArrayEquals(new Integer[]{0, 1}, aab.toArray());

final Collection<Integer> a = trie.match("a");
assertArrayEquals(new Integer[]{0, 1, 3}, a.toArray());

final Collection<Integer> empty = trie.match("");
assertArrayEquals(new Integer[]{0, 1, 2, 3}, empty.toArray());

final Collection<Integer> bbccdd = trie.match("bbccdd");
assertArrayEquals(new Integer[]{2}, bbccdd.toArray());

final Collection<Integer> xyz = trie.match("xyz");
assertArrayEquals(new Integer[]{}, xyz.toArray());

final Collection<Integer> aabbccwwwwwwwwww = trie.match("aabbccwwwwwwwwww");
assertArrayEquals(new Integer[]{}, aabbccwwwwwwwwww.toArray());
```

