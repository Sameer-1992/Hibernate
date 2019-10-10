package training.boot.trainingdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import training.boot.trainingdemo.entities.UserEntity;
@Repository
public interface CustomerRepository extends CrudRepository<UserEntity,Long> {
}
