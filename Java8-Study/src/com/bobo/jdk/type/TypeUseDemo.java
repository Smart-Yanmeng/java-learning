package com.bobo.jdk.type;

public class TypeUseDemo {
    public @NotNull Integer age = 10;

    public Integer sum(@NotNull Integer a,@NotNull Integer b) {
        return a + b;
    }
}
