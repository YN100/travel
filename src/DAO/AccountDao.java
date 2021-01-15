package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.AccountBeans;

public class AccountDao {
	final String id = "postgres";
	final String password = "sutoraiku";
	final String url =  "jdbc:postgresql://localhost:5432/userinfo";


	public AccountBeans findAccont(AccountBeans ab) {

		AccountBeans returnAb = new AccountBeans();
		try {
			Class.forName("org.postgresql.Driver");

			try(Connection conn = DriverManager.getConnection(url, id, password)){
				String sql = "SELECT uid, passwd, username FROM users WHERE uId = ? AND passwd = ?";
				PreparedStatement ps= conn.prepareStatement(sql);

				ps.setString(1, ab.getUid());
				ps.setString(2, ab.getPasswd());

				//データベースの検索
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					// 見つかったアカウント情報を戻り値にセット
					returnAb.setUid(rs.getString("uid"));
					returnAb.setPasswd(rs.getString("passwd"));
					returnAb.setUserName(rs.getString("username"));
				} else {
					// アカウントがなければnullを返す
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return returnAb;
	}

}


