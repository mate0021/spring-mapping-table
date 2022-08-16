package rnd.mate00.springmappingtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import rnd.mate00.springmappingtable.entity.orderservice.tableperclass.HardwareVendor;
import rnd.mate00.springmappingtable.entity.orderservice.tableperclass.SoftwareVendor;
import rnd.mate00.springmappingtable.repository.orderservice.HardwareVendorRepository;
import rnd.mate00.springmappingtable.repository.orderservice.SoftwareVendorRepository;

@Component
@Profile("order")
public class OrderBootstrap implements CommandLineRunner {

    @Autowired
    private SoftwareVendorRepository softwareVendorRepository;

    @Autowired
    private HardwareVendorRepository hardwareVendorRepository;

    @Override
    public void run(String... args) throws Exception {
        SoftwareVendor oracle = new SoftwareVendor();
        oracle.setVendorName("Oracle");
        oracle.setLanguageUsed("Java");

        softwareVendorRepository.save(oracle);

        HardwareVendor intel = new HardwareVendor();
        intel.setVendorName("Intel");
        intel.setTypeOfChip("Processor");

        hardwareVendorRepository.save(intel);
    }
}
