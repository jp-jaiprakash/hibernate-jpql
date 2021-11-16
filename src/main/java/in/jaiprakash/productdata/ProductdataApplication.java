package in.jaiprakash.productdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductdataApplication.class, args);
	}

}

/**
 *
 * Spring boot scans class path entries in our case maven dependencies. hibernate is default orm. Also it
 * finds SQL jar so it knows we want to connect with SQL DB.
 * Then looks at application.properties for connection details
 * Then scans through the package to find repository and entities.
 *
 * Spring-data has all the information for creation of JPA EntityManagerFactory. Then it will create EntityManager
 * When we exceute productrepository.save() then spring internally creates a proxy implementation productrepository
 *
 *PagingAndSortingRepository is the child class of CRUDRepository
 * pageable -> Interface and implemented by PageRequest
 *
 * Sorting => Sort, Direction,Order
 *
 */
