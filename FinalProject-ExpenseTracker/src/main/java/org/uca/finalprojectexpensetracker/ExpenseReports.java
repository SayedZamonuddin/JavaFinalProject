package org.uca.finalprojectexpensetracker;

import javafx.scene.chart.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExpenseReports {
    // assume the following data structures have been created
    ExpenseTracker expenseTracker;
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    PieChart pieChart = new PieChart();
    LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);

    public ObservableList<ExpenseCategory> getCategoryNames() {
        // return an observable list of category names
        return FXCollections.observableArrayList(Arrays.asList(ExpenseCategory.values()));
    }

    public void generateExpenseReport(Date startDate, Date endDate, ExpenseCategory category) {
        // get expenses that fall within the specified date range and category
        List<Expense> expenses = expenseTracker.getExpensesByCategoryAndDateRange(category, startDate, endDate);

        // calculate total expenses
        double totalExpenses = expenses.stream().mapToDouble(Expense::getAmount).sum();

        // display total expenses in a text field
        //double TextField Object totalExpensesField = new TextField(String.format("%.2f", totalExpenses));

        // generate a pie chart to visualize expenses by category
        Map<ExpenseCategory, Double> expensesByCategory = expenseTracker.calculateExpensesByCategory(expenses);
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Map.Entry<ExpenseCategory, Double> entry : expensesByCategory.entrySet()) {
            pieChartData.add(new PieChart.Data(entry.getKey().toString(), entry.getValue()));
        }
        pieChart.setData(pieChartData);

        // generate a line chart to visualize expenses over time
        Map<Date, Double> expensesByDate = expenseTracker.calculateExpensesByDate(expenses);
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (Map.Entry<Date, Double> entry : expensesByDate.entrySet()) {
            series.getData().add(new XYChart.Data<>(entry.getKey().toString(), entry.getValue()));
        }
        lineChart.getData().add(series);
    }
}

