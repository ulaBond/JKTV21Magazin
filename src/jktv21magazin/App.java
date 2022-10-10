/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktv21magazin;

import entity.Customer;
import entity.Product;
import entity.Purchase;
import java.util.Scanner;

/*@author Юлия*/
class App {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        do {
            System.out.println("функции приложения: ");
            System.out.println("0 - закрыть приложение.");
            System.out.println("1 - добавить товар.");
            System.out.println("2 - добавить покупателя.");
            System.out.println("3 - добавить запись о покупке товара.");
            System.out.println("4 - добавить запись о возврате товара.");
            System.out.println("5 - список товаров.");
            System.out.println("Выберите номер функции: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task){
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1 - добавить товар.");
                    Product product = new Product();
                    break;
                case 2:
                    System.out.println("2 - добавить читателя.");
                    Customer customer = new Customer();
                    break;
                case 3:
                    System.out.println("3 - добавить запись о взятии книги.");
                    Purchase purchase = new Purchase();
                    break;
                case 4:
                    System.out.println("4 - добавить запись о возврате книги.");
                    break;
                case 5:
                    System.out.println("5 - список книг.");
                    break;
                  
                default:
                    System.out.println("Выберите номер функции из списка!");
            }
        }while(repeat);
        System.out.println("Chao!");
    }
}