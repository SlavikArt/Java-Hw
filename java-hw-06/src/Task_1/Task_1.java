package Task_1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.DayOfWeek;
import java.util.function.Predicate;
import java.util.function.Function;

public class Task_1 {
    public static void main(String[] args) {
        Predicate<Integer> isLeapYear = year -> (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println("1969 рік високосний? " + isLeapYear.test(1969));
        System.out.println("2000 рік високосний? " + isLeapYear.test(2000));

        DateDifference daysBetween = (date1, date2) -> ChronoUnit.DAYS.between(date1, date2);
        LocalDate date1 = LocalDate.of(1969, 7, 20);
        LocalDate date2 = LocalDate.of(2023, 10, 17);
        System.out.println("Днів між " + date1 + " і " + date2 + ": "
                + daysBetween.daysBetween(date1, date2));

        SundayCounter countSundays = (start, end) -> {
            long days = ChronoUnit.DAYS.between(start, end);
            LocalDate current = start;
            long sundays = 0;
            for (long i = 0; i <= days; i++) {
                if (current.getDayOfWeek() == DayOfWeek.SUNDAY)
                    sundays++;
                current = current.plusDays(1);
            }
            return sundays;
        };
        System.out.println("Кількість неділь між " + date1 + " і " + date2 + ": "
                + countSundays.countSundaysBetween(date1, date2));

        Function<LocalDate, DayOfWeek> getDayOfWeek = date -> date.getDayOfWeek();
        System.out.println("20 липня 1969 року було: " + getDayOfWeek.apply(date1));
    }
}
