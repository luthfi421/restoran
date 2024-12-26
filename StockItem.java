public class StockItem extends Item {
    private int jumlah;

    public StockItem(int id, String nama, double harga, int jumlah) {
        super(id, nama, harga);
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return super.toString() + ", Jumlah: " + jumlah;
    }
}