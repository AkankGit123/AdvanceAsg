package com.rays.servletJ;

public class TestRegistrationModel {

	public static void main(String[] args) throws Exception {
		testAdd();
		
	}

	private static void testAdd() throws Exception {
		
		RegistrationBean bean = new RegistrationBean();
		bean.setFname(bean.getFname());
		bean.setLname(bean.getLname());
		bean.setGender(bean.getGender());
		bean.setDob(bean.getDob());
		bean.setAdd(bean.getAdd());
		bean.setEmail(bean.getEmail());
		bean.setPwd(bean.getPwd());
		 RegistrationModel model = new RegistrationModel();
		 model.add(bean);
		  
		 		}
	
	
	}

