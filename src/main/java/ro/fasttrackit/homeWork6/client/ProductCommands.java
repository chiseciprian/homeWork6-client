package ro.fasttrackit.homeWork6.client;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ro.fasttrackit.homeWork6.client.model.Category;
import ro.fasttrackit.homeWork6.client.model.Product;
import ro.fasttrackit.homeWork6.client.service.ProductService;

import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class ProductCommands {
    private final ProductService productService;

    @ShellMethod("Add new product")
    void addProduct() {
        System.out.print("name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("price: ");
        scanner = new Scanner(System.in);
        Integer price = scanner.nextInt();
        System.out.print("description: ");
        scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        System.out.print("category: ");
        scanner = new Scanner(System.in);
        String category = scanner.nextLine();
        productService.addProduct(new Product(name, price, description, Category.valueOf(category)));
    }

    @ShellMethod("Delete product")
    void deleteProductById() {
        System.out.print("id: ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        productService.deleteProductById(id);
    }

    @ShellMethod("Get Products")
    void getProducts() {
        System.out.println(productService.getProducts());
    }

    @ShellMethod("get by category")
    void byCategory() {
        System.out.print("category: ");
        Scanner scanner = new Scanner(System.in);
        String category = scanner.nextLine();
        System.out.println(productService.getProductsByCategory(category));
    }

    @ShellMethod("get by max price")
    void maxPrice() {
        System.out.print("max price: ");
        Scanner scanner = new Scanner(System.in);
        Integer maxPrice = scanner.nextInt();
        System.out.println(productService.getProductsByMaxPrice(maxPrice));
    }
}
