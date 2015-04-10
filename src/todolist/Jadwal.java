/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package todolist;

import java.util.Date;

/**
 *
 * @author Farhan
 */
public class Jadwal {
    private Date date;
    private Task[] task;
    private int count = 0;
    private String nama;
    
    public Jadwal(int tgl, int bulan){
        String str1 = Integer.toString(tgl);
        String str2 = Integer.toString(bulan);
        nama = str1+"Bulan "+str2;
        
        date = new Date(2015, bulan, tgl);
        task = new Task[99];   
    }
    

    
    public void addTask(Task task){
        if (count < 99) {
            this.task[count] = task;
            count++;
        } else {
            System.out.println("Penuh.");
        }
    }
    public Task getTask(int id){
        return task[id];
    }

    public String getNama() {
        return nama;
    }
    
    public int getTgl(){
        return date.getDay();
    }
    
    public int getBulan(){
        return date.getMonth();
    }
    
    public int getCount(){
        return count;
    }
    
    public void showAllTask(){
        System.out.println(date);
        for (int i = 0; i < count; i++) {
            System.out.println(task[i].getNama());
        }
    }

    public void taskNull(int id) {
        task[id] = null;
    }
}
