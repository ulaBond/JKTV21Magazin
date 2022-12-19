/* */
package managers;

import entity.Customer;
import java.util.Scanner;

public class CustomerManager {
    private Scanner scanner;

    public CustomerManager() {
        scanner = new Scanner(System.in);
    }
    
    public Customer createCustomer(){
        Customer customer = new Customer();
        System.out.println("Введите имя: ");
        customer.setFirstname(scanner.nextLine());
        System.out.println("Введите фамилию: ");
        customer.setLastname(scanner.nextLine());
        System.out.println("Введите телефон: ");
        customer.setPhone(scanner.nextLine());
        return customer;
    }
    
    public void printListCustomers(Customer[] customers){
        for (int i = 0; i < customers.length; i++){
            System.out.printf("%d. %s %s. Телефон: %s%n"
                ,i+1
                , customers[i].getFirstname()
                , customers[i].getLastname()
                , customers[i].getPhone()
            );
        }
    }

    public Customer[] changeCustomer(Customer[] customers) {
        System.out.println("Список покупателей");
        this.printListCustomers(customers);
        System.out.print("Выберите номер покупателя из списка");
        int numberCustomer = scanner.nextInt(); scanner.nextLine();
        System.out.println("Имя: "+customers[numberCustomer - 1].getFirstname());
        System.out.print("Заменить? (y/n)");
        String task = scanner.nextLine();
        if("y".equals(task)){
            System.out.println("Введите новое имя покупателя: ");
            customers[numberCustomer - 1].setFirstname(scanner.nextLine());
        }
        System.out.println("Фамилия: "+customers[numberCustomer - 1].getLastname());
        System.out.print("Заменить? (y/n)");
        task = scanner.nextLine();
        if("y".equals(task)){
            System.out.println("Введите новую фамилию покупателя: ");
            customers[numberCustomer - 1].setLastname(scanner.nextLine());
        }
        System.out.println("Телефон: "+customers[numberCustomer - 1].getPhone());
        System.out.print("Заменить? (y/n)");
        task = scanner.nextLine();
        if("y".equals(task)){
            System.out.println("Введите новый телефон покупателя: ");
            customers[numberCustomer - 1].setPhone(scanner.nextLine());
        }
        System.out.println("Новые данные покупателя: "+customers[numberCustomer - 1].toString());
        
        return customers;        
    }
}