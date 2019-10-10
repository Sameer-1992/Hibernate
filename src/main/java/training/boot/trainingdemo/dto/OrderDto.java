package training.boot.trainingdemo.dto;

import java.util.List;

public class OrderDto {

    private String purchaseOrderNumber;
    private String packType;
    private List<OrderEntryDto> entries;

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

    public List<OrderEntryDto> getEntries() {
        return entries;
    }

    public void setEntries(List<OrderEntryDto> entries) {
        this.entries = entries;
    }
}
