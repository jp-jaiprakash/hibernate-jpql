package in.jaiprakash.productdata;

import in.jaiprakash.productdata.entities.Employee;
import in.jaiprakash.productdata.entities.Product;
import in.jaiprakash.productdata.entities.Student;
import in.jaiprakash.productdata.repos.EmployeeRepository;
import in.jaiprakash.productdata.repos.ProductRepository;
import in.jaiprakash.productdata.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductdataApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	StudentRepository studentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate(){
		Product product = new Product(1,"Iphone", "Awesome", 1000.0);

		productRepository.save(product);
	}

	@Test
	public void testRead(){
		Optional<Product> product = productRepository.findById(1);

		assertNotNull(product.get());
		assertEquals("Iphone", product.get().getName());
	}


	@Test
	public void testUpdate(){
		Product product = productRepository.findById(1).get();
		product.setPrice(1200.0);
		productRepository.save(product);
	}

	@Test
	public void testDelete(){
		productRepository.deleteById(1);
	}

	@Test
	public void createEmployee(){
		Employee employee = new Employee();
		employee.setName("Jai");
		employeeRepository.save(employee);
	}


	@Test
	public void testFindAllPaging() {

		Pageable pageable = Pageable.ofSize(2);
		Pageable page2 = PageRequest.of(0, 2); // means divide the records by 2 and pull index 0
		Pageable page3 = PageRequest.of(1, 2);
		Iterable<Product> products = productRepository.findAll(page3);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllSorting() {
		productRepository.findAll(Sort.by(new Sort.Order(Sort.Direction.DESC, "name"), new Sort.Order(Sort.Direction.ASC, "price"))
		).forEach(p -> System.out.println(p.getName()));
	}


	@Test
	public void testStudentCreate(){
		Student student1 = new Student("John", "F", 88);
		Student student2 = new Student("Jai", "Prakash", 94);

		studentRepository.save(student1);
		studentRepository.save(student2);
	}

	@Test
	public void testFindAllJPQL(){
		System.out.println(studentRepository.findAllStudents());
	}

	@Test
	public void testFindAllJPQLPartial(){
		List<Object[]> partialData= studentRepository.findAllStudentsPartialData();
		for(Object[] o: partialData){
			System.out.println(o[0] + ":" + o[1]);
		}
	}

	@Test
	public void testFindAllJPQLByFirstName(){
		System.out.println(studentRepository.findAllStudentsByFirstName("Jai"));
	}

	@Test
	public void testFindAllJPQLPaging(){
		System.out.println(studentRepository.findAllStudents(Pageable.ofSize(2)));
	}

	@Test
	public void  testFindAllJPQLPagingSorting(){
		System.out.println(studentRepository.findAllStudents(PageRequest.of(1, 3, Sort.Direction.DESC, "firstName")));
	}

	@Test
	public void testFindAllJPQLPagingSecondPage(){
		System.out.println(studentRepository.findAllStudents(PageRequest.of(1, 2)));
	}
}
