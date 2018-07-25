package com.example.faas.vm.config;

import java.util.HashMap;
import java.util.Map;

import com.example.faas.common.Function;

public class ApplicationMain {
	
	
	public static void main(String[] args) throws Exception {
		if(args.length != 1) throw new IllegalArgumentException("Class name arg missing");
		String clazz = args[0];
        System.out.println("Loading class "+clazz);
        Class functionClass = Class.forName(clazz);
        System.out.println("Class loaded");
        Function function = (Function) functionClass.newInstance();
        System.out.println("Function instantiated");
        
        Map<String,String> config = new HashMap<>();
        config.put("BASE_URL", "http://bdbl.org.uk");
		function.setStaticConfig(config);
		
        Map<String,String> jobParams = new HashMap<>();
		function.setJobParams(jobParams);
        
        // pass the params - fetch from queue?
        // if we fetch from queue, we don't have to have a massive command line and 
        // we can be told to do another run or to shut down.
        
        Object result = function.call();
	}
}
