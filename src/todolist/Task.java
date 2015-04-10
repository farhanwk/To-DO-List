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
public class Task {
    private String nama;
    
    public Task(String nama){
        this.nama = nama;
    }
    
    public void setnama(String nama){
        this.nama = nama;
    }

    public String getNama() {
        return this.nama;
    }
   
}
