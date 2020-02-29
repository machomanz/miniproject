package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.CustomerBean;

public class CustomerDAO{
	private static CustomerDAO instance;
	private Connection conn;
	private PreparedStatement stmt;
	
	private CustomerDAO() {
		ConnectionDAO dao = ConnectionDAO.getInstance();
		this.conn = dao.getConn();
	}
	
	public static CustomerDAO getInstance() {
		return (instance == null) ? instance = new CustomerDAO() : instance ;
	}
	
	public List<CustomerBean> customerList(){
		String selectSQL = "select cust_id, cust_pw, cust_tel, user_addr, cust_name from customer";
		ResultSet rest = null;
		List<CustomerBean> customerList = null;
		CustomerBean customerBean = null;
		
		try {
			stmt = conn.prepareStatement(selectSQL);
			rest = stmt.executeQuery();
			customerList = new ArrayList<CustomerBean>();
			
			while(rest.next()) {
				customerBean = new CustomerBean();
				customerBean.setCust_id(rest.getString(1));
				customerBean.setCust_pw(rest.getString(2));
				customerBean.setCust_tel(rest.getString(3));
				customerBean.setUser_addr(rest.getString(4));
				customerBean.setCust_name(rest.getString(5));
				
				customerList.add(customerBean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rest != null)
					rest.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // finally end
		
		return customerList;
	}
	
	public CustomerBean customerSearch(String id, String pw) {
		String selectSQL = "select cust_id, cust_pw, cust_tel, user_addr, cust_name from customer where cust_id=? and cust_pw=?";
		ResultSet rest = null;
		CustomerBean customerBean = null;
		
		try {
			stmt = conn.prepareStatement(selectSQL);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rest = stmt.executeQuery();
			
			if(rest.next()) {
				customerBean = new CustomerBean();
				customerBean.setCust_id(rest.getString(1));
				customerBean.setCust_pw(rest.getString(2));
				customerBean.setCust_tel(rest.getString(3));
				customerBean.setUser_addr(rest.getString(4));
				customerBean.setCust_name(rest.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customerBean;
		
	}
}