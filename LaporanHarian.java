public class LaporanHarian {
    private double totalPendapatan;

    public LaporanHarian() {
        this.totalPendapatan = 0.0;
    }

    public void tambahkanPendapatan(double pendapatan) {
        totalPendapatan += pendapatan;
    }

    public double getTotalPendapatan() {
        return totalPendapatan;
    }
}