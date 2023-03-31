package delhi_capitals_bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import delhi_capitals_bank.colors.ConsoleColors;
import delhi_capitals_bank.dto.UserDTO;
import delhi_capitals_bank.exceptions.NoRecordFoundException;
import delhi_capitals_bank.exceptions.SomethingWentWrongException;


 public class UserDAOImpl implements UserDAO {
   
	//sign-Up method of customer
	
	@Override
	public void userSignUp(UserDTO udto) throws SomethingWentWrongException {
		    Connection conn=null;
	
			try {
				conn=DButils.getConnectiontodb();
				
				String query="INSERT INTO CustomerLogin (Cname,Cmobile,Caddress,username,password)"
				+" VALUES (?,?,?,?,?)";
				
				PreparedStatement ps=conn.prepareStatement(query);
				
				//data stuffing
				ps.setString(1, udto.getName());
				ps.setLong(2, udto.getMobile());
				ps.setString(3, udto.getAddress());
				ps.setString(4, udto.getUsername());
				ps.setString(5, udto.getPassword());
				
				ps.executeUpdate();
				
			}catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
				
				throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Sign-up failed due to some tehnical error!");
			}finally {
				try {
					DButils.closeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	  }
	
      
	//sign-in method of Customer
	
	@Override
	public boolean userSignIn(String username, String password)
			throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn=null;
		try {
			conn=DButils.getConnectiontodb();
			String query="SELECT customer_id FROM CustomerLogin WHERE username=? AND password=?";
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setString(1, username);
            ps.setString(2, password);	
            
			ResultSet rs=ps.executeQuery();
			
			if(DButils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException(ConsoleColors.RED_BOLD_BRIGHT+"Invalid username and password!!");
			}
			
			while(rs.next()) {
				UserLogged.UserLoggedInId=rs.getInt(1);
				return true;
			}
			
		}catch(Exception e) {
			throw new SomethingWentWrongException(ConsoleColors.RED_BOLD_BRIGHT+"Not able to login due to some technical error");
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
