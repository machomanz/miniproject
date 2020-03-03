package cust_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn_DAO.ConnectionDAO;
import cust_DTO.CustomerBean;
import seller_DTO.SellerBean;

public class LoginCustomerDAO {
	private PreparedStatement stmt;
	private Connection conn = ConnectionDAO.getInstance().getConn();	
	private static AddCustomerDAO instance;
	ResultSet rest;
	
	public LoginCustomerDAO() {
		
	}
		
	public static AddCustomerDAO getInstance() {
		return (instance == null) ? instance = new AddCustomerDAO() : instance;
	}	
	
	public CustomerBean nameSearch(String id, String pw){
		String sql = "select cust_id, cust_pw, cust_name, user_addr, cust_tel from customer where cust_id=? and cust_pw=?";
		CustomerBean bean = null;
		ResultSet rest=null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);			
			rest = stmt.executeQuery();		
			
			if(rest.next()) {
				bean = new CustomerBean();
				bean.setCust_id(rest.getString(1));
				bean.setCust_pw(rest.getString(2));
				bean.setCust_name(rest.getString(3));
				bean.setCust_addr(rest.getString(4));
				bean.setCust_tel(rest.getString(5));
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
	
	public SellerBean sellerSearch(String id, String pw) {
		String sql = "select sell_id, sell_pw from seller where sell_id=? and sell_pw=?";
		SellerBean sellerBean = null;
		ResultSet rest = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rest = stmt.executeQuery();
			
			if(rest.next()) {
				sellerBean = new SellerBean();
				sellerBean.setSell_id(rest.getString(1));
				sellerBean.setSell_pw(rest.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sellerBean;
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















