package org.pmalipio.prefixmatcher;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PrefixMatcherTrie {

    public CompiledStrings compile(final String... strings) {
        return new CompiledStrings(strings);
    }

}
