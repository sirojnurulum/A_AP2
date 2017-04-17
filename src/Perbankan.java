
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ABC
 */
public class Perbankan {

    //deklarasi array
    private ArrayList<Nasabah> dataNasabah = new ArrayList<Nasabah>();
    private AtmPerbankan ATM = new AtmPerbankan();

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // main
    public static void main(String[] args) {
        // UNTUK INPUT
        BufferedReader LS = new BufferedReader(new InputStreamReader(System.in));
        // PEMBENTUKAN OBJECT BARU
        Perbankan O = new Perbankan();
        System.out.println("Selamat datang di bank XXX");
        System.out
                .println("========================================================================");
        // PEMILIHAN MENU UTAMA
        boolean bolihMain = false;
        while (bolihMain == false) {
            try {
                System.out.println("silahkan pilih menu : ");
                System.out.println("1. Perbankan\n2. Atm Perbankan\n3. Keluar");
                System.out.print("pilih : ");
                int pilihMenuMain = Integer.parseInt(LS.readLine());
                System.out
                        .println("========================================================================");
                switch (pilihMenuMain) {
                    case 1: {
                        System.out.println("=== Perbankan ===");
                        // OBJECT MEMANGGIL METHOD DARI BANK
                        O.dariBank();
                        bolihMain = false;
                    }
                    ;
                    break;
                    case 2: {
                        System.out.println("=== Atm Perbankan ===");
                        // OBJECT MEMANGGIL METHOD DARI ATM
                        O.dariaAtm();
                        bolihMain = false;
                    }
                    ;
                    break;
                    case 3: {
                        // PROSES SELESAI
                        System.out
                                .println("----------------------------- terimakasih -----------------------------");
                        bolihMain = true;
                    }
                    ;
                    break;
                    default: {
                        // DEFAULT UNTUK PILIHAN PADA MENU UTAMA
                        System.out.println("pilih terlebih dahulu");
                        System.out
                                .println("========================================================================");
                        bolihMain = false;
                    }
                }
            } catch (Exception LS2) {
                // BERFUNGSI UNTUK MENG-HANDEL INPUTAN
                System.out
                        .println("========================================================================");
                System.out.println("anda belum memilih #1");
                System.out
                        .println("========================================================================");
            }
        }
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // perbankan_/_atmPerbankan
    public void dariBank() {
        BufferedReader LS = new BufferedReader(new InputStreamReader(System.in));
        boolean pilihMenuBank = false;
        while (pilihMenuBank == false) {
            System.out.println("1. Menambah Nasabah");
            System.out.println("2. Edit Data Nasabah");
            System.out.println("3. Menabung");
            System.out.println("4. Mengambil Uang");
            System.out.println("5. Menghapus Data Nasabah");
            System.out.println("6. Menampilkan Data Nasabah");
            System.out.println("7. keluar");
            try {
                System.out.print("pilih : ");

                int pilihMenuDariBank = Integer.parseInt(LS.readLine());
                System.out
                        .println("========================================================================");
                switch (pilihMenuDariBank) {
                    case 1: {
                        System.out.println(inputNasabah(dataNasabah));
                    }
                    ;
                    break;
                    case 2: {
                        System.out
                                .println("========================================================================");
                        System.out.print("Masukkan No Rekening : ");
                        String tmpNoRek = LS.readLine();
                        int index = cariNoRek(tmpNoRek);
                        if (tmpNoRek.isEmpty()) {
                            System.out.println("no rekening tidak di isi");
                            System.out
                                    .println("========================================================================");
                        } else {

                            if (index == (-1)) {
                                System.out
                                        .println("data tidak ditemukan\n=========================================================");
                            } else {
                                ubahData(dataNasabah.get(index), index);
                            }
                        }
                    }
                    ;
                    break;
                    case 3: {
                        System.out
                                .println("========================================================================");
                        System.out.print("Masukkan No Rekening : ");
                        String tmpNoRek = LS.readLine();
                        int index = cariNoRek(tmpNoRek);
                        if (tmpNoRek.isEmpty()) {
                            System.out.println("no rekening tidak di isi");
                            System.out
                                    .println("========================================================================");
                        } else {

                            System.out.print("masukkan nominal saldo : ");
                            String nominalX1 = LS.readLine();
                            if (nominalX1.isEmpty()) {
                                System.out
                                        .println("nominal saldo tidak diisi.\n proses selesai\njumlah saldo tidak dirubah");
                            } else {
                                if (cekParsing(nominalX1) == true) {
                                    int nominalX2 = Integer.parseInt(nominalX1);
                                    menambahSaldo(nominalX2, index);
                                    System.out
                                            .println("penambahan saldo sukses\n=========================================================");
                                } else {
                                    System.out
                                            .println("penambahan saldo gagal\n=========================================================");
                                }
                            }
                        }
                    }
                    ;
                    break;
                    case 4: {
                        System.out
                                .println("========================================================================");
                        System.out.print("Masukkan No Rekening : ");
                        String tmpNoRek = LS.readLine();
                        int index = cariNoRek(tmpNoRek);
                        if (tmpNoRek.isEmpty()) {
                            System.out.println("no rekening tidak di isi");
                            System.out
                                    .println("========================================================================");
                        } else {
                            System.out.print("masukkan pin : ");
                            String tmpPin = LS.readLine();
                            if (cekPin(tmpPin) == true
                                    && dataNasabah.get(index).getPin().equals(
                                            tmpPin)) {
                                System.out
                                        .println("========================================================================");
                                System.out.print("masukkan nominal saldo : ");
                                String nominalX1 = LS.readLine();
                                if (nominalX1.isEmpty()) {
                                    System.out
                                            .println("nominal saldo tidak diisi.\n proses selesai\njumlah saldo tidak dirubah");
                                } else {
                                    if (cekParsing(nominalX1) == true) {
                                        int nominalX2 = Integer.parseInt(nominalX1);
                                        mengurangiSaldo(nominalX2, index);
                                        System.out
                                                .println("pengurangan saldo sukses\n=========================================================");
                                    } else {
                                        System.out
                                                .println("pengurangan saldo gagal\n=========================================================");
                                    }
                                }
                            } else {
                                System.out.println("Pin salah");
                            }
                            // //////------------------------------------

                            // /////-------------------------------------
                        }
                    }
                    ;
                    break;
                    case 5: {
                        System.out
                                .println("========================================================================");
                        System.out.print("Masukkan No Rekening : ");
                        String tmpNoRek = LS.readLine();
                        int index = cariNoRek(tmpNoRek);
                        if (tmpNoRek.isEmpty()) {
                            System.out.println("No rekening tidak di isi");
                            System.out
                                    .println("========================================================================");
                        } else {
                            if (cekNoRek(tmpNoRek) == false) {
                                System.out.println("Format no rekening salah");
                                System.out
                                        .println("========================================================================");
                            } else {
                                if (cariNoRek(tmpNoRek) == (-1)) {
                                    System.out
                                            .println("no rekening tidak terdaftar");
                                    System.out
                                            .println("========================================================================");
                                } else {
                                    hapusData(index);
                                    System.out
                                            .println("========================================================================");
                                }
                            }
                        }
                    }
                    ;
                    break;
                    case 6: {
                        System.out
                                .println("========================================================================");
                        tampilNasabah();
                        System.out
                                .println("========================================================================");
                    }
                    ;
                    break;
                    case 7: {
                        pilihMenuBank = true;
                    }
                    ;
                    break;
                    default: {
                        System.out.println("pilih terlebih dahulu");
                        System.out
                                .println("========================================================================");
                        pilihMenuBank = false;
                        ;
                    }
                }
            } catch (Exception LS2) {
                System.out
                        .println("========================================================================");
                System.out.println("anda belum memilih #1");
                System.out
                        .println("========================================================================");
                pilihMenuBank = false;
            }
        }
    }

    public void dariaAtm() {
        BufferedReader LS = new BufferedReader(new InputStreamReader(System.in));
        boolean pilihMenuAtm = false;
        while (pilihMenuAtm == false) {
            System.out.println("1. Nasabah");
            System.out.println("2. Petugas");
            System.out.println("3. Keluar");
            try {
                System.out.print("pilih : ");
                int pilihMenuDariAtm = Integer.parseInt(LS.readLine());
                System.out
                        .println("========================================================================");
                switch (pilihMenuDariAtm) {
                    case 1: {
                        System.out.println("=== Atm Perbankan / Nasabah ===");
                        atmNasabah();
                    }
                    ;
                    break;
                    case 2: {
                        System.out.println("=== Atm Perbankan / Petugas ===");
                        atmPetugas();
                    }
                    ;
                    break;
                    case 3: {
                        pilihMenuAtm = true;
                    }
                    ;
                    break;
                    default: {
                        System.out.println("pilih terlebih dahulu");
                        System.out
                                .println("========================================================================");
                        pilihMenuAtm = false;
                    }
                }
            } catch (Exception LS2) {
                System.out
                        .println("========================================================================");
                System.out.println("anda belum memilih #1");
                System.out
                        .println("========================================================================");
                pilihMenuAtm = false;
            }
        }
    }

    public void atmNasabah() {
        BufferedReader LS = new BufferedReader(new InputStreamReader(System.in));
        boolean pilihMenuAtmNasabah = false;
        while (pilihMenuAtmNasabah == false) {
            System.out.println("1. merubah PIN");
            System.out.println("2. mengambil uang");
            System.out.println("3. menampilkan saldo uang");
            System.out.println("4. keluar");
            try {
                System.out.print("pilih : ");
                int pilihAtmNasabahMenu = Integer.parseInt(LS.readLine());
                System.out
                        .println("========================================================================");
                switch (pilihAtmNasabahMenu) {
                    case 1: {
                        System.out.print("masukkan no rekening : ");
                        String tmpNoRekening = LS.readLine();
                        int index = cariNoRek(tmpNoRekening);
                        if (index == (-1)) {
                            System.out.println("no rekening tidak terdaftar");
                            System.out
                                    .println("========================================================================");
                        } else {
                            ATM.setNasabahAtm(dataNasabah.get(index));
                            boolean boleUbahPin = false;
                            while (boleUbahPin == false) {
                                System.out.print("masukkan pin : ");
                                String tmpPin = LS.readLine();
                                if (ATM.getPassword().equals(tmpPin)) {
                                    boolean ulangMaPinBar = false;
                                    while (ulangMaPinBar == false) {
                                        System.out.print("masukkan PIN baru : ");
                                        String tmpPinBaru = LS.readLine();
                                        if (tmpPinBaru.isEmpty()) {
                                            ulangMaPinBar = false;
                                            System.out
                                                    .println("masukkan PIN baru terlebih dahulu !!!");
                                            System.out
                                                    .println("========================================================================");
                                            ulangMaPinBar = false;
                                        } else {
                                            if (cekPin(tmpPinBaru) == false) {
                                                System.out
                                                        .println("format pin ditak diterima (XXXX)");
                                                System.out
                                                        .println("========================================================================");
                                                boolean ulangUbahPin = false;
                                                while (ulangUbahPin == false) {
                                                    System.out
                                                            .println("1. masukkan kembali PIN dengan benar\2. keluar");
                                                    String pilihUlangUbahPin = LS
                                                            .readLine();
                                                    if (pilihUlangUbahPin.isEmpty()) {
                                                        ulangUbahPin = false;
                                                        System.out
                                                                .println("harus pilih (1/2)");
                                                        System.out
                                                                .println("========================================================================");
                                                    } else if (pilihUlangUbahPin
                                                            .equals("1")) {
                                                        ulangUbahPin = true;
                                                        ulangMaPinBar = false;
                                                    } else if (pilihUlangUbahPin
                                                            .equals("2")) {
                                                        ulangUbahPin = true;
                                                        ulangMaPinBar = true;
                                                        System.out
                                                                .println("Pin batal di ubah");
                                                        System.out
                                                                .println("========================================================================");
                                                    } else {
                                                        ulangUbahPin = false;
                                                        System.out
                                                                .println("harus pilih (1/2)");
                                                        System.out
                                                                .println("========================================================================");
                                                    }
                                                }
                                            } else {
                                                ulangMaPinBar = true;
                                                boleUbahPin = true;
                                                ATM.getNasabahAtm().setPin(
                                                        tmpPinBaru);
                                                System.out
                                                        .println("pin sukses di ubah");
                                                System.out
                                                        .println("========================================================================");
                                            }
                                        }
                                    }
                                } else {
                                    boleUbahPin = true;
                                    System.out.println("PIN salah");
                                    System.out
                                            .println("========================================================================");
                                }
                            }
                        }
                    }
                    ;
                    break;
                    case 2: {

                        System.out.print("masukkan no rekening : ");
                        String tmpNoRekening = LS.readLine();
                        int index = cariNoRek(tmpNoRekening);
                        if (index == (-1)) {
                            System.out.println("No Rekening tidak terdaftar");
                            System.out
                                    .println("========================================================================");
                        } else {
                            ATM.setNasabahAtm(dataNasabah.get(index));
                            boolean boleAmbilUang = false;
                            while (boleAmbilUang == false) {
                                System.out.print("masukkan pin : ");
                                String tmpPin = LS.readLine();
                                if (ATM.getPassword().equals(tmpPin)) {
                                    boolean ulangMaNomin = false;
                                    while (ulangMaNomin == false) {
                                        System.out
                                                .print("masukkan nominal pengambilan uang : ");
                                        String tmpNominalAmbilUang = LS.readLine();
                                        if (tmpNominalAmbilUang.isEmpty()) {
                                            System.out.println("harus isi nominal");
                                            System.out
                                                    .println("========================================================================");
                                            ulangMaNomin = false;
                                        } else {
                                            if (cekParsing(tmpNominalAmbilUang) == false) {
                                                System.out
                                                        .println("nominal harus angka");
                                                System.out
                                                        .println("========================================================================");
                                                ulangMaNomin = false;
                                            } else {
                                                int nominal = Integer
                                                        .parseInt(tmpNominalAmbilUang);
                                                if (cekAmbilSaldo(nominal, index) == true) {
                                                    if (ATM.outputIsiBox(nominal)
                                                            .equals("3")) {
                                                        ulangMaNomin = true;
                                                        boleAmbilUang = true;
                                                        System.out
                                                                .println("proses pengambilan uanng sukses");
                                                        System.out
                                                                .println("========================================================================");
                                                    } else if (ATM.outputIsiBox(
                                                            nominal).equals("2")) {
                                                        ulangMaNomin = true;
                                                        boleAmbilUang = true;
                                                        System.out
                                                                .println("maaf sisa isi box tidak mencukupi");
                                                        System.out
                                                                .println("========================================================================");
                                                    } else if (ATM.outputIsiBox(
                                                            nominal).equals("1")) {
                                                        ulangMaNomin = true;
                                                        boleAmbilUang = true;
                                                        System.out
                                                                .println("pengambilan uang harus kelipatan 50.000");
                                                        System.out
                                                                .println("========================================================================");
                                                    }
                                                } else {
                                                    ulangMaNomin = true;
                                                    System.out
                                                            .println("Saldo tidak mencukupi");
                                                    System.out
                                                            .println("saldo anda : Rp."
                                                                    + ATM
                                                                            .getNasabahAtm()
                                                                            .getSaldo()
                                                                    + ",-");
                                                    System.out
                                                            .println("========================================================================");
                                                }
                                            }
                                        }
                                    }

                                } else {
                                    boleAmbilUang = true;
                                    System.out.println("PIN salah");
                                    System.out
                                            .println("========================================================================");
                                }
                            }
                        }
                    }
                    ;
                    break;
                    case 3: {
                        System.out.print("masukkan no rekening : ");
                        String tmpNoRekening = LS.readLine();
                        int index = cariNoRek(tmpNoRekening);
                        if (index == (-1)) {
                            System.out.println("No Rekening tidak terdaftar");
                            System.out
                                    .println("========================================================================");
                        } else {
                            ATM.setNasabahAtm(dataNasabah.get(index));
                            boolean boleTampilSaldo = false;
                            if (boleTampilSaldo == false) {
                                System.out.print("masukkan pin : ");
                                String tmpPin = LS.readLine();
                                if (ATM.getNasabahAtm().getPin().equals(tmpPin)) {
                                    System.out
                                            .println("saldo = Rp."
                                                    + ATM.getNasabahAtm()
                                                            .getSaldo() + ",-");
                                    System.out
                                            .println("========================================================================");
                                } else {
                                    boleTampilSaldo = true;
                                    System.out.println("PIN salah");
                                    System.out
                                            .println("========================================================================");
                                }
                            }
                        }
                    }
                    ;
                    break;
                    case 4: {
                        pilihMenuAtmNasabah = true;
                    }
                    break;
                    default: {
                        System.out.println("pilih terlebih dahulu");
                        System.out
                                .println("========================================================================");
                        pilihMenuAtmNasabah = false;
                    }
                }

            } catch (Exception LS2) {
            }
        }
    }

    public void atmPetugas() {
        BufferedReader LS = new BufferedReader(new InputStreamReader(System.in));
        boolean pilihMenuAtmPetugas = false;
        while (pilihMenuAtmPetugas == false) {
            System.out.println("1. menginput nominal uang dalam box");
            System.out.println("2. menampilkan nominal uang dalam atm");
            System.out.println("3. merubah password");
            System.out.println("4. keluar");
            try {
                System.out.print("pilih : ");
                int pilihAtmPetugasMenu = Integer.parseInt(LS.readLine());
                System.out
                        .println("========================================================================");
                switch (pilihAtmPetugasMenu) {
                    case 1: {
                        System.out.print("masukkan password : ");
                        String tmpPassword = LS.readLine();
                        if (tmpPassword.isEmpty()) {
                            System.out.println("password salah");
                            System.out
                                    .println("========================================================================");
                        } else {
                            if (ATM.getPasswordAtm().equals(tmpPassword)) {
                                System.out
                                        .print("masukkan nominal untuk isi box : ");
                                String tmpNomIsiBoxX1 = LS.readLine();
                                if (tmpNomIsiBoxX1.isEmpty()) {
                                    System.out
                                            .println("nominal isi box tidak di isi");
                                    System.out
                                            .println("========================================================================");
                                } else {
                                    if (cekParsing(tmpNomIsiBoxX1) == false) {
                                        System.out.println("nominal harus angka");
                                        System.out
                                                .println("========================================================================");
                                    } else {
                                        int tmpNomIsiBoxX2 = Integer
                                                .parseInt(tmpNomIsiBoxX1);
                                        System.out.println(ATM
                                                .inputIsiBox(tmpNomIsiBoxX2));
                                        System.out
                                                .println("========================================================================");
                                    }
                                }
                            } else {
                                System.out.println("password salah");
                                System.out
                                        .println("========================================================================");
                            }
                        }
                    }
                    ;
                    break;
                    case 2: {
                        System.out.print("masukkan password : ");
                        String tmpPassword = LS.readLine();
                        if (tmpPassword.isEmpty()) {
                            System.out.println("password salah");
                        } else {
                            System.out.println("jumlah isi box : Rp."
                                    + ATM.konversiOutAtm() + ",-");
                        }
                    }
                    ;
                    break;
                    case 3: {
                    }
                    ;
                    break;
                    case 4: {
                        pilihMenuAtmPetugas = true;
                    }
                    break;
                    default:
                        pilihMenuAtmPetugas = false;
                }

            } catch (Exception LS2) {
            }
        }
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // input_nasabah_baru
    public String inputNasabah(ArrayList<Nasabah> dataNasabahBaru) {
        // menginsert data kedalam data nasabah.
        Nasabah simpanDulu = new Nasabah();
        BufferedReader LS = new BufferedReader(new InputStreamReader(System.in));
        boolean terus = true;
        try {
            if (terus == true) {
                // --------------------------------------------------------------
                // input nomor rekening
                // --------------------------------------------------------------
                boolean boleNoRek = false;
                while (boleNoRek == false) {
                    System.out
                            .println("Format untuk no rekening : (XXX-DDMMYYYY-UUUU)\nKeterangan : \nXXX = Cabang Bank\nDD = Hari Pendaftaran\nMM = Bulan Pendaftaran\nYYYY = Tahun Pendaftaran\nUUUU = Nomor Urut Pendaftaran Pada Tanggal Tersebut");
                    System.out.print("Masukkan No Rekening : ");
                    String strNoRek = LS.readLine();
                    boolean checkNR = cekNoRek(strNoRek);
                    if (checkNR == false) {
                        System.out
                                .println("Format No Rekening Tidak Dapat Diterima !!!!");
                        System.out
                                .println("========================================================================");
                        boolean ulangNoRek = false;
                        while (ulangNoRek == false) {
                            System.out
                                    .println("1. masukkan no rekening kembali dengan format yang benar \n2. keluar ");
                            System.out.print("pilih (1/2): ");
                            String pilihUlangNoRekening = LS.readLine();
                            if (pilihUlangNoRekening.equals("1")) {
                                ulangNoRek = true;
                                boleNoRek = false;
                            } else if (pilihUlangNoRekening.equals("2")) {
                                terus = false;
                                ulangNoRek = true;
                                boleNoRek = true;
                            } else if ((pilihUlangNoRekening.isEmpty())
                                    || !((pilihUlangNoRekening.equals("1")) && pilihUlangNoRekening
                                    .equals("2"))) {
                                ulangNoRek = false;
                            }
                        }
                        System.out
                                .println("=========================================================");
                    } else {
                        if (cekNoRekAdaBelum(strNoRek) == false) {
                            System.out
                                    .println("no rekening sudah ada yang menggunakan");
                            System.out
                                    .println("=========================================================");
                            terus = false;
                            boleNoRek = true;
                        } else {
                            terus = true;
                            boleNoRek = true;
                            simpanDulu.setNoRekening(strNoRek);
                        }

                    }
                }
                if (terus == true) {
                    // --------------------------------------------------------------
                    // input nama
                    // --------------------------------------------------------------
                    boolean boleNama = false;
                    while (boleNama == false) {
                        System.out.print("Masukkan Nama : ");
                        String strNama = LS.readLine();
                        if (strNama.isEmpty()) {
                            System.out
                                    .println("========================================================================");
                            System.out.println("nama masih kosong");
                            boolean ulangNama = false;
                            while (ulangNama == false) {
                                System.out
                                        .println("1. masukkan nama kembali\n2. keluar");
                                System.out.print("pilih (1/2): ");
                                String pilihUlangNama = LS.readLine();
                                if (pilihUlangNama.equals("1")) {
                                    boleNama = false;
                                    ulangNama = true;
                                } else if (pilihUlangNama.equals("2")) {
                                    boleNama = true;
                                    ulangNama = true;
                                    terus = false;
                                } else if ((pilihUlangNama.isEmpty())
                                        || !((pilihUlangNama.equals("1")) && pilihUlangNama
                                        .equals("2"))) {
                                    ulangNama = false;
                                }
                            }
                            System.out
                                    .println("========================================================================");
                        } else {
                            boleNama = true;
                            simpanDulu.setNama(strNama);
                            terus = true;
                        }
                    }
                    if (terus == true) {
                        // --------------------------------------------------------------
                        // input alamat
                        // --------------------------------------------------------------
                        boolean boleAlamat = false;
                        while (boleAlamat == false) {
                            System.out.print("Masukkan Alamat : ");
                            String strAlamat = LS.readLine();
                            if (strAlamat.isEmpty()) {
                                System.out
                                        .println("========================================================================");
                                System.out.println("Alamat masih kosong");
                                boolean ulangAlamat = false;
                                while (ulangAlamat == false) {
                                    System.out
                                            .println("1. masukkan alamat kembali\n2. keluar");
                                    System.out.print("pilih (1/2): ");
                                    String pilihUlangAlamat = LS.readLine();
                                    if (pilihUlangAlamat.equals("1")) {
                                        boleAlamat = false;
                                        ulangAlamat = true;
                                    } else if (pilihUlangAlamat.equals("2")) {
                                        boleAlamat = true;
                                        ulangAlamat = true;
                                        terus = false;
                                    } else if ((pilihUlangAlamat.isEmpty())
                                            || !((pilihUlangAlamat.equals("1")) && pilihUlangAlamat
                                            .equals("2"))) {
                                        ulangAlamat = true;
                                    }
                                }
                                System.out
                                        .println("========================================================================");
                            } else {
                                boleAlamat = true;
                                simpanDulu.setAlamat(strAlamat);
                                terus = true;
                            }
                        }
                        if (terus == true) {
                            // --------------------------------------------------------------
                            // input tanggal lahir
                            // --------------------------------------------------------------
                            boolean boleTanggalLahir = false;
                            while (boleTanggalLahir == false) {
                                System.out.print("Tanggal Lahir : ");
                                String strTangLahir = LS.readLine();
                                System.out
                                        .println("=========================================================");
                                boolean checkTL = cekTggLhr(strTangLahir);
                                if (checkTL == false) {
                                    System.out
                                            .println("Format Tanggal Lahir Tidak Dapat Diterima !!!!");
                                    System.out
                                            .println("=========================================================");
                                    System.out
                                            .println("1.  masukkan tanggal lahir kembali dengan format yang sesuai \n2. keluar");
                                    boolean ulangTanggalLahir = false;
                                    while (ulangTanggalLahir == false) {
                                        System.out.print("pilih (1/2): ");
                                        String pilihTanggalLahir = LS
                                                .readLine();
                                        if (pilihTanggalLahir.equals("1")) {
                                            ulangTanggalLahir = true;
                                            boleTanggalLahir = false;
                                        } else if (pilihTanggalLahir
                                                .equals("2")) {
                                            terus = false;
                                            boleTanggalLahir = true;
                                            ulangTanggalLahir = true;

                                        } else if ((pilihTanggalLahir.isEmpty())
                                                || !((pilihTanggalLahir
                                                        .equals("1")) && pilihTanggalLahir
                                                .equals("2"))) {
                                            ulangTanggalLahir = false;
                                        }
                                    }
                                    System.out
                                            .println("=========================================================");
                                } else {
                                    terus = true;
                                    boleTanggalLahir = true;
                                    simpanDulu.setTanggalLahir(strTangLahir);
                                }
                            }
                            if (terus == true) {
                                // --------------------------------------------------------------
                                // input saldo
                                // --------------------------------------------------------------
                                boolean boleSaldo = false;
                                while (boleSaldo == false) {
                                    System.out
                                            .println("saldo awal minimal Rp.500.000,-");
                                    System.out.print("masukkan saldo awal : ");
                                    String inSaldo1 = LS.readLine();
                                    if (inSaldo1.isEmpty()) {
                                        System.out
                                                .println("saldo masih kosong !!!");
                                        System.out
                                                .println("=========================================================");
                                        System.out
                                                .println("1.  masukkan saldo kembali dengan benar \n2. keluar");
                                        boolean ulangSaldo = false;
                                        while (ulangSaldo == false) {
                                            System.out.print("pilih (1/2): ");
                                            String pilihUlangSaldo = LS
                                                    .readLine();
                                            if (pilihUlangSaldo.equals("1")) {
                                                ulangSaldo = true;
                                                boleSaldo = false;
                                            } else if (pilihUlangSaldo
                                                    .equals("2")) {
                                                boleSaldo = true;
                                                ulangSaldo = true;
                                                terus = false;
                                            } else if ((pilihUlangSaldo
                                                    .isEmpty())
                                                    || !((pilihUlangSaldo
                                                            .equals("1")) && pilihUlangSaldo
                                                    .equals("2"))) {
                                                ulangSaldo = false;
                                            }
                                        }
                                        System.out
                                                .println("=========================================================");
                                    } else if (cekParsing(inSaldo1) == false) {
                                        System.out
                                                .println("inputan harus angka !!!");
                                        System.out
                                                .println("=========================================================");
                                        System.out
                                                .println("1.  masukkan saldo kembali dengan benar \n2. keluar");
                                        boolean ulangSaldo = false;
                                        while (ulangSaldo == false) {
                                            System.out.print("pilih (1/2): ");
                                            String pilihUlangSaldo = LS
                                                    .readLine();
                                            if (pilihUlangSaldo.equals("1")) {
                                                ulangSaldo = true;
                                                boleSaldo = false;
                                            } else if (pilihUlangSaldo
                                                    .equals("2")) {
                                                boleSaldo = true;
                                                ulangSaldo = true;
                                                terus = false;
                                            } else if ((pilihUlangSaldo
                                                    .isEmpty())
                                                    || !((pilihUlangSaldo
                                                            .equals("1")) && pilihUlangSaldo
                                                    .equals("2"))) {
                                                ulangSaldo = false;
                                            }
                                        }
                                        System.out
                                                .println("=========================================================");
                                    } else {
                                        int inSaldo = Integer
                                                .parseInt(inSaldo1);
                                        if (cekInputSaldo(inSaldo) == false) {
                                            System.out
                                                    .println("Format saldo Tidak Dapat Diterima !!!!");
                                            System.out
                                                    .println("=========================================================");
                                            System.out
                                                    .println("1.  masukkan saldo kembali dengan benar \n2. keluar");
                                            boolean ulangSaldo = false;
                                            while (ulangSaldo == false) {
                                                System.out
                                                        .print("pilih (1/2): ");
                                                String pilihUlangSaldo = LS
                                                        .readLine();
                                                if (pilihUlangSaldo.equals("1")) {
                                                    ulangSaldo = true;
                                                    boleSaldo = false;
                                                } else if (pilihUlangSaldo
                                                        .equals("2")) {
                                                    boleSaldo = true;
                                                    ulangSaldo = true;
                                                    terus = false;
                                                } else if ((pilihUlangSaldo
                                                        .isEmpty())
                                                        || !((pilihUlangSaldo
                                                                .equals("1")) && pilihUlangSaldo
                                                        .equals("2"))) {
                                                    ulangSaldo = false;
                                                }
                                            }
                                            System.out
                                                    .println("=========================================================");
                                        } else {
                                            terus = true;
                                            boleSaldo = true;
                                            simpanDulu.setSaldo(inSaldo);
                                        }
                                    }
                                }
                                if (terus == true) {
                                    // --------------------------------------------------------------
                                    // input pin
                                    // --------------------------------------------------------------
                                    System.out.println("Pin Awal = 1234");
                                    String strPin = "1234";
                                    simpanDulu.setPin(strPin);
                                    terus = true;
                                    System.out
                                            .println("untuk merubah pin dapat dilakukan di ATM");
                                    System.out
                                            .println("PIN sekarang adalah PIN standar : "
                                                    + simpanDulu.getPin());
                                    System.out
                                            .println("=========================================================");
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception LS2) {
        }
        if (terus == true) {
            dataNasabahBaru.add(simpanDulu);
            return "data sukses ditambah\n=========================================================";
        } else {
            return "Data gagal ditambah\n=========================================================";
        }
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // ubah_data_nasabah
    public String ubahData(Nasabah DataUbah, int index) {
        // Mengubah nilai data yang parameternya parameter yang ada merupakan
        // data referenfsi terbaru yang nantinya dimasukan kedalam indeks yang
        // akan dirubah.
        BufferedReader LS = new BufferedReader(new InputStreamReader(System.in));
        boolean ubahData = false;
        String kembali = null;
        while (ubahData == false) {
            System.out.println("1. Ubah Nama");
            System.out.println("2. Ubah Alamat");
            System.out.println("3. Ubah Tanggal Lahir");
            System.out.println("4. Ubah Saldo");
            try {
                System.out.print("pilih : ");
                int pilihUbahData = Integer.parseInt(LS.readLine());
                switch (pilihUbahData) {
                    case 1: {
                        ubahData = true;
                        System.out.println("=== ubah nama ===");
                        boolean boleUbahNama = false;
                        while (boleUbahNama == false) {
                            System.out.print("masukkan Nama Baru : ");
                            String tampungNama = LS.readLine();
                            if (tampungNama.isEmpty()) {
                                System.out.println("Nama baru belum dimasukkan");
                                boolean ulangUbahNama = false;
                                while (ulangUbahNama == false) {
                                    System.out
                                            .println("1. masukkan kembali Nama dengan benar\n2. keluar");
                                    System.out.print("pilih (1/2): ");
                                    String pilihUlangNama = LS.readLine();
                                    if (pilihUlangNama.equals("1")) {
                                        ulangUbahNama = true;
                                        boleUbahNama = false;
                                    } else if (pilihUlangNama.equals("2")) {
                                        boleUbahNama = true;
                                        ulangUbahNama = true;
                                        kembali = "Nama gagal di ubah\n=========================================================";
                                    } else if ((pilihUlangNama.isEmpty())
                                            || !((pilihUlangNama.equals("1")) && pilihUlangNama
                                            .equals("2"))) {
                                        ulangUbahNama = false;
                                    }
                                }
                            } else {
                                boleUbahNama = true;
                                DataUbah.setNama(tampungNama);
                                kembali = "Nama sukses di ubah\n=========================================================";
                            }
                        }
                    }
                    ;
                    break;
                    case 2: {
                        ubahData = true;
                        System.out.println("=== ubah alamat ==");
                        boolean boleUbahAlamat = false;
                        while (boleUbahAlamat == false) {
                            System.out.print("masukkan alamat baru : ");
                            String tampungAlamat = LS.readLine();
                            if (tampungAlamat.isEmpty()) {
                                System.out.println("Alamat baru belum dimasukkan");
                                boolean ulangUbahAlamat = false;
                                while (ulangUbahAlamat == false) {
                                    System.out
                                            .println("1. masukkan kembali Alamat dengan benar\n2. keluar");
                                    System.out.print("pilih (1/2): ");
                                    String pilihUlangAlamat = LS.readLine();
                                    if (pilihUlangAlamat.equals("1")) {
                                        ulangUbahAlamat = true;
                                        boleUbahAlamat = false;
                                    } else if (pilihUlangAlamat.equals("2")) {
                                        boleUbahAlamat = true;
                                        ulangUbahAlamat = true;
                                        kembali = "Alamat gagal di ubah\n=========================================================";
                                    } else if ((pilihUlangAlamat.isEmpty())
                                            || !((pilihUlangAlamat.equals("1")) && pilihUlangAlamat
                                            .equals("2"))) {
                                        boleUbahAlamat = false;
                                    }
                                }
                            } else {
                                boleUbahAlamat = true;
                                DataUbah.setAlamat(tampungAlamat);
                                kembali = "Alamat sukses di ubah\n=========================================================";
                            }
                        }
                    }
                    ;
                    break;
                    case 3: {
                        ubahData = true;
                        System.out.println("== ubah tanggal lahir ===");
                        boolean boleUbahTanggalLahir = false;
                        while (boleUbahTanggalLahir == false) {
                            System.out.print("masukkan tanggal lahir baru : ");
                            String tampungTanggalLahir = LS.readLine();
                            if (tampungTanggalLahir.isEmpty()) {
                                System.out
                                        .println("tanggal lahir baru baru belum dimasukkan");
                                boolean ulangUbahTanggalLahir = false;
                                while (ulangUbahTanggalLahir == false) {
                                    System.out
                                            .println("1. masukkan kembali tanggal lahir dengan benar dengan benar\n2. keluar");
                                    System.out.print("pilih (1/2): ");
                                    String pilihUlangAlamat = LS.readLine();
                                    if (pilihUlangAlamat.equals("1")) {
                                        ulangUbahTanggalLahir = true;
                                        boleUbahTanggalLahir = false;
                                    } else if (pilihUlangAlamat.equals("2")) {
                                        boleUbahTanggalLahir = true;
                                        ulangUbahTanggalLahir = true;
                                        kembali = "Tanggal lahir gagal di ubah\n=========================================================";
                                    } else if ((pilihUlangAlamat.isEmpty())
                                            || !((pilihUlangAlamat.equals("1")) && pilihUlangAlamat
                                            .equals("2"))) {
                                        boleUbahTanggalLahir = false;
                                    }
                                }
                            } else {
                                if (cekTggLhr(tampungTanggalLahir) == true) {
                                    boleUbahTanggalLahir = true;
                                    DataUbah.setTanggalLahir(tampungTanggalLahir);
                                } else {
                                    kembali = "tanggal lahir gagal diubah\n=========================================================";
                                }
                            }
                        }
                    }
                    ;
                    break;
                    case 4: {
                        ubahData = true;
                        System.out.println("== ubah saldo ===");
                        boolean boleUbahSaldo = false;
                        while (boleUbahSaldo == false) {
                            System.out.print("masukkan nominal saldo baru : ");
                            String tampungSaldoX1 = LS.readLine();
                            if (tampungSaldoX1.isEmpty()) {
                                System.out
                                        .println("nominal saldo baru belum dimasukkan");
                                boolean ulangUbahSaldoX1 = false;
                                while (ulangUbahSaldoX1 == false) {
                                    System.out
                                            .println("1. masukkan kembali nominal saldo dengan benar\n2. keluar");
                                    System.out.print("pilih (1/2): ");
                                    String pilihUlangsaldo = LS.readLine();
                                    if (pilihUlangsaldo.equals("1")) {
                                        ulangUbahSaldoX1 = true;
                                        boleUbahSaldo = false;
                                    } else if (pilihUlangsaldo.equals("2")) {
                                        boleUbahSaldo = true;
                                        ulangUbahSaldoX1 = true;
                                        kembali = "saldo gagal di ubah\n=========================================================";
                                    } else if ((pilihUlangsaldo.isEmpty())
                                            || !((pilihUlangsaldo.equals("1")) && pilihUlangsaldo
                                            .equals("2"))) {
                                        boleUbahSaldo = false;
                                    }
                                }
                            } else {
                                if (cekParsing(tampungSaldoX1) == true) {
                                    int tampungSaldoX2 = Integer
                                            .parseInt(tampungSaldoX1);
                                    boleUbahSaldo = true;
                                    DataUbah.setSaldo(tampungSaldoX2);
                                    kembali = "Saldo sukses di ubah\n=========================================================";
                                } else {
                                    kembali = "saldo gagal diubah\n=========================================================";
                                }
                            }
                        }
                    }
                    ;
                    break;
                    default:
                        ubahData = false;

                }
            } catch (Exception LS2) {
            }
        }
        return kembali;
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // menabung
    public int menambahSaldo(int nominal, int index) {
        // menambahkan saldo nasabah.
        int tampungNominal = nominal + dataNasabah.get(index).getSaldo();
        dataNasabah.get(index).setSaldo(tampungNominal);
        return tampungNominal;
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // mengambil_uang
    public int mengurangiSaldo(int nominal, int index) {
        // mengurangi saldo nasabah.
        int tampungNominal = dataNasabah.get(index).getSaldo() - nominal;
        dataNasabah.get(index).setSaldo(tampungNominal);
        return tampungNominal;
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // menghapus_data_nasabah
    public String hapusData(int index) {
        // menghapus indeks array yang ada berdasarkan noRekening akan tetapi
        // input yang diterima sudah berupa indeks ke berapa noRek tersebut
        // karena sudah dicari terlebih dahulu.
        dataNasabah.remove(index);
        return "Data Sukses Dihapus\n=========================================================";
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // megurutkan_data_nasabah
    public void mengurutkanData() {
        // mengurutkan_data_nasabah_secara_ascending
        Nasabah data;
        int indexKe;
        String noRekNoUrut1, noRekNoUrut2;
        int noUrut1, noUrut2;
        // try {

        // ^^^^^^^^^^^^^^^&&&&&&&&&&&&&&&&&&&&&&^^^^^^^^^^^^^^^^^^^^^^^^^^
        // pengurutan_tahun
        for (int i = 0; i < dataNasabah.size() - 1; i++) {
            data = dataNasabah.get(i);
            indexKe = i;
            noRekNoUrut1 = dataNasabah.get(i).getNoRekening();
            noUrut1 = Integer.parseInt(noRekNoUrut1.substring(13, 17));

            for (int j = i + 1; j < dataNasabah.size(); j++) {
                noRekNoUrut2 = dataNasabah.get(j).getNoRekening();
                noUrut2 = Integer.parseInt(noRekNoUrut2.substring(13, 17));
                if (noUrut1 > noUrut2) {
                    // noUrut1 = noUrut2;
                    // indexKe = j;
                    // ======================
                    data = dataNasabah.get(indexKe);
                    dataNasabah.set(indexKe, dataNasabah.get(i));
                    dataNasabah.set(i, data);
                    // ======================

                }
            }
            // if (indexKe != i) {
            // data = dataNasabah.get(indexKe);
            // dataNasabah.set(indexKe, dataNasabah.get(i));
            // dataNasabah.set(i, data);
            // }
        }
        // ^^^^^^^^^^^^^^^&&&&&&&&&&&&&&&&&&&&&&^^^^^^^^^^^^^^^^^^^^^^^^^^
        // pengurutan_bulan_&_tanggal
        // } catch (Exception LS2) {

        // }
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // menampilkan_data_nasabah
    public void tampilNasabah() {
        // menampilkan data nasabah yang ada.
        mengurutkanData();
        for (int i = 0; i < dataNasabah.size(); i++) {
            System.out.println(dataNasabah.get(i).getNoRekening() + "\t"
                    + dataNasabah.get(i).getNama() + "\t"
                    + dataNasabah.get(i).getAlamat() + "\t"
                    + dataNasabah.get(i).getTanggalLahir() + "\t"
                    + dataNasabah.get(i).getSaldo() + "\t"
                    + dataNasabah.get(i).getPin());
        }
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // pengecekan
    public boolean cekParsing(String coba) {
        try {
            Integer.parseInt(coba);
            return true;
        } catch (Exception LS2) {
            return false;
        }
    }

    public boolean cekAmbilSaldo(int ambil, int index) {
        int tampungSaldo = dataNasabah.get(index).getSaldo();
        if (ambil >= tampungSaldo) {
            return false;
        } else {
            return true;
        }
    }

    public boolean cekNoRek(String noRek) {
        try {
            String[] CNR = noRek.split("-");

            Integer.parseInt(CNR[0]);
            Integer.parseInt(CNR[1]);
            Integer.parseInt(CNR[2]);

            int dd = Integer.parseInt(CNR[1].substring(0, 2));
            int mm = Integer.parseInt(CNR[1].substring(2, 4));
            int yyyy = Integer.parseInt(CNR[1].substring(4, 8));
            boolean x1;
            boolean x2 = true;
            if ((CNR[0].length() == 3) && ((dd > 0) && (dd <= 31))
                    && ((mm > 0) && (mm <= 12))
                    && (((yyyy >= 1980) && (yyyy < 10000)))
                    && (CNR[2].length() == 4)) {
                x1 = true;
            } else {
                x1 = false;
            }
            for (int i = 0; i < dataNasabah.size(); i++) {
                if (dataNasabah.get(i).getNoRekening() == noRek) {
                    x2 = false;
                }
            }
            if (x1 == true && x2 == true) {
                return true;
            } else {
                return false;
            }
        } catch (Exception LS2) {
            return false;
        }
    }

    // PENGECEKAN TANGGAL LAHIR
    public boolean cekTggLhr(String tggLhr) {
        try {
            String CTL[] = tggLhr.split("-");
            int dd = Integer.parseInt(CTL[0]);
            int mm = Integer.parseInt(CTL[1]);
            int yyyy = Integer.parseInt(CTL[2]);
            if ((CTL.length == 3) && (dd > 0 & dd <= 31) && (mm > 0 & mm <= 12)
                    && (yyyy > 1980 & yyyy < 10000)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception LS2) {
            return false;
        }
    }

    // PENGECEKAN JUMLAH SALDO AWAL
    public boolean cekInputSaldo(int saldo) {
        if (saldo >= 500000) {
            return true;
        } else {
            return false;
        }
    }

    // PENGECEKAN PIN (ANGKA || BUKAN ANGKA) & PANJANG KARAKTER (=4 || !=4)
    public boolean cekPin(String pin) {
        boolean x1;
        try {
            Integer.parseInt(pin);
            if (pin.length() == 4) {
                x1 = true;
            } else {
                x1 = false;
            }
        } catch (Exception LS2) {
            x1 = false;
        }
        return x1;
        /*
		 * if (((pin.codePointAt(0) == 48) || (pin.codePointAt(0) == 49) ||
		 * (pin.codePointAt(0) == 50) || (pin.codePointAt(0) == 51) ||
		 * (pin.codePointAt(0) == 52) || (pin.codePointAt(0) == 53) ||
		 * (pin.codePointAt(0) == 54) || (pin.codePointAt(0) == 55) ||
		 * (pin.codePointAt(0) == 56) || (pin.codePointAt(0) == 57)) &&
		 * ((pin.codePointAt(1) == 48) || (pin.codePointAt(1) == 49) ||
		 * (pin.codePointAt(1) == 50) || (pin.codePointAt(1) == 51) ||
		 * (pin.codePointAt(1) == 52) || (pin.codePointAt(1) == 53) ||
		 * (pin.codePointAt(1) == 54) || (pin.codePointAt(1) == 55) ||
		 * (pin.codePointAt(1) == 56) || (pin.codePointAt(1) == 57)) &&
		 * ((pin.codePointAt(2) == 48) || (pin.codePointAt(2) == 49) ||
		 * (pin.codePointAt(2) == 50) || (pin.codePointAt(2) == 51) ||
		 * (pin.codePointAt(2) == 52) || (pin.codePointAt(2) == 53) ||
		 * (pin.codePointAt(2) == 54) || (pin.codePointAt(2) == 55) ||
		 * (pin.codePointAt(2) == 56) || (pin.codePointAt(2) == 57)) &&
		 * ((pin.codePointAt(3) == 48) || (pin.codePointAt(3) == 49) ||
		 * (pin.codePointAt(3) == 50) || (pin.codePointAt(3) == 51) ||
		 * (pin.codePointAt(3) == 52) || (pin.codePointAt(3) == 53) ||
		 * (pin.codePointAt(3) == 54) || (pin.codePointAt(3) == 55) ||
		 * (pin.codePointAt(3) == 56) || (pin.codePointAt(3) == 57)) &&
		 * pin.length() == 4) { return true; } else { return false; }
         */
    }

    // PENCARIAN NO REKENING (TERDAFTAR || TIDAK)
    public int cariNoRek(String noRek) {
        // mencari data no rekening yang dinput melalui parameter dan
        // mengembalikan nilai indeks yang ditemukan.apabila tidak ditemukan,
        // kembalikan nilai -1
        int nilai = -1;
        for (int i = 0; i < dataNasabah.size(); i++) {
            if (dataNasabah.get(i).getNoRekening().equals(noRek)) {
                nilai = i;
            }
        }
        return nilai;
    }

    // PENGECEKAN NO REKENING (SUDAH ADA YANG MENGGUNAKAN || BELUM)
    public boolean cekNoRekAdaBelum(String noRek) {
        boolean x1 = true;
        for (int i = 0; i < dataNasabah.size(); i++) {
            if (dataNasabah.get(i).getNoRekening().equals(noRek)) {
                x1 = false;
            }
        }
        return x1;
    }
}
