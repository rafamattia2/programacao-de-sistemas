package ps.com.example.demo;

public class Processor {
    private Instruction instruction;
    private Registers registers;
    private Memory memory;
    private Loaded program;

    public Processor(Memory memory, Registers registers) {
        this.instruction = new Instruction();
        this.registers = registers;
        this.memory = memory;
        this.program = memory.getProgram();
    }

    public void run() {
        while(true) {
            String instructionString = fetchInstruction();
            if(instruction.equals("HLT")) {
                break;
            }
            decodeInstruction(instructionString);
            executeInstruction();
        }
    }

    private String fetchInstruction() {
        int address = registers.getPC();
        String instructionString = memory.read(address);
        registers.setPC(address + 1);
        return instructionString;
    }

    private void decodeInstruction(String instruction){
        String opcode = instruction.substring(0, 2);
        String address = instruction.substring(2);

        switch(opcode) {
            case "18":
                Instructions.add(registers, memory, address);
                break;

            case "40":
                Instructions.and(registers, memory, address);
                break;

            case "28":
                Instructions.comp(registers, memory, address);
                break;

            case "24":
                Instructions.div(registers, memory, address);
                break;

            case "3C":
                Instructions.j(registers, memory, Integer.parseInt(address, 16));
                break;

            case "30":
                Instructions.jeq(registers, memory, Integer.parseInt(address, 16));
                break;

            case "34":
                Instructions.jgt(registers, memory, Integer.parseInt(address, 16));
                break;

            case "38":
                Instructions.jlt(registers, memory, Integer.parseInt(address, 16));
                break;

            case "48":
                Instructions.jsub(registers, memory, Integer.parseInt(address, 16));
                break;

            case "00":
                Instructions.lda(registers, memory, address);
                break;

            case "50":
                Instructions.ldch(registers, memory, address);
                break;

            case "08":
                Instructions.ldl(registers, memory, address);
                break;

            case "04":
                Instructions.ldx(registers, memory, address);
                break;

            case "20":
                Instructions.mul(registers, memory, address);
                break;

            case "44":
                Instructions.or(registers, memory, address);
                break;

            case "0C":
                Instructions.sta(registers, memory, address);
                break;

            default:
                throw new IllegalArgumentException("Invalid instruction: " + instruction);
        }
    }

    private void executeInstruction(String instruction) {
        decodeInstruction(instruction);
        registers.setPC(registers.getPC()+1);
    }
}