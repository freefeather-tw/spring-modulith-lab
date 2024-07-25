package com.freefeather.modulith.product;

import com.freefeather.modulith.notification.NotificationDTO;
import com.freefeather.modulith.product.internal.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ProductService {

    private final ApplicationEventPublisher events;

    public ProductService(ApplicationEventPublisher events) {
        this.events = events;
    }

    public void create(ProductDTO productDTO) {
        create(new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getPrice()));
    }

    private void create(Product product) {
        //notificationService.createNotification(new NotificationDTO(new Date(), "SMS", product.getName()));
        try {
            log.info("Creating product {} with price {}", product.getName(), product.getPrice());
            events.publishEvent(new NotificationDTO(new Date(), "SMS", product.getName()));
            log.info("Product created");
        } catch (Exception e) {
            log.error("Error creating product", e);
        }
    }
}
