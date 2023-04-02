package delhi_capitals_bank.dao;

import java.util.Scanner;

import delhi_capitals_bank.exceptions.NoRecordFoundException;
import delhi_capitals_bank.exceptions.SomethingWentWrongException;

public interface AdminDAO {
	public void viewAllCustomer() throws SomethingWentWrongException ,NoRecordFoundException;
	public void viewCustomerByID(int customer_id) throws SomethingWentWrongException , NoRecordFoundException;
	public void viewAllAccounts() throws SomethingWentWrongException ,NoRecordFoundException;
	public void viewAccountByaccountNumber(Long accountNumber) throws SomethingWentWrongException,NoRecordFoundException;
	public void changeStatus(Long accountNumber) throws SomethingWentWrongException;
	public void viewAllInOperative() throws SomethingWentWrongException ,NoRecordFoundException;
	public void viewAllclosedAccounts() throws SomethingWentWrongException ,NoRecordFoundException;
	public void viewAllOperative() throws SomethingWentWrongException ,NoRecordFoundException;
    public void transactionReport() throws SomethingWentWrongException ,NoRecordFoundException;
    public void highMagnitudeTrans() throws SomethingWentWrongException,NoRecordFoundException;
}
