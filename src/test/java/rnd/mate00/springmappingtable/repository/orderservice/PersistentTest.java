package rnd.mate00.springmappingtable.repository.orderservice;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import rnd.mate00.springmappingtable.entity.orderservice.Address;
import rnd.mate00.springmappingtable.entity.orderservice.Customer;


import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("order")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersistentTest {

    private static int customersInDb;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Order(1)
    public void checkNumberOfEntities() {
        customersInDb = customerRepository.findAll().size();
    }

    @Test
    @Order(2)
    @Rollback(false)
    public void thisWillBeWrittenToDb() {
        Customer c = new Customer("Mr Persistent",
                new Address("Street St", "Birmingham", "09-0WQ"), "123-345-645", "e@mail");

        Customer savedCustomer = customerRepository.save(c);

        assertThat(savedCustomer.getId()).isNotNull();
        System.out.println(c);
    }

    @Test
    @Order(3)
    public void checkAfterInsertInOtherTestCase() {
        int newNumberOfCustomers = customerRepository.findAll().size();

        assertThat(newNumberOfCustomers).isGreaterThan(customersInDb);
    }
}
