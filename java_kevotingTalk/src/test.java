import java.sql.Connection;
import java.sql.DriverManager;

public class test {

	public static void main(String[] args) {
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3306/yujinDB";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1");
			con = DriverManager.getConnection(url, "yujin", "1234");
			System.out.println("DB success!!");
		}catch(Exception e){
			System.out.println( e.toString());
		}

	}

}
