package com.lianyv.test;

import java.util.List;

import com.qjm.jdbc.MysqlUtil;

public class LoginValidate {
	public static boolean validate(UserInfo u){
		boolean IsSuccess = false;
		MysqlUtil mu = new MysqlUtil("evol","root","root");
		String sql="select * from userInfo";
		List<String[]> list = mu.querySQL(sql);
		for(int i=0;i<list.size();i++) {
			String[] result = list.get(i);
			if(result[1].equals(u.name)&&result[2].equals(u.pwd))
				IsSuccess = true;
		}
		return IsSuccess;
	}
}
