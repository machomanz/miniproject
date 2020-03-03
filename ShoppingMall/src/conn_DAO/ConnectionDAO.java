package conn_DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	private Connection conn;
	public Connection getConn() {
		return conn;
	}

	private static ConnectionDAO instance;

	private ConnectionDAO() {
		try {
			// 1. 디비 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// 2. 커넥션 (디비 사용권한을 받는다)
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

	public static ConnectionDAO getInstance() {
		return (instance == null) ? instance = new ConnectionDAO() : instance;
	}

	private void close() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void finalize() throws Throwable {
		close();
		super.finalize();
	}
}
