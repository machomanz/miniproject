package cust_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn_DAO.ConnectionDAO;
import cust_DTO.CustomerBean;


public class SearchCustomerDAO {
	private PreparedStatement stmt;
	private Connection conn = ConnectionDAO.getInstance().getConn();	
	private static SearchCustomerDAO instance;
	ResultSet rest;
	public SearchCustomerDAO() {
		
	}	
	
	public List<CustomerBean> customerList(){
		String sqlSelect ="select cust_id, cust_name, cust_addr, cust_tel from customer";
		List<CustomerBean> list=null;
		ResultSet rest=null;
		try {
			stmt = conn.prepareStatement(sqlSelect);
			rest = stmt.executeQuery();
			list = new ArrayList<CustomerBean>();
			while(rest.next()) {				
				CustomerBean bean = new CustomerBean();
				bean.setCust_id(rest.getString(1));				
				bean.setCust_name(rest.getString(2));
				bean.setCust_addr(rest.getString(3));
				bean.setCust_tel(rest.getString(4));
				list.add(bean);
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
		return list;
	}
	
	
	public static SearchCustomerDAO getInstance() {
		return (instance == null) ? instance = new SearchCustomerDAO() : instance;
	}	
	

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















