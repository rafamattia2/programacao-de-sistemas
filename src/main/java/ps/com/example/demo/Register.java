package ps.com.example.demo;

public class Register{
    private int A; // Acumulador
    private int X; // Registrador de índice
    private int L; // Registrador de ligação
    private int B; // Registrador Base
    private int S; // Registrador de uso geral
    private int T; // Registrador de uso geral
    private long F; // Acumulador de ponto flutuante
    private int PC; // Contador de Instruções (Program Counter)
    private int SW; // Palavra de status

    public Register() {
        // inicializa os registradores com valor 0
        this.A = 0;
        this.X = 0;
        this.L = 0;
        this.B = 0;
        this.S = 0;
        this.T = 0;
        this.F = 0L;
        this.PC = 0;
        this.SW = 0;
    }

    // getters e setters para cada registrador
    public int getA() {
        return this.A;
    }

    public void setA(int a) {
        this.A = a;
    }

    public int getX() {
        return this.X;
    }

    public void setX(int x) {
        this.X = x;
    }

    public int getL() {
        return this.L;
    }

    public void setL(int l) {
        this.L = l;
    }

    public int getB() {
        return this.B;
    }

    public void setB(int b) {
        this.B = b;
    }

    public int getS() {
        return this.S;
    }

    public void setS(int s) {
        this.S = s;
    }

    public int getT() {
        return this.T;
    }

    public void setT(int t) {
        this.T = t;
    }

    public long getF() {
        return this.F;
    }

    public void setF(long f) {
        this.F = f;
    }

    public int getPC() {
        return this.PC;
    }

    public void setPC(int pc) {
        this.PC = pc;
    }

    public int getSW() {
        return this.SW;
    }

    public void setSW(int sw) {
        this.SW = sw;
    }

    public void reset(){
        this.A = 0;
        this.X = 0;
        this.L = 0;
        this.B = 0;
        this.S = 0;
        this.T = 0;
        this.F = 0L;
        this.PC = 0;
        this.SW = 0;
    }
}
