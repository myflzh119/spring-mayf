package com.cn.mayf.mergedBD;

/**
 * @Author mayf
 * @Date 2021/4/13 23:42
 */
public class ParentBean {
	private String type;
	private String name;

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "type-------"+type+"\nname-------"+name;
	}
}
