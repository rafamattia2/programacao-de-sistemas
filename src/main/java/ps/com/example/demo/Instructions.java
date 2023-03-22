package ps.com.example.demo;

public class Instructions {
    private int opcode;
    private int mode;
    private int operand;

    public Instructions(int opcode, int mode, int operand) {
        this.opcode = opcode;
        this.mode = mode;
        this.operand = operand;
    }

    public int getOpcode() {
        return opcode;
    }

    public int getMode() {
        return mode;
    }

    public int getOperand() {
        return operand;
    }
}
