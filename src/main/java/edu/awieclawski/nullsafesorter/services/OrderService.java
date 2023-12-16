package edu.awieclawski.nullsafesorter.services;

import edu.awieclawski.nullsafesorter.models.Order;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class OrderService {

    public List<Order> sortedByIdCreatedAtSent(List<Order> input) {
        return input.stream()
                .sorted(
                        Comparator.comparing(Order::getId, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Order::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Order::getSent, Comparator.nullsLast(Comparator.reverseOrder()))
                )
                .collect(Collectors.toList());
    }

    public List<Order> sortedByCreatedAtIdSent(List<Order> input) {
        return input.stream()
                .sorted(
                        Comparator.comparing(Order::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Order::getId, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Order::getSent, Comparator.nullsLast(Comparator.reverseOrder()))
                )
                .collect(Collectors.toList());
    }

    public List<Order> sortedByCreatedAtSentId(List<Order> input) {
        return input.stream()
                .sorted(
                        Comparator.comparing(Order::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Order::getSent, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Order::getId, Comparator.nullsLast(Comparator.naturalOrder()))
                )
                .collect(Collectors.toList());
    }


}
