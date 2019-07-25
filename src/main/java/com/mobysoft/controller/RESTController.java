package com.mobysoft.controller;

import com.mobysoft.Application;
import com.mobysoft.model.TransactionImpl;
import com.mobysoft.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class RESTController {

    private static final Logger logger =
            LoggerFactory.getLogger(RESTController.class);

    private TransactionService transactionService;

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @ApiOperation(value = "Read a list of all transactions", notes = "Will returns a list of all transactions")
    @RequestMapping(value = "/transactions", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<TransactionImpl> getAllTransactions() {

        ResponseEntity response;

        List<TransactionImpl> transactionList = transactionService.findAllTransactions();

        if (transactionList != null) {
            logger.debug("Transactions found, returning OK");
            response = new ResponseEntity<>(transactionList, HttpStatus.OK);
        } else {
            logger.debug("Transactions not found, returning NOT_FOUND");
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;

    }

    @ApiOperation(value = "Read a list of all weekly transactions", notes = "Will returns a list of all weekly transactions")
    @RequestMapping(value = "/transactions/weekly", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<TransactionImpl> getWeeklyTransactions() {

        ResponseEntity response;

        List<TransactionImpl> transactionList = transactionService.findWeeklyTransactions();

        if (transactionList != null) {
            logger.debug("Transactions found, returning OK");
            response = new ResponseEntity<>(transactionList, HttpStatus.OK);
        } else {
            logger.debug("Transactions not found, returning NOT_FOUND");
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;

    }

    @ApiOperation(value = "Read a list of all fortnightly transactions", notes = "Will returns a list of all fortnightly transactions")
    @RequestMapping(value = "/transactions/fortnightly", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<TransactionImpl> getFortnightlyTransactions() {

        ResponseEntity response;

        List<TransactionImpl> transactionList = transactionService.findFortnightlyTransactions();

        if (transactionList != null) {
            logger.debug("Transactions found, returning OK");
            response = new ResponseEntity<>(transactionList, HttpStatus.OK);
        } else {
            logger.debug("Transactions not found, returning NOT_FOUND");
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;

    }

    @ApiOperation(value = "Read a list of all four weekly transactions", notes = "Will returns a list of all four weekly transactions")
    @RequestMapping(value = "/transactions/fourweekly", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<TransactionImpl> getFourWeeklyTransactions() {

        ResponseEntity response;

        List<TransactionImpl> transactionList = transactionService.findFourWeeklyTransactions();

        if (transactionList != null) {
            logger.debug("Transactions found, returning OK");
            response = new ResponseEntity<>(transactionList, HttpStatus.OK);
        } else {
            logger.debug("Transactions not found, returning NOT_FOUND");
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;

    }

    @ApiOperation(value = "Read a list of all monthly transactions", notes = "Will returns a list of all monthly transactions")
    @RequestMapping(value = "/transactions/monthly", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<TransactionImpl> getMonthlyTransactions() {

        ResponseEntity response;

        List<TransactionImpl> transactionList = transactionService.findMonthlyTransactions();

        if (transactionList != null) {
            logger.debug("Transactions found, returning OK");
            response = new ResponseEntity<>(transactionList, HttpStatus.OK);
        } else {
            logger.debug("Transactions not found, returning NOT_FOUND");
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;

    }

}
