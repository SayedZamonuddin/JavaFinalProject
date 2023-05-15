package org.uca.finalprojectexpensetracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExpenseTracker {
    private final List<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getExpensesByCategory(ExpenseCategory category) {
        List<Expense> filteredExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getCategory() == category) {
                filteredExpenses.add(expense);
            }
        }
        return filteredExpenses;
    }

    public List<Expense> getExpensesByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Expense> filteredExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            LocalDate expenseDate = expense.getDate();
            if (((LocalDate) expenseDate).isAfter(startDate) && expenseDate.isBefore(endDate)) {
                filteredExpenses.add(expense);
            }
        }
        return filteredExpenses;
    }

    public double calculateTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    public List<Expense> getExpensesByCategoryAndDateRange(ExpenseCategory category, Date startDate, Date endDate) {
        return null;
    }

    public Map<ExpenseCategory, Double> calculateExpensesByCategory(List<Expense> expenses) {
        return null;
    }

    public Map<Date, Double> calculateExpensesByDate(List<Expense> expenses) {
        return null;
    }

    // Implement methods to load and save expenses from/to a file or database
    // You can use serialization, file I/O, or database APIs for this purpose

    // Example methods:
    // public void loadExpensesFromFile(String filePath) { ... }
    // public void saveExpensesToFile(String filePath) { ... }
    // public void loadExpensesFromDatabase() { ... }
    // public void saveExpensesToDatabase() { ... }
}
