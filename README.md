# prefixtrie

Usage example:

```
final PrefixMatcherTrie trie = PrefixMatcherTrie.builder(
                "aabbcc",
                "aabbdd",
                "bbccdd",
                "abcdbc"
        );

Collection<Integer> aab = trie.match("aab");
```

The collection _"aab"_ will have the values 0 and 1 since those are
the array rows that match the _"aab"_ prefix.