package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.AccountBeans;

public class NewRegistaration {
	final String id = "postgres";
	final String password = "sutoraiku";
	final String url =  "jdbc:postgresql://localhost:5432/userinfo";

	public AccountBeans registar(AccountBeans ab) {
		try {
			Class.forName("org.postgresql.Driver");


			try(Connection conn = DriverManager.getConnection(url, id, password)){
				String sql = "INSERT INTO users(uid, passwd, username) VALUES(?, ?, ?)";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, ab.getUid());
				ps.setString(2, ab.getPasswd());
				ps.setString(3, ab.getUserName());

				//データベースの更新
				int update = ps.executeUpdate();
				conn.setAutoCommit(false);

				if(update > 0) {
					conn.commit();
					System.out.println("登録成功しました!");
				}else {
					conn.rollback();
					System.out.println("登録失敗しました!");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  ab;
	}
}