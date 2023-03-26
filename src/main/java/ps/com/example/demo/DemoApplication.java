package ps.com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(DemoApplication.class, args);

		String filePath = "src/src.o";
		Loaded program = Reader.readObjectCode(filePath);

		List<Instruction> list = program.getInstructions();

		Memory memory = new Memory(program);

		for(MemoryItem memoryItem : memory.getMemoryItem()){
			String address = memoryItem.getAddress();
			Byte memData = memoryItem.getMemData();
			System.out.print(address + "->" + memData + "\n");

		}
		Byte memData = memory.read("004001");
		System.out.println(memData);
//		int i = 0;
//		for(MemoryItem memoryItem : memory.getMemoryItem()){
//			String address = memoryItem.getAddress();
//			Byte memData = memoryItem.getMemData();
//			if(memoryItem.getMemData() != 0){
//				System.out.print(address + "->" + memData + "\n");
//			}
//		}

//		for (Instruction instruction : list) {
//			System.out.println("Nome da instrução: " + instruction.getMnemonic() + " Binário: " + instruction.getBinaryCode() + " Hex: " + instruction.getHexCode() + " Endereço = " + instruction.getAddress() + " Formato = " + instruction.getFormat());
//			if(instruction.getFormat() == 2) {
//				System.out.println("Operando 1: " + instruction.getOp1());
//				System.out.println("Operando 2: " + instruction.getOp2());
//			}
//			else{
//				System.out.println("Operando: " + instruction.getOp1() + " Modo de Endereçamento: " + instruction.getAddressingMode());
//			}
//		}

		System.out.println(program.getProgramSize() + " " + program.getStartingAddress());
		app.close();
	}
}
