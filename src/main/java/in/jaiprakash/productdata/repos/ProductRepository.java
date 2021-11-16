package in.jaiprakash.productdata.repos;

import in.jaiprakash.productdata.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    List<Product> findByName(String name);

    List<Product> findByNameAndDesc(String name, String desc);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByDescContains(String desc);

    List<Product> findByPriceBetween(Double price1,Double price2);

    List<Product> findByDescLike( String desc);

    List<Product> findByIdIn(List<Integer> ids);

}
