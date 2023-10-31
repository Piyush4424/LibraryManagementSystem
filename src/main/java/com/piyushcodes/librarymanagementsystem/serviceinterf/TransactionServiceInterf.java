package com.piyushcodes.librarymanagementsystem.serviceinterf;

import com.piyushcodes.librarymanagementsystem.enums.State;

public interface TransactionServiceInterf {
   String makeTransaction(int bookId, int studentId, State state);
}
