package com.mobysoft.service;

import com.mobysoft.model.TransactionImpl;

import java.util.List;

public interface TransactionService {

    public List<TransactionImpl> findAllTransactions();
    public List<TransactionImpl> findFrequencyByWeekTransactions(int numberOfWeeks);
    public List<TransactionImpl> findWeeklyTransactions();
    public List<TransactionImpl> findFortnightlyTransactions();
    public List<TransactionImpl> findFourWeeklyTransactions();
    public List<TransactionImpl> findMonthlyTransactions();

}
