public class Pesanan extends Entitas implements DapatDiperbaruiStatus {
    private String idMeja;
    private String namaPembeli;
    private String teleponPembeli;
    private Status status;

    public Pesanan(String id, String idMeja, String namaPembeli, String teleponPembeli) {
        super(id);
        this.idMeja = idMeja;
        this.namaPembeli = namaPembeli;
        this.teleponPembeli = teleponPembeli;
        this.status = Status.DALAM_ANTREAN;
    }

    public String getIdMeja() {
        return idMeja;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public String getTeleponPembeli() {
        return teleponPembeli;
    }

    @Override
    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    @Override
    public String getStatus() {
        return status.name();
    }

    public enum Status {
        DALAM_ANTREAN,
        SEDANG_DIMASAK,
        SELESAI
    }
}