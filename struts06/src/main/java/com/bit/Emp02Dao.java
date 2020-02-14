package com.bit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Emp02Dao {
	SqlMapClient sqlMapClient;
	
	public Emp02Dao() {
		
		try {
			Reader reader = Resources.getResourceAsReader("/SqlMapConfig.xml");
			
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Emp02Vo> selectAll() throws SQLException{
		return sqlMapClient.queryForList("selectAll");
	}
	
	public void insertOne(Emp02Vo bean) throws SQLException{
		sqlMapClient.insert("insertOne",bean);
	}
	
	public Emp02Vo selectOne(int sabun) throws SQLException{
		return (Emp02Vo)sqlMapClient.queryForObject("selectOne",sabun);
	}
	
	public int updateOne(Emp02Vo bean) throws SQLException{
		return sqlMapClient.update("updateOne",bean);
	}
	
	public int deleteOne(int sabun) throws SQLException{
		return sqlMapClient.delete("deleteOne",sabun);
	}
	
}
