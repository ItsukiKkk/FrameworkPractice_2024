/**
 * 
 */
package com.seiryo.data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class Data {
	private int[] a;
	private List<String> list;
	private Map<Integer, String> map;
	private Set<String>set;
	private Properties properties;
	public int[] getA() {
		return a;
	}
	public void setA(int[] a) {
		this.a = a;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<Integer, String> getMap() {
		return map;
	}
	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	/**
	 * @param a
	 * @param list
	 * @param map
	 * @param set
	 * @param properties
	 */
	public Data(int[] a, List<String> list, Map<Integer, String> map, Set<String> set, Properties properties) {
		super();
		this.a = a;
		this.list = list;
		this.map = map;
		this.set = set;
		this.properties = properties;
	}
	/**
	 * 
	 */
	public Data() {
		super();
	}
	@Override
	public String toString() {
		return "Data [a=" + Arrays.toString(a) + ", list=" + list + ", map=" + map + ", set=" + set + ", properties="
				+ properties + "]";
	}
	
}
