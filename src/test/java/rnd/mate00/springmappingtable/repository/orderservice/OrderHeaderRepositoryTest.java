package rnd.mate00.springmappingtable.repository.orderservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import rnd.mate00.springmappingtable.entity.orderservice.Category;
import rnd.mate00.springmappingtable.entity.orderservice.OrderApproval;
import rnd.mate00.springmappingtable.entity.orderservice.OrderHeader;
import rnd.mate00.springmappingtable.entity.orderservice.OrderLine;
import rnd.mate00.springmappingtable.entity.orderservice.OrderStatus;
import rnd.mate00.springmappingtable.entity.orderservice.Product;

import java.util.Set;

import static org.mockito.ArgumentMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ActiveProfiles("order")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderHeaderRepositoryTest {

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void saveOrderHeader() {
        OrderHeader orderHeader = new OrderHeader("New Customer", null, null, OrderStatus.NEW);

        OrderHeader saved = orderHeaderRepository.save(orderHeader);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
    }

    @Test
    public void saveWithOrderLine() {
        OrderHeader orderHeader = new OrderHeader("New Customer", null, null, OrderStatus.NEW);
        OrderLine l1 = new OrderLine(5);
        OrderLine l2 = new OrderLine(25);

//        l1.setOrderHeader(orderHeader); // <- this can be done by idiom in OrderHeader.addOrderLine()
//        l2.setOrderHeader(orderHeader);
//        orderHeader.setOrderLines(Set.of(l1, l2));
        orderHeader.addOrderLine(l1);
        orderHeader.addOrderLine(l2);

        OrderHeader saved = orderHeaderRepository.save(orderHeader);
        assertThat(saved).isNotNull();
        assertThat(saved.getOrderLines()).size().isEqualTo(2);

        Set<OrderLine> orderLines = saved.getOrderLines();
        for (OrderLine ol : orderLines) {
            assertThat(ol.getId()).isNotNull();         // <- this will fail unless I get CascadeType.PERSIST in my Entity
            assertThat(ol.getCreatedDate()).isNotNull();//    or unless I save l1 and l2 first, and then save orderHeader
        }
    }

    @Test
    public void shouldSaveProductWithCategories() {
        Category savedCategory = categoryRepository.save(new Category("test category"));
        Product p = new Product("test prod");
        p.setCategories(Set.of(savedCategory));
        Product savedProduct = productRepository.save(p);

        assertThat(savedProduct.getCategories()).hasSize(1);
        assertThat(savedCategory.getProducts()).isNotNull();
    }

}