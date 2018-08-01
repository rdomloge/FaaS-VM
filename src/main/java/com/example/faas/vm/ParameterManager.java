package com.example.faas.vm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.example.faas.common.Function;

public class ParameterManager {
	
	private File workspaceFolder;
	
	private String jobId;

	
	public ParameterManager(File workspaceFolder) {
		this.workspaceFolder = workspaceFolder;
	}

	public void configureJobParameters(Function fn) throws IOException {
		fn.setJobParams(load());
	}
	
	private Properties load() throws IOException {
		Properties props = new Properties();
		File paramFile = new File(workspaceFolder, "params-"+jobId+".txt");
		if(paramFile.exists()) {
			try(FileInputStream fis = new FileInputStream(paramFile)) {
				props.load(fis);
			}
		}
		else
			System.out.println("Params file missing - doing nothing: "+paramFile);
		
		return props;
	}
}
