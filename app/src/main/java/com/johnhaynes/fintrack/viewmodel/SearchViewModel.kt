package com.johnhaynes.fintrack.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.johnhaynes.fintrack.data.entity.Transaction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModel : ViewModel() {

    private val _results = MutableStateFlow<List<Transaction>>(emptyList())
    val results: StateFlow<List<Transaction>> = _results

    private val sampleTransactions = listOf(
        Transaction(1, "Paycheck", 1500.0, "Income"),
        Transaction(2, "Groceries", -120.0, "Food"),
        Transaction(3, "Rent", -900.0, "Housing"),
        Transaction(4, "Gas", -60.0, "Transportation"),
        Transaction(5, "Electric Bill", -98.0, "Utilities"),
        Transaction(6, "Internet", -75.0, "Utilities"),
        Transaction(7, "Phone Bill", -85.0, "Utilities"),
        Transaction(8, "Restaurant", -42.0, "Dining"),
        Transaction(9, "Coffee", -12.0, "Dining"),
        Transaction(10, "Movie Tickets", -30.0, "Entertainment"),
        Transaction(11, "Car Insurance", -140.0, "Insurance"),
        Transaction(12, "Savings Deposit", 300.0, "Savings")
    )

    fun search(context: Context, query: String) {

        if (query.isBlank()) {
            _results.value = emptyList()
            return
        }

        _results.value = sampleTransactions.filter {
            it.description.contains(
                query,
                ignoreCase = true
            )
        }
    }
}