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
public class Invite {
    private User user1;
    private User user2[];
    private int count;
    private Task task;
    
    public Invite(User user1, User user2, Task task){
                this.user1 = user1;
this.user1 = user1;
        addUser2(user2);
    }
    public void addUser2(User us){
        user2[count]=us;
        us.addTask(task.getNama());
        count++;
    }
    public Task getTask() {
        return task;
    }

    public String getUser1() {
        return user1.getNama();
    }

    public String getUser2(int id) {
        return user2[id].getNama();
    }
    
}
