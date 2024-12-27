public class Menu extends Entitas {
    private String nama;
    private String kategori;
    private double harga;

    public Menu(String id, String nama, String kategori, double harga) {
        super(id);
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}