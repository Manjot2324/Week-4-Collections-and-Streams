import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    String name;
    double weight;
    
    WarehouseItem(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
}

class Electronics extends WarehouseItem {
    Electronics(String name, double weight) {
        super(name, weight);
    }
}

class Groceries extends WarehouseItem {
    Groceries(String name, double weight) {
        super(name, weight);
    }
}

class Furniture extends WarehouseItem {
    Furniture(String name, double weight) {
        super(name, weight);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    
    public void addItem(T item) {
        items.add(item);
    }
    
    public List<T> getItems() {
        return items;
    }
    
    public void displayItems(List<? extends WarehouseItem> list) {
        for (WarehouseItem item : list) {
            System.out.println(item.name + " - " + item.weight + "kg");
        }
    }
    
    public static void main(String[] args) {
        Storage<WarehouseItem> warehouse = new Storage<>();
        
        warehouse.addItem(new Electronics("Laptop", 1.5));
        warehouse.addItem(new Groceries("Apple", 0.2));
        warehouse.addItem(new Furniture("Table", 15.0));
        
        warehouse.displayItems(warehouse.getItems());
    }
}
