package delhi_capitals_bank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import delhi_capitals_bank.colors.ConsoleColors;
import delhi_capitals_bank.dto.BankAccountDTO;
import delhi_capitals_bank.exceptions.NoRecordFoundException;
import delhi_capitals_bank.exceptions.SomethingWentWrongException;

public class BankAccountDAOImpl implements BankAccountDAO {
	     public static Long accountNumber;
	     public static int pinNumber;
	   @Override
       public void openBankAccount(BankAccountDTO bdto) throws SomethingWentWrongException {
    	   Connection conn=null;
    	   
    	   try {
			conn=DButils.getConnectiontodb();
			
			Random ran=new Random();
			accountNumber=Math.abs((ran.nextLong()%90000000L)+5040936800000000L);
			pinNumber=Math.abs((ran.nextInt()%9000)+1000);
			
			String query="INSERT INTO CustomerSignUp (customer_id,name,fname,dob,gender,email,martial,address,income,type,services,accountNumber,pinNumber)"
					+ "Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setInt(1, UserLogged.UserLoggedInId);
			ps.setString(2,bdto.getName());
			ps.setString(3, bdto.getFname());
			ps.setDate(4, Date.valueOf(bdto.getDob()));
			ps.setString(5, bdto.getGender());
			ps.setString(6, bdto.getEmail());
			ps.setString(7, bdto.getMartial());
			ps.setString(8, bdto.getAddress());
			ps.setInt(9,bdto.getIncome());
			ps.setString(10, bdto.getType());
			ps.setString(11, bdto.getService());
			ps.setLong(12, accountNumber);
			ps.setInt(13,pinNumber);
			
			ps.executeUpdate();
			
			String query1="INSERT INTO login (accountNumber,pinNumber) VALUES(?,?)";
			
			PreparedStatement ps1=conn.prepareStatement(query1);
			
			ps1.setLong(1,accountNumber);
			ps1.setInt(2,pinNumber);
		    
			ps1.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical error account can not be opened");
		}finally {
			try {
				DButils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	   
       }
	   
	   
	   @Override
	   public boolean alreadyBankAccount(Long accountNumber,int pinNumber) throws SomethingWentWrongException,NoRecordFoundException {
		   Connection conn=null;
			try {
				conn=DButils.getConnectiontodb();
				
				String query="SELECT customer_id FROM CustomerSignUp WHERE accountNumber =? AND pinNumber=?";
				
				PreparedStatement ps=conn.prepareStatement(query);
				
				ps.setLong(1, accountNumber);
				ps.setInt(2, pinNumber);
				
				ResultSet rs=ps.executeQuery();
				
				if(DButils.isResultSetEmpty(rs)) {
					throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Invalid account number and pin number.. Please check it or signup first!!");
				}
				
				while(rs.next()) {
					UserLogged.UserLoggedInId=rs.getInt(1);
					return true;
				}
				
			}catch(Exception e) {
				throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical error not able to login right now!!");
			}finally {
				try {
					DButils.closeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		   
		   return false;
		   
	   }
	   
	   
}
