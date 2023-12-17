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
        list.add(Order.builder().id(11L).createdAt(addDays(thisDate, -1211234)).sent(thisInstant.plus(-1111234L, ChronoUnit.SECONDS)).build());
        list.add(Order.builder().id(22L).createdAt(addDays(thisDate, -911234)).sent(thisInstant.plus(-711234L, ChronoUnit.SECONDS)).build());
        list.add(Order.builder().id(33L).createdAt(addDays(thisDate, -1911234)).sent(thisInstant.plus(-1711234L, ChronoUnit.SECONDS)).build());
        list.add(Order.builder().id(43L).createdAt(addDays(thisDate, -711234)).sent(thisInstant.plus(-411234L, ChronoUnit.SECONDS)).build());
        list.add(Order.builder().id(55L).createdAt(addDays(thisDate, -411234)).sent(thisInstant.plus(-211234L, ChronoUnit.SECONDS)).build());
        return list;
    }

    private Date addDays(Date date, int seconds) {
        return date != null ? new DateTime(date).plusSeconds(seconds).toDate() : null;
    }
}
