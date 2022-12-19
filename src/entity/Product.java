/*JKTV21 Bondarenko*/
package entity;

import java.util.Arrays;

public class Product {
    private String title;
    private Brand[] brands = new Brand[0];

    public Product() {
    }

    public Product(String title, Brand[] brands) {
        this.title = title;
        this.brands = brands;
    }

    public Brand[] getBrands() {
        return brands;
    }

    public void setBrands(Brand[] brands) {
        this.brands = brands;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public String toString() {
        return "Product{"
                + "title=" + title
                + ", brands=" + Arrays.toString(brands) 
                + '}';
    }

    public void addBrand(Brand brand) {
        Brand[] newBrands = Arrays.copyOf(brands, brands.length + 1);
        newBrands [newBrands.length-1] = brand;
        this.brands = newBrands;
    }
    public void removeBrand(int numberOfBrand){
        //обнуляем указанный бренд (по индексу)
        this.getBrands()[numberOfBrand-1]=null;
        //создаем массив с количеством элементов на 1 меньше
        Brand[] newBrands = new Brand[this.getBrands().length-1];
        // в цикле копируем элементы в новый массив не учитывая обнуленную ячейку
        int j = 0;
        for (Brand brand : this.getBrands()) {
            if (brand != null) {
                newBrands[j] = brand;
                j++;
            }
        }
        //копируем ссылку на новый массив в продукт
        this.setBrands(newBrands);
    }
}
