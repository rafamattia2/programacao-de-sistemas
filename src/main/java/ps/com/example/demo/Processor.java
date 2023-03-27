package ps.com.example.demo;
import java.util.List;
import static ps.com.example.demo.Reader.*;

public class Processor {
    private Instruction instruction;
    private String addressOperando;
    private Registers registers;
    private Memory memory;
    private Loaded program;
    private List<Instruction> instructionsList;

    public Processor(Memory memory) {
        this.instruction = new Instruction();
        this.registers = new Registers();
        this.memory = memory;
    }

    public void run() {

        registers.setPC(Integer.parseInt(memory.getProgram().getStartingAddress(), 16));
        System.out.println("Program Counter: " + registers.getPC());

        while(registers.getPC() < 16406){
            decodeInstruction();
            System.out.println("Endereço Alvo: " + String.format("%06X", Integer.parseInt(instruction.getOp1(), 2)));
            executeInstruction();
            registers.setPC(registers.getPC() + 3);
            System.out.println("Program Counter: " + registers.getPC());
        }
    }

    private void decodeInstruction(){
        byte firstByte = memory.read(String.format("%06X", registers.getPC()));
        byte secondByte;
        byte thirdByte;

        String opcode = evaluateOpcode(String.format("%02X", firstByte));
        int instructionFormat = calcInstructionFormat(opcode);

        if (opcode == null){
            return;
        }

        if(instructionFormat == 3){
            secondByte = memory.read(String.format("%06X", registers.getPC() + 1));
            thirdByte = memory.read(String.format("%06X", registers.getPC() + 2));
            byte[] word = new byte[3];

            word[0] = firstByte;
            word[1] = secondByte;
            word[2] = thirdByte;

            String hex = String.format("%02X%02X%02X", word[0], word[1], word[2]);
            instruction.setHexCode(hex);
            instruction.setMnemonic(evaluateOpcode(hex.substring(0, 2)));
            instruction.setFormat(calcInstructionFormat(instruction.getMnemonic()));
            instruction.setBinaryCode(String.format("%24s", Integer.toBinaryString(Integer.parseInt(hex, 16))).replace(' ', '0'));
            instruction.setOp1(instruction.getBinaryCode().substring(12));
            instruction.setAddressingMode(addressingModeCalculator(instruction.getBinaryCode()));
            addressOperando = String.format("%06X", Integer.parseInt(instruction.getOp1(), 2));
        }
    }

    private void executeInstruction() {
        switch (instruction.getMnemonic()) {
            case "LDX":
                Instructions.ldx(registers, memory, addressOperando);
                break;
            case "LDA":
                Instructions.lda(registers, memory, addressOperando);
                break;
        }
    }
}
