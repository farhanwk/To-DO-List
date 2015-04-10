/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author Farhan
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner i = new Scanner(System.in);
        Application a = new Application();
        int pil = 0;
        while (pil != 3) {
            System.out.println(" Silahkan Pilih menu");
            System.out.println("1.Registrasi");
            System.out.println("2.Login");
            System.out.println("3.EXIT");
            System.out.print("Pilih : ");
            pil = i.nextInt();
            switch (pil) {
                case 1:
                    a.regristrasi();
                    break;
                case 2:
                    a.login();
                    Runtime.getRuntime().exec("cls");
                    a.munculinTask();
                    int pilih = 0;
                    while (pilih != 3) {
                        System.out.println(" Silahkan Pilih menu");
                        System.out.println("1.Buat Task");
                        System.out.println("2.Invite");
                        System.out.println("3.Back ");
                        System.out.print("Pilih : ");
                        pilih = i.nextInt();
                        Runtime.getRuntime().exec("cls");
                        switch (pilih) {
                            case 1:
                                a.buatTask();
                                break;
                            case 2:
                                int pili = 0;
                                while (pili != 3) {
                                    System.out.println(" Silahkan Pilih menu");
                                    System.out.println("1.Invite Baru");
                                    System.out.println("2.Invite User");
                                    System.out.println("3.Back ");
                                    System.out.print("Pilih : ");
                                    pili = i.nextInt();
                                    switch (pili) {
                                        case 1:
                                            a.invite();
                                            break;
                                        case 2:
                                            System.out.println("Nama User");
                                            String x = i.nextLine();
                                            System.out.println("No Invite");
                                            int y = i.nextInt();
                                            a.inviteUser2(x, y);
                                            break;
                                    }
                                }
                                break;
                        }

                    }
                    break;
            }

        }
    }

}
