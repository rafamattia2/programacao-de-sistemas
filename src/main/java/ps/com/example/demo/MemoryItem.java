package ps.com.example.demo;

public class MemoryItem implements Comparable<MemoryItem>{
    private String address;
    private byte memData;

    public MemoryItem(String address, byte memData) {
        this.address = address;
        this.memData = memData;
    }

    public String getAddress() {
        return address;
    }

    public byte getMemData() {
        return memData;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MemoryItem)) {
            return false;
        }
        MemoryItem other = (MemoryItem) obj;
        return this.address.equals(other.address);
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }

    @Override
    public int compareTo(MemoryItem other) {
        return Integer.parseInt(this.address, 16) - Integer.parseInt(other.address, 16);
    }
}
