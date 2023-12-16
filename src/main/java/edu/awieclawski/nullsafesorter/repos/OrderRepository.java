package edu.awieclawski.nullsafesorter.repos;

import edu.awieclawski.nullsafesorter.models.Order;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class OrderRepository {

    public List<Order> getAllOrders() {
        Date thisDate = new Date();
        Instant thisInstant = Instant.now();
        List<Order> list = new ArrayList<>();
        list.add(Order.builder().id(11L).createdAt(addDays(thisDate, -121)).sent(thisInstant.plus(-111L, ChronoUnit.DAYS)).build());
        list.add(Order.builder().id(22L).createdAt(addDays(thisDate, -91)).sent(thisInstant.plus(-71L, ChronoUnit.DAYS)).build());
        list.add(Order.builder().id(33L).createdAt(addDays(thisDate, -191)).sent(thisInstant.plus(-171L, ChronoUnit.DAYS)).build());
        list.add(Order.builder().id(43L).createdAt(addDays(thisDate, -71)).sent(thisInstant.plus(-41L, ChronoUnit.DAYS)).build());
        return list;
    }

    private Date addDays(Date date, int days) {
        return date != null ? new DateTime(date).plusDays(days).toDate() : null;
    }
}
