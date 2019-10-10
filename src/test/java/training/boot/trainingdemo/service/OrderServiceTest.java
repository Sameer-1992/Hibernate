package training.boot.trainingdemo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import training.boot.trainingdemo.dto.OrderDto;
import training.boot.trainingdemo.dto.OrderEntryDto;
import training.boot.trainingdemo.entities.OrderEntity;

import java.util.ArrayList;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void testCreateOrder(){
        OrderDto order = new OrderDto();
        order.setPackType("pack");
        order.setPurchaseOrderNumber("819723981");
        OrderEntryDto entry = new OrderEntryDto();
        entry.setProductCode("1111");
        entry.setQuantity(1);
        order.setEntries(new ArrayList<>());
        order.getEntries().add(entry);
        orderService.createOrder(order);
        Optional<OrderEntity> orderModel = orderService.findOrder("819723981");
        Assert.assertTrue(orderModel.get() != null);
    }




}
