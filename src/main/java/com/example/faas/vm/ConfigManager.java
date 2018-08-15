package com.example.faas.vm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

import com.example.faas.common.Function;

public class ConfigManager {
	
	private File workspaceFolder;
	
	public ConfigManager(File workspaceFolder) {
		this.workspaceFolder = workspaceFolder;
	}

	public void configure(Function<Properties> fn) throws IOException {
		Properties config = load();
		for (Entry e : config.entrySet()) {
			System.out.printf("Property: %s = %s\n", e.getKey(), e.getValue());
		}
		
		fn.setStaticConfig(load());
	}
	
	private Properties load() throws IOException {
		Properties props = new Properties();
		File cfgFile = new File(workspaceFolder, "config.txt");
		if(cfgFile.exists()) {
			try(FileInputStream fis = new FileInputStream(cfgFile)) {
				props.load(fis);
			}
		}
		else
			System.out.println("Config file missing - doing nothing: "+cfgFile);
		
		return props;
	}
}
