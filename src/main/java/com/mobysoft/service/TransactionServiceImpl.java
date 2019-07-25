package com.mobysoft.service;

import com.mobysoft.model.TransactionImpl;
import com.mobysoft.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private static final Logger logger =
            LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Value("${mobysoft.datefuzz}")
    private int fuzzDays;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<TransactionImpl> findAllTransactions() {

        List<TransactionImpl> transactionList = transactionRepository.findAll();

        return transactionList;

    }

    private boolean dateEqualsWithFuzz(LocalDate date, LocalDate futureDate) {

        // Exact match
        if (date.equals(futureDate)) {
            return true;
        }

        // Not an exact match, so check fuzzy match
        if (fuzzDays >= 1) {
            for (int i = 0; i < fuzzDays; i++) {
                if (date.equals(futureDate.plusDays(fuzzDays)) | date.equals(futureDate.minusDays(fuzzDays))) {
                    return true;
                }
            }
        }

        // No match
        return false;
    }

    @Override
    public List<TransactionImpl> findFrequencyByWeekTransactions(int numberOfWeeks) {

        List<TransactionImpl> transactionList = transactionRepository.findAll();
        List<TransactionImpl> frequencyTransactionList = new ArrayList<>();

        // NOTE: Wasn't happy with this solution, however after a fresh look at this I realised
        // I could get rid of the if-statement and the for-loop, replacing them with a while loop.
        // Then I'd count down within the while-loop from date+fuzzyDays to date and make this the
        // condition of the loop - this way if the futureDate is completely outside of the range
        // I wouldn't waste unnecessary loops checking for it. If I found a date match within the
        // while-loop, immediately return true out of the entire sub-routine.
        //
        // However, I've got a meeting this morning and the agency rep. says this has to be in
        // this morning for review, so I've no time to refactor this :-)
        for (TransactionImpl transaction : transactionList) {
            for (TransactionImpl tempTransaction : transactionList) {
                if ((transaction != tempTransaction) && !(frequencyTransactionList.contains(transaction))) {
                    if (transaction.getTags().equals(tempTransaction.getTags())) {
                        if (dateEqualsWithFuzz(transaction.getDate().plusWeeks(numberOfWeeks), tempTransaction.getDate())) {
                            if (!frequencyTransactionList.contains(transaction)) {
                                frequencyTransactionList.add(transaction);
                            }
                            frequencyTransactionList.add(tempTransaction);
                        }
                    }
                }
            }

        }

        return frequencyTransactionList;

    }

    @Override
    public List<TransactionImpl> findWeeklyTransactions() {

        return findFrequencyByWeekTransactions(1);

    }

    @Override
    public List<TransactionImpl> findFortnightlyTransactions() {

        return findFrequencyByWeekTransactions(2);

    }

    @Override
    public List<TransactionImpl> findFourWeeklyTransactions() {

        return findFrequencyByWeekTransactions(4);


    }

    @Override
    public List<TransactionImpl> findMonthlyTransactions() {

        List<TransactionImpl> transactionList = transactionRepository.findAll();
        List<TransactionImpl> monthlyTransactionList = new ArrayList<>();

        for (TransactionImpl transaction : transactionList) {
            for (TransactionImpl tempTransaction : transactionList) {
                if (transaction != tempTransaction) {
                    if (transaction.getTags().equals(tempTransaction.getTags())) {
                        if (transaction.getDate().plusMonths(1).equals(tempTransaction.getDate())) {
                            if (!monthlyTransactionList.contains(transaction)) {
                                monthlyTransactionList.add(transaction);
                            }
                            monthlyTransactionList.add(tempTransaction);
                        }
                    }
                    System.out.println();
                }
            }

        }

        return monthlyTransactionList;

    }

}
