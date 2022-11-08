package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    enum Month {JANUARY("January", 31),
    FEBRUARY("February", 28),
    MARCH ("March", 31),
    APRIL ("April", 30),
    MAY ("May", 31),
    JUNE ("June", 30),
    JULY ("July", 31),
    AUGUST ("August", 31),
    SEPTEMBER ("September", 30),
    OCTOBER ("October", 31),
    NOVEMBER ("November", 30),
    DECEMBER ("December", 31);

    private String name;
    private int days;

    private Month(final String name, final int days) {
        this.name = name;
        this.days = days;
    }

    public String getName() {
        return this.name;
    }

    public int getDays() {
        return this.days;
    }
}

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
