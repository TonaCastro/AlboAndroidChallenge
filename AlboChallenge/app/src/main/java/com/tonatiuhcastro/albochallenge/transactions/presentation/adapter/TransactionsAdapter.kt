package com.tonatiuhcastro.albochallenge.transactions.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tonatiuhcastro.albochallenge.R
import com.tonatiuhcastro.albochallenge.databinding.ItemMonthResumeBinding
import com.tonatiuhcastro.albochallenge.transactions.presentation.model.TransactionData
import java.lang.StringBuilder

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2/1/21
 * @updated on
 * @modified by
 */
class TransactionsAdapter(private val transactions: List<TransactionData>, private val context: Context):
    RecyclerView.Adapter<TransactionsAdapter.TransactionsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionsViewHolder {
        val binding: ItemMonthResumeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_month_resume, parent, false)
        return TransactionsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionsViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.binding.itemMonthTvTitle.text =  transaction.month + ":"
        holder.binding.itemMonthTvTotalBlocked.text = transaction.totalRejected.toString()
        holder.binding.itemMonthTvTotalPending.text = transaction.totalPending.toString()
        holder.binding.itemMonthTvTotalIncomes.text = String.format("$ %.2f", transaction.totalIncomes)
        holder.binding.itemMonthTvTotalExpense.text = String.format("$ %.2f", transaction.totalExpenses)
        val expences = StringBuilder()
        transaction.expenses.forEach() {
            expences.append(it.kind.padEnd((50 - it.kind.length), ' '))
            expences.append("%")
            expences.append(String.format("%.1f", ((it.amount / transaction.totalExpenses ) * 100) ) )
            expences.append("\n")
        }
        holder.binding.itemMonthTvExpenses.text = expences

    }

    override fun getItemCount(): Int = transactions.size

    inner class TransactionsViewHolder(view: ItemMonthResumeBinding) : RecyclerView.ViewHolder(view.root) {
        var binding: ItemMonthResumeBinding = view
    }
}