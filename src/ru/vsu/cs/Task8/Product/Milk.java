package ru.vsu.cs.Task8.Product;

import java.util.Objects;

public class Milk extends Product {
    private Double fatness;
    private final static int VOLUME;

    static {
        VOLUME = 500;
        System.out.println("Статический блок инициализации в Milk вызван. Объем: " + VOLUME);
    }

    {
        fatness = 1.0;
        System.out.println("Экземплярный блок инициализации в Milk вызван. Жирность: " + fatness);
    }

    public Milk(String nameOfProduct, Double price, String supplier, Double fatness) {
        super(nameOfProduct, price, supplier);
        this.fatness = fatness != null ? fatness : this.fatness;
    }

    public String checkFatness() {
        if (fatness > 3.5) {
            return "Молоко весьма жирное!";
        } else {
            return "Это маложирное молоко.";
        }
    }

    public String nameOutput() {
        return "Это молоко с жирностью " + fatness + "%.";
    }

    public Double getFatness() {
        return fatness;
    }

    public void setFatness(Double fatness) {
        this.fatness = fatness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Milk milk = (Milk) o;
        return Objects.equals(fatness, milk.fatness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fatness);
    }

    @Override
    public String toString() {
        return "Milk{" +
                "fatness=" + fatness +
                '}' + super.toString();
    }
}
