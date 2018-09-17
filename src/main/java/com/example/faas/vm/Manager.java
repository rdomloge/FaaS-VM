package com.example.faas.vm;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import com.example.faas.common.Function;

public class Manager {

	private String jobId;
	private String workspacePath;
	
	private FunctionInstantiation functionInstantiation;
	private ConfigManager configManager;
	private ParameterManager parameterManager;
	private ResponseHandler responseHandler;
	
	public Manager(String jobId, String workspacePath) {
		this.jobId = jobId;
		this.workspacePath = workspacePath;
		
		File workspaceFolder = new File(workspacePath);
		if( ! workspaceFolder.exists() || ! workspaceFolder.isDirectory()) throw new IllegalArgumentException();
		
		functionInstantiation = new FunctionInstantiation();
		configManager = new ConfigManager(workspaceFolder);
		parameterManager = new ParameterManager(workspaceFolder, jobId);
		responseHandler = new ResponseHandler(workspaceFolder, jobId);
	}

	public void handle(String clazz) throws IOException {
		@SuppressWarnings("unchecked")
		Function<Properties> function = functionInstantiation.forClassName(clazz);
		configManager.configure(function);
		parameterManager.configureJobParameters(function);
		Object result = function.call();
        responseHandler.handle(result);
	}
}
