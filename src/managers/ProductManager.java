/*JKTV21 Bondarenko */
package managers;

import entity.Brand;
import entity.Product;
import java.util.Scanner;

public class ProductManager {
    private Scanner scanner;

    public ProductManager() {
        scanner = new Scanner(System.in);
    }
    
    public Product createProduct(){
        Product product = new Product();
        System.out.println("Введите название продукта: ");
        product.setTitle(scanner.nextLine());
        System.out.println("Сколько брендов: ");
        int countBrandsInProduct = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < countBrandsInProduct; i++) {
            product.addBrand(createBrand());
        }
        return product;
    }
    private Brand createBrand() {
        Brand brand = new Brand();
        System.out.println("Введите название бренда: ");
        brand.setName(scanner.nextLine());
        System.out.println("Введите контактный телефон: ");
        brand.setPhone(scanner.nextLine());
        return brand;
    }
    public void printListProducts(Product[] products){
        for (int i = 0; i < products.length; i++) {
            Product product1 = products[i];
            System.out.println("*************************");
            System.out.printf(i+1+". %s. ", product1.getTitle());
            for (int j = 0; j < product1.getBrands().length; j++) {
                System.out.printf(j+1+". Brand: %s %s.",
                        product1.getBrands()[j].getName(),
                        product1.getBrands()[j].getPhone());                            
            }
            System.out.printf("Цена: %s euro. ", product1.getPrice());
            System.out.printf("Количество: %s штук. ", product1.getKol());
        }
    }
    
    public Product[] changeProduct(Product[] products) {
        System.out.println("Список продуктов: ");
        this.printListProducts(products);
        System.out.print("Выберите номер продукта для редактирования: ");
        int numProductForEdit = scanner.nextInt();scanner.nextLine();
        System.out.println("Название продукта: "+products[numProductForEdit - 1].getTitle());
        System.out.println("Изменить название продукта? (y/n)");
        String edit = scanner.nextLine();
        if(edit.equals("y")){
            System.out.print("Введите новое название продукта: ");
            products[numProductForEdit - 1].setTitle(scanner.nextLine());
        }
        System.out.println("Брендов этого продукта "+products[numProductForEdit - 1].getBrands().length);
        System.out.println("Изменить количество брендов? (y/n)");
        edit = scanner.nextLine();
        if(edit.equals("y")){// Меняем количество брендов
            System.out.print("Введите новое количество брендов: ");
            int newCountBrandsInProduct = scanner.nextInt();
            scanner.nextLine();
         // количество брендов может быть больше или меньше.
            if(newCountBrandsInProduct < products[numProductForEdit - 1].getBrands().length){
              //если меньше, выводим нумерованный список брендов и просим указать какого удалить
               // вычисляем на сколько меньше 
                int deltaBrands = products[numProductForEdit - 1].getBrands().length - newCountBrandsInProduct;
                for (int n = 0; n < deltaBrands; n++) {
                    //удаляем лишние (deltaBrands) бренды из продукта
                    products[numProductForEdit - 1] = deleteBrandProduct(products[numProductForEdit - 1]);
                }
            }else{
                for (int i = 0; i < newCountBrandsInProduct; i++) {
                    //если счетчик больше количесвтва брендов
                    if(i >= products[numProductForEdit - 1].getBrands().length){
                        // добаляем новый бренд в продукт
                        Brand newBrand = new Brand();
                        System.out.print("Введите название бренда "+(i+1)+": ");
                        newBrand.setName(scanner.nextLine());
                        System.out.print("Введите контактный телефон"+(i+1)+": ");
                        newBrand.setPhone(scanner.nextLine());
                        products[numProductForEdit - 1].addBrand(newBrand);
                    }else if(i < products[numProductForEdit - 1].getBrands().length){
                        // изменяем существующие бренды у продукта
                        System.out.println(i+1+"-й бренд: "
                            +products[numProductForEdit - 1].getBrands()[i].getName()+" "+
                                   products[numProductForEdit - 1].getBrands()[i].getPhone());
                        System.out.print("Изменить название бренда? (y/n)");
                        edit = scanner.nextLine();
                        if(edit.equals("y")){
                            System.out.print("Введите новое название бренда: ");
                            products[numProductForEdit - 1].getBrands()[i].setName(scanner.nextLine());
                        }    
                        System.out.print("Изменить контактный телефон? (y/n)");
                        edit = scanner.nextLine();
                        if(edit.equals("y")){
                            System.out.print("Введите новый контактный телефон: ");
                            products[numProductForEdit - 1].getBrands()[i].setPhone(scanner.nextLine());
                        }    
                    }
                }
            }
        }
        return products;
        
    }
    private Product changeProductName(Product product) {
        System.out.print("Название продукта: ");
        System.out.println(product.getTitle());
        System.out.print("Изменить название продукта? (y/n)");
        String edit = scanner.nextLine();
        System.out.println();
        if(edit.equals("y")){
            System.out.print("Введите новое название продукта: ");
            product.setTitle(scanner.nextLine());
        }
        return product;
    }

    private Product deleteBrandProduct(Product product) {
        for (int i = 0; i < product.getBrands().length; i++) {
            System.out.println(
                    i+1+". "+product.getBrands()[i].getName()+" "+
                            product.getBrands()[i].getPhone());
        }
        System.out.println("Какой бренд удалить? ");
        int numDeleteBrand = scanner.nextInt();
        scanner.nextLine();
        product.removeBrand(numDeleteBrand);
        return product;
    }
}
