package kodlamaio.northwind.dataAccess.Abstracts;

import kodlamaio.northwind.entities.Concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {





}
