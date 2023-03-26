package ps.com.example.demo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Memory {
    private Loaded program;
    private static final int WORD_SIZE = 24;
    private ArrayList<Byte> memory;
    private ArrayList<String> addresses;

    public Memory (Loaded program){
        memory = new ArrayList<Byte>();
        setProgram(program);
        for(int i = 0; i < 1048576; i++) {
            String hexAddresses = String.format("%06X", i);
            addresses.add(hexAddresses);
        }
    }

    public void loadProgram(){
        int regex = Integer.parseInt(program.getStartingAddress());
        for(Instruction instruction : program.getInstructions()) {
            String hexCode = instruction.getHexCode();
            String[] bytesString = hexCode.split("(?<=\\G.{2})");
            for(String byteString : bytesString) {
                byte byteValue = (byte) Integer.parseInt(byteString, 16);
                String hexAddres = String.format("%06X", regex);
                write(hexAddres, byteValue);
                regex++;
            }
        }
    }

    public void write(String address, byte data){
        int index = addresses.indexOf(address);
        if(index != -1){
            memory.set(index, data);
        }else{
            addresses.add(address);
            memory.add(data);
        }
    }

    public Byte read(String address){
        int index = addresses.indexOf(address);
        if(index != -1){
            return memory.get(index);
        }else{
            return 0;
        }
    }

    public void setProgram (Loaded program){
        this.program = program;
    }

    public Loaded getProgram(){
        return this.program;
    }

}
