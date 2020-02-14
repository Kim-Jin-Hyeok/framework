package com.bit.action;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import com.bit.model.Emp02Dao;
import com.bit.model.entity.Emp02Vo;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action {
	Logger log = Logger.getLogger(this.getClass());
	private List<Emp02Vo> list;
	
	public List<Emp02Vo> getList(){
		return list;
	}
	
	@Override
	public String execute() throws Exception {
		log.debug("ListAction success");
		Emp02Dao dao = new Emp02Dao();
		list = dao.selectAll();
		log.debug(Arrays.toString(list.toArray()));
		return this.SUCCESS;
	}
}
