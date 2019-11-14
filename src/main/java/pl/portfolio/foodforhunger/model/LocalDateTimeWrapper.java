package pl.portfolio.foodforhunger.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeWrapper {

    private LocalDate date;

    private LocalTime time;

    public LocalDateTimeWrapper(LocalDateTime localDateTime) {
        this.date = localDateTime.toLocalDate();
        this.time = localDateTime.toLocalTime();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public static LocalDateTimeWrapper now() {
        return new LocalDateTimeWrapper(LocalDateTime.now());
    }
}
