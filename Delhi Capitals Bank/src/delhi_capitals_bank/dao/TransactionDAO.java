package delhi_capitals_bank.dao;

import delhi_capitals_bank.exceptions.NoRecordFoundException;
import delhi_capitals_bank.exceptions.SomethingWentWrongException;

public interface TransactionDAO {
	 public Long balanceEnquiry(int pinNumber) throws SomethingWentWrongException,NoRecordFoundException;
	 public void depositMoney(Long bal,int pinNumber) throws SomethingWentWrongException;
	 public void withdrawMoney(Long bal,int pinNumber) throws SomethingWentWrongException;
	 public void changePin(int oldpin,int newpin,int renewpin) throws SomethingWentWrongException,NoRecordFoundException;
	 public void checkHistory(int pinNumber) throws SomethingWentWrongException,NoRecordFoundException;
	 public  void transferMoney(Long accountNumber,Long daccountNumber,Long amount,int pinNumber) throws SomethingWentWrongException,NoRecordFoundException ;
		 
}
