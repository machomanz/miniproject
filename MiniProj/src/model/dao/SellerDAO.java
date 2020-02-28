package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.SellerBean;

public class SellerDAO {
	private static SellerDAO instance;
	private Connection conn;
	private PreparedStatement stmt;
	private List<SellerBean> sellerBeans;

	private SellerDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/miniproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "1q2w3e!@#");

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SellerDAO getInstance() {
		return (instance == null) ? instance = new SellerDAO() : instance;
	}
	
	public List<SellerBean> sellerList(){
		String selectSQL = "select sell_id, sell_pw from seller";
		
		ResultSet rest = null;
		List<SellerBean> sellerList = null;
		SellerBean sellerBean = null;
		
		try {
			stmt = conn.prepareStatement(selectSQL);
			rest = stmt.executeQuery();
			
			sellerList = new ArrayList<SellerBean>();
			while(rest.next()) {
				sellerBean = new SellerBean();
				sellerBean.setSell_id(rest.getString(1));
				sellerBean.setSell_pw(rest.getString(2));
				
				sellerList.add(sellerBean);
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
		
		return sellerList;
	}

	public SellerBean sellerSearch(String sell_id, String sell_pw) {
		String selectSQL = "select sell_id, sell_pw from seller where sell_id=? and sell_pw=?";
		
		ResultSet rest = null;
		SellerBean sellerBean = null;

		try {
			stmt = conn.prepareStatement(selectSQL);
			stmt.setString(1, sell_id);
			stmt.setString(2, sell_pw);
			rest = stmt.executeQuery();
			
			if(rest.next()) {
				sellerBean = new SellerBean();
				sellerBean.setSell_id(rest.getString(1));
				sellerBean.setSell_pw(rest.getString(2));
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

		return sellerBean;
	}

}
