package View;

import javax.swing.JOptionPane;


public class SIAView {
    public void printData(String data, String nama, String instance){
        JOptionPane.showMessageDialog(null, data, "Data " + instance + " " + nama , 1);
    }
    public void printNA(String NA){
        JOptionPane.showMessageDialog(null, NA, "Nilai Akhir", 1);
    }
    public void printJmlMhsTidakLulus(String jmlMhsAmbil, String jmlMhsTidakLulus, String namaMK){
        JOptionPane.showMessageDialog(null, jmlMhsTidakLulus + "/" +jmlMhsAmbil + " Mahasiswa", "Tidak Lolos " + namaMK, 0);
    }
    public void printMatkulDiambilPlusAbsen(String data, String jmlHadir, String jmlHari){
        JOptionPane.showMessageDialog(null, data + "\nDengan kehadiran: " + jmlHadir + "/" + jmlHari, "MataKuliah Diambil", 1);
    }
    public void printJamHadirDosen(String jam, String nama){
        JOptionPane.showMessageDialog(null, "Dosen: " + nama + "\nMengajar selama: " + jam + " jam", "Kehadiran Dosen", 1);
    }
    public void printGajiStaff(String gaji, String nik){
        JOptionPane.showMessageDialog(null, "Dosen dengan nik: " + nik + "\nMemiliki gaji sebesar: " + gaji, "Gaji Staff", 1);
    }
}
