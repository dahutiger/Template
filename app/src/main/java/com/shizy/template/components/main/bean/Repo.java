package com.shizy.template.components.main.bean;

import com.shizy.template.common.bean.BaseBean;

public class Repo extends BaseBean {

	private static final long serialVersionUID = -2023625673622903606L;

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
