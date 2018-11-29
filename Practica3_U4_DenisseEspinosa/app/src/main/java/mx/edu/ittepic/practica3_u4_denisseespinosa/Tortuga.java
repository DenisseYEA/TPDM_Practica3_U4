package mx.edu.ittepic.practica3_u4_denisseespinosa;


/**
 * Created by denisseyea on 20/11/18.
 */

public class Tortuga {
    int s,c = 1,p;

    public void jTortuga(){
        p = (int) (Math.random() * 100) + 1;
        if (p <= 50){
            s = 1;
        }else if (p <= 80){
            s = 3;
        }else {
            s = 2;
        }

        if (s == 2){
            if (c <= 6){
                c = 1;
            }else {
                c-=6;
            }
        }else if (s == 1){
            if (c > 67){
                c = 70;
            }else {
                c+=3;
            }
        }else {
            c+=1;
        }

    }
}
