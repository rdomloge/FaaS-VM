package com.example.faas.vm;

import java.util.HashMap;
import java.util.Map;

import com.example.faas.common.Function;

public class ParameterManager {

	public void configureJobParameters(Function fn) {
		Map<String,String> jobParams = new HashMap<>();
		fn.setJobParams(jobParams);
	}
}
