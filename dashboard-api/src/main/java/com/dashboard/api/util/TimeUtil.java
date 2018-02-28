package com.dashboard.api.util;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author LEBOC Philippe
 */
@Component
public final class TimeUtil {

    private static final String ZONE = "Europe/Paris"; // TODO: move it to properties

    private TimeUtil() {
        // Never create instance of Util class
    }

    /**
     * Same as LocalDateTime.now() with an addition of TimeZone (very important)
     * @return The current time as LocalDateTime and time zone from properties file
     */
    public static LocalDateTime now() {
        return LocalDateTime.now().atZone(ZoneId.of(ZONE)).toLocalDateTime();
    }

    /**
     * Convert LocalDateTime to timestamp in second (front required millis)
     * Global useful method used to convert any Model LocalDateTime to DTO as long
     * @param time The java 8 date
     * @return time to UTC with configured timezone (from properties) if time is set, null otherwise
     */
    public static long toEpochSecond(LocalDateTime time) {
        if(time == null) return -1;
        return time.atZone(ZoneId.of(ZONE)).toEpochSecond();
    }

    /**
     * Convert LocalDateTime to millis
     * @param time The java 8 date
     * @return time to UTC with configured timezone (from properties) if time is set, null otherwise
     */
    public static long toEpochMillis(LocalDateTime time) {
        if(time == null) return -1;
        return time.atZone(ZoneId.of(ZONE)).toEpochSecond() * 1000;
    }

    /**
     * Convert an SQL Timestamp object to a Java 8 LocalDateTime
     * @param object The SQL Timestamp to be converted
     * @return Converted object if not null, otherwise null
     */
    public static LocalDateTime toLocalDateTime(Timestamp object) {
        return object == null ? null : object.toLocalDateTime();
    }

    /**
     * Convert a LocalDateTime object to an SQL Timestamp or <code>null</code>
     * @param object The object to be converted to Timestamp
     * @return Conversion to SQL Timestamp if set, otherwise return <code>null</code>
     */
    public static Timestamp toTimestamp(LocalDateTime object) {
        return object == null ? null : Timestamp.valueOf(object);
    }
}
