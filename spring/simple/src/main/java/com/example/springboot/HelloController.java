package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;

@RestController
public class HelloController {

    public static int COUNT=0;

	@RequestMapping("/")
	public String index() throws Exception {
        String colour = "n/a";

        // read config value from disk
        try {
            BufferedReader br = new BufferedReader(new FileReader("/config/colour"));
            colour = br.readLine();
        }
        catch (Exception e ) {
            System.out.println("Unable to read config. going with default.");
        }

        String result = "Results for " + colour + " --> " + COUNT++;

        return result;
	}

}
