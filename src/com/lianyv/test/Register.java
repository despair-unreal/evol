package com.lianyv.test;

import com.qjm.jdbc.MysqlUtil;

public class Register {
	public static boolean RegisterSql(UserInfo u) {
		boolean IsSuccess = false;
		MysqlUtil mu = new MysqlUtil("evol", "root", "root");
		String sql = "insert into userInfo value(0,'"+u.name+"','"+u.pwd+"','user')";
		int result = mu.executeSQL(sql);
		if(result != 0)
			IsSuccess = true;
		return IsSuccess;
	}
}
