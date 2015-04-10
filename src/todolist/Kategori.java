/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package todolist;

/**
 *
 * @author Farhan
 */
public class Kategori {
    private String nama;
    private Task[] task;
    private int count = 0;
    
    public Kategori (String nama){
        this.nama = nama;
        task = new Task[99];
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void addTask(Task task){
        if (count < 99) {
            count++;
            this.task[count] = task;  
        } else {
            System.out.println("Penuh.");
        }
    }
    
    public Task getTask(int id){
        return task[id];
    }
    
    public int getCount(){
        return this.count;
    }
    
    public void taskNull(int id){
        task[id] = null;
    }
    
    public void showAllTask(){
        System.out.println("Kategori "+getNama());
        for (int i = 0; i <= count; i++) {
            System.out.println(task[i].getNama());
        }
    }
    
}
