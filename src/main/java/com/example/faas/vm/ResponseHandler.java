package com.example.faas.vm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseHandler {
	
	private File workspaceFolder;
	
	private String jobId;

	public ResponseHandler(File workspaceFolder, String jobId) {
		super();
		this.workspaceFolder = workspaceFolder;
		this.jobId = jobId;
	}

	public void handle(Object response) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(response);
		File output = new File(workspaceFolder, "output-"+jobId+".json");
		try(FileWriter fw = new FileWriter(output)) {
			fw.write(json);
		}
	}
}
