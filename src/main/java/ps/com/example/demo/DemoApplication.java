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

		String filePath = "src/src.o";
		Reader reader = new Reader();
		Loaded program = reader.readObjectCode(filePath);

		List<Instruction> list = program.getInstructions();

		for (Instruction instruction : list) {
			System.out.println("Nome da instrução: " + instruction.getMnemonic() + " Binário: " + instruction.getBinaryCode() + " Hex: " + instruction.getHexCode() + " Endereço = " + instruction.getAddress() + " Formato = " + instruction.getFormat());
		}

		app.close();
	}
}
