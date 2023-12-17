package edu.awieclawski.nullsafesorter.models;

import lombok.Builder;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Builder
public class Order {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneId.systemDefault());

    private Long id;

    private Date createdAt;

    private Instant sent;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdAt=" + DATE_FORMAT.format(createdAt) +
                ", sent=" + DATE_TIME_FORMATTER.format(sent) +
                '}';
    }
}
