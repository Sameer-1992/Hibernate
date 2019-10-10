package training.boot.trainingdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import training.boot.trainingdemo.entities.OrderEntity;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

    public Optional<OrderEntity> findByPurchaseOrderNumber(String purchaseOrderNumber);

}
