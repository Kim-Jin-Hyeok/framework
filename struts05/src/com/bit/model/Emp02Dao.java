package com.bit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import com.bit.model.entity.Emp02Vo;

public class Emp02Dao {
	static DataSource dataSource;
	
	public Emp02Dao() throws SQLException{
		if(dataSource == null) 
			setDataSource();
	}
	
	public void setDataSource() throws SQLException{
		OracleDataSource dataSource = null;
		dataSource = new OracleDataSource();
		dataSource.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUser("scott");
		dataSource.setPassword("tiger");
		this.dataSource = dataSource;
	}
	
	public List<Emp02Vo> selectAll() throws SQLException{
		String sql = "select * from Emp02";
		List<Emp02Vo> list = new ArrayList<Emp02Vo>();
		try(Connection conn = dataSource.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Emp02Vo(
						rs.getInt("sabun"),
						rs.getString("name"),
						rs.getDate("nalja"),
						rs.getInt("pay")
						));
			}
		}finally{
			
		}
		return list;
	}
	
	public void insertOne(Emp02Vo bean) throws SQLException{
		String sql = "insert into emp02 values(?,?,sysdate,?)";
		
		try(Connection conn= dataSource.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			pstmt.executeUpdate();
		}
	}
}
