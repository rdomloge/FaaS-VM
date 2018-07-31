package com.example.faas.vm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.example.faas.common.Function;

public class ConfigManager {
	
	private File workspaceFolder;

	
	public ConfigManager(File workspaceFolder) {
		this.workspaceFolder = workspaceFolder;
	}

	public void configure(Function fn) throws IOException {
        
		Properties config = load();
		config.put("BASE_URL", "http://bdbl.org.uk");
		fn.setStaticConfig(config);
	}
	
	private Properties load() throws IOException {
		Properties props = new Properties();
		try(FileInputStream fis = new FileInputStream(new File(workspaceFolder, "config.txt"))) {
			props.load(fis);
		}
		return props;
	}
}
