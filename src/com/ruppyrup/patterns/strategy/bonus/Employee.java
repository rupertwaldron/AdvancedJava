package com.ruppyrup.patterns.strategy.bonus;

public class Employee {
    private BonusScheme bonus;

    public Employee(BonusScheme bonus) {
        this.bonus = bonus;
    }

    Money totalPay() {
        Money pay = calculateBasePay();

        bonus.apply(pay);

        return pay;
    }

    private Money calculateBasePay() {
        return new Money(100);
    }
}
