package aptecht2008m.demospring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Page<Product> findAll(int page, int limit){ ;
        return productRepository.findAll(
                PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "price")));
    }
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public List<Product> findByNameAndPrice(String name, double price){
        return productRepository.findAllByNameContainsAndPriceLessThanEqual(name, price);
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    public Product save(Product account) {
        return productRepository.save(account);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

}
