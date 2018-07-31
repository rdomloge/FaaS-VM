package com.example.faas.vm.config;

import com.example.faas.vm.Manager;

public class ApplicationMain {
	
	
	public static void main(String[] args) throws Exception {
		if(args.length != 3) throw new IllegalArgumentException("[class] [jobId] [workspace path]");
		
		String clazz = args[0];
		String jobId = args[1];
		String workspacePath = args[2];
		
        Manager mgr = new Manager(jobId, workspacePath);
        mgr.handle(clazz);
	}
}
