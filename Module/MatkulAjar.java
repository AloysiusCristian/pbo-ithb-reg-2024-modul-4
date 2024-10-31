package Module;

import java.util.ArrayList;

public class MatkulAjar{
    Matakuliah matakuliah;
    private ArrayList<PresensiStaff> presensi = new ArrayList<PresensiStaff>();
    
    public MatkulAjar(Matakuliah matakuliah, ArrayList<PresensiStaff> presensi) {
        this.matakuliah = matakuliah;
        this.presensi = presensi;
    }

    public Matakuliah getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(Matakuliah matakuliah) {
        this.matakuliah = matakuliah;
    }

    public ArrayList<PresensiStaff> getPresensi() {
        return presensi;
    }

    public void setPresensi(ArrayList<PresensiStaff> presensi) {
        this.presensi = presensi;
    }

    @Override
    public String toString(){
        return
            "\nMata Kuliah: " + matakuliah +
            "\nPresensi: " + presensi;
    }
}
