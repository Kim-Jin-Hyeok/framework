package com.bit;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class BbsAction implements ModelDriven<Emp02Vo> , Preparable{
	private List<Emp02Vo> list;
	Emp02Vo bean;
	
	public List<Emp02Vo> getList() {
		return list;
	}
	
	public void setBean(Emp02Vo bean) {
		this.bean = bean;
	}
	
	public Emp02Vo getBean() {
		return bean;
	}
	
	public String execute(){
		return Action.SUCCESS;
	}
	
	public String addForm(){
		return Action.SUCCESS;
	}
	
	public String list() throws SQLException{
		Emp02Dao dao = new Emp02Dao();
		list=dao.selectAll();
		return Action.SUCCESS;
	}
	
	public String insert() throws SQLException{
		Emp02Dao dao = new Emp02Dao();
		dao.insertOne(bean);
		return Action.SUCCESS;
	}
	
	public String detail() throws SQLException{
		Emp02Dao dao = new Emp02Dao();
		bean= dao.selectOne(bean.getSabun());
		return Action.SUCCESS;
	}

	public String update() throws SQLException{
		Emp02Dao dao = new Emp02Dao();
		dao.updateOne(bean);
		return Action.SUCCESS;
	}
	
	@Override
	public Emp02Vo getModel() {
		// TODO Auto-generated method stub
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		bean = new Emp02Vo();
		
	}

}
