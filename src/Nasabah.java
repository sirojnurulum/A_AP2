/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ABC
 */
public class Nasabah {

    private String NoRekening;
    private String nama;
    private String alamat;
    private String tanggalLahir;
    private int saldo;
    private String pin;

    public void setNoRekening(String noRekening) {
        this.NoRekening = noRekening;
    }

    public String getNoRekening() {
        return this.NoRekening;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return this.nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTanggalLahir() {
        return this.tanggalLahir;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return this.pin;
    }
}
