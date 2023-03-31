package delhi_capitals_bank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import delhi_capitals_bank.colors.ConsoleColors;
import delhi_capitals_bank.exceptions.NoRecordFoundException;
import delhi_capitals_bank.exceptions.SomethingWentWrongException;

public class TransactionDAOImpl implements TransactionDAO {
	public static Long balance;
	
	@Override
     public Long balanceEnquiry(int pinNumber) throws SomethingWentWrongException,NoRecordFoundException{
        
    	 Connection conn=null;
    	 
    	 try {
    		 conn=DButils.getConnectiontodb();
    		 
    		 String query="Select balance from login where pinNumber=?";
    		 
    		 PreparedStatement ps=conn.prepareStatement(query);
    		 
    		 ps.setInt(1, pinNumber);
    		 
    		 ResultSet rs=ps.executeQuery();
    		 
    		 if(DButils.isResultSetEmpty(rs)) {
    			 throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Invalid pin Number");
    		 }
    		 
    		 while(rs.next()) {
    			 balance=rs.getLong(1);
    		 }
    		 
    	 }catch(Exception e) {
    		 throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical error..Not able to display balance of the account");
    	 }finally {
    		 try {
				DButils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	 } 
     return balance;
     
      }
	
	
	 @Override
	 public void depositMoney(Long bal,int pinNumber) throws SomethingWentWrongException {
		 
         Connection conn=null;
    	 
    	 try {
    		 conn=DButils.getConnectiontodb();
    		 
    		 String query="UPDATE login SET balance=(balance + ?) WHERE pinNumber=? ";
    		 
    		 PreparedStatement ps=conn.prepareStatement(query);
    		 
    		 ps.setLong(1, bal);
    		 ps.setInt(2, pinNumber);
    		 
    		 ps.executeUpdate();
    		 
    		 String query1="INSERT INTO transaction (customer_id, Tdate,Ttime,transaction_type, amount,pinNumber) VALUES (?, ?, ?, ?, ?, ?)";
    		 
    		 PreparedStatement ps1=conn.prepareStatement(query1);
    		 
    		 ps1.setInt(1, UserLogged.UserLoggedInId);
    		 ps1.setDate(2, Date.valueOf(LocalDate.now()));
    		 ps1.setTime(3, Time.valueOf(LocalTime.now()));
    		 ps1.setString(4, "Deposit");
    		 ps1.setLong(5, bal);
    		 ps1.setInt(6,pinNumber);
    		 
    		 ps1.executeUpdate();
    		 
    	 }catch(Exception e) {
    		 throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Invalid pin number.. Please check your pin & try again!!");
    	 }finally {
    		 try {
				DButils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		 
    	 } 
	 }
	
	 @Override
     public void withdrawMoney(Long bal,int pinNumber) throws SomethingWentWrongException {
		 
         Connection conn=null;
    	 
    	 try {
    		 conn=DButils.getConnectiontodb();
    		 
    		 String query="UPDATE login SET balance=(balance - ?) WHERE pinNumber=? ";
    		 
    		 PreparedStatement ps=conn.prepareStatement(query);
    		 
    		 ps.setLong(1, bal);
    		 ps.setInt(2, pinNumber);
    		 
    		 ps.executeUpdate();
    		 
             String query1="INSERT INTO transaction (customer_id, Tdate,Ttime,transaction_type, amount,pinNumber) VALUES (?, ?, ?, ?, ?, ?)";
    		 
    		 PreparedStatement ps1=conn.prepareStatement(query1);
    		 
    		 ps1.setInt(1, UserLogged.UserLoggedInId);
    		 ps1.setDate(2, Date.valueOf(LocalDate.now()));
    		 ps1.setTime(3, Time.valueOf(LocalTime.now()));
    		 ps1.setString(4, "Withdraw");
    		 ps1.setLong(5, bal);
    		 ps1.setInt(6,pinNumber);
    		 
    		 ps1.executeUpdate();
    		 
    	 }catch(Exception e) {
    		 throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Invalid pin number.. Please check your pin & try again!!");
    	 }finally {
    		 try {
				DButils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		 
    	 } 
     }
     
     @Override
	 public void changePin(int oldpin,int newpin,int renewpin) throws SomethingWentWrongException,NoRecordFoundException {
		
		 Connection conn=null;
		 
		 try {
			 conn=DButils.getConnectiontodb();
			 
			 String query1="Select * from CustomerSignUp WHERE pinNumber = ?";
			 
			 PreparedStatement ps=conn.prepareStatement(query1);
			 
			 ps.setInt(1, oldpin);
			 
			 ResultSet rs=ps.executeQuery();
			 
			 if(DButils.isResultSetEmpty(rs)) {
				 throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Invalid pin number.. Please check your pin and try again!!");
			 }else {
				 if(rs.next()) {
					 if(newpin==renewpin) {
						 String query2="UPDATE CustomerSignUp SET pinNumber = ? WHERE pinNumber = ?";
						 PreparedStatement ps2=conn.prepareStatement(query2);
						 ps2.setInt(1, newpin);
						 ps2.setInt(2, oldpin);
						 
						 ps2.executeUpdate();
						 
						 String query3="UPDATE login SET pinNumber = ? WHERE pinNumber = ?";
						 PreparedStatement ps3=conn.prepareStatement(query3);
						 ps3.setInt(1, newpin);
						 ps3.setInt(2, oldpin);
						 
						 ps3.executeUpdate();
						 
					 }else {
						 throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Wrong pin entered");
					 }
				 }
			 }
			 
		 }catch(Exception e) {
			 throw new SomethingWentWrongException("Due to technical error not able to change pin");
		 }finally {
			 try {
				DButils.closeConnection(conn);
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		 }
		 
	 }
	
     
	 @Override
	 public void checkHistory(int pinNumber) throws SomethingWentWrongException,NoRecordFoundException {
          Connection conn=null;
		 
		 try {
			 conn=DButils.getConnectiontodb();
			 
			 String query="SELECT * FROM  transaction WHERE pinNumber=?";
			 
			 PreparedStatement ps=conn.prepareStatement(query);
			 
			 ps.setInt(1, pinNumber);
			 
			 ResultSet rs=ps.executeQuery();
			 
			 if(DButils.isResultSetEmpty(rs)) {
				 throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Invalid pin number.. Please check your pin");
			 }
			 
			 while(rs.next()) {
				 System.out.println("customer_id : "+rs.getInt(1)+" Date : "+rs.getDate(2)+" Time : "+rs.getTime(3)
				 +" Transaction-Type : "+rs.getString(4)+" Amount : "+rs.getLong(5));
			 }
			 
		 }catch(Exception e) {
			 throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical error.. Not able to display transaction history");
		 }finally {
			 try {
				DButils.closeConnection(conn);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		 }
	 }
	 
	 
	 public void transferMoney(Long accountNumber,Long daccountNumber,Long amount,int pinNumber) throws SomethingWentWrongException,NoRecordFoundException {
		  Connection conn=null;
			 
			 try {
				 conn=DButils.getConnectiontodb();
				 
				 conn.setAutoCommit(false);
				 
				 Long sourceBalance=null;
				 
				 String query="SELECT balance FROM login WHERE accountNumber = ?";
				 
				 PreparedStatement ps=conn.prepareStatement(query);
				 
				   ps.setLong(1, accountNumber);
			      ResultSet rs = ps.executeQuery();
			      
			      if (rs.next()) {
			          sourceBalance = rs.getLong(1);
			        } else {
			         throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Source account Not found");
			        }
			      
			      if (sourceBalance < amount) {
			          System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Insufficient balance in the source account!");
			          return;
			        }
				 
			      String updateSql1 = "UPDATE login SET balance = balance - ? WHERE accountNumber = ?";
			      PreparedStatement pstmt1 = conn.prepareStatement(updateSql1);
			      pstmt1.setLong(1, amount);
			      pstmt1.setLong(2, accountNumber);
			       pstmt1.executeUpdate();
			     
			      
			      String updateSql2 = "UPDATE login SET balance = balance + ? WHERE accountNumber = ?";
			      PreparedStatement pstmt2 = conn.prepareStatement(updateSql2);
			      pstmt2.setLong(1, amount);
			      pstmt2.setLong(2, daccountNumber);
			       pstmt2.executeUpdate();
			     
			      
			      
			      String query1="INSERT INTO transaction (customer_id, Tdate,Ttime,transaction_type, amount,pinNumber) VALUES (?, ?, ?, ?, ?, ?)";
		    		 
		    		 PreparedStatement ps1=conn.prepareStatement(query1);
		    		 
		    		 ps1.setInt(1, UserLogged.UserLoggedInId);
		    		 ps1.setDate(2, Date.valueOf(LocalDate.now()));
		    		 ps1.setTime(3, Time.valueOf(LocalTime.now()));
		    		 ps1.setString(4, "Transfer");
		    		 ps1.setLong(5, amount);
		    		 ps1.setInt(6,pinNumber);
		    		 
		    		 ps1.executeUpdate();
			      
			        conn.commit();
			     
			 }catch(Exception e) {
				 throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical error not able to transfer money");
			 }finally {
				 try {
					DButils.closeConnection(conn);
				} catch (SQLException e) {
					
					e.printStackTrace();
					 try {
					        conn.rollback();
					      } catch (SQLException ex) {
					        ex.printStackTrace();
					      }
				}
			 }
			 
	 }
	 
	 
}



