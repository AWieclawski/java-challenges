package edu.awieclawski.nullsafesorter.models;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
public class Order {

    private Long id;

    private Date createdAt;

    private Instant sent;

}
