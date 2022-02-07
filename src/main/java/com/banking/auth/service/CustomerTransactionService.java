package com.banking.auth.service;

import com.banking.auth.entities.CustomerTransactions;

public interface CustomerTransactionService {

	CustomerTransactions saveTransactionLog(CustomerTransactions sendersTransactionLog);

}
