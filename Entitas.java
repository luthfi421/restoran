public abstract class Entitas implements DapatDiidentifikasi {
    protected String id;

    public Entitas(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}