package delhi_capitals_bank.dao;

import delhi_capitals_bank.dto.BankAccountDTO;
import delhi_capitals_bank.exceptions.NoRecordFoundException;
import delhi_capitals_bank.exceptions.SomethingWentWrongException;

public interface BankAccountDAO {
	 public void openBankAccount(BankAccountDTO bdto) throws SomethingWentWrongException;
	 public boolean alreadyBankAccount(Long accountNumber,int pinNumber) throws SomethingWentWrongException,NoRecordFoundException ;
			
}
