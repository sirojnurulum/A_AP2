/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ABC
 */
public class AtmPerbankan {

    private Nasabah nasabahAtm;
    private short isiBox;
    private String passwordAtm = "1234";

    public AtmPerbankan() {

    }

    public void setNasabahAtm(Nasabah nasabahAtm) {
        // men-set data nasabah yang akan diproses dalam ATM perbankan ini
        // berdasarkan no rekning yang diinputkan terlebih dahulu.
        this.nasabahAtm = nasabahAtm;
    }

    public Nasabah getNasabahAtm() {
        // mengambil nilai nasabah yang diproses
        return nasabahAtm;
    }

    public void setIsiBox(short isiBox) {
        // mengisi nilai isibox(merupakan jumlah lembar uang yang ada dalam ATM)
        this.isiBox = isiBox;
    }

    public int getIsiBox() {
        // mengembalikan nilai isibox
        return isiBox;
    }

    public void setPasswordAtm(String passwordAtm) {
        // menginput nilai password yang baru
        this.passwordAtm = passwordAtm;
    }

    public String getPasswordAtm() {
        // mengembalikan nilai password yang ada
        return passwordAtm;
    }

    public String inputIsiBox(int nominal) {
        // menginput nilai isibox berupa nominal kemudian dikonfersi kedalam
        // lembar uang.
        String kembali;
        if (cekLipat(nominal) == true) {
            short jumBar1 = konversiInAtm(nominal);
            short jumBar2 = (short) (isiBox + jumBar1);
            setIsiBox(jumBar2);
            kembali = "pengisian Box sukses";
        } else {
            kembali = "niminal harus kelipatan 50000";
        }
        return kembali;
    }

    public String outputIsiBox(int nominalNas) {
        // mengembalikan nilai isibox berupa nominal berdasarkan jmlh lembar
        // uang
        // yang ada dalam isibox.
        int nominalAtm = konversiOutAtm();
        String kembali;
        if (cekLipat(nominalNas) == true) {
            if (nominalNas >= nominalAtm) {
                // sisa isi box tidak mencukupi = 2
                kembali = "2";
            } else {
                int valueBox1 = getIsiBox() * 50000;
                int valueBox2 = valueBox1 - nominalNas;
                short jumBar1 = konversiInAtm(valueBox2);
                setIsiBox(jumBar1);
                nasabahAtm.setSaldo(nasabahAtm.getSaldo() - nominalNas);
                // pengambilan uang sukses = 3
                kembali = "3";
            }
        } else {
            // pengambilan uang harus kelipatan 50.000 = 1
            kembali = "1";
        }

        return kembali;
    }

    public boolean checkPass(String pass) {
        // mengecek berupa angka atau tidak
        boolean x1;
        try {
            Integer.parseInt(pass);
            x1 = true;
        } catch (Exception LS2) {
            x1 = false;
        }
        return x1;
    }

    public boolean checkPass2(String pass) {
        // mengecek lengthnya 4 atau tidak
        if (pass.length() == 4) {
            return true;
        } else {
            return false;
        }
    }

    public boolean gantiPassword(String pinBaru) {
        // merubah password yang ada
        boolean x2 = false;
        if (checkPass(pinBaru) == true) {
            if (checkPass2(pinBaru) == true) {
                passwordAtm = pinBaru;
                x2 = true;
            } else {
                x2 = false;
            }
        } else {
            x2 = false;
        }
        return x2;
    }

    public String getPassword() {
        // mengembalikan nilai atribut password
        return nasabahAtm.getPin();
    }

    public boolean cekLipat(int nominal) {
        if (nominal % 50000 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public short konversiInAtm(int nominal) {
        short jumBar = (short) (nominal / 50000);
        return jumBar;
    }

    public int konversiOutAtm() {
        int jumAng = isiBox * 50000;
        return jumAng;
    }
}
