package com.example.faas.vm;

import java.util.HashMap;
import java.util.Map;

import com.example.faas.common.Function;

public class ConfigManager {

	
	public void configure(Function fn) {
		Map<String,String> config = new HashMap<>();
        config.put("BASE_URL", "http://bdbl.org.uk");
		fn.setStaticConfig(config);
	}
}
