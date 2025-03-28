package Task_1;

import java.time.LocalDate;

@FunctionalInterface
interface DateDifference {
    long daysBetween(LocalDate date1, LocalDate date2);
}
