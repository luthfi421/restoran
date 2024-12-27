public class BahanBaku {
    private String id;
    private String nama;
    private int stok;

    public BahanBaku(String id, String nama, int stok) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}