public class Meja extends Entitas implements DapatDiperbaruiStatus {
    private String status;

    public Meja(int id) {
        super(String.valueOf(id));
        this.status = "tersedia";
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        return status;
    }
}