package com.example.springboot;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

	private static int index = 0;
	
	@PostMapping("/translator/java")
	public String index(@RequestPart("file") MultipartFile file) {
		String s = "";
		try {
			byte[] bytes = file.getBytes();
			final String x = Integer.toString(index++);
			TimeUnit.SECONDS.sleep(5);
			final Path path = Paths.get(x + "_" + file.getOriginalFilename());
			Files.write(path, bytes);
	        s = "=== OK ===\n";
		}
        catch (Exception e) {}
        return s;
	}
}
