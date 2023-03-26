package ps.com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Setter
@Getter
public class Memory {
    private Loaded program;
    private Set<MemoryItem> memory = new TreeSet<>();

    public Memory(Loaded program) {
        this.program = program;
        for(int i = 0; i < 16384; i++){
            String address = String.format("%06X", i);
            memory.add(new MemoryItem(address, (byte) 0));
        }
        loadProgram(program);
    }

    public void loadProgram(Loaded program) {
        String startAddress = program.getStartingAddress();
        int currentAddress = Integer.parseInt(startAddress, 16);
        System.out.println(currentAddress);
        for (Instruction instruction : program.getInstructions()) {
            String hexCode = instruction.getHexCode();
            String[] bytesString = hexCode.split("(?<=\\G.{2})");
            for (String byteString : bytesString) {
                byte byteValue = (byte) Integer.parseInt(byteString, 16);
                String hexAddress = String.format("%06X", currentAddress);
                write(hexAddress, byteValue);
                currentAddress++;
            }
        }
    }

    public Set<MemoryItem> getMemoryItem() {
        return memory;
    }

    public void write(String address, byte data) {
        MemoryItem item = new MemoryItem(address, data);
        memory.add(item);
    }

    public byte read(String address) {
        for (MemoryItem item : memory) {
            if (item.getAddress().equals(address)) {
                return item.getMemData();
            }
        }
        throw new IllegalArgumentException("Endereço inválido: " + address);
    }
}
//package ps.com.example.demo;
//
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@Setter
//public class Memory {
//    private Loaded program;
//    private static final int WORD_SIZE = 24;
//    private ArrayList<Byte> memory;
//    private ArrayList<String> addresses;
//
//    public Memory (Loaded program){
//        memory = new ArrayList<Byte>();
//        addresses = new ArrayList<String>();
//        setProgram(program);
//        for(int i = 0; i < 1048576; i++) {
//            String hexAddresses = String.format("%06X", i);
//            addresses.add(hexAddresses);
//        }
//        loadProgram();
//    }
//
//    public void loadProgram(){
//        int regex = Integer.parseInt(program.getStartingAddress());
//        for(Instruction instruction : program.getInstructions()) {
//            String hexCode = instruction.getHexCode();
//            String[] bytesString = hexCode.split("(?<=\\G.{2})");
//            for(String byteString : bytesString) {
//                byte byteValue = (byte) Integer.parseInt(byteString, 16);
//                String hexAddres = String.format("%06X", regex);
//                write(hexAddres, byteValue);
//                regex++;
//            }
//        }
//    }
//
//    public void write(String address, byte data){
//        int index = addresses.indexOf(address);
//        if(index != -1){
//            memory.set(index, data);
//        }else{
//            addresses.add(address);
//            memory.add(data);
//        }
//    }
//
//    public Byte read(String address){
//        int index = addresses.indexOf(address);
//        if(index != -1){
//            return memory.get(index);
//        }else{
//            return 0;
//        }
//    }
//
//    public void setProgram (Loaded program){
//        this.program = program;
//    }
//
//    public Loaded getProgram(){
//        return this.program;
//    }
//
//}
