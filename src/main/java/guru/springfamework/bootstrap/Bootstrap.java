package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initCategories();
        initCustomers();
        initVendors();
    }


    private void initCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);


        System.out.println("Categories data loaded: " + categoryRepository.count() );
    }

    private void initCustomers() {
        Customer joe = new Customer();
        joe.setFirstname("Joe");
        joe.setLastname("Buck");

        Customer sandy = new Customer();
        sandy.setFirstname("Sandy");
        sandy.setLastname("Burgund");

        Customer melissa = new Customer();
        melissa.setFirstname("Melissa");
        melissa.setLastname("Snow");

        customerRepository.save(joe);
        customerRepository.save(sandy);
        customerRepository.save(melissa);

        System.out.println("Customers data loaded: " + customerRepository.count());
    }

    private void initVendors() {
        Vendor vendor1 = new Vendor();
        vendor1.setName("Vendor no1");

        Vendor vendor2 = new Vendor();
        vendor2.setName("Vendor no2");

        Vendor vendor3 = new Vendor();
        vendor3.setName("Vendor no3");

        vendorRepository.save(vendor1);
        vendorRepository.save(vendor2);
        vendorRepository.save(vendor3);

        System.out.println("Vendor's data loaded: " + vendorRepository.count());
    }
}
