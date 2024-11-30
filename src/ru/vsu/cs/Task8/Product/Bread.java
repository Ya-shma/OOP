package ru.vsu.cs.Task8.Product;

import java.util.Objects;

public class Bread extends Product {
    private String typeOfBread;
    private static final String DEFAULT_TYPE = "Белый";

    static {
        System.out.println("Статический блок инициализации в Bread вызван.");
    }

    {
        typeOfBread = DEFAULT_TYPE;
        System.out.println("Экземплярный блок инициализации в Bread вызван. Тип хлеба: " + typeOfBread);
    }

    public Bread(String nameOfProduct, Double price, String supplier, String typeOfBread) {
        super(nameOfProduct, price, supplier);
        this.typeOfBread = typeOfBread != null ? typeOfBread : this.typeOfBread;
    }

    public String nameOutput() {
        return "Это " + typeOfBread + " хлеб.";
    }


    public String getTypeOfBread() {
        return typeOfBread;
    }

    public void setTypeOfBread(String typeOfBread) {
        this.typeOfBread = typeOfBread;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bread bread = (Bread) o;
        return Objects.equals(typeOfBread, bread.typeOfBread);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfBread);
    }

    @Override
    public String toString() {
        return "Bread{" +
                "typeOfBread='" + typeOfBread + '\'' +
                '}' + super.toString();
    }
}
