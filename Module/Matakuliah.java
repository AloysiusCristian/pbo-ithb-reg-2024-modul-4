package Module;

public class Matakuliah {
    protected String kode, nama;
    protected int sks;
    
    public Matakuliah(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }
    public String getKode() {
        return kode;
    }
    public void setKode(String kode) {
        this.kode = kode;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getSks() {
        return sks;
    }
    public void setSks(int sks) {
        this.sks = sks;
    }

    @Override
    public String toString(){
        return
            "Kode: " + this.kode +
            "\nMatkul: " +this.nama +
            "\nsks: " +this.sks;
    }
}
