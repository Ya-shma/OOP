package ru.vsu.cs.Task8.Discount;

import ru.vsu.cs.Task8.Discount.DiscountStrategy;

public enum DiscountTypes {
    PERCENTAGE_DISCOUNT((originalPrice, discountValue) -> originalPrice * (1 - discountValue / 100)),
    FIX_DISCOUNT((originalPrice, discountValue) -> originalPrice - discountValue),
    ONE_PLUS_ONE((originalPrice, discountValue) -> originalPrice * (1 - (1.0 / (discountValue + 1))));
    //это расчет того, сколько покупатель платит за каждый товар при покупке двух товаров по акции 1+1
    private final DiscountStrategy discountStrategy;

    DiscountTypes(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public DiscountStrategy value() {
        return discountStrategy;
    }
}