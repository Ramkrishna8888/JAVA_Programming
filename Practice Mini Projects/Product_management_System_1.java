// Use of Exception handeling

import java.util.*;
import java.util.stream.*;
import java.time.*;

class InvalidPriceException extends Exception {
    public InvalidPriceException(String msz) {
        super(msz);
    }
}

class InvalidDescriptionException extends Exception {
    public InvalidDescriptionException(String msz) {
        super(msz);
    }
}

class NewProduct {
    private int productId;
    private String productName;
    private double price;
    private LocalDate expiryDate;
    private String productDescription;

    NewProduct(int productId, String productName, double price, LocalDate expiryDate, String productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.expiryDate = expiryDate;
        this.productDescription = productDescription;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getProductDescription() { return productDescription; }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Price: " + price + 
               ", Expiry Date: " + expiryDate + ", Description: " + productDescription;
    }
}

class ProductValidator {
    public boolean validProductName(String name) {
        return name.matches("[A-Z]{1}[a-zA-Z]{0,19}");
    }

    public boolean validProductDescription(String description) {
        return description.matches("[a-zA-Z,\\- ]+");
    }
}

class ProductServices {
    List<NewProduct> list = new ArrayList<>();

    void addProduct(NewProduct product) {
        list.add(product);
    }

    boolean deleteProduct(int productId) {
        return list.removeIf(product -> product.getProductId() == productId);
    }

    void removeExpiredProducts() {
        LocalDate currentDate = LocalDate.now();
        list.removeIf(product -> product.getExpiryDate().isBefore(currentDate));
    }

    List<NewProduct> searchProductByName(String name) {
        return list.stream()
                .filter(e -> e.getProductName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    Map<Integer, String> searchProductByPriceRange(double minPrice, double maxPrice) throws InvalidPriceException {
        if (minPrice < 0 || maxPrice < 0) {
            throw new InvalidPriceException("Price cannot be negative.");
        }
        return list.stream()
                .filter(e -> e.getPrice() >= minPrice && e.getPrice() <= maxPrice)
                .collect(Collectors.toMap(NewProduct::getProductId, NewProduct::getProductName));
    }

    List<NewProduct> sortByExpiryDateDescending() {
        return list.stream()
                .sorted(Comparator.comparing(NewProduct::getExpiryDate).reversed())
                .collect(Collectors.toList());
    }

    List<NewProduct> sortByNameAscending() {
        return list.stream()
                .sorted(Comparator.comparing(NewProduct::getProductName))
                .collect(Collectors.toList());
    }
}

public class NewProductDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductServices obj = new ProductServices();
        ProductValidator validator = new ProductValidator();

        System.out.println("Enter the number of products:");
        int size = sc.nextInt();
        sc.nextLine(); 

        try {
            for (int i = 0; i < size; i++) {
                System.out.print("Enter in format (ProductID:ProductName:Price:ExpiryDate:ProductDescription): ");
                String details = sc.nextLine();

                String[] arr = details.split(":");
                int productId = Integer.parseInt(arr[0]);
                String productName = arr[1];
                double price = Double.parseDouble(arr[2]);
                LocalDate expiryDate = LocalDate.parse(arr[3]);
                String productDescription = arr[4];

                if (!validator.validProductName(productName)) {
                    System.out.println("Product name is invalid. It should start with a capital letter and at most 20 characters.");
                    return;
                }

                if (!validator.validProductDescription(productDescription)) {
                    System.out.println("Product description is invalid. It should contain only letters, commas, hyphens, and spaces.");
                    return;
                }

                NewProduct newProduct = new NewProduct(productId, productName, price, expiryDate, productDescription);
                obj.addProduct(newProduct);
                System.out.println("Product added successfully!\n");
            }

            obj.removeExpiredProducts();
            System.out.println("Expired products removed if there is any");

            System.out.println("\nEnter the product ID to delete:");
            int deleteId = sc.nextInt();
            sc.nextLine(); 

            if (!obj.deleteProduct(deleteId)) {
                System.out.println("No product found with ID: " + deleteId);
            } else {
                System.out.println("Product deleted successfully!");
            }

            System.out.println("\nEnter the product name to search:");
            String searchProduct = sc.nextLine();
            List<NewProduct> searchedProducts = obj.searchProductByName(searchProduct);

            if (searchedProducts.isEmpty()) {
                System.out.println("No product found with name: " + searchProduct);
            } else {
                System.out.println("Products found:");
                searchedProducts.forEach(System.out::println);
            }

            System.out.println("\nEnter minimum and maximum price range to search products:");
            double minPrice = sc.nextDouble();
            double maxPrice = sc.nextDouble();
            sc.nextLine();

            Map<Integer, String> productsByPrice = obj.searchProductByPriceRange(minPrice, maxPrice);
            if (productsByPrice.isEmpty()) {
                System.out.println("No products found in the price range: " + minPrice + " to " + maxPrice);
            } else {
                System.out.println("Products in the price range:");
                productsByPrice.forEach((id, name) -> System.out.println("Product ID: " + id + ", Name: " + name));
            }

            System.out.println("Products sorted by Expiry Date (Descending):");
            obj.sortByExpiryDateDescending().forEach(System.out::println);

            System.out.println("Products sorted by Name (Ascending):");
            obj.sortByNameAscending().forEach(System.out::println);

        } catch (InvalidPriceException e) {
            System.out.println(e.getMessage());
        }
    }
}
