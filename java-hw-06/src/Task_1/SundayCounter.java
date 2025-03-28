package Task_1;

import java.time.LocalDate;

@FunctionalInterface
interface SundayCounter {
    long countSundaysBetween(LocalDate start, LocalDate end);
}
