package training.boot.trainingdemo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "salesorder")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    @NotNull
    private String purchaseOrderNumber;
    private String packType;
    @NotNull
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "lineitem_id")
    private List<OrderLineItemEntity> lineItems;

    public List<OrderLineItemEntity> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<OrderLineItemEntity> lineItems) {
        this.lineItems = lineItems;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getPackType() {
        return packType;
    }

    public void setPackType(String packType) {
        this.packType = packType;
    }
}
