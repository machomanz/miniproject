package cust_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn_DAO.ConnectionDAO;
import cust_DTO.CustomerBean;


public class AddCustomerDAO {
	private PreparedStatement stmt;
	private Connection conn = ConnectionDAO.getInstance().getConn();	
	private static AddCustomerDAO instance;
	ResultSet rest;
	public AddCustomerDAO() {
		
	}
	
	
	public static AddCustomerDAO getInstance() {
		return (instance == null) ? instance = new AddCustomerDAO() : instance;
	}	
	
	public int insertCustomer(CustomerBean bean) {
		int count = 0;	
		stmt = null;
		String sql = "insert into customer values(?,?,?,?,?) ";
		
		try {			
			stmt=conn.prepareStatement(sql);			
			stmt.setString(1, bean.getCust_id());
			stmt.setString(2, bean.getCust_pw());
			stmt.setString(3, bean.getCust_name());
			stmt.setString(4, bean.getCust_addr());
			stmt.setString(5, bean.getCust_tel());
			count = stmt.executeUpdate();
			if(count>0) {
				System.out.println("회원가입 성공");			
			}else {
				System.out.println("회원가입 실패");
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}			
		return count;
	}
	
	
	// 4. 사용을 다했으면 종료
	public void close() {
		try {
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
			
	}
	
	@Override
	protected void finalize() throws Throwable {
		close();
		super.finalize();
	}
	
}















