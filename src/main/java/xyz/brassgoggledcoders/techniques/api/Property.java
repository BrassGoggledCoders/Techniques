package xyz.brassgoggledcoders.techniques.api;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Property<T> {
    private final Supplier<T> get;
    private final Consumer<T> set;

    public Property(Supplier<T> get, Consumer<T> set) {
        this.get = get;
        this.set = set;
    }

    public void set(T value) {
        this.set.accept(value);
    }

    public T get() {
        return get.get();
    }
}
