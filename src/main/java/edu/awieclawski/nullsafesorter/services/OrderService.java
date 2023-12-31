package edu.awieclawski.nullsafesorter.services;

import edu.awieclawski.nullsafesorter.models.Order;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class OrderService {

    public List<Order> sortedByIdNat_CreatedRev_SentRev(List<Order> input) {
        return input.stream()
                .sorted(
                        Comparator.comparing(Order::getId, Comparator.nullsLast(Comparator.naturalOrder()))
                                .thenComparing(Order::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder()))
                                .thenComparing(Order::getSent, Comparator.nullsLast(Comparator.reverseOrder()))
                )
                .collect(Collectors.toList());
    }

    public List<Order> sortedByIdRev_CreatedRev_SentRev(List<Order> input) {
        return input.stream()
                .sorted(
                        Comparator.comparing(Order::getId, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Order::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Order::getSent, Comparator.nullsLast(Comparator.reverseOrder()))
                )
                .collect(Collectors.toList());
    }

    public List<Order> sortedByCreatedRev_IdNat_SentRev(List<Order> input) {
        return input.stream()
                .sorted(
                        Comparator.comparing(Order::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Order::getId, Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(Order::getSent, Comparator.nullsLast(Comparator.reverseOrder()))
                )
                .collect(Collectors.toList());
    }

    public List<Order> sortedByCreatedNat_IdNat_SentRev(List<Order> input) {
        return input.stream()
                .sorted(
                        Comparator.comparing(Order::getCreatedAt, Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(Order::getId, Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(Order::getSent, Comparator.nullsLast(Comparator.reverseOrder()))
                )
                .collect(Collectors.toList());
    }

    public List<Order> sortedBySentRev_CreatedRev_IdNat(List<Order> input) {
        return input.stream()
                .sorted(
                        Comparator.comparing(Order::getSent, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Order::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Order::getId, Comparator.nullsLast(Comparator.naturalOrder()))
                )
                .collect(Collectors.toList());
    }

    public List<Order> sortedBySentNat_CreatedRev_IdNat(List<Order> input) {
        return input.stream()
                .sorted(
                        Comparator.comparing(Order::getSent, Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(Order::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Order::getId, Comparator.nullsLast(Comparator.naturalOrder()))
                )
                .collect(Collectors.toList());
    }


}
