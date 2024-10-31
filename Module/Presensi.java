package Module;

import java.util.Date;

public class Presensi {
    protected Date tanggal = new Date(0);
    protected StatusHadir status;
    
    public Presensi(Date tanggal, StatusHadir status) {
        this.tanggal = tanggal;
        this.status = status;
    }
    public Date getTanggal() {
        return tanggal;
    }
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    public StatusHadir getStatus() {
        return status;
    }
    public void setStatus(StatusHadir status) {
        this.status = status;
    }
    @Override
    public String toString(){
        return 
            super.toString() +
            "\nDate: " + this.tanggal + 
            "\nStatus Hadir: " + this.status;
    }
}
