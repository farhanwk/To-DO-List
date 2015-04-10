/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

/**
 *
 * @author USER
 */
public class User {

    private String nama;
    private String username;
    private String password;
    private Jadwal[] jadwal;
    private int countJadwal;
    private Kategori[] kategori;
    private int countKategori;
    private Task[] task;
    private int countTask;
    private Kategori inbox;

    public User(String nama, String username, String password) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        kategori = new Kategori[99];
        kategori[0] = new Kategori("Inbox");
        countKategori = 1;
        inbox = kategori[0];
    }

    public String getNama() {
        return this.nama;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void addTask(String judul) {
        inbox.addTask(new Task(judul));
    }

    public void addTask(String judul, int tgl, int bulan) {
        inbox.addTask(new Task(judul));
        boolean ada = false;
        int i = 0;

        while (!ada && i <= countJadwal) {
            if (jadwal[i].getTgl() == tgl && jadwal[i].getBulan() == bulan) {
                ada = true;
            } else {
                i++;
            }
        }

        if (ada) {
            jadwal[i].addTask(inbox.getTask(inbox.getCount()));
        } else {
            jadwal[countJadwal] = new Jadwal(tgl, bulan);
            jadwal[countJadwal].addTask(inbox.getTask(inbox.getCount()));
        }

    }

    public void addTask(String judul, int noKategori) {
        if (noKategori > countKategori) {
            //kasih eksepsyen  
        } else {
            task[countTask] = new Task(judul);
            kategori[noKategori].addTask(task[countTask]);
            countTask++;
        }
    }

    public void addTask(String judul, int noKategori, int tgl, int bulan) {
        //Masukin task 
        if (noKategori > countKategori) {
            //kasih eksepsyen  
        } else {
            addTask(judul, noKategori);
            boolean ada = false;
            int i = 0;

            while (!ada && i <= countJadwal) {
                if (jadwal[i].getTgl() == tgl && jadwal[i].getBulan() == bulan) {
                    ada = true;
                } else {
                    i++;
                }
            }
            task[countTask] = new Task(judul);
            if (ada) {
                jadwal[i].addTask(task[countTask]);
            } else {
                jadwal[countJadwal] = new Jadwal(tgl, bulan);
                jadwal[countJadwal].addTask(task[countTask]);
            }
            countTask++;
        }
    }
    
    public void deleteTask(int id){
        for (int i = 0; i < countKategori; i++) {
            for (int j = 0; j < kategori[i].getCount(); j++) {
                if (task[id].getNama().equals(kategori[i].getTask(id).getNama())) {
                    kategori[i].taskNull(id);
                }
            }
        }
        
        for (int i = 0; i < countJadwal; i++) {
            for (int j = 0; j < jadwal[i].getCount(); j++) {
                if (task[id].getNama().equals(jadwal[i].getTask(id).getNama())) {
                    jadwal[i].taskNull(id);
                }
            }
        }
        
        task[id] = null;
    }
    
    public void addKategori(String nama) {
        countKategori++;
        kategori[countKategori] = new Kategori(nama);
    }

    public void showAllKategori() {
        for (int i = 0; i < countKategori; i++) {
            System.out.println(kategori[i].getNama());
        }
    }

    public void showAllTaskKategori() {
        for (int i = 0; i < countKategori; i++) {
            kategori[i].showAllTask();
        }
    }
    
    public void showAllTaskdalamKategori(int id){
        kategori[id].showAllTask();
    }
    
    public void showAllJadwal(){
        for (int i = 0; i < countJadwal; i++) {
            System.out.println(jadwal[i].getNama());
        }
    }
    
    public void showAllTaskJadwal() {
        for (int i = 0; i < countJadwal; i++) {
            jadwal[i].showAllTask();
        }
    }
    
    public void showAllTaskdalamJadwal(int id){
        jadwal[id].showAllTask();
    }
    
    public Task getTask(int id){
        return task[id];
    }
    public String getTasknama(int id){
        return task[id].getNama();
    }
    
}
