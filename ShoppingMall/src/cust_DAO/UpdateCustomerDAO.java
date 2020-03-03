package cust_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn_DAO.ConnectionDAO;
import cust_DTO.CustomerBean;

public class UpdateCustomerDAO {
	private PreparedStatement stmt;
	private Connection conn = ConnectionDAO.getInstance().getConn();	
	private static UpdateCustomerDAO instance;
	ResultSet rest;
	
	public UpdateCustomerDAO() {
		
	}
		
	public static UpdateCustomerDAO getInstance() {
		return (instance == null) ? instance = new UpdateCustomerDAO() : instance;
	}	
	
	public CustomerBean customerSearch(String cust_id) {
		String sql =  "select cust_id, cust_name, cust_addr, cust_tel from customer where cust_id=?";
		
		CustomerBean bean=null;
		ResultSet rest=null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cust_id);
			
			rest = stmt.executeQuery();
			bean = new CustomerBean();
			if(rest.next()) {
				//select  id, pw, nickName, cartCount, addr				
				bean.setCust_id(rest.getString(1));
				bean.setCust_name(rest.getString(2));
				bean.setCust_addr(rest.getString(3));				
				bean.setCust_tel(rest.getString(4));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(rest!=null)rest.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return bean;
	}
	
	public int customerUpdate(CustomerBean bean) {
		int returnValue=0;
		String sql = "update customer set cust_name=?, cust_addr=?, cust_tel=? where id=?";
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(4, bean.getCust_id());
			stmt.setString(1, bean.getCust_name());
			stmt.setString(2, bean.getCust_addr());
			stmt.setString(3, bean.getCust_tel());			
			returnValue=stmt.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return returnValue;
		
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
