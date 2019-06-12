package web;

import web.utils.Utils;

public class Lambda  {
	
	 public String handleRequest(Object input) {
		 Utils.setJSON(input.toString());
		 
	        return input.toString();
	    }
	 

	
}