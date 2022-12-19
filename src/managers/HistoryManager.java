/*JKTV21 Bondarenko*/
package managers;

import entity.Customer;
import entity.History;
import entity.Product;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class HistoryManager {
    private final Scanner scanner;
    private final CustomerManager readerManager;
    private final ProductManager bookManager;

    public HistoryManager(){
       scanner = new Scanner(System.in);
       readerManager = new CustomerManager();
       bookManager = new ProductManager();
    }
    public History takeOnProduct(Customer[] customer, Product[] products){
         //из списка покупателей выбрать покупателя
        //их списка продуктов выбрать продукт
        //инициировать поля History
        //добавить дату выдачи продукта
        System.out.println("Список покупателей: ");
        readerManager.printListCustomers(customer);
        System.out.println("Выберите номер покупателя из списка: ");
        int numberCustomer = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Список продуктов:");
        bookManager.printListProducts(products);
        System.out.println("Выберите номер продукта из списка: ");
        int numberProduct = scanner.nextInt();
        scanner.nextLine();
        History history = new History();
        history.setProduct(products[numberProduct - 1]);
        history.setCustomer(customer[numberCustomer - 1]);
        history.setTakeOnProduct(new GregorianCalendar().getTime());
        return history;
    }
    public void printListPurchasedProducts(History[] histories) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < histories.length; i++) {
            History history = histories[i];
            if(history.getReturnProduct() == null){
                System.out.printf("%d. %s. Куплено: %s  Покупатель: %s %s. Телефон: %s%n"
                        ,i+1
                        ,history.getProduct().getTitle()
                        ,sdf.format(history.getTakeOnProduct())
                        ,history.getCustomer().getFirstname()
                        ,history.getCustomer().getLastname()
                        ,history.getCustomer().getPhone()
                );
            }
           
        }        
    }
    public History[] returnProduct(History[] histories){
        // vybrat nomer istorii c vydannoi knigoi iz spiska
        // propisat datu vozvrata v istoriju
        System.out.println("Список купленного товара: ");
        this.printListPurchasedProducts(histories);
        System.out.println("Выберите номер возвращаемого товара из списка: ");
        int numberHistory = scanner.nextInt(); scanner.nextLine();
        histories[numberHistory - 1].setReturnProduct(new GregorianCalendar().getTime());
        return histories;
    }    
}