package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    private static final Comparator<String> BY_DAYS = new SortByDays();
    private static final Comparator<String> BY_ORDER = new SortByMonthOrder();

    @Override
    public Comparator<String> sortByDays() {
        return BY_DAYS;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return BY_ORDER;
    }

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

    public static Month fromString(final String name) {
        try {
            return valueOf(name);
        } catch (IllegalArgumentException e) {
            Month match = null;
            for (Month m : values()) {
                if (m.toString().toLowerCase(Locale.ROOT).startsWith(name.toLowerCase(Locale.ROOT))) {
                    throw new IllegalArgumentException(name + "is ambigous"); 
                }
                match = m;
            }
            if (match == null) {
                throw new IllegalArgumentException(name + "undefinied");
            }
            return match;
        }
    }
}

    private static class SortByDays implements Comparator<String> {
        @Override
        public int compare(String arg0, String arg1) {
            final Month m1 = Month.fromString(arg0);
            final Month m2 = Month.fromString(arg1);
            return Integer.compare(m1.getDays(), m2.getDays());
        }
    }

    private static class SortByMonthOrder implements Comparator<String> {
        @Override
        public int compare(String arg0, String arg1) {
            final Month m1 = Month.fromString(arg0);
            final Month m2 = Month.fromString(arg1);
            return m1.compareTo(m2);
        }
        
    }
}
