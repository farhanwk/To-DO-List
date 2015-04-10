/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Application {

    Scanner input = new Scanner(System.in);
    private User user[];
    private int countUser = 0;
    int iNow;
    int noUser2;
    private Invite[] invite;
    private int countInvite = 0;
    boolean ada = false;

    public Application(){
        user =new User[99];
        invite=new Invite[99];
    }

    public void addUser(String nama, String username, String password) {
        user[countUser] = new User(nama, username, password);
        countUser++;
    }

    public User getUser(int id) {
        return user[id];
    }

    public void regristrasi() {
        System.out.println("REGISTRASI");
        System.out.println("Nama: ");
        String nama = input.nextLine();
        System.out.println("Username:   ");
        String username = input.nextLine();
        boolean k = false;
        String password = "";
        while (k == false) {
            System.out.println("Password: ");
            password = input.nextLine();
            System.out.println("Confirm Password: ");
            String pass = input.nextLine();
            if (pass.equals(password)) {
                k = true;
            }
        }
        addUser(nama, username, password);
    }

    public void login() {

        int i = 0;
        iNow = 0;

        System.out.println("LOGIN");
        System.out.println("Username:   ");
        String username = input.nextLine();
        System.out.println("Password");
        String password = input.nextLine();

        while ((!ada) && (i < countUser)) {
            if ((user[i].getUsername().equals(username)) && (user[i].getPassword().equals(password))) {
                ada = true;
                iNow = i;
            } else if ((!user[i].getUsername().equals(username)) || (!user[i].getPassword().equals(password))) {
                ada = false;
                i++;
            }
        }

        if (ada) {
            System.out.println("Login sukses");
        } else if (!ada) {
            System.out.println("Login gagal");
            System.out.println("Masukan lagi");
            login();
        }

    }

    public boolean cekUser2(String username) {
        ada = false;
        int i = 0;

        while (!ada && i < countUser) {
            if (user[i].getNama() == username) {
                ada = true;
                noUser2 = i;
            } else {
                i++;
            }
        }
        return ada;
    }

    public void inviteUser2(String user2, int id) {
        if (cekUser2(user2)) {
            invite[id].addUser2(user[noUser2]);
        } else {
            System.out.println("User seperti hilal pada tahun 2012");
        }

    }

    public void munculinTask() {
        user[iNow].showAllTaskKategori();
    }

    public void buatTask() {
        System.out.print("Kegiatan:   ");
        String nama = input.nextLine();
        System.out.println("Kategori(Pilihan):  ");
        user[iNow].showAllKategori();
        System.out.print("Pilih:  ");
        int noKategori = 99;
        noKategori = input.nextInt();
        System.out.print("Reminder  ");
        System.out.print("Tanggal:    ");
        int tgl = 0;
        tgl = input.nextInt();
        System.out.print("Bulan ke:   ");
        int bulan = 0;
        bulan = input.nextInt();

        if ((noKategori == 99) && (tgl == 0 || bulan == 0)) {
            user[iNow].addTask(nama);
        } else if (noKategori == 99) {
            user[iNow].addTask(nama, tgl, bulan);
        } else if (tgl == 0 || bulan == 0) {
            user[iNow].addTask(nama, noKategori);
        } else {
            user[iNow].addTask(nama, noKategori, tgl, bulan);
        }
    }

    public void invite() {
        System.out.println("Masukkan teman yang di invite : ");
        String k = input.nextLine();
        ada = cekUser2(k);
        if (ada) {
            System.out.println("Masukkan nomor Task : ");
            int j = input.nextInt();
            invite[countInvite] = new Invite(user[iNow], user[noUser2], user[iNow].getTask(j));
        }
    }

}
