package com.madeanhive.service.impl;

import com.madeanhive.model.Order;
import com.madeanhive.model.Seller;
import com.madeanhive.model.Transaction;
import com.madeanhive.repository.SellerRepository;
import com.madeanhive.repository.TransactionRepository;
import com.madeanhive.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final SellerRepository sellerRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  SellerRepository sellerRepository
    ) {
        this.transactionRepository = transactionRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Transaction createTransaction(Order order) {
        Seller seller = sellerRepository.findById(order.getSellerId()).get();
        Transaction transaction = new Transaction();
        transaction.setCustomer(order.getUser());
        transaction.setOrder(order);
        transaction.setSeller(seller);
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactionBySeller(Seller seller) {
        return transactionRepository.findBySellerId(seller.getId());
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

}
