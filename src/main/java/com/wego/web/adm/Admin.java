package com.wego.web.adm;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data @Component
public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String eid,pwd,job,mgr,hireDate,sal,comm,deptNo;

}