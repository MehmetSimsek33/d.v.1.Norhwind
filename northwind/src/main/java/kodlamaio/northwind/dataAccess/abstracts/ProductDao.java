package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product,Integer>{
	  Product getByProductName(String productName);
	  
	  Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	  
	  List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	  
	  List<Product> getByCategoryIn(List<Integer> categories);
	  
	  List<Product> getByProductNameContains(String productName);
	  
	  List<Product> getByProductNameStartsWith(String productName);
	  
	  @Query("From Product where productName=:productName and category.categoryId=:categoryId")
	  List<Product> getByNameAndCategory(String productName, int categoryId);
	  
	  @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
	  		+ "(p.id,p.productName,c.categoryName) "
	  		+ "From Category c Inner Join c.products p")
	  		List<ProductWithCategoryDto> getProductWithCategoryDetails();
	//select from products where=productName=...;(1)
	//select *from products  where=productName=... and categoryId= ...;(2)
	//select *from where=productName=... or categoryId= ...;(3)
	//select *from products where category_id in(..,..,.,,)(4)
	//Select *from products where product_name birşey and categoryId=birsey(7)
	 //select *from Category c inner join Product p on c. categoryId=P.categoryId(8)



	
	
	
}
