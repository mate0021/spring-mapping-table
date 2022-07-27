package rnd.mate00.springmappingtable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rnd.mate00.springmappingtable.entity.Country;
import rnd.mate00.springmappingtable.entity.Office;
import rnd.mate00.springmappingtable.entity.Product;
import rnd.mate00.springmappingtable.entity.Region;
import rnd.mate00.springmappingtable.repository.CountryRepository;
import rnd.mate00.springmappingtable.repository.OfficeRepository;
import rnd.mate00.springmappingtable.repository.ProductRepository;
import rnd.mate00.springmappingtable.repository.RegionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

//    @Autowired
    private ProductRepository productRepository;

//    @Autowired
    private RegionRepository regionRepository;

//    @Autowired
    private CountryRepository countryRepository;

//    @Autowired
    private OfficeRepository officeRepository;

    @GetMapping("/")
    public String main() {
        List<String> regionsIn = List.of("APAC");
        List<String> countriesIn = List.of("Poland", "France");
        List<String> officesIn = List.of("ger1", "ger2");

        List<Region> regionsToAdd = new ArrayList<>();
        List<Country> countriesToAdd = new ArrayList<>();
        List<Office> officesToAdd = new ArrayList<>();

        for (String r : regionsIn) {
            Region region = regionRepository.findByRegionName(r).orElse(null);
            if (region != null) {
                regionsToAdd.add(region);
            }
        }

        for (String c : countriesIn) {
            Country country = countryRepository.findByCountryName(c).orElse(null);
            if (country != null) {
                countriesToAdd.add(country);
            }
        }

        for (String o : officesIn) {
            Office office = officeRepository.findByOfficeName(o).orElse(null);
            if (office != null) {
                officesToAdd.add(office);
            }
        }

        Optional<Product> newProduct = productRepository.findByProductName("new product");

        if (newProduct.isPresent()) {
            newProduct.get().setRegions(regionsToAdd);
            newProduct.get().setCountries(countriesToAdd);
            newProduct.get().setOffices(officesToAdd);
//            productRepository.save(newProduct.get());
        }

        return "products";
    }
}
