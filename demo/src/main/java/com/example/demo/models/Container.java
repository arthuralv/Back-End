package com.example.demo.models;

import java.io.*;
import java.net.URL;

public class Container {
    
	public void catchFileFromURL () {
		try (BufferedInputStream in = new BufferedInputStream(new URL("https://raw.githubusercontent.com/wcota/covid19br/master/cases-brazil-cities.csv").openStream());
				  FileOutputStream fileOutputStream = new FileOutputStream("cases-brazil-cities.csv")) {
			byte dataBuffer[] = new byte[1024];
		    int bytesRead;
		    
		    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
		        fileOutputStream.write(dataBuffer, 0, bytesRead);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
        }
    }
}