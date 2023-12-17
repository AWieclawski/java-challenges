package edu.awieclawski.nullsafesorter.services;

import edu.awieclawski.nullsafesorter.models.Order;
import edu.awieclawski.nullsafesorter.repos.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OrderServiceTest {

    private OrderService service = new OrderService();
    private OrderRepository repository = new OrderRepository();
    private List<Order> input = repository.getAllOrders();

    @Test
    void sortedByIdNat_CreatedRev_SentRev() {
        List<Order> output = service.sortedByIdNat_CreatedRev_SentRev(input);
        Assertions.assertTrue(output.get(0).getId() < output.get(1).getId());
    }

    @Test
    void sortedByIdRev_CreatedRev_SentRev() {
        List<Order> output = service.sortedByIdRev_CreatedRev_SentRev(input);
        Assertions.assertTrue(output.get(0).getId() > output.get(1).getId());
    }

    @Test
    void sortedByCreatedRev_IdNat_SentRev() {
        List<Order> output = service.sortedByCreatedRev_IdNat_SentRev(input);
        Assertions.assertTrue(output.get(0).getCreatedAt().after(output.get(1).getCreatedAt()));
    }

    @Test
    void sortedByCreatedNat_IdNat_SentRev() {
        List<Order> output = service.sortedByCreatedNat_IdNat_SentRev(input);
        Assertions.assertTrue(output.get(0).getCreatedAt().before(output.get(1).getCreatedAt()));
    }

    @Test
    void sortedBySentRev_CreatedRev_IdNat() {
        List<Order> output = service.sortedBySentRev_CreatedRev_IdNat(input);
        Assertions.assertTrue(output.get(0).getSent().isAfter(output.get(1).getSent()));
    }

    @Test
    void sortedBySentNat_CreatedRev_IdNat() {
        List<Order> output = service.sortedBySentNat_CreatedRev_IdNat(input);
        Assertions.assertTrue(output.get(0).getSent().isBefore(output.get(1).getSent()));
    }
}