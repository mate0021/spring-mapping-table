package rnd.mate00.springmappingtable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import rnd.mate00.springmappingtable.repository.CountryRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@DataJpaTest // <- get only slice of context that is necessary for JPA
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // <- to prevent using H2
@ComponentScan(basePackages = {"rnd.mate00.springmappingtable"})
public class MySqlIntegrationTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void countriesShouldBeThere() {
        assertThat(countryRepository.count()).isEqualTo(4);
    }
}
