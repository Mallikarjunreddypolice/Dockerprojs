package com.exam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGeneration {

	
	
	
	public Map<Boolean,List<String>> generateRandom(String name,List<String> users,Boolean userflag) {
		
		Boolean flag=Boolean.FALSE;
		Map<Boolean,List<String>> checkUserNames=new HashMap<Boolean, List<String>>();
		 List<String> strings = new ArrayList<String>();
		
			for (int i = 0; i <= 20; i++) {
				String username=userflag==Boolean.TRUE ?"":name;
				strings.add(name+ RandomStringUtils.randomAlphanumeric(7));
			}
			
			if(users!=null && !users.isEmpty()){
			for(String string:users){
				if(string.equalsIgnoreCase(name)){
					flag=Boolean.TRUE;	
				}
			}
			
			List<String> commonlist=new ArrayList<String>(strings);
			if(commonlist.retainAll(users)){
				strings.removeAll(commonlist);
			}
			
			}else {
				flag=Boolean.FALSE;	
			}
			checkUserNames.put(flag, strings);
			return checkUserNames;
		
	}

}
