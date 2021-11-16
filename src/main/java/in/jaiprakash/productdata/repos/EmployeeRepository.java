package in.jaiprakash.productdata.repos;

import in.jaiprakash.productdata.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
