
package com.johnhaynes.fintrack.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.johnhaynes.fintrack.data.entity.Transaction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DashboardViewModel : ViewModel() {

    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> = _transactions

    private val _totalIncome = MutableStateFlow(0.0)
    val totalIncome: StateFlow<Double> = _totalIncome

    private val _totalExpenses = MutableStateFlow(0.0)
    val totalExpenses: StateFlow<Double> = _totalExpenses

    private val _balance = MutableStateFlow(0.0)
    val balance: StateFlow<Double> = _balance

    fun loadDashboardData(context: Context) {

        val sampleTransactions = listOf(

            Transaction(
                id = 1,
                description = "Paycheck",
                amount = 1500.0,
                category = "Income"
            ),

            Transaction(
                id = 2,
                description = "Groceries",
                amount = -120.0,
                category = "Food"
            ),

            Transaction(
                id = 3,
                description = "Rent",
                amount = -900.0,
                category = "Housing"
            ),

            Transaction(
                id = 4,
                description = "Gas",
                amount = -55.0,
                category = "Transportation"
            ),

            Transaction(
                id = 5,
                description = "Electric Bill",
                amount = -98.0,
                category = "Utilities"
            ),

            Transaction(
                id = 6,
                description = "Internet",
                amount = -75.0,
                category = "Utilities"
            ),

            Transaction(
                id = 7,
                description = "Phone Bill",
                amount = -85.0,
                category = "Utilities"
            ),

            Transaction(
                id = 8,
                description = "Restaurant",
                amount = -42.0,
                category = "Dining"
            ),

            Transaction(
                id = 9,
                description = "Coffee",
                amount = -12.0,
                category = "Dining"
            ),

            Transaction(
                id = 10,
                description = "Movie Tickets",
                amount = -30.0,
                category = "Entertainment"
            ),

            Transaction(
                id = 11,
                description = "Car Insurance",
                amount = -140.0,
                category = "Insurance"
            ),

            Transaction(
                id = 12,
                description = "Savings Deposit",
                amount = 300.0,
                category = "Savings"
            )
        )


        _transactions.value = sampleTransactions

        val income = sampleTransactions
            .filter { it.amount > 0 }
            .sumOf { it.amount }

        val expenses = sampleTransactions
            .filter { it.amount < 0 }
            .sumOf { it.amount }

        _totalIncome.value = income
        _totalExpenses.value = expenses
        _balance.value = income + expenses
    }
}