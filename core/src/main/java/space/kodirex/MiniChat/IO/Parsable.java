package space.kodirex.MiniChat.IO;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public interface Parsable<V> {
    int getID();
    V getValue();

    static <V> Optional<Parsable<V>> getParseable(int find, Parsable<V>[] parsable) {
        return Arrays.stream(parsable)
                .filter(p -> p.getID() == find)
                .findFirst();
    }

    static <V> Optional<Parsable<V>> getParseable(int find, Supplier<Parsable<V>[]> parsable) {
        return getParseable(find, parsable.get());
    }

    static <V> Optional<Parsable<V>> getParseable(Object find, Parsable<V>[] parsable) {
        return Arrays.stream(parsable)
                .filter(p -> p.getValue().equals(find))
                .findFirst();
    }

    static <V> Optional<Parsable<V>> getParseable(Object find, Supplier<Parsable<V>[]> parsable) {
        return getParseable(find, parsable.get());
    }
}
