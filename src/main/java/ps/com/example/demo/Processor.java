package ps.com.example.demo;

public class Processor {
    private Instruction instruction;
    private Registers registers;
    private Memory memory;

    public Processor() {
        this.instruction = null;
        this.registers = new Registers();
        this.memory = new Memory();
    }

    public void run() {
        while (registers.getPC() < memory.getSize()) {
            instruction = new Instruction(memory.reader(registers.getPC()));
            executeInstruction();
        }
    }

    private void executeInstruction() {
        switch (instruction.getOpcode()) {
            case "ADD":
                Instructions.add(registers, memory, instruction.getAddress());
                break;
            case "AND":
                Instructions.and(registers, memory, instruction.getAddress());
                break;
            case "COMP":
                Instructions.comp(registers, memory, instruction.getAddress());
                break;
            case "DIV":
                Instructions.div(registers, memory, instruction.getAddress());
                break;
            case "J":
                Instructions.j(registers, memory, instruction.getAddress());
                break;
            case "JEQ":
                Instructions.jeq(registers, memory, instruction.getAddress());
                break;
            case "JGT":
                Instructions.jgt(registers, memory, instruction.getAddress());
                break;
            case "JLT":
                Instructions.jlt(registers, memory, instruction.getAddress());
                break;
            case "JSUB":
                Instructions.jsub(registers, memory, instruction.getAddress());
                break;
            case "LDA":
                Instructions.lda(registers, memory, instruction.getAddress());
                break;
            case "LDCH":
                Instructions.ldch(registers, memory, instruction.getAddress());
                break;
            case "LDL":
                Instructions.ldl(registers, memory, instruction.getAddress());
                break;
            case "LDX":
                Instructions.ldx(registers, memory, instruction.getAddress());
                break;
            case "MUL":
                Instructions.mul(registers, memory, instruction.getAddress());
                break;
            case "OR":
                Instructions.or(registers, memory, instruction.getAddress());
                break;
            case "STA":
                Instructions.sta(registers, memory, instruction.getAddress());
                break;
        }
        registers.setPC(registers.getPC() + instruction.getSize()); // nao consegui fazer o uso do getsize
    }
}

public class Registers {
    private int A;
    private int X;
    private int L;
    private int PC;
    private int SW;

    public Registers() {
        this.A = 0;
        this.X = 0;
        this.L = 0;
        this.PC = 0;
        this.SW = 0;
    }

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getL() {
        return L;
    }

    public void setL(int l) {
        L = l;
    }

    public int getPC() {
        return PC;
    }

    public void setPC(int pc) {
        PC = pc;
    }

    public int getSW() {
        return SW;
    }

    public void setSW(int sw) {
        SW = sw;
    }
}

public class Memory {
    private final String