/*JKTV21 Bondarenko*/
package jktv21magazin;

import entity.Brand;
import entity.Customer;
import entity.History;
import entity.Product;
import java.util.Arrays;

import java.util.Scanner;
import managers.CustomerManager;
import managers.HistoryManager;
import managers.ProductManager;

public class App {
    private final Scanner scanner;
    private final ProductManager productManager;
    private final CustomerManager customerManager;
    private final HistoryManager historyManager;
    private Product[] products;
    private Customer[] customers;
    private History[] histories;
    
    public App(){
        scanner = new Scanner(System.in);
        productManager = new ProductManager();
        customerManager = new CustomerManager();
        historyManager= new HistoryManager();
        
        products = new Product[0];
        customers = new Customer[0];
        histories = new History[0];
        testAddProduct();
        testAddCustomer();
    }
    
    public void run(){
        boolean repeat = true;
        do {
            System.out.println("---------------------------------------------------");
            System.out.println("функции приложения: ");
            System.out.println("0 - закрыть приложение.");
            System.out.println("1 - добавить товар.");
            System.out.println("2 - добавить покупателя.");
            System.out.println("3 - добавить запись о покупке товара.");
            System.out.println("4 - добавить денег покупателю.");
            System.out.println("5 - список товаров.");            
            System.out.println("6 - список зарегистрированных покупателей."); 
            System.out.println("7 - изменить данные покупателя.");
            System.out.println("8 - редактирование товаров.");
            System.out.println("9 - доход магазина за все время работы.");
            System.out.println("Выберите номер функции: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task){
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1 - добавить товар.");
                    addProduct(productManager.createProduct());
                    break;
                case 2:
                    System.out.println("2 - добавить покупателя.");
                    addCustomer(customerManager.createCustomer());
                    break;
                case 3:
                    System.out.println("3 - добавить запись о покупке товара.");
                    addHistories(historyManager.takeOnProduct(customers, products));
                    break;
                case 4:
                    System.out.println("4 - добавить денег покупателю.");
                case 5:
                    System.out.println("5 - список товаров.");
                    productManager.printListProducts(products);                    
                    break;
                case 6:
                    System.out.println("6 - список зарегистрированных покупателей.");
                    customerManager.printListCustomers(customers);
                    break;
                case 7:
                    System.out.println("7 - изменить данные покупателя.");
                    customerManager.changeCustomer(customers);
                    break;
                case 8:
                    System.out.println("8 - редактирование товаров.");
                    productManager.changeProduct(products);  
                    break;
                case 9:
                    System.out.println("9 - доход магазина за все время работы.");
                    break;
                default:
                    System.out.println("Выберите номер функции из списка!");
            }
        }while(repeat);
        System.out.println("Chao!");
    }
    private void addProduct(Product product){
        products = Arrays.copyOf(products, products.length+1);
        products[products.length-1] = product;
    }
    
    private void addCustomer(Customer customer){
        customers = Arrays.copyOf(customers, customers.length+1);
        customers[customers.length-1] = customer;
    }
    
    private void addHistories(History history){
        histories = Arrays.copyOf(histories, histories.length+1);
        histories[histories.length-1] = history;
    }
    
    private void testAddProduct(){
        Product product = new Product();
        product.setTitle("Piim");
        Brand brand = new Brand("Farmi", "53768882");
        product.addBrand(brand);
        this.products = Arrays.copyOf(this.products, this.products.length + 1);
        this.products[this.products.length - 1] = product;
    }
    private void testAddCustomer(){
        Customer customer = new Customer("Yuliia", "Bond", "1254789");
        customers = Arrays.copyOf(customers, customers.length + 1);
        customers[customers.length - 1] = customer;
    }
}