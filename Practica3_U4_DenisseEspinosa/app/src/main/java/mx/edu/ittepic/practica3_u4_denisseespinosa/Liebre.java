package mx.edu.ittepic.practica3_u4_denisseespinosa;

/**
 * Created by denisseyea on 20/11/18.
 */

public class Liebre {
    int s,c = 1,p;

    public void jLiebre() {
        p = (int) (Math.random() * 100) + 1;
        if (p <= 30){
            s = 1;
        }else if (p <= 50){
            s = 2;
        }else if (p <= 70){
            s = 3;
        }else if (p <= 90){
            s = 4;
        }else {
            s = 5;
        }

        if (s == 5){
            if (c <= 12){
                c = 1;
            }else {
                c-=12;
            }
        }else if (s == 4){
            if (c <= 2){
                c = 1;
            }else {
                c-=2;
            }
        }else if (s == 3){
            if (c > 61){
                c = 70;
            }else {
                c+=9;
            }
        }else if (s == 2){

        }else {
            c+=1;
        }
    }
}
