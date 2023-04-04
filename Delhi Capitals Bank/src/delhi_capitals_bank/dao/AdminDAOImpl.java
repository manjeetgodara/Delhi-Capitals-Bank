package delhi_capitals_bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import delhi_capitals_bank.colors.ConsoleColors;
import delhi_capitals_bank.exceptions.NoRecordFoundException;
import delhi_capitals_bank.exceptions.SomethingWentWrongException;

public class AdminDAOImpl implements AdminDAO {
     
	@Override
	public void viewAllCustomer() throws SomethingWentWrongException ,NoRecordFoundException {
		Connection conn=null;
		
		try {
			conn=DButils.getConnectiontodb();
			
			String query="SELECT * FROM CustomerLogin WHERE is_delete=0";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			if(DButils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Nothing is available in database");
			}
			
			while(rs.next()) {
				System.out.println(ConsoleColors.BANANA_YELLOW+"customer_id : "+rs.getInt(1)+" Customer name : "+rs.getString(2)
				+" Customer mobile : "+rs.getString(3)+" Customer address : "+rs.getString(4)
				+" username : "+rs.getString(5));
			}
		
			
		}catch(Exception e) {
			throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical issue..Not able to display customers");
		}finally {
			try {
				DButils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void viewCustomerByID(int customer_id) throws SomethingWentWrongException , NoRecordFoundException{
       Connection conn=null;
		
		try {
			conn=DButils.getConnectiontodb();
			
			String query="SELECT * FROM CustomerLogin WHERE customer_id=? AND is_delete=0";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setInt(1, customer_id);
			
			ResultSet rs=ps.executeQuery();
			
			if(DButils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"No record is available in database with this customer_id");
			}
			
			while(rs.next()) {
				System.out.println(ConsoleColors.BANANA_YELLOW+"customer_id : "+rs.getInt(1)+" Customer name : "+rs.getString(2)
				+" Customer mobile : "+rs.getString(3)+" Customer address : "+rs.getString(4)
				+" username : "+rs.getString(5));
			}
		
			
		}catch(Exception e) {
			throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical issue..Not able to display customers");
		}finally {
			try {
				DButils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void viewAllAccounts() throws SomethingWentWrongException, NoRecordFoundException {
       Connection conn=null;
		
		try {
			conn=DButils.getConnectiontodb();
			
			String query="SELECT * FROM CustomerSignUp WHERE is_delete=0";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			if(DButils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Nothing is available in database");
			}
			
			while(rs.next()) {
				System.out.println(ConsoleColors.BANANA_YELLOW+"customer_id : "+rs.getInt(1)+" Customer name : "+rs.getString(2)
				+" Customer father name : "+rs.getString(3)+" Customer date_of_birth : "+rs.getDate(4)
				+" gender : "+rs.getString(5)+ " email : "+rs.getString(6)+" address : "+rs.getString(8)
				+" account number "+rs.getLong(13) + " type : "+rs.getString(10)+" address : "+rs.getString(8));
			}
		
			
		}catch(Exception e) {
			throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical issue..Not able to display customers");
		}finally {
			try {
				DButils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void viewAccountByaccountNumber(Long accountNumber)
			throws SomethingWentWrongException, NoRecordFoundException {
		   Connection conn=null;
			
			try {
				conn=DButils.getConnectiontodb();
				
				String query="SELECT * FROM CustomerSignUp WHERE accountNumber=? AND is_delete=0";
				
				PreparedStatement ps=conn.prepareStatement(query);
				ps.setLong(1,accountNumber);
				
				ResultSet rs=ps.executeQuery();
				
				if(DButils.isResultSetEmpty(rs)) {
					throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Nothing is available in database");
				}
				
				while(rs.next()) {
					System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT+"customer_id : "+rs.getInt(1)+" Customer name : "+rs.getString(2)
					+" Customer father name : "+rs.getString(3)+" Customer date_of_birth : "+rs.getDate(4)
					+" gender : "+rs.getString(5)+ " email : "+rs.getString(6)+" address : "+rs.getString(8)
					+" account number "+rs.getLong(13) + " type : "+rs.getString(10)+" address : "+rs.getString(8));
				}
			
				
			}catch(Exception e) {
				throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical issue..Not able to display customers");
			}finally {
				try {
					DButils.closeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
	  }

	@Override
	public void changeStatus(Long accountNumber) throws SomethingWentWrongException {
		 Connection conn=null;
			
			try {
				conn=DButils.getConnectiontodb();
				
				String query="UPDATE CustomerSignUp SET status= 'inoperative' WHERE accountNumber=?";
				
				PreparedStatement ps=conn.prepareStatement(query);
				
				ps.setLong(1, accountNumber);
				
				int res=ps.executeUpdate();
				if(res!=0) {
					System.out.println(ConsoleColors.BANANA_YELLOW+"Status Changed Successfully!!");
				}else {
					System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Wrong account number");
				}
				
			}catch(Exception e) {
				throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to invalid data ..Not able to change customer account status");
			}finally {
				try {
					DButils.closeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}

	@Override
	public void viewAllInOperative() throws SomethingWentWrongException, NoRecordFoundException {
		    Connection conn=null;
			
			try {
				conn=DButils.getConnectiontodb();
				
				String query="SELECT * FROM CustomerSignUp WHERE status='inoperative' AND is_delete=0";
				
				PreparedStatement ps=conn.prepareStatement(query);
				
				ResultSet rs=ps.executeQuery();
				
				if(DButils.isResultSetEmpty(rs)) {
					throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Nothing is available in database");
				}
				
				while(rs.next()) {
					System.out.println(ConsoleColors.FOREST_GREEN+"customer_id : "+rs.getInt(1)+" Customer name : "+rs.getString(2)
					+" Customer father name : "+rs.getString(3)+" Customer date_of_birth : "+rs.getDate(4)
					+" gender : "+rs.getString(5)+ " email : "+rs.getString(6)+" address : "+rs.getString(8)
					+" account number "+rs.getLong(13) + " type : "+rs.getString(10)+" address : "+rs.getString(8));
				}
			
				
			}catch(Exception e) {
				throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical issue..Not able to display inoperative customers account");
			}finally {
				try {
					DButils.closeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}

	@Override
	public void viewAllclosedAccounts() throws SomethingWentWrongException, NoRecordFoundException {
		 Connection conn=null;
			
			try {
				conn=DButils.getConnectiontodb();
				
				String query="SELECT * FROM CustomerSignUp WHERE is_delete=1";
				
				PreparedStatement ps=conn.prepareStatement(query);
				
				ResultSet rs=ps.executeQuery();
				
				if(DButils.isResultSetEmpty(rs)) {
					throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Nothing is available in database");
				}
				
				while(rs.next()) {
					System.out.println(ConsoleColors.GREEN+"customer_id : "+rs.getInt(1)+" Customer name : "+rs.getString(2)
					+" Customer father name : "+rs.getString(3)+" Customer date_of_birth : "+rs.getDate(4)
					+" gender : "+rs.getString(5)+ " email : "+rs.getString(6)+" address : "+rs.getString(8)
					+" account number "+rs.getLong(13) + " type : "+rs.getString(10)+" address : "+rs.getString(8));
				}
			
				
			}catch(Exception e) {
				throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical issue..Not able to display customers");
			}finally {
				try {
					DButils.closeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

	@Override
	public void viewAllOperative() throws SomethingWentWrongException, NoRecordFoundException {
		  Connection conn=null;
			
			try {
				conn=DButils.getConnectiontodb();
				
				String query="SELECT * FROM CustomerSignUp WHERE status='active' AND is_delete=0";
				
				PreparedStatement ps=conn.prepareStatement(query);
				
				ResultSet rs=ps.executeQuery();
				
				if(DButils.isResultSetEmpty(rs)) {
					throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Nothing is available in database");
				}
				
				while(rs.next()) {
					System.out.println(ConsoleColors.BANANA_YELLOW+"customer_id : "+rs.getInt(1)+" Customer name : "+rs.getString(2)
					+" Customer father name : "+rs.getString(3)+" Customer date_of_birth : "+rs.getDate(4)
					+" gender : "+rs.getString(5)+ " email : "+rs.getString(6)+" address : "+rs.getString(8)
					+" account number "+rs.getLong(13) + " type : "+rs.getString(10)+" address : "+rs.getString(8));
				}
			
				
			}catch(Exception e) {
				throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical issue..Not able to display inoperative customers account");
			}finally {
				try {
					DButils.closeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

	@Override
	public void transactionReport() throws SomethingWentWrongException, NoRecordFoundException {
		  Connection conn=null;
			
			try {
				conn=DButils.getConnectiontodb();
				
				String query="Select * from transaction";
				
                PreparedStatement ps=conn.prepareStatement(query);
				
				ResultSet rs=ps.executeQuery();
				
				if(DButils.isResultSetEmpty(rs)) {
					throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Nothing is available in database");
				}
				
				while(rs.next()) {
					System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Customer ID : "+rs.getInt(1)+" Date : "+rs.getDate(2)
					+" Time : "+rs.getTime(3)+" Transaction_type : "+rs.getString(4)+" Amount : "+rs.getLong(5));
				}
				
			}catch(Exception e) {
				throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical issue..Not able to display transaction report");

			}finally {
				try {
					DButils.closeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

	@Override
	public void highMagnitudeTrans() throws SomethingWentWrongException, NoRecordFoundException {
		  Connection conn=null;
			
			try {
				conn=DButils.getConnectiontodb();
				
				String query="Select * from transaction WHERE amount>49999";
				
              PreparedStatement ps=conn.prepareStatement(query);
				
				ResultSet rs=ps.executeQuery();
				
				if(DButils.isResultSetEmpty(rs)) {
					throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Nothing is available in database");
				}
				
				while(rs.next()) {
					System.out.println(ConsoleColors.BANANA_YELLOW+"Customer ID : "+rs.getInt(1)+" Date : "+rs.getDate(2)
					+" Time : "+rs.getTime(3)+" Transaction_type : "+rs.getString(4)+" Amount : "+rs.getLong(5));
				}
				
			}catch(Exception e) {
				throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical issue..Not able to display high magnitude transaction report");

			}finally {
				try {
					DButils.closeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

	@Override
	public void changeNonActive(Long accountNumber) throws SomethingWentWrongException {
		 Connection conn=null;
			
			try {
				conn=DButils.getConnectiontodb();
				
				String query="UPDATE CustomerSignUp SET status= 'active' WHERE accountNumber=?";
				
				PreparedStatement ps=conn.prepareStatement(query);
				
				ps.setLong(1, accountNumber);
				
				int res=ps.executeUpdate();
				if(res!=0) {
					System.out.println(ConsoleColors.BANANA_YELLOW+"Status changed Successfully!!");
				}else {
					System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Wrong account number");
				}
				
			}catch(Exception e) {
				throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Due to some technical issue..Not able to change customer account status");
			}finally {
				try {
					DButils.closeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}
	
	
	
	
	
	
}
