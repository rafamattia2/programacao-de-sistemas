package ps.com.example.demo;

/* Essa classe armazena as características do programa
 * atual carregado na máquina virtual */

import java.util.ArrayList;
import java.util.List;

class Loaded {
    private String startingAddress;
    private String programSize;
    private int instructions_number;
    private List<Instruction> instructions;

    Loaded (String startAddr, String progSize, int instrNumber, List<Instruction> instructions) {
        this.startingAddress = startAddr;
        this.programSize = progSize;
        this.instructions_number = instrNumber;
        this.instructions = instructions;
    }

    public String getStartingAddress() {
        return startingAddress;
    }

    public void setStartingAddress(String startingAddress) {
        this.startingAddress = startingAddress;
    }

    public String getProgramSize() {
        return programSize;
    }

    public void setProgramSize(String programSize) {
        this.programSize = programSize;
    }

    public int getInstructions_number() {
        return instructions_number;
    }

    public void setInstructions_number(int instructions_number) {
        this.instructions_number = instructions_number;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }
}
