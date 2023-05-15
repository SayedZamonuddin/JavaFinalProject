package org.uca.finalprojectexpensetracker;

public enum ExpenseCategory {
    FOOD("Food"),
    TRANSPORTATION("Transportation"),
    ENTERTAINMENT("Entertainment"),
    UTILITIES("Utilities"),
    HEALTHCARE("Healthcare"),
    OTHER("Other");

    private final String categoryName;

    ExpenseCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

