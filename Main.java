import Module.*;
import View.*;
import Controller.*;

import java.sql.Time;
import java.util.*;

import javax.swing.JOptionPane;

public class Main {
    static ArrayList<Mahasiswa> listMahasiswa = new ArrayList<Mahasiswa>();
    static ArrayList<Staff> listStaff =  new ArrayList<Staff>();
    static Matakuliah[] listMatkul = new Matakuliah[20];

    public static void createDummy(){
        listMatkul[0] = new Matakuliah("001", "Desain Website", 2);
        listMatkul[1] = new Matakuliah("002", "Algoritma", 4);
        listMatkul[2] = new Matakuliah("003", "Praktikum Algoritma", 1);
        listMatkul[3] = new Matakuliah("004", "PTI", 3);
        listMatkul[4] = new Matakuliah("005", "Indo", 2);
        listMatkul[5] = new Matakuliah("001", "DesWeb", 2);
        listMatkul[6] = new Matakuliah("006", "Pancasila", 2);
        listMatkul[7] = new Matakuliah("007", "Statistika", 3);
        listMatkul[8] = new Matakuliah("008", "Basis Data", 4);
        listMatkul[9] = new Matakuliah("009", "Sistem Operasi", 3);
        listMatkul[10] = new Matakuliah("010", "Pemrograman Java", 4);
        listMatkul[11] = new Matakuliah("011", "Struktur Data", 3);
        listMatkul[12] = new Matakuliah("012", "Jaringan Komputer", 3);
        listMatkul[13] = new Matakuliah("013", "Kalkulus", 4);
        listMatkul[14] = new Matakuliah("014", "Sistem Informasi", 3);
        listMatkul[15] = new Matakuliah("015", "Manajemen Proyek", 2);
        listMatkul[16] = new Matakuliah("016", "Pemrograman Python", 4);
        listMatkul[17] = new Matakuliah("017", "Etika Profesi", 2);
        listMatkul[18] = new Matakuliah("018", "Teori Graf", 3);
        listMatkul[19] = new Matakuliah("019", "Pemrograman Mobile", 4);

        Presensi[] listPresensi = new Presensi[10];
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 10; i++) {
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, i);
            StatusHadir status;
            if (i % 2 == 0) {
                status = StatusHadir.HADIR;
            }
            else{
                status = StatusHadir.ALPHA;
            }
            listPresensi[i] = new Presensi(calendar.getTime(), status);
        }

        Doktor doktorDion = new Doktor("Dionisius", "Bandung", "Bandung", "082", "112201", "IF", "CNN", 90, 90, 99);
        listMahasiswa.add(doktorDion);
        Doktor doktorAmelia = new Doktor("Amelia", "Jakarta", "Jakarta", "083", "112202", "CS", "Deep Learning", 85, 88, 95);
        listMahasiswa.add(doktorAmelia);
        Doktor doktorBudi = new Doktor("Budi", "Surabaya", "Surabaya", "084", "112203", "IT", "Natural Language Processing", 78, 84, 89);
        listMahasiswa.add(doktorBudi);
        Doktor doktorClara = new Doktor("Clara", "Bandung", "Bandung", "085", "112204", "SE", "Cyber Security", 92, 90, 94);
        listMahasiswa.add(doktorClara);
                
        ArrayList<Presensi> listPresensiRichie = new ArrayList<>();
        listPresensiRichie.add(listPresensi[0]);
        listPresensiRichie.add(listPresensi[2]);
        listPresensiRichie.add(listPresensi[3]);
        listPresensiRichie.add(listPresensi[6]);
        listPresensiRichie.add(listPresensi[8]);
        ArrayList<MatkulAmbil> listMatkulRichie = new ArrayList<>();
        listMatkulRichie.add(new MatkulAmbil(listMatkul[1], listPresensiRichie, 70, 80, 90));
        listMatkulRichie.add(new MatkulAmbil(listMatkul[3], listPresensiRichie, 80, 90, 90));
        listMatkulRichie.add(new MatkulAmbil(listMatkul[0], listPresensiRichie, 70, 93, 76));
        Magister magisterRichie = new Magister("Richie", "Bandung", "Bandung", "081", "112302", "IF", listMatkulRichie, "AI");
        listMahasiswa.add(magisterRichie);

        ArrayList<Presensi> listPresensiAlex = new ArrayList<>();
        listPresensiAlex.add(listPresensi[1]);
        listPresensiAlex.add(listPresensi[3]);
        listPresensiAlex.add(listPresensi[5]);
        listPresensiAlex.add(listPresensi[7]);
        listPresensiAlex.add(listPresensi[9]);
        ArrayList<MatkulAmbil> listMatkulAlex = new ArrayList<>();
        listMatkulAlex.add(new MatkulAmbil(listMatkul[2], listPresensiAlex, 65, 75, 85));
        listMatkulAlex.add(new MatkulAmbil(listMatkul[4], listPresensiAlex, 88, 79, 92));
        listMatkulAlex.add(new MatkulAmbil(listMatkul[5], listPresensiAlex, 78, 84, 80));
        Magister magisterAlex = new Magister("Alex", "Jakarta", "Jakarta", "082", "112301", "IF", listMatkulAlex, "ML");
        listMahasiswa.add(magisterAlex);

        ArrayList<Presensi> listPresensiNina = new ArrayList<>();
        listPresensiNina.add(listPresensi[2]);
        listPresensiNina.add(listPresensi[4]);
        listPresensiNina.add(listPresensi[6]);
        listPresensiNina.add(listPresensi[8]);
        listPresensiNina.add(listPresensi[1]);
        ArrayList<MatkulAmbil> listMatkulNina = new ArrayList<>();
        listMatkulNina.add(new MatkulAmbil(listMatkul[3], listPresensiNina, 85, 88, 90));
        listMatkulNina.add(new MatkulAmbil(listMatkul[5], listPresensiNina, 70, 80, 88));
        listMatkulNina.add(new MatkulAmbil(listMatkul[6], listPresensiNina, 82, 90, 86));
        Magister magisterNina = new Magister("Nina", "Surabaya", "Surabaya", "083", "112304", "IF", listMatkulNina, "Data Science");
        listMahasiswa.add(magisterNina);

        ArrayList<Presensi> listPresensiLiam = new ArrayList<>();
        listPresensiLiam.add(listPresensi[0]);
        listPresensiLiam.add(listPresensi[2]);
        listPresensiLiam.add(listPresensi[4]);
        listPresensiLiam.add(listPresensi[7]);
        listPresensiLiam.add(listPresensi[9]);
        ArrayList<MatkulAmbil> listMatkulLiam = new ArrayList<>();
        listMatkulLiam.add(new MatkulAmbil(listMatkul[7], listPresensiLiam, 40, 40, 40));
        listMatkulLiam.add(new MatkulAmbil(listMatkul[8], listPresensiLiam, 40, 40, 40));
        listMatkulLiam.add(new MatkulAmbil(listMatkul[9], listPresensiLiam, 40, 40, 40));
        Magister magisterLiam = new Magister("Liam", "Bandung", "Bandung", "084", "112305", "IF", listMatkulLiam, "Cyber Security");
        listMahasiswa.add(magisterLiam);

        ArrayList<Presensi> listPresensiAloy = new ArrayList<>();
        listPresensiAloy.add(listPresensi[0]);
        listPresensiAloy.add(listPresensi[2]);
        listPresensiAloy.add(listPresensi[4]);
        listPresensiAloy.add(listPresensi[7]);
        listPresensiAloy.add(listPresensi[9]);
        ArrayList<MatkulAmbil> listMatkulAloy = new ArrayList<>();
        listMatkulAloy.add(new MatkulAmbil(listMatkul[1], listPresensiAloy, 70, 80, 90));
        listMatkulAloy.add(new MatkulAmbil(listMatkul[3], listPresensiAloy, 80, 90, 90));
        listMatkulAloy.add(new MatkulAmbil(listMatkul[0], listPresensiAloy, 70, 93, 76));
        Sarjana sarjanaAloy = new Sarjana("Aloy", "Bandung", "Bandung", "083", "112303", "IF", listMatkulAloy);
        listMahasiswa.add(sarjanaAloy);

        ArrayList<Presensi> listPresensiBudi = new ArrayList<>();
        listPresensiBudi.add(listPresensi[1]);
        listPresensiBudi.add(listPresensi[3]);
        listPresensiBudi.add(listPresensi[5]);
        listPresensiBudi.add(listPresensi[6]);
        listPresensiBudi.add(listPresensi[8]);
        ArrayList<MatkulAmbil> listMatkulBudi = new ArrayList<>();
        listMatkulBudi.add(new MatkulAmbil(listMatkul[2], listPresensiBudi, 40, 40, 40));
        listMatkulBudi.add(new MatkulAmbil(listMatkul[4], listPresensiBudi, 40, 40, 40));
        listMatkulBudi.add(new MatkulAmbil(listMatkul[5], listPresensiBudi, 40, 40, 40));
        Sarjana sarjanaBudi = new Sarjana("Budi", "Jakarta", "Jakarta", "084", "112304", "TI", listMatkulBudi);
        listMahasiswa.add(sarjanaBudi);

        ArrayList<Presensi> listPresensiClara = new ArrayList<>();
        listPresensiClara.add(listPresensi[0]);
        listPresensiClara.add(listPresensi[2]);
        listPresensiClara.add(listPresensi[6]);
        listPresensiClara.add(listPresensi[8]);
        listPresensiClara.add(listPresensi[9]);
        ArrayList<MatkulAmbil> listMatkulClara = new ArrayList<>();
        listMatkulClara.add(new MatkulAmbil(listMatkul[3], listPresensiClara, 82, 85, 90));
        listMatkulClara.add(new MatkulAmbil(listMatkul[6], listPresensiClara, 75, 80, 84));
        listMatkulClara.add(new MatkulAmbil(listMatkul[7], listPresensiClara, 89, 92, 88));
        Sarjana sarjanaClara = new Sarjana("Clara", "Surabaya", "Surabaya", "085", "112305", "SE", listMatkulClara);
        listMahasiswa.add(sarjanaClara);

        ArrayList<Presensi> listPresensiDewi = new ArrayList<>();
        listPresensiDewi.add(listPresensi[1]);
        listPresensiDewi.add(listPresensi[3]);
        listPresensiDewi.add(listPresensi[4]);
        listPresensiDewi.add(listPresensi[7]);
        listPresensiDewi.add(listPresensi[8]);
        ArrayList<MatkulAmbil> listMatkulDewi = new ArrayList<>();
        listMatkulDewi.add(new MatkulAmbil(listMatkul[1], listPresensiDewi, 40, 40, 40));
        listMatkulDewi.add(new MatkulAmbil(listMatkul[5], listPresensiDewi, 40, 40, 40));
        listMatkulDewi.add(new MatkulAmbil(listMatkul[8], listPresensiDewi, 40, 40, 40));
        Sarjana sarjanaDewi = new Sarjana("Dewi", "Malang", "Malang", "086", "112306", "SI", listMatkulDewi);
        listMahasiswa.add(sarjanaDewi);

        PresensiStaff[] listPresensiStaff = new PresensiStaff[10];
        for (int i = 0; i < 10; i++) {
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, i);
            StatusHadir status;
            if (i % 2 == 0) {
                status = StatusHadir.HADIR;
            }
            else{
                status = StatusHadir.ALPHA;
            }
            listPresensiStaff[i] = new PresensiStaff(calendar.getTime(), status, new Time(0));
        }

        ArrayList<PresensiStaff> listPresensiBuInge = new ArrayList<PresensiStaff>();
        listPresensiBuInge.add(listPresensiStaff[0]);
        listPresensiBuInge.add(listPresensiStaff[2]);
        listPresensiBuInge.add(listPresensiStaff[4]);
        listPresensiBuInge.add(listPresensiStaff[6]);
        listPresensiBuInge.add(listPresensiStaff[8]);
        ArrayList<MatkulAjar> listMatkulBuInge = new ArrayList<MatkulAjar>();
        listMatkulBuInge.add(new MatkulAjar(listMatkul[1], listPresensiBuInge));
        listMatkulBuInge.add(new MatkulAjar(listMatkul[3], listPresensiBuInge));
        DosenTetap dosenTetap1 = new DosenTetap("Ibu Inge", "Bandung", "Bandung", "0889", "118", "IF", listMatkulBuInge, 150000);
        listStaff.add(dosenTetap1);

        ArrayList<PresensiStaff> listPresensiBapakJoko = new ArrayList<PresensiStaff>();
        listPresensiBapakJoko.add(listPresensiStaff[1]);
        listPresensiBapakJoko.add(listPresensiStaff[3]);
        listPresensiBapakJoko.add(listPresensiStaff[5]);
        listPresensiBapakJoko.add(listPresensiStaff[7]);
        listPresensiBapakJoko.add(listPresensiStaff[9]);
        ArrayList<MatkulAjar> listMatkulBapakJoko = new ArrayList<MatkulAjar>();
        listMatkulBapakJoko.add(new MatkulAjar(listMatkul[2], listPresensiBapakJoko));
        listMatkulBapakJoko.add(new MatkulAjar(listMatkul[4], listPresensiBapakJoko));
        DosenTetap dosenTetap2 = new DosenTetap("Bapak Joko", "Jakarta", "Jakarta", "0890", "119", "SI", listMatkulBapakJoko, 160000);
        listStaff.add(dosenTetap2);

        ArrayList<PresensiStaff> listPresensiIbuSari = new ArrayList<PresensiStaff>();
        listPresensiIbuSari.add(listPresensiStaff[0]);
        listPresensiIbuSari.add(listPresensiStaff[2]);
        listPresensiIbuSari.add(listPresensiStaff[6]);
        listPresensiIbuSari.add(listPresensiStaff[8]);
        listPresensiIbuSari.add(listPresensiStaff[4]);
        ArrayList<MatkulAjar> listMatkulIbuSari = new ArrayList<MatkulAjar>();
        listMatkulIbuSari.add(new MatkulAjar(listMatkul[5], listPresensiIbuSari));
        listMatkulIbuSari.add(new MatkulAjar(listMatkul[6], listPresensiIbuSari));
        DosenTetap dosenTetap3 = new DosenTetap("Ibu Sari", "Yogyakarta", "Yogyakarta", "0891", "120", "TI", listMatkulIbuSari, 155000);
        listStaff.add(dosenTetap3);

        ArrayList<PresensiStaff> listPresensiBapakAli = new ArrayList<PresensiStaff>();
        listPresensiBapakAli.add(listPresensiStaff[1]);
        listPresensiBapakAli.add(listPresensiStaff[3]);
        listPresensiBapakAli.add(listPresensiStaff[5]);
        listPresensiBapakAli.add(listPresensiStaff[7]);
        listPresensiBapakAli.add(listPresensiStaff[9]);
        ArrayList<MatkulAjar> listMatkulBapakAli = new ArrayList<MatkulAjar>();
        listMatkulBapakAli.add(new MatkulAjar(listMatkul[7], listPresensiBapakAli));
        listMatkulBapakAli.add(new MatkulAjar(listMatkul[8], listPresensiBapakAli));
        DosenTetap dosenTetap4 = new DosenTetap("Bapak Ali", "Surabaya", "Surabaya", "0892", "121", "KOM", listMatkulBapakAli, 165000);
        listStaff.add(dosenTetap4);

        ArrayList<PresensiStaff> listPresensiKoHans = new ArrayList<PresensiStaff>();
        listPresensiKoHans.add(listPresensiStaff[1]);
        listPresensiKoHans.add(listPresensiStaff[3]);
        listPresensiKoHans.add(listPresensiStaff[5]);
        listPresensiKoHans.add(listPresensiStaff[7]);
        listPresensiKoHans.add(listPresensiStaff[9]);
        ArrayList<MatkulAjar> listMatkulKoHans = new ArrayList<MatkulAjar>();
        listMatkulKoHans.add(new MatkulAjar(listMatkul[0], listPresensiKoHans));
        listMatkulKoHans.add(new MatkulAjar(listMatkul[2], listPresensiKoHans));
        listMatkulKoHans.add(new MatkulAjar(listMatkul[4], listPresensiKoHans));
        DosenHonorer dosenHonorer1 = new DosenHonorer("Ko Hans", "Bandung", "Bandung", "0898", "122", "IF", listMatkulKoHans, 20000);
        listStaff.add(dosenHonorer1);
        
        // Dummy 2
        ArrayList<PresensiStaff> listPresensiBuRina = new ArrayList<PresensiStaff>();
        listPresensiBuRina.add(listPresensiStaff[0]);
        listPresensiBuRina.add(listPresensiStaff[2]);
        listPresensiBuRina.add(listPresensiStaff[4]);
        listPresensiBuRina.add(listPresensiStaff[6]);
        listPresensiBuRina.add(listPresensiStaff[8]);
        ArrayList<MatkulAjar> listMatkulBuRina = new ArrayList<MatkulAjar>();
        listMatkulBuRina.add(new MatkulAjar(listMatkul[1], listPresensiBuRina));
        listMatkulBuRina.add(new MatkulAjar(listMatkul[3], listPresensiBuRina));
        listMatkulBuRina.add(new MatkulAjar(listMatkul[5], listPresensiBuRina));
        DosenHonorer dosenHonorer2 = new DosenHonorer("Bu Rina", "Jakarta", "Jakarta", "0900", "123", "IF", listMatkulBuRina, 25000);
        listStaff.add(dosenHonorer2);
        
        // Dummy 3
        ArrayList<PresensiStaff> listPresensiKoJoko = new ArrayList<PresensiStaff>();
        listPresensiKoJoko.add(listPresensiStaff[1]);
        listPresensiKoJoko.add(listPresensiStaff[3]);
        listPresensiKoJoko.add(listPresensiStaff[5]);
        listPresensiKoJoko.add(listPresensiStaff[7]);
        listPresensiKoJoko.add(listPresensiStaff[9]);
        ArrayList<MatkulAjar> listMatkulKoJoko = new ArrayList<MatkulAjar>();
        listMatkulKoJoko.add(new MatkulAjar(listMatkul[2], listPresensiKoJoko));
        listMatkulKoJoko.add(new MatkulAjar(listMatkul[4], listPresensiKoJoko));
        listMatkulKoJoko.add(new MatkulAjar(listMatkul[6], listPresensiKoJoko));
        DosenHonorer dosenHonorer3 = new DosenHonorer("Ko Joko", "Yogyakarta", "Yogyakarta", "0901", "124", "IF", listMatkulKoJoko, 22000);
        listStaff.add(dosenHonorer3);
        
        // Dummy 4
        ArrayList<PresensiStaff> listPresensiBuAni = new ArrayList<PresensiStaff>();
        listPresensiBuAni.add(listPresensiStaff[0]);
        listPresensiBuAni.add(listPresensiStaff[2]);
        listPresensiBuAni.add(listPresensiStaff[4]);
        listPresensiBuAni.add(listPresensiStaff[6]);
        listPresensiBuAni.add(listPresensiStaff[8]);
        ArrayList<MatkulAjar> listMatkulBuAni = new ArrayList<MatkulAjar>();
        listMatkulBuAni.add(new MatkulAjar(listMatkul[1], listPresensiBuAni));
        listMatkulBuAni.add(new MatkulAjar(listMatkul[3], listPresensiBuAni));
        listMatkulBuAni.add(new MatkulAjar(listMatkul[5], listPresensiBuAni));
        DosenHonorer dosenHonorer4 = new DosenHonorer("Bu Ani", "Surabaya", "Surabaya", "0902", "125", "IF", listMatkulBuAni, 23000);
        listStaff.add(dosenHonorer4);
        

        ArrayList<PresensiStaff> listPresensiPaTaufik = new ArrayList<PresensiStaff>();
        listPresensiPaTaufik.add(listPresensiStaff[1]);
        listPresensiPaTaufik.add(listPresensiStaff[3]);
        listPresensiPaTaufik.add(listPresensiStaff[5]);
        listPresensiPaTaufik.add(listPresensiStaff[7]);
        listPresensiPaTaufik.add(listPresensiStaff[9]);
        Karyawan karyawan1 = new Karyawan("Pa Taufik", "Bandung", "Bandung", "0988", "126", 70000, listPresensiPaTaufik);
        listStaff.add(karyawan1);

        ArrayList<PresensiStaff> listPresensiBapakBudi = new ArrayList<PresensiStaff>();
        listPresensiBapakBudi.add(listPresensiStaff[0]);
        listPresensiBapakBudi.add(listPresensiStaff[2]);
        listPresensiBapakBudi.add(listPresensiStaff[4]);
        listPresensiBapakBudi.add(listPresensiStaff[6]);
        listPresensiBapakBudi.add(listPresensiStaff[8]);
        Karyawan karyawan2 = new Karyawan("Bapak Budi", "Jakarta", "Jakarta", "0989", "128", 80000, listPresensiBapakBudi);
        listStaff.add(karyawan2);

        ArrayList<PresensiStaff> listPresensiIbuAni = new ArrayList<PresensiStaff>();
        listPresensiIbuAni.add(listPresensiStaff[1]);
        listPresensiIbuAni.add(listPresensiStaff[3]);
        listPresensiIbuAni.add(listPresensiStaff[5]);
        listPresensiIbuAni.add(listPresensiStaff[7]);
        listPresensiIbuAni.add(listPresensiStaff[9]);
        Karyawan karyawan3 = new Karyawan("Ibu Ani", "Yogyakarta", "Yogyakarta", "0990", "129", 75000, listPresensiIbuAni);
        listStaff.add(karyawan3);

        ArrayList<PresensiStaff> listPresensiBapakCahyo = new ArrayList<PresensiStaff>();
        listPresensiBapakCahyo.add(listPresensiStaff[0]);
        listPresensiBapakCahyo.add(listPresensiStaff[2]);
        listPresensiBapakCahyo.add(listPresensiStaff[4]);
        listPresensiBapakCahyo.add(listPresensiStaff[6]);
        listPresensiBapakCahyo.add(listPresensiStaff[8]);
        Karyawan karyawan4 = new Karyawan("Bapak Cahyo", "Surabaya", "Surabaya", "0991", "130", 72000, listPresensiBapakCahyo);
        listStaff.add(karyawan4);

    }

    public static void main(String[] args) {
        createDummy();
        SIAView view = new SIAView();
        SIAController controller = new SIAController(listMahasiswa, listStaff, listMatkul, view);

        // KALAU MAU CEK TAPI GA LIAT DUMMY, BISA PAKAI DI BAWAH INI
        // controller.searchUser("dionisius"); //No1
        // controller.printNAperMHS("112303", "004"); //No2
        // controller.printNASatuMK("003"); //No3
        // controller.printTidakLulus("003"); //No4
        // controller.printMatkulDiambilPlusAbsen("112303");//No5
        // controller.printJamHadirStaff("118");//No6
        // controller.printGajiStaff("128"); //No7

        String menu = "Select an option:\n"
                    + "1. Search User\n"
                    + "2. Print NA per MHS\n"
                    + "3. Print NA for One Course\n"
                    + "4. Print Students Who Didn't Pass\n"
                    + "5. Print Courses Taken and Attendance\n"
                    + "6. Print Staff Attendance Hours\n"
                    + "7. Print Staff Salary\n"
                    + "0. Exit";

        int option;
        
        do {
            String input = JOptionPane.showInputDialog(menu);
            option = Integer.parseInt(input != null ? input : "0");

            switch (option) {
                case 1:
                    String username = JOptionPane.showInputDialog("Enter username:");
                    controller.searchUser(username);
                    break;
                
                case 2:
                    String studentId = JOptionPane.showInputDialog("Enter Student ID:");
                    String courseId = JOptionPane.showInputDialog("Enter Course ID:");
                    controller.printNAperMHS(studentId, courseId);
                    break;
                
                case 3:
                    String courseIdNA = JOptionPane.showInputDialog("Enter Course ID:");
                    controller.printNASatuMK(courseIdNA);
                    break;
                
                case 4:
                    String courseIdNoPass = JOptionPane.showInputDialog("Enter Course ID:");
                    controller.printTidakLulus(courseIdNoPass);
                    break;
                
                case 5: 
                    String studentIdCourses = JOptionPane.showInputDialog("Enter Student ID:");
                    controller.printMatkulDiambilPlusAbsen(studentIdCourses);
                    break;
                
                case 6:
                    String staffIdAttendance = JOptionPane.showInputDialog("Enter Staff ID:");
                    controller.printJamHadirStaff(staffIdAttendance);
                    break;
                
                case 7:
                    String staffIdSalary = JOptionPane.showInputDialog("Enter Staff ID:");
                    controller.printGajiStaff(staffIdSalary);
                    break;
                
                case 0:
                    JOptionPane.showMessageDialog(null, "Exiting program.");
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please select a valid option.");
                    break;
            }
        } while (option != 0);
    }
}
