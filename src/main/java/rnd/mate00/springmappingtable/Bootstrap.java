package rnd.mate00.springmappingtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rnd.mate00.springmappingtable.entity.Country;
import rnd.mate00.springmappingtable.entity.Office;
import rnd.mate00.springmappingtable.entity.Product;
import rnd.mate00.springmappingtable.entity.Region;
import rnd.mate00.springmappingtable.repository.*;

import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {
        addRegions();
        addCountries();
        addOffices();

        Product prod1 = new Product("my product 1");
        prod1.setCountries(List.of(
                countryRepository.findByCountryName("Germany").orElse(null)
        ));
        prod1.setOffices(List.of(
                officeRepository.findByOfficeName("pol1").orElse(null),
                officeRepository.findByOfficeName("pol2").orElse(null)
        ));
        productRepository.save(prod1);

        Product prod2 = new Product("product 2");
        prod2.setRegions(List.of(
                regionRepository.findByRegionName("EMEA").orElse(null)
        ));
        productRepository.save(prod2);

        Product newProduct = new Product("new product");
        productRepository.save(newProduct);
    }

    private void addOffices() {
        Office pol1 = new Office("pol1");
        Office pol2 = new Office("pol2");
        Office pol3 = new Office("pol3");

        Office ger1 = new Office("ger1");
        Office ger2 = new Office("ger2");

        Office fra1 = new Office("fra1");
        Office fra2 = new Office("fra2");
        Office fra3 = new Office("fra3");

        officeRepository.save(pol1);
        officeRepository.save(pol2);
        officeRepository.save(pol3);
        officeRepository.save(ger1);
        officeRepository.save(ger2);
        officeRepository.save(fra1);
        officeRepository.save(fra2);
        officeRepository.save(fra3);
    }

    private void addCountries() {
        Country pol = new Country("Poland");
        Country ger = new Country("Germany");
        Country fra = new Country("France");
        Country mex = new Country("Mexico");
        countryRepository.save(pol);
        countryRepository.save(ger);
        countryRepository.save(fra);
        countryRepository.save(mex);
    }

    private void addRegions() {
        Region amer = new Region("AMERICAS");
        Region apac = new Region("APAC");
        Region emea = new Region("EMEA");
        regionRepository.save(amer);
        regionRepository.save(apac);
        regionRepository.save(emea);
    }
}
