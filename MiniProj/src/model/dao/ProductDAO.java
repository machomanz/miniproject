package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.ProductBean;

public class ProductDAO {
	private static ProductDAO instance;
	private Connection conn;
	private PreparedStatement stmt;
	
	private ProductDAO() {
		ConnectionDAO dao = ConnectionDAO.getInstance();
		this.conn = dao.getConn();
	}
	
	public static ProductDAO getInstance() {
		return (instance == null) ? instance = new ProductDAO() : instance;
	}
	
	public List<ProductBean> productList(){
		List<ProductBean> productList = null;
		ResultSet rest = null;
		String selectSQL = "select product_code, product_name, product_price, category, sell_id, product_img from product";
		try {
			stmt = conn.prepareStatement(selectSQL);
			rest = stmt.executeQuery();
			
			ProductBean productBean = null;
			productList = new ArrayList<ProductBean>();
			
			while(rest.next()) {
				productBean = new ProductBean();
				productBean.setProduct_code(rest.getString(1));
				productBean.setProduct_name(rest.getString(2));
				productBean.setProduct_price(rest.getInt(3));
				productBean.setCategory(rest.getString(4));
				productBean.setSell_id(rest.getString(5));
				productBean.setProduct_img(rest.getString(6));
				
				productList.add(productBean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rest != null) {
					rest.close();					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return productList;
	}
	
	public void productInsert(int product_price, String... product) {
		String insertSQL = "insert into product values(?,?,?,?,?,?)";		
		try {
			stmt = conn.prepareStatement(insertSQL);
			stmt.setString(1, product[0]); // 제품코드
			stmt.setString(2, product[1]); // 제품이름
			stmt.setInt(3, product_price); // 제품가격
			stmt.setString(4, product[2]); // 카테고리
			stmt.setString(5, product[3]); // 판매자 아이디
			stmt.setString(6, product[4]);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
