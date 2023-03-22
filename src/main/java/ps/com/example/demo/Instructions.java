package ps.com.example.demo;
// Instruções SIC/XE
public class Instructions {
    public static void add(Registers registers, Memory memory, int address) {
        registers.setA(registers.getA() + Integer.valueOf(memory.read(address)));
    }

    public static void and(Registers registers, Memory memory, int address) {
        registers.setA(registers.getA() & Integer.valueOf(memory.read(address)));
    }

    public static void comp(Registers registers, Memory memory, int address) {
        int value = Integer.valueOf(memory.read(address));
        if (registers.getA() < value) {
            registers.setSW(-1);
        } else if (registers.getA() == value) {
            registers.setSW(0);
        } else {
            registers.setSW(1);
        }
    }

    public static void div(Registers registers, Memory memory, int address) {
        int value = Integer.valueOf(memory.read(address));
        if (value != 0) {
            registers.setA(registers.getA() / value);
        }
    }

    public static void j(Registers registers, Memory memory, int address) {
        registers.setPC(address);
    }

    public static void jeq(Registers registers, Memory memory, int address) {
        if (registers.getSW() == 0) {
            registers.setPC(address);
        }
    }

    public static void jgt(Registers registers, Memory memory, int address) {
        if (registers.getSW() == 1) {
            registers.setPC(address);
        }
    }

    public static void jlt(Registers registers, Memory memory, int address) {
        if (registers.getSW() == -1) {
            registers.setPC(address);
        }
    }

    public static void jsub(Registers registers, Memory memory, int address) {
        memory.write(registers.getL(), String.valueOf(registers.getPC()));
        registers.setL(registers.getPC());
        registers.setPC(address);
    }

    public static void lda(Registers registers, Memory memory, int address) {
        registers.setA(Integer.valueOf(memory.read(address)));
    }

    public static void ldch(Registers registers, Memory memory, int address) {
        registers.setA((registers.getA() & 0xFFFF00) | (Integer.valueOf(memory.read(address)) & 0xFF));
    }

    public static void ldl(Registers registers, Memory memory, int address) {
        registers.setL(Integer.valueOf(memory.read(address)));
    }

    public static void ldx(Registers registers, Memory memory, int address) {
        registers.setX(Integer.valueOf(memory.read(address)));
    }

    public static void mul(Registers registers, Memory memory, int address) {
        registers.setA(registers.getA() * Integer.valueOf(memory.read(address)));
    }

    public static void or(Registers registers, Memory memory, int address) {
        registers.setA(registers.getA() | Integer.valueOf(memory.read(address)));
    }

    public static void sta(Registers registers, Memory memory, int address) {
        memory.write(address, String.valueOf(registers.getA()));
    }
}