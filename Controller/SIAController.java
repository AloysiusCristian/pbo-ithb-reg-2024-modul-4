package Controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Module.*;
import View.*;

public class SIAController {
    private ArrayList<Mahasiswa> listMahasiswa;
    private ArrayList<Staff> listStaff;
    private Matakuliah[] listMatakuliah;
    private SIAView view;

    public SIAController(ArrayList<Mahasiswa> listMahasiswa, ArrayList<Staff> listStaff, Matakuliah[] listMatakuliah, SIAView view){
        this.listMahasiswa = listMahasiswa;
        this.listMatakuliah = listMatakuliah;
        this.listStaff = listStaff;
        this.view = view;
    }

    public void searchUser(String nama){
        boolean notFound = true;
        for (Mahasiswa mahasiswa : listMahasiswa) {
            if (mahasiswa.getNama().equalsIgnoreCase(nama)) {
                notFound = false;
                String instance;
                if (mahasiswa instanceof Sarjana) {
                    instance = "Sarjana";
                }
                if (mahasiswa instanceof Magister) {
                    instance = "Magister";
                }
                else{
                    instance = "Doktor";
                }
                view.printData(mahasiswa.toString(), nama, instance);
            }
        }
        for (Staff staff : listStaff) {
            if (staff.getNama().equalsIgnoreCase(nama)) {
                notFound = false;
                String instance;
                if (staff instanceof DosenHonorer) {
                    instance = "Dosen Honorer";
                }
                if (staff instanceof DosenTetap) {
                    instance = "Dosen Tetap";
                }
                else{
                    instance = "Karyawan";
                }
                view.printData(staff.toString(), nama, instance);
            }
        }
        if (notFound) {
            JOptionPane.showMessageDialog(null, "User Tidak Ketemu", "ERROR", 0);
        }
    }

    public double countNA(String nim, String kodeMK){
        double rata2 = 0;
        for (Mahasiswa mahasiswa : listMahasiswa) {
            if (mahasiswa.getNim().equalsIgnoreCase(nim)) {
                if (mahasiswa instanceof Doktor) {
                    double nilai = 0;
                    nilai += ((Doktor)mahasiswa).getN1();
                    nilai += ((Doktor)mahasiswa).getN2();
                    nilai += ((Doktor)mahasiswa).getN3();
                    rata2 = nilai/3;
                    return rata2;
                }
                else{
                    ArrayList<MatkulAmbil> matkulAmbil = new ArrayList<MatkulAmbil>();;
                    if(mahasiswa instanceof Magister){
                        matkulAmbil = ((Magister)mahasiswa).getMataKuliahDiambil();
                    }
                    else{
                        matkulAmbil = ((Sarjana)mahasiswa).getMataKuliahDiambil();
                    }
                    for (MatkulAmbil matkul : matkulAmbil) {
                        if (matkul.getMatakuliah().getKode().equalsIgnoreCase(kodeMK)) { // anehnya ini logic udah bener jir?
                            double nilai = 0;
                            nilai += matkul.getN1();
                            nilai += matkul.getN2();
                            nilai += matkul.getN3();
                            rata2 = nilai/3;
                            return rata2;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public void printNAperMHS(String nim, String kodeMK){
        double na = countNA(nim, kodeMK);
        if (na == -1) {
            view.printNA("Data Tidak Ditemukan");
        }
        else{
            view.printNA("" + na);
        }
    }

    public void printNASatuMK(String kodeMK){
        double count = 0;
        double totalna = 0;
        for (Mahasiswa mahasiswa : listMahasiswa) {
            if (mahasiswa instanceof Magister) {
                double temp = countNA(mahasiswa.getNim(), kodeMK);
                if (temp > 0) {
                    count++;
                    totalna += temp;
                }
            }
            else if(mahasiswa instanceof Sarjana){
                double temp = countNA(mahasiswa.getNim(), kodeMK);
                if (temp > 0) {
                    count++;
                    totalna += temp;
                }
            }
        }
        if (count == 0) {
            count = 1;
        }
        view.printNA("" + totalna/count);
    }

    public void printTidakLulus(String kodeMK){
        int jmlTidakLulus = 0;
        int jmlMhsAmbilMK = 0;
        String namaMK = "";
        for (Matakuliah matkul : listMatakuliah) {
            if (matkul.getKode().equalsIgnoreCase(kodeMK)) {
                namaMK = matkul.getNama();
                break;
            }
        }
        for (Mahasiswa mahasiswa : listMahasiswa) {
            if (mahasiswa instanceof Magister) {
                double na = countNA(mahasiswa.getNim(), kodeMK);
                if (na < 56 & na > -1) {
                    jmlTidakLulus++;
                }
                if (na > -1) {
                    jmlMhsAmbilMK++;
                };
            }
            else if(mahasiswa instanceof Sarjana){
                double na = countNA(mahasiswa.getNim(), kodeMK);
                if (na < 56 & na > -1) {
                    jmlTidakLulus++;
                }
                if (na > -1) {
                    jmlMhsAmbilMK++;
                };
            }
        }
        view.printJmlMhsTidakLulus("" + jmlMhsAmbilMK, "" + jmlTidakLulus, namaMK);
    }

    public void printMatkulDiambilPlusAbsen(String nim){
        for (Mahasiswa mahasiswa : listMahasiswa) {
            if (mahasiswa.getNim().equalsIgnoreCase(nim)) {
                if (mahasiswa instanceof Sarjana) {
                    ArrayList<MatkulAmbil> matkulAmbil =  ((Sarjana)mahasiswa).getMataKuliahDiambil();
                    for (MatkulAmbil matkul : matkulAmbil) {
                        int countHadir = 0;
                        for (Presensi presensi : matkul.getPresensi()) {
                            if (presensi.getStatus() == StatusHadir.HADIR) {
                                countHadir++;
                            }
                        }
                        view.printMatkulDiambilPlusAbsen(matkul.toString(), "" + countHadir, "" + matkul.getPresensi().size());
                    }
                }
                if (mahasiswa instanceof Magister) {
                    ArrayList<MatkulAmbil> matkulAmbil =  ((Magister)mahasiswa).getMataKuliahDiambil();
                    for (MatkulAmbil matkul : matkulAmbil) {
                        int countHadir = 0;
                        for (Presensi presensi : matkul.getPresensi()) {
                            if (presensi.getStatus() == StatusHadir.HADIR) {
                                countHadir++;
                            }
                        }
                        view.printMatkulDiambilPlusAbsen(matkul.toString(), "" + countHadir, "" + matkul.getPresensi().size());
                    }
                }
            }
        }
    }

    public int countJamHadirStaff(String nik){
        int jamHadir = 0;
        for (Staff staff : listStaff) {
            if (staff.getNik().equalsIgnoreCase(nik)) {
                    if (staff instanceof DosenHonorer) {
                        ArrayList<MatkulAjar> listMatkul = ((DosenHonorer)staff).getMataKuliahDiajar();
                        for (MatkulAjar matkulAjar : listMatkul) {
                            ArrayList<PresensiStaff> listPresensi = matkulAjar.getPresensi();
                            for (PresensiStaff presensiStaff : listPresensi) {
                                if (presensiStaff.getStatus() == StatusHadir.HADIR) {
                                    jamHadir += matkulAjar.getMatakuliah().getSks();
                                }
                            }
                        }
                    }
                    else if (staff instanceof DosenTetap) {
                        ArrayList<MatkulAjar> listMatkul = ((DosenTetap)staff).getMataKuliahDiajar();
                        for (MatkulAjar matkulAjar : listMatkul) {
                            ArrayList<PresensiStaff> listPresensi = matkulAjar.getPresensi();
                            for (PresensiStaff presensiStaff : listPresensi) {
                                if (presensiStaff.getStatus() == StatusHadir.HADIR) {
                                    jamHadir += matkulAjar.getMatakuliah().getSks();
                                }
                            }
                        }
                    }
                    else{
                        ArrayList<PresensiStaff> listPresensi = ((Karyawan)staff).getPresensi();
                        for (PresensiStaff presensiStaff : listPresensi) {
                            if (presensiStaff.getStatus() == StatusHadir.HADIR) {
                                //Anggap 1 hari maksudnya bukan 1 jam untuk karyawan
                                jamHadir += 1;
                            }
                        }
                    }
                return jamHadir;
            }
        }
        return -1;
    }

    public void printJamHadirStaff(String nik){
        for (Staff staff : listStaff) {
            if (staff.getNik().equalsIgnoreCase(nik)) {
                int jamHadir = countJamHadirStaff(nik);
                view.printJamHadirDosen("" + jamHadir, staff.getNama());
                break;
            }
        }
    }
    
    public void printGajiStaff(String nik){
        double gaji = 0;
        double jamHadir = countJamHadirStaff(nik);
        double totalGaji = 0;
        for (Staff staff : listStaff) {
            if (staff.getNik().equalsIgnoreCase(nik)) {
                if (staff instanceof Karyawan) {
                    gaji = ((Karyawan)staff).getSalary();
                    totalGaji = jamHadir/22 * gaji;
                }
                else if(staff instanceof DosenTetap){
                    gaji = ((DosenTetap)staff).getSalary();
                    totalGaji = gaji + (jamHadir * 25000);
                }
                else{
                    gaji = ((DosenHonorer)staff).getHonorPerSKS();
                    totalGaji = jamHadir * gaji;
                }
                view.printGajiStaff("" + totalGaji, staff.getNama());
                break;
            }
        }
    }
}