package com.ktds.dojun;

import com.ktds.dojun.biz.HRBiz;
import com.ktds.dojun.biz.HRBizImpl;

public class HRController {

	public void start() {

		HRBiz hrBiz = new HRBizImpl();
		// hrBiz.printAllEmployees();
		// hrBiz.printAllEmployeesWithDp();
		
		// hrBiz.findOneEmployee(110);
	}

	public static void main(String[] args) {
		new HRController().start();
	}

}