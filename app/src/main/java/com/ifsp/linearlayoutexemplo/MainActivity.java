package com.ifsp.linearlayoutexemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText textInput;
    private TextView textResultado, textEscolha, textTamanho;
    private CheckBox cboxBranco, cboxPreto, cboxVerde;
    private RadioGroup rgTam;
    private RadioButton rbP, rbM, rbG;
    private ImageButton imagem;
    List<String> check = new ArrayList<String>();
    private Button btn;



    private Switch swImagem;
    private ToggleButton tbHabilitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btn = findViewById(R.id.btnEnviar);
        swImagem = findViewById(R.id.swOcultar);
        tbHabilitado = findViewById(R.id.tbHabilitado);
        imagem = findViewById(R.id.imB);
        textInput = findViewById(R.id.txtInput);
        textResultado = findViewById(R.id.txtvResultado);
        cboxBranco = findViewById(R.id.cbBranco);
        cboxPreto = findViewById(R.id.cbPreto);
        cboxVerde = findViewById(R.id.cbVerde);
        textEscolha = findViewById(R.id.txtvEscolhaCheck);
        cboxVerde = findViewById(R.id.cbVerde);

        textTamanho = findViewById(R.id.txtvRadio);
        rbG = findViewById(R.id.rbG);
        rbM = findViewById(R.id.rbM);
        rbP = findViewById(R.id.rbP);
        rgTam = findViewById(R.id.rgTamanho);

        swImagem.setOnClickListener(new Switch.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (swImagem.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Deslizou " + swImagem.getTextOn().toString(), Toast.LENGTH_SHORT).show();
                    imagem.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getApplicationContext(), "Deslizou " + swImagem.getTextOff().toString(), Toast.LENGTH_SHORT).show();
                    imagem.setVisibility(View.GONE);
                }
            }
        });
        tbHabilitado.setOnClickListener(new ToggleButton.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (tbHabilitado.isChecked()) {
                    Toast.makeText(getApplicationContext(), "toggle : " + tbHabilitado.getTextOn().toString() , Toast.LENGTH_SHORT).show();
                    btn.setEnabled(true);
                } else {
                    Toast.makeText(getApplicationContext(), "toggle " + tbHabilitado.getTextOff().toString(), Toast.LENGTH_SHORT).show();
                    btn.setEnabled(false);
                }
            }

        });





        this.CriarListenerRadio();
    }



    public void enviar(View v){
        String item;
        item = textInput.getText().toString();
        textResultado.setText(item);
        verificaCheck(v);
    }

    public void verificaCheck(View v){
        check.clear();
        if(cboxBranco.isChecked()) {
          check.add(cboxBranco.getText().toString());
        }
        if(cboxPreto.isChecked()) {
            check.add(cboxPreto.getText().toString());
        }
        if(cboxVerde.isChecked()) {
            check.add(cboxVerde.getText().toString());
        }
        textEscolha.setText(check.toString());
    }

    public void CriarListenerRadio(){
        rgTam.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbP) {

                    textTamanho.setText("Pequeno");

                } else if (checkedId == R.id.rbM) {

                    textTamanho.setText(rbM.getText().toString());

                } else if(checkedId == R.id.rbG){
                    textTamanho.setText("Não disponível");
                }
            }
        });
    }



}