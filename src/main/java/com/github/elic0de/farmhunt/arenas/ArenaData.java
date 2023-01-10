package com.github.elic0de.farmhunt.arenas;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ArenaData {
    String name() default "UNKNOWN";

    String description() default "No description provided";

    int minPlayer() default 2;

    double maxPlayer() default 20;

    long waitingCountdown() default 5;

    long startingCountdown() default 5;

}
