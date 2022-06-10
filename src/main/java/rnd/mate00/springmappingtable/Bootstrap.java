package rnd.mate00.springmappingtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rnd.mate00.springmappingtable.entity.Country;
import rnd.mate00.springmappingtable.entity.Office;
import rnd.mate00.springmappingtable.entity.Region;
import rnd.mate00.springmappingtable.repository.*;

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
        addOffices();
        addCountries();
        addRegions();
    }

    private void addOffices() {
        Office pol1 = new Office("pol1");
        Office pol2 = new Office("pol2");
        Office pol3 = new Office("pol3");

        Office ger1 = new Office("ger1");
        Office ger2 = new Office("ger2");
        officeRepository.save(pol1);
        officeRepository.save(pol2);
        officeRepository.save(pol3);
        officeRepository.save(ger1);
        officeRepository.save(ger2);
    }

    private void addCountries() {
        Country pol = new Country("Poland");
        Country ger = new Country("Germany");
        countryRepository.save(pol);
        countryRepository.save(ger);
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
