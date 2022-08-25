package rnd.mate00.springmappingtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import rnd.mate00.springmappingtable.entity.orderservice.singletable.Car;
import rnd.mate00.springmappingtable.entity.orderservice.singletable.Truck;
import rnd.mate00.springmappingtable.entity.orderservice.tableperclass.HardwareVendor;
import rnd.mate00.springmappingtable.entity.orderservice.tableperclass.SoftwareVendor;
import rnd.mate00.springmappingtable.repository.orderservice.singletable.VehicleRepository;
import rnd.mate00.springmappingtable.repository.orderservice.tableperclass.HardwareVendorRepository;
import rnd.mate00.springmappingtable.repository.orderservice.tableperclass.SoftwareVendorRepository;

@Component
@Profile("order")
public class OrderBootstrap implements CommandLineRunner {

    @Autowired
    private SoftwareVendorRepository softwareVendorRepository;

    @Autowired
    private HardwareVendorRepository hardwareVendorRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void run(String... args) throws Exception {
        addVendors();
        addVehicles();
    }

    private void addVendors() {
        SoftwareVendor oracle = new SoftwareVendor();
        oracle.setVendorName("Oracle");
        oracle.setLanguageUsed("Java");
        softwareVendorRepository.save(oracle);
        HardwareVendor intel = new HardwareVendor();
        intel.setVendorName("Intel");
        intel.setTypeOfChip("Processor");

        hardwareVendorRepository.save(intel);
    }

    private void addVehicles() {
        Car car = new Car();
        car.setTrimLevel("TrimLvl1");

        vehicleRepository.save(car);

        Truck truck = new Truck();
        truck.setPayload("15000");

        vehicleRepository.save(truck);
    }
}
