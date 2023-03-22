package ps.com.example.demo;

public class Memory {
    String[] memory;

    public Memory (int size){
        this.memory = new String[size];
    }

    public String read (int address){
        return memory[address];
    }

    public void write (int address, String value){
        memory[address] = value;
    }
}
