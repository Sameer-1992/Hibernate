package training.boot.trainingdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.boot.trainingdemo.dto.OrderDto;
import training.boot.trainingdemo.dto.OrderEntryDto;
import training.boot.trainingdemo.entities.OrderEntity;
import training.boot.trainingdemo.entities.OrderLineItemEntity;
import training.boot.trainingdemo.repository.OrderRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Optional<OrderEntity> findOrder(String purchaseOrderNumber) {
        Optional <OrderEntity> order = orderRepository.findByPurchaseOrderNumber(purchaseOrderNumber);
        order.get().getLineItems();
        return order;

    }

    //@Transactional
    public void createOrder(OrderDto orderDto) {
        OrderEntity order = new OrderEntity();
        order.setPackType(orderDto.getPackType());
        order.setPurchaseOrderNumber(orderDto.getPurchaseOrderNumber());
        order.setLineItems(new ArrayList<>());
        for (OrderEntryDto entry : orderDto.getEntries()) {
            OrderLineItemEntity lineItemEntity = new OrderLineItemEntity();
            lineItemEntity.setProductCode(entry.getProductCode());
            lineItemEntity.setQuantity(entry.getQuantity());
            lineItemEntity.setOrder(order);
            //entityManager.persist(lineItemEntity);
            order.getLineItems().add(lineItemEntity);
        }
        orderRepository.save(order);
    }

}
