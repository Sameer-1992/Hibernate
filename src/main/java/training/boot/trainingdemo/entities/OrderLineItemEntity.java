package training.boot.trainingdemo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="salesorderitem")
public class OrderLineItemEntity {

    @Id
    @GeneratedValue
    private  Long id;

    @NotNull
    private String productCode;
    @NotNull
    private double quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    private OrderEntity order;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
