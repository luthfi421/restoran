public class Staf {
    private String id;
    private String nama;
    private String jabatan;
    private String jamKerja;

    public Staf(String id, String nama, String jabatan, String jamKerja) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
        this.jamKerja = jamKerja;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public String getJamKerja() {
        return jamKerja;
    }
}