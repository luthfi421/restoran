public class MenuItem extends Item {
    private String kategori;

    public MenuItem(int id, String nama, double harga, String kategori) {
        super(id, nama, harga);
        this.kategori = kategori;
    }

    public String getKategori() {
        return kategori;
    }

    @Override
    public String toString() {
        return super.toString() + ", Kategori: " + kategori;
    }
}
