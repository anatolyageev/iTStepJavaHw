package org.example.ageev;

import org.example.ageev.domain.Product;
import org.example.ageev.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ContextConfig.class);

        ProductService productService = ctx.getBean(ProductService.class);
        System.out.println("insert example:");
        dbInit(productService);
        System.out.println(productService.findAll());
        System.out.println("--------------------------------");
        System.out.println("findById example:");
        System.out.println(productService.findById(1));
        System.out.println("--------------------------------");
        System.out.println("findByLabel example:");
        System.out.println(productService.findByLabel("iPad"));
        System.out.println("--------------------------------");
        System.out.println("update example:");
        System.out.println(productService.update(new Product(2,"appleWatch5",120)));
        System.out.println(productService.findAll());
        System.out.println("--------------------------------");
        System.out.println("delete example:");
        System.out.println(productService.delete(productService.findById(3)));
        System.out.println(productService.findAll());
        System.out.println("--------------------------------");
        productService.deleteAll();
    }

    private static void dbInit(ProductService productService) {
        productService.insert(new Product("iPhone",500));
        productService.insert(new Product("appleWatch",100));
        productService.insert(new Product("iPad",600));
        productService.insert(new Product("JBL",100));
    }
}
