package mx.edu.ittepic.practica3_u4_denisseespinosa;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Thread jtortuga,jliebre;
    String sucesot[] = {"Avance rápido","Resbaló","Avance lento"},sucesol[]={
            "Pequeño salto","Duerme","Gran salto","Resbalón pequeño","Resbalón grande"
    };
    Liebre l = new Liebre();
    Tortuga t = new Tortuga();
    TextView tsuceso,tcasilla,lsuceso,lcasilla;
    Boolean status= true;
    Button i,r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tsuceso = findViewById(R.id.tortugasuceso);
        tcasilla = findViewById(R.id.tortugacasilla);
        lsuceso = findViewById(R.id.liebresuceso);
        lcasilla = findViewById(R.id.liebrecasilla);
        i = findViewById(R.id.iniciar);
        r = findViewById(R.id.reiniciar);

        tcasilla.setText("");
        tsuceso.setText("");
        lsuceso.setText("");
        lcasilla.setText("");
        r.setVisibility(View.GONE);

        jtortuga = new Thread(){
          public void run(){
              while (status = true) {
                  while (t.c < 70 && l.c < 70) {
                      try {
                          sleep(1000);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      t.jTortuga();
                      runOnUiThread(new Runnable() {
                          @Override
                          public void run() {
                              tsuceso.setText(sucesot[t.s - 1]);
                              tcasilla.setText(t.c + "");
                              if (t.c == 70) {
                                  ganador();
                              }
                          }
                      });


                  }
              }
          }
        };

        jliebre = new Thread(){
            public void run(){
                while (status = true) {
                    while (l.c < 70 && t.c < 70) {
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        l.jLiebre();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                lsuceso.setText(sucesol[l.s - 1]);
                                lcasilla.setText(l.c + "");
                                if (l.c == 70) {
                                    ganador();
                                }
                            }
                        });


                    }
                }
            }
        };
    }

    public void iniciar(View v){
        tcasilla.setText(t.c+"");
        lcasilla.setText(l.c+"");
        jtortuga.start();
        jliebre.start();
        i.setVisibility(View.GONE);
        r.setVisibility(View.VISIBLE);
    }

    public void reiniciar(View v){
        t.c = 1;
        l.c = 1;
        tcasilla.setText(t.c+"");
        tsuceso.setText("");
        lsuceso.setText("");
        lcasilla.setText(l.c+"");
    }

    private void ganador(){
        if (l.c == 70 && t.c == 70){
            AlertDialog.Builder alertaGanador = new AlertDialog.Builder(MainActivity.this);
            alertaGanador.setTitle("¡GANADOR!").setMessage("EMPATE").show();
        }else if (l.c == 70){
            AlertDialog.Builder alertaGanador = new AlertDialog.Builder(MainActivity.this);
            alertaGanador.setTitle("¡GANADOR!").setMessage("LIEBRE").show();
        }else {
            AlertDialog.Builder alertaGanador = new AlertDialog.Builder(MainActivity.this);
            alertaGanador.setTitle("¡GANADOR!").setMessage("TORTUGA").show();
        }
    }
}
