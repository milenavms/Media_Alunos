package com.milena.aprovacaodealunos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    Regras de Negocios
//      4 disciplinas
//
//    Se a media for maior ou igual a 5, o aluno será aprovado. Caso contrário, será reprovado.
//    Se a quantidade de faltas for menor ou igual a 20 o aluno será aprovado. Caso contrário, será reprovado.
//
//    Se a média for maior ou igual a 5 e a quantidade de faltas for menor que 20, o aluno será reprovado por faltas.
//
//    Se a quantidade de faltas for meior ou igual a 20 e a media for menor que 5, o aluno será reprovado.

    //atributos do obejto MainActivity

    private EditText nota1, nota2, nota3, nota4, qtdFaltas;
    private Button btnCalcular;
    private TextView txtMedia, txtResultado;
    private ImageView icCheck, icClose, icBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //ocultando o actionBar
        getSupportActionBar().hide();

        nota1 = findViewById(R.id.edt_nota01);
        nota2 = findViewById(R.id.edt_nota02);
        nota3 = findViewById(R.id.edt_nota03);
        nota4 = findViewById(R.id.edt_nota04);
        qtdFaltas = findViewById(R.id.edt_qtd_faltas);
        btnCalcular = findViewById(R.id.btn_calcular);
        txtMedia= findViewById(R.id.txt_media);
        txtResultado = findViewById(R.id.txt_resultado);
        icCheck = findViewById(R.id.ic_check);
        icClose = findViewById(R.id.ic_close);
        icBtn = findViewById(R.id.ic_btn);

        icBtn.setVisibility(View.VISIBLE);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculaMedia();
            }
        });
    }


    public void CalculaMedia(){
        icClose.setVisibility(View.GONE);
        icCheck.setVisibility(View.GONE);
        icBtn.setVisibility(View.GONE);

        double nota01 = Double.parseDouble(nota1.getText().toString().replace(',', '.'));
        double nota02 = Double.parseDouble(nota2.getText().toString().replace(',', '.'));
        double nota03 = Double.parseDouble(nota3.getText().toString().replace(',', '.'));
        double nota04 = Double.parseDouble(nota4.getText().toString().replace(',', '.'));

        int faltas = Integer.parseInt(qtdFaltas.getText().toString());

        double mediaNota= (nota01 + nota02 + nota03 + nota04) / 4;

        if(mediaNota >= 5 && faltas <= 20){
            txtResultado.setText("O aluno foi Aprovado");
            txtResultado.setTextColor(getColor(R.color.teal_200));
            txtMedia.setText("Média: " + mediaNota);
            icCheck.setVisibility(View.VISIBLE);
        }else if(mediaNota >= 5 && faltas >= 20){
            txtResultado.setText("O aluno foi reprovado por faltas");
            txtResultado.setTextColor(getColor(R.color.red));
            txtMedia.setText("Média: " + String.valueOf(mediaNota));
            icClose.setVisibility(View.VISIBLE);
        }else if(mediaNota <= 5 && faltas <= 20){
            txtResultado.setText("O aluno foi reprovado por nota");
            txtResultado.setTextColor(getColor(R.color.red));
            txtMedia.setText("Média: " + String.valueOf(mediaNota));
            icClose.setVisibility(View.VISIBLE);
        }else {
            txtResultado.setText("O aluno foi reprovado por nota e faltas");
            txtResultado.setTextColor(getColor(R.color.red));
            txtMedia.setText("Média: " + String.valueOf(mediaNota));
            icClose.setVisibility(View.VISIBLE);
        }
    }






}