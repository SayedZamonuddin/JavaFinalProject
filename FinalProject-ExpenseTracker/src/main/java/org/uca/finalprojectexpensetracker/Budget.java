package org.uca.finalprojectexpensetracker;

public class Budget {
    private double amount;
    private ExpenseCategory category;

    public Budget(double amount, ExpenseCategory category) {
        this.amount = amount;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }
}

