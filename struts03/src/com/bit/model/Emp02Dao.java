package com.bit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import org.apache.log4j.Logger;

import com.bit.model.entity.Emp02Vo;

public class Emp02Dao {
	Logger logger = Logger.getLogger(this.getClass());
	DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Emp02Dao() throws SQLException{
		if(dataSource == null) setDataSource();
	}
	
	public void setDataSource() throws SQLException{
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUser("scott");
		dataSource.setPassword("tiger");
//		dataSource.setLoginTimeout(3000);//로그인 시간
		this.dataSource = dataSource;
	}
	
	public List<Emp02Vo> selectAll() throws SQLException{
		String sql = "select * from emp02";
		List<Emp02Vo> list = new ArrayList<Emp02Vo>();
		try{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Emp02Vo bean = new Emp02Vo(rs.getInt("sabun"),
						rs.getString("name"),
						rs.getDate("nalja"),
						rs.getInt("pay")
						);
				logger.debug(bean);
				list.add(bean);
			}
		}finally{
			if(conn != null)
				conn.close();
		}
		
		return list;
	}
	
	public void insertOne(int sabun,String name,int pay) throws SQLException{
		String sql = "insert into emp02 values(?,?,sysdate,?)";
		
		try{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.setString(2, name);
			pstmt.setInt(3, pay);
			
			pstmt.executeUpdate();
		}finally{
			if(pstmt!=null) pstmt.close();
			if(conn!= null) conn.close();
		}
	}
}
