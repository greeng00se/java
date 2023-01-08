package com.example.simplejava.time;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.time.zone.ZoneRules;
import org.junit.jupiter.api.Test;

public class TimeTest {

    @Test
    void localDateTest() {
        LocalDate date = LocalDate.of(2022, 1, 8);
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        assertThat(year).isEqualTo(2022);
        assertThat(month).isEqualTo(1);
        assertThat(day).isEqualTo(8);
    }

    @Test
    void instantTest() {
        Instant instant = Instant.ofEpochSecond(2L, 1_000_000_000L);

        long epochSecond = instant.getEpochSecond();

        assertThat(epochSecond).isEqualTo(3L);
    }

    @Test
    void durationTest() {
        Duration duration = Duration.ofDays(1L);

        long seconds = duration.getSeconds();

        assertThat(seconds).isEqualTo(86400L);
    }

    @Test
    void temporalAdjustTest() {
        LocalDate localDate = LocalDate.of(2017, 07, 8);

        LocalDate nextSunday = localDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        assertThat(nextSunday.toString()).isEqualTo("2017-07-09");
    }

    @Test
    void formatterTest() {
        LocalDate date = LocalDate.of(2023, 1, 8);

        assertThat(date.format(DateTimeFormatter.ISO_DATE)).isEqualTo("2023-01-08");
        assertThat(date.format(DateTimeFormatter.BASIC_ISO_DATE)).isEqualTo("20230108");
    }

    @Test
    void zone() {
        Instant instant = Instant.now();
        LocalDateTime utc = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
    }
}
