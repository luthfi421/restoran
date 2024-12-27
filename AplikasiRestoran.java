import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AplikasiRestoran extends JFrame {
    private ArrayList<Menu> daftarMenu;
    private ArrayList<Meja> daftarMeja;
    private ArrayList<Pesanan> daftarPesanan;
    private ArrayList<Staf> daftarStaf;
    private ArrayList<BahanBaku> daftarBahanBaku;
    private int nomorAntrian;

    private JTextArea areaTeks;
    private JTextField inputPesananField;
    private JTextField inputMejaField;
    private JTextField inputNamaField;
    private JTextField inputTeleponField;

    public AplikasiRestoran() {
        daftarMenu = new ArrayList<>();
        daftarMeja = new ArrayList<>();
        daftarPesanan = new ArrayList<>();
        daftarStaf = new ArrayList<>();
        daftarBahanBaku = new ArrayList<>();
        nomorAntrian = 1;

        setTitle("Sistem Restoran Cerdas");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inisialisasiMenu();
        inisialisasiMeja();
        inisialisasiStaf();
        inisialisasiBahanBaku();


        JPanel navbar = new JPanel();
        navbar.setBackground(new Color(60, 63, 65));
        navbar.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton btnMenu = createNavButton("Menu");
        JButton btnPesanan = createNavButton("Pesanan");
        JButton btnMeja = createNavButton("Meja");
        JButton btnStaf = createNavButton("Staf");
        JButton btnBahanBaku = createNavButton("Bahan Baku");
        JButton btnUbahStatus = createNavButton("Ubah Status Pesanan");

        btnMenu.addActionListener(e -> tampilkanMenu());
        btnPesanan.addActionListener(e -> tampilkanPesanan());
        btnMeja.addActionListener(e -> tampilkanMeja());
        btnStaf.addActionListener(e -> tampilkanStaf());
        btnBahanBaku.addActionListener(e -> tampilkanBahanBaku());
        btnUbahStatus.addActionListener(e -> ubahStatusPesanan());

        navbar.add(btnMenu);
        navbar.add(btnPesanan);
        navbar.add(btnMeja);
        navbar.add(btnStaf);
        navbar.add(btnBahanBaku);
        navbar.add(btnUbahStatus);

        add(navbar, BorderLayout.NORTH);

        areaTeks = new JTextArea(20, 50);
        areaTeks.setEditable(false);
        areaTeks.setBackground(new Color(43, 43, 43));
        areaTeks.setForeground(new Color(255, 215, 0));
        areaTeks.setFont(new Font("Arial", Font.BOLD, 16));
        JScrollPane scrollPane = new JScrollPane(areaTeks);

        inputPesananField = new JTextField(30);
        inputMejaField = new JTextField(15);
        inputNamaField = new JTextField(30);
        inputTeleponField = new JTextField(15);

        JButton tombolPesan = new JButton("Pesan");
        tombolPesan.setFont(new Font("Arial", Font.BOLD, 14));
        tombolPesan.setBackground(new Color(76, 175, 80));
        tombolPesan.setForeground(Color.WHITE);
        tombolPesan.addActionListener(e -> ambilPesanan());

        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridy = 0;
        panelInput.add(new JLabel("Nama Pembeli:"), gbc);
        gbc.gridy = 1;
        panelInput.add(inputNamaField, gbc);
        gbc.gridy = 2;
        panelInput.add(new JLabel("Nomor Telepon:"), gbc);
        gbc.gridy = 3;
        panelInput.add(inputTeleponField, gbc);
        gbc.gridy = 4;
        panelInput.add(new JLabel("Nomor Meja:"), gbc);
        gbc.gridy = 5;
        panelInput.add(inputMejaField, gbc);
        gbc.gridy = 6;
        panelInput.add(new JLabel("ID Menu:"), gbc);
        gbc.gridy = 7;
        panelInput.add(inputPesananField, gbc);
        gbc.gridy = 8;
        panelInput.add(tombolPesan, gbc);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panelInput, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
        tampilkanMenu();
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(76, 175, 80));
        button.setForeground(Color.WHITE);
        return button;
    }

    private void inisialisasiMenu() {
        daftarMenu.add(new Menu("1", "Nasi Goreng", "Makanan", 15000));
        daftarMenu.add(new Menu("2", "Ayam Penyet", "Makanan", 25000));
        daftarMenu.add(new Menu("3", "Es Teh", "Minuman", 5000));
        daftarMenu.add(new Menu("4", "Kopi", "Minuman", 10000));
    }

    private void inisialisasiMeja() {
        daftarMeja.add(new Meja(1));
        daftarMeja.add(new Meja(2));
        daftarMeja.add(new Meja(3));
    }

    private void inisialisasiStaf() {
        daftarStaf.add(new Staf("1", "Budi", "Koki", "08:00 - 16:00"));
        daftarStaf.add(new Staf("2", "Siti", "Pelayan", "09:00 - 17:00"));
        daftarStaf.add(new Staf("3", "Andi", "Kasir", "10:00 - 18:00"));
    }

    private void inisialisasiBahanBaku() {
        daftarBahanBaku.add(new BahanBaku("1", "Beras", 100));
        daftarBahanBaku.add(new BahanBaku("2", "Ayam", 50));
        daftarBahanBaku.add(new BahanBaku("3", "Minyak Goreng", 30));
    }

    private void tampilkanMenu() {
        StringBuilder daftarMenuStr = new StringBuilder("Daftar Menu:\n");
        for (Menu menu : daftarMenu) {
            daftarMenuStr.append(menu.getId())
                    .append(". ")
                    .append(menu.getNama())
                    .append(" - ")
                    .append(menu.getHarga())
                    .append(" IDR\n");
        }
        areaTeks.setText(daftarMenuStr.toString());
    }

    private void tampilkanPesanan() {
        StringBuilder daftarPesananStr = new StringBuilder("Daftar Pesanan:\n");
        for (Pesanan pesanan : daftarPesanan) {
            daftarPesananStr.append(pesanan.getId())
                    .append(" - Meja: ")
                    .append(pesanan.getIdMeja())
                    .append(", Nama: ")
                    .append(pesanan.getNamaPembeli())
                    .append(", Telepon: ")
                    .append(pesanan.getTeleponPembeli())
                    .append(", Status: ")
                    .append(pesanan.getStatus())
                    .append("\n");
        }
        areaTeks.setText(daftarPesananStr.toString());
    }

    private void tampilkanMeja() {
        StringBuilder daftarMejaStr = new StringBuilder("Daftar Meja:\n");
        for (Meja meja : daftarMeja) {
            daftarMejaStr.append("Meja ")
                    .append(meja.getId())
                    .append(" - Status: ")
                    .append(meja.getStatus())
                    .append("\n");
        }
        areaTeks.setText(daftarMejaStr.toString());
    }

    private void tampilkanStaf() {
        StringBuilder daftarStafStr = new StringBuilder("Daftar Staf:\n");
        for (Staf staf : daftarStaf) {
            daftarStafStr.append(staf.getId())
                    .append(". ")
                    .append(staf.getNama())
                    .append(" - ")
                    .append(staf.getJabatan())
                    .append(" - Jam Kerja: ")
                    .append(staf.getJamKerja())
                    .append("\n");
        }
        areaTeks.setText(daftarStafStr.toString());
    }

    private void tampilkanBahanBaku() {
        StringBuilder daftarBahanBakuStr = new StringBuilder("Daftar Bahan Baku:\n");
        for (BahanBaku bahan : daftarBahanBaku) {
            daftarBahanBakuStr.append(bahan.getId())
                    .append(". ")
                    .append(bahan.getNama())
                    .append(" - Stok: ")
                    .append(bahan.getStok())
                    .append("\n");
        }
        areaTeks.setText(daftarBahanBakuStr.toString());
    }

    private void ambilPesanan() {
        String namaPembeli = inputNamaField.getText();
        String teleponPembeli = inputTeleponField.getText();
        String idMeja = inputMejaField.getText();
        String idMenu = inputPesananField.getText();

        if (namaPembeli.isEmpty() || teleponPembeli.isEmpty() || idMeja.isEmpty() || idMenu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap masukkan semua informasi.");
            return;
        }

        Meja meja = daftarMeja.stream()
                .filter(m -> m.getId().equals(idMeja))
                .findFirst()
                .orElse(null);

        if (meja == null || !meja.getStatus().equals("tersedia")) {
            JOptionPane.showMessageDialog(this, "Meja tidak tersedia.");
            return;
        }

        String[] ids = idMenu.split(",");
        StringBuilder ringkasanPesanan = new StringBuilder();
        double totalHarga = 0.0;

        for (String id : ids) {
            String trimmedId = id.trim();
            Menu menu = daftarMenu.stream()
                    .filter(m -> m.getId().equals(trimmedId))
                    .findFirst()
                    .orElse(null);
            if (menu != null) {
                ringkasanPesanan.append(menu.getNama()).append("\n");
                totalHarga += menu.getHarga();
            } else {
                System.out.println("Menu tidak ditemukan untuk ID: " + trimmedId);
            }
        }

        if (ringkasanPesanan.length() > 0) {
            Pesanan pesanan = new Pesanan("Pesanan" + nomorAntrian, idMeja, namaPembeli, teleponPembeli);
            daftarPesanan.add(pesanan);
            meja.setStatus("tidak tersedia");
            areaTeks.append("Pesanan untuk Meja " + idMeja + ":\n" + ringkasanPesanan);
            areaTeks.append("Total Harga: " + totalHarga + " IDR\n\n");
            nomorAntrian++;
        }

        inputPesananField.setText("");
        inputMejaField.setText("");
        inputNamaField.setText("");
        inputTeleponField.setText("");
    }

    private void ubahStatusPesanan() {
        String idPesanan = JOptionPane.showInputDialog(this, "Masukkan ID Pesanan:");
        Pesanan pesanan = daftarPesanan.stream()
                .filter(p -> p.getId().equals(idPesanan))
                .findFirst()
                .orElse(null);

        if (pesanan == null) {
            JOptionPane.showMessageDialog(this, "Pesanan tidak ditemukan.");
            return;
        }

        String[] statusOptions = {"DALAM_ANTREAN", "SEDANG_DIMASAK", "SELESAI"};
        String statusBaru = (String) JOptionPane.showInputDialog(this,
                "Pilih status baru:",
                "Ubah Status Pesanan",
                JOptionPane.PLAIN_MESSAGE,
                null,
                statusOptions,
                statusOptions[0]);

        if (statusBaru != null) {
            pesanan.setStatus(statusBaru);

            if (statusBaru.equals("SELESAI")) {
                Meja meja = daftarMeja.stream()
                        .filter(m -> m.getId().equals(pesanan.getIdMeja()))
                        .findFirst()
                        .orElse(null);
                if (meja != null) {
                    meja.setStatus("tersedia");
                }
            }

            JOptionPane.showMessageDialog(this, "Status pesanan telah diperbarui.");
            tampilkanPesanan();
            tampilkanMeja();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AplikasiRestoran app = new AplikasiRestoran();
            app.setVisible(true);
        });
    }
}