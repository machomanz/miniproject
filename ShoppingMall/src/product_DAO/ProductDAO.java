package product_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn_DAO.ConnectionDAO;
import product_DTO.ProductBean;

public class ProductDAO {
	private static ProductDAO instance;
	private Connection conn;
	private PreparedStatement stmt;

	private ProductDAO() {
		this.conn = ConnectionDAO.getInstance().getConn();
	}

	public static ProductDAO getInstance() {
		return (instance == null) ? instance = new ProductDAO() : instance;

	}
	
	public List<ProductBean> productList(){
		String sql = "select product_code, product_name, product_price, category, sell_id, product_img from product";
		List<ProductBean> productList = null;
		ProductBean productBean = null;
		ResultSet rest = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			rest = stmt.executeQuery();
			
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
		}
		
		return productList;
	}
	
	public void productInsert(int product_price, String... product) {
		String sql = "insert into product values(?,?,?,?,?,?)";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, product[0]);
			stmt.setString(2, product[1]);
			stmt.setInt(3, product_price);
			stmt.setString(4, product[3]);
			stmt.setString(5, product[4]);
			stmt.setString(6, product[5]);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(stmt != null) stmt.close();
			if(conn == null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // close() end
	
	// 인스턴스가 가비지 컬렉터에 수집 대상이 되면 처리해라!
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		close();
		super.finalize();
	}
}
