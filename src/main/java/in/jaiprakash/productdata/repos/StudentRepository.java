package in.jaiprakash.productdata.repos;

import in.jaiprakash.productdata.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    // if we want partial columns then use select statement
    // "Student" is class name not table name
    @Query("from Student")
    List<Student> findAllStudents();

    // change 3
    @Query("select st.firstName,st.lastName from Student st")
    List<Object[]> findAllStudentsPartialData();

    // change 2
    @Query("from Student where firstName=:firstName")
    List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);

    // Adding Paging and sorting change 1
    @Query("from Student")
    List<Student> findAllStudents(Pageable pageable);
}
