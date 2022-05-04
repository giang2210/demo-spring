package aptecht2008m.demospring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {
    @Autowired
    ProductService productService;
    private static Page<Product> productList;

    //static {
    //productList = new ArrayList<>();
    // productList.add(new Product(1,"giang", "hjgjhghj", 1, 1));
    //productList.add(new Product(2,"giang1", "ggggg", 2,2));
    //productList.add(new Product(3,"giang2", "gggggdd", 3,3));
    //productList.add(new Product(4,"giang3", "eaaaaaa", 4,4));
    //}
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getList(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "10") int limit) {
        //System.out.println("Page" +page);
        // System.out.println("Limit" +limit);
        return (List<Product>) productService.findAll(page, limit);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Product getDetail(@PathVariable int id) {
        // Product fount = null;
        // for (Product product:
        //     productList) {
        // if (product.getId() == id){
        //     fount = product;
        //     break;
        // }
        // }
        //  return fount;
        return productService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product product) {
        productService.save(product);
        //productList.add(product);
        return product;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Product update(@PathVariable int id, @RequestBody Product updateProduct) {
        // Product found = null;
        // for (Product product :
        //      productList) {
        //  if (product.getId() == id) {
        //      found = product;
        //      break;
        //  }
        // }
        //if (found != null) {
        //      found.setName(updateProduct.getName());
        //      found.setDescription(updateProduct.getDescription());
        //      found.setStatus(updateProduct.getStatus());
        //      found.setPrice(updateProduct.getPrice());
        //  }
        //  return found;
        Product existing = productService.findById(id).get();
        existing.setName(updateProduct.getName());
        productService.save(existing);
        return updateProduct;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id) {
        //  Product found= null;
        //  for (Product product:
        //      productList) {
        //  if (product.getId() == id){
        //      found = product;
        //      break;
        //  }
        //}
        //if (found!= null){
        //  productList.remove(found);
        //}
        //return "0kie";
        //}
        return true;
    }
}
