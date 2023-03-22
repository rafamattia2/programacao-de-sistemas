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
    //Getters
    public int getOpcode() {
        return opcode;
    }

    public int getMode() {
        return mode;
    }

    public int getOperand() {
        return operand;
    }
    //Fim Getters

    //Inicio Operações Basicas!
    public int add(int acc, int opd) {
        return acc + opd;
    }
    public int divide(int acc, int opd) {
        return acc / opd;
    }
    public int mult(int acc, int opd){
        acc *= opd;
        return acc;
    }
    public int sub(int acc, int opd) {//reap as sub
        return opd - acc;
        //Fim Operações Basicas!
    }
}