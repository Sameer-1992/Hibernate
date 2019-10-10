package training.boot.trainingdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.boot.trainingdemo.dto.UserDto;
import training.boot.trainingdemo.entities.UserEntity;
import training.boot.trainingdemo.repository.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository custrepository;

    public void createUser(final UserDto userDto){
        if(userDto != null){
            UserEntity userEntity = new UserEntity();
            userEntity.setAge(userDto.getAge());
            userEntity.setCompany(userDto.getCompany());
            userEntity.setName(userDto.getName());
            userEntity.setId(userDto.getId());
            custrepository.save(userEntity);
        }
    }

    public Optional<UserEntity> getUser(final Long id){
        return custrepository.findById(id);
    }

}
