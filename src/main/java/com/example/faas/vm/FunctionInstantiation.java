package com.example.faas.vm;

import com.example.faas.common.Function;

public class FunctionInstantiation {

	public Function forClassName(String clazz) throws IllegalArgumentException {
		System.out.println("Loading class "+clazz);
        Class functionClass;
		try {
			functionClass = Class.forName(clazz);
			System.out.println("Class loaded");
			Function function = (Function) functionClass.newInstance();
			System.out.println("Function instantiated");
			return function;
		} 
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException("Could not load "+clazz, e);
		}
	}
}
