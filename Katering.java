public class Katering implements DapatDiperbaruiStatus {
    private String id;
    private String nama;
    private String status;

    public Katering(String id, String nama) {
        this.id = id;
        this.nama = nama;
        this.status = "Tersedia";
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
}