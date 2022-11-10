package kodlamaio.northwind.api.Contreollers;

import kodlamaio.northwind.business.Abstracts.ProductService;
import kodlamaio.northwind.business.Concretes.ProductManager;
import kodlamaio.northwind.entities.Concretes.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/api/products")
public class ProductsController {

    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){
        return this.productService.getAll();
    }

}
