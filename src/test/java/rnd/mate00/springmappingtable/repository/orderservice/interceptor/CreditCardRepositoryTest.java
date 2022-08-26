package rnd.mate00.springmappingtable.repository.orderservice.interceptor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import rnd.mate00.springmappingtable.entity.interceptor.CreditCard;

import static org.mockito.ArgumentMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest // <- this will not rollback
@ActiveProfiles("order")
//@DataJpaTest // <- this will rollback

// we're taking full context here instead of DataJpaTest because we want
// interceptor component to be autowired
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CreditCardRepositoryTest {

    @Autowired
    private CreditCardRepository repository;

    @Test
    public void creditCardNumberShouldBeEncoded() {
        CreditCard c = new CreditCard("XyZ", "1234-5678", "12/23");

        CreditCard savedCreditCard = repository.save(c);
        System.out.println(savedCreditCard);

        CreditCard found = repository.findFirstByHolderName("XyZ");
        System.out.println(found);

        assertThat(found.getCreditCardNumber()).isNotEqualTo("1234-5678");
    }
}
