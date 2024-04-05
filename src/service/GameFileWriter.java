package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class GameFileWriter {
	
	public static void WriteGameToFile(String filename, String gameInfo) {
		Path path = Paths.get(filename);
		try (Stream<String> lines = Files.lines(path)) {
			Files.write(path, (gameInfo + System.lineSeparator()).getBytes(), java.nio.file.StandardOpenOption.APPEND);
			
		} catch (IOException e) {
			 System.err.println("파일 쓰기 오류: " + e.getMessage());
		}
	}
}
