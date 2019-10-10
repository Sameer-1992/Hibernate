package training.boot.trainingdemo.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import training.boot.trainingdemo.dto.UserDto;
import training.boot.trainingdemo.entities.UserEntity;
import training.boot.trainingdemo.repository.CustomerRepository;

import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository repository;

    @Before
    public  void before(){
        UserEntity customer = new UserEntity();
        customer.setAge(40);
        customer.setName("testuser");
        customer.setCompany("deloitte");
        customer.setId(1l);

        UserEntity democustomer = new UserEntity();
        democustomer.setAge(41);
        democustomer.setName("demouser");
        democustomer.setCompany("cognizant");
        democustomer.setId(2l);
        repository.saveAll(Arrays.asList(customer,democustomer));
    }

    @Test
    public void testCreateUser(){
        UserDto customerDto = new UserDto();
        customerDto.setAge(40);
        customerDto.setName("customer");
        customerDto.setCompany("deloitte");
        customerDto.setId(123l);
        customerService.createUser(customerDto);
        Optional<UserEntity> user = customerService.getUser(123l);
        Assert.assertTrue("Unable to find ID",user.isPresent());
        Assert.assertEquals(user.get().getName(),"customer");
    }


}
