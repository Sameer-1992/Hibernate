package training.boot.trainingdemo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "customer",  schema = "dev")
@NamedNativeQuery(name = "UserEntity.getByIDAndName", query = "select * from customer where id =:id, name = :name")
public class UserEntity {
    @Id
    private long id;
    private String name;
    private String company;
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
