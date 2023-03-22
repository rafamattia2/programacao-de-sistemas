package ps.com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(DemoApplication.class, args);
		String filePath = "src/src.txt";

		Reader reader = new Reader();
		List<Loaded> program = reader.readObjectCode(filePath);

		for (Loaded codes : program) {
			String[] binaryLine = codes.toBinary();

			for (String str : binaryLine) {
				System.out.print(str + " ");
			}
			System.out.println("\n");
		}

		app.close();
	}
}
