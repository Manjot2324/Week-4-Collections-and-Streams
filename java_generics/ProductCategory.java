import java.util.*;

abstract class ProductCategory {
    String category;
    double price;
    
    ProductCategory(String category, double price) {
        this.category = category;
        this.price = price;
    }
}

class BookCategory extends ProductCategory {
    BookCategory(double price) {
        super("Books", price);
    }
}

class ClothingCategory extends ProductCategory {
    ClothingCategory(double price) {
        super("Clothing", price);
    }
}

class GadgetCategory extends ProductCategory {
    GadgetCategory(double price) {
        super("Gadgets", price);
    }
}

class Product<T extends ProductCategory> {
    T category;
    
    Product(T category) {
        this.category = category;
    }
    
    <T extends Product> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.category.price - (product.category.price * (percentage / 100));
        System.out.println("Discounted price: " + discountedPrice);
    }
    
    public static void main(String[] args) {
        Product<BookCategory> bookProduct = new Product<>(new BookCategory(100.0));
        bookProduct.applyDiscount(bookProduct, 10);
        
        Product<ClothingCategory> clothingProduct = new Product<>(new ClothingCategory(50.0));
        clothingProduct.applyDiscount(clothingProduct, 15);
        
        Product<GadgetCategory> gadgetProduct = new Product<>(new GadgetCategory(200.0));
        gadgetProduct.applyDiscount(gadgetProduct, 20);
    }
}
