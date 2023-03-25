package ps.com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(DemoApplication.class, args);

		String filePath = "src/src.o";
		Loaded program = Reader.readObjectCode(filePath);

		List<Instruction> list = program.getInstructions();

		for (Instruction instruction : list) {
			System.out.println("Nome da instrução: " + instruction.getMnemonic() + " Binário: " + instruction.getBinaryCode() + " Hex: " + instruction.getHexCode() + " Endereço = " + instruction.getAddress() + " Formato = " + instruction.getFormat());
			if(instruction.getFormat() == 2) {
				System.out.println("Operando 1: " + instruction.getOp1());
				System.out.println("Operando 2: " + instruction.getOp2());
			}
			else{
				System.out.println("Operando: " + instruction.getOp1() + " Modo de Endereçamento: " + instruction.getAddressingMode());
			}
		}

		app.close();
	}
}
