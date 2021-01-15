package beans;

import java.io.Serializable;

public class AccountBeans implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uid;
	private String passwd;
	private String userName;

	public AccountBeans() {}



	public AccountBeans(String uid, String passwd, String userName) {
		super();
		this.uid = uid;
		this.passwd = passwd;
		this.userName = userName;
	}



	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
