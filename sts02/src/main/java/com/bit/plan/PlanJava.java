package com.bit.plan;

import com.bit.service.Remote;
import com.bit.service.Tv;

public class PlanJava {

	public static void main(String[] args) {
		
//		Remote remote = new Remote(new Tv());
//		remote.setRemote(new Tv());
		
		Remote remote = new Remote();
		
		remote.setRemote(new Tv());
		remote.func3();
	}

}
