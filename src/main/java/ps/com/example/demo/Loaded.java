package ps.com.example.demo;

class Loaded {
    char type;
    String data;

    Loaded (char type, String data) {
        this.type = type;
        this.data = data;
    }
    public String toString() {
        return "" + type + data;
    }

    public String[] toBinary() {

        //Remove os espaços e divide em substrings
        String[] substrings = data.trim().split("\\s+");
        String[] binarios = new String[substrings.length];

        if (type == 'H'){
            return substrings;
        }

        for (int i = 0; i < substrings.length ; i++){
            int valor = Integer.parseInt(substrings[i]);
            binarios[i] = Integer.toBinaryString(valor);
        }

        //Retorna uma array de Strings em binário que representa a linha de código de máquina
        return binarios;
    }
}
