package ps.com.example.demo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Reader {
    public static Loaded readObjectCode(String filePath) {

        String programName = null;
        String initialAddress = null;
        int programSize = 0;

        List<Instruction> instructionList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                System.out.println(line);
                String buffer; // Responsável por guardar o hex atual

                if (line.length() > 0) {
                    if (line.charAt(0) == 'H') {
                        programName = line.substring(2, 8);
                        initialAddress = line.substring(10, 15);
                        programSize = Integer.parseInt(line.substring(16, 22), 16);
                        System.out.println("Header: " + programName + " " + initialAddress + " " + programSize);

                    } else if (line.charAt(0) == 'T') {

                        String baseAddress = line.substring(2, 8);
                        int startIndex = 12, endIndex = 18, lastFormat = 0;
                        System.out.println(line.substring(9,11));

                        // Iteração pelo número de instruções da linha
                        for (int i = 0; i < (Integer.parseInt(line.substring(9, 11), 16)) / 3; i++) {
                            Instruction actual = new Instruction();
                            buffer = line.substring(startIndex, endIndex);

                            actual.setHexCode(buffer);
                            actual.setBinaryCode(Integer.toBinaryString(Integer.parseInt(buffer, 16)));
                            actual.setMnemonic(evaluateOpcode(buffer.substring(0, 2)));
                            actual.setFormat(calcInstructionFormat(actual.getMnemonic()));
                            actual.setAddress(Integer.toHexString((Integer.parseInt(baseAddress, 16)) + lastFormat));

                            instructionList.add(actual);

                            lastFormat = actual.getFormat();
                            startIndex += 7;
                            endIndex += 7;
                        }
                    } else if (line.charAt(0) == 'E') {
                        System.out.println("Cheguei ao End.");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao abrir o arquivo: " + e.getMessage());
        }

        return new Loaded(programName, initialAddress, programSize, instructionList);
    }

    String calcNextAddress(String instruction){
        return instruction;
    }

    static int calcInstructionFormat(String instruction){
        Set<String> type_2 = new HashSet<>(Arrays.asList(
                "ADDR", "CLEAR", "COMPR",
                "DIVR", "MULR", "RMO",
                "SHIFTL", "SUBR", "TIXR"));
        Set<String> type_3 = new HashSet<>(Arrays.asList(
                "ADD", "AND", "COMP", "DIV",
                "J", "JEQ", "JGT", "JLT",
                "JSUB", "LDA", "LDB", "LDCH",
                "LDL", "LDS", "LDT", "LDX",
                "MUL", "OR", "RSUB", "STA",
                "STB", "STCH", "STL", "STS",
                "STT", "STX", "SUB", "TIX"));
        if (type_2.contains(instruction)) {
            return 2;
        }
        if (type_3.contains(instruction)) {
            return 3;
        }
        return 0;
    }

    static String evaluateOpcode(String opCode){

        Map<String, String> opCodeList = new HashMap<>();
        opCodeList.put("00", "LDA");
        opCodeList.put("18", "ADD");
        opCodeList.put("90", "ADDR");
        opCodeList.put("40", "AND");
        opCodeList.put("01", "LDA");
        opCodeList.put("0C", "STA");
        opCodeList.put("B4", "CLEAR");
        opCodeList.put("28", "COMP");
        opCodeList.put("A0", "COMPR");
        opCodeList.put("24", "DIV");
        opCodeList.put("9C", "DIVR");
        opCodeList.put("3C", "J");
        opCodeList.put("30", "JEQ");
        opCodeList.put("34", "JGT");
        opCodeList.put("38", "JLT");
        opCodeList.put("48", "JSUB");
        opCodeList.put("68", "LDB");
        opCodeList.put("50", "LDCH");
        opCodeList.put("08", "LDL");
        opCodeList.put("6C", "LDS");
        opCodeList.put("74", "LDT");
        opCodeList.put("04", "LDX");
        opCodeList.put("20", "MUL");
        opCodeList.put("98", "MULR");
        opCodeList.put("44", "OR");
        opCodeList.put("AC", "RMO");
        opCodeList.put("4C", "RSUB");
        opCodeList.put("A4", "SHIFTL");
        opCodeList.put("A8", "SHIFTR");
        opCodeList.put("78", "STB");
        opCodeList.put("54", "STCH");
        opCodeList.put("14", "STL");
        opCodeList.put("7C", "STS");
        opCodeList.put("84", "STT");
        opCodeList.put("10", "STX");
        opCodeList.put("1C", "SUB");
        opCodeList.put("94", "SUBR");
        opCodeList.put("2C", "TIX");
        opCodeList.put("B8", "TIXR");

        return opCodeList.getOrDefault(opCode, null);
    }
}