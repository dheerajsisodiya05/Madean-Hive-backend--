package com.madeanhive.service;

import com.madeanhive.model.Order;
import com.madeanhive.model.Seller;
import com.madeanhive.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction createTransaction(Order order);
    List<Transaction> getTransactionBySeller(Seller seller);
    List<Transaction>getAllTransactions();
}
