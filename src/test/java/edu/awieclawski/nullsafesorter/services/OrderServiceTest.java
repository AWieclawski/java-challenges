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
    void sortedByIdCreatedAtSent() {
        List<Order> output = service.sortedByIdCreatedAtSent(input);
        Assertions.assertTrue(output.get(0).getId() > output.get(1).getId());
    }

    @Test
    void sortedByCreatedAtIdSent() {
        List<Order> output = service.sortedByCreatedAtIdSent(input);
        Assertions.assertTrue(output.get(0).getCreatedAt().after(output.get(1).getCreatedAt()));
    }

    @Test
    void sortedByCreatedAtSentId() {
        List<Order> output = service.sortedByCreatedAtSentId(input);
        Assertions.assertTrue(output.get(0).getCreatedAt().after(output.get(1).getCreatedAt()));
    }
}