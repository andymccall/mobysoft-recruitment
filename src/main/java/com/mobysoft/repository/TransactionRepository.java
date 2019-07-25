package com.mobysoft.repository;

import com.mobysoft.model.TransactionImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionImpl, String> {

}
