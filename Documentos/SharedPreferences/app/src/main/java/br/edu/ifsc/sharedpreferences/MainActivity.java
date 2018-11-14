package br.edu.ifsc.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textResultado;
    TextInputEditText editText;
    Button salveBtn;

    private static final String FILE = "notas";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado = (TextView) findViewById(R.id.textRest);
        editText = (TextInputEditText) findViewById(R.id.inputText);
        salveBtn = (Button) findViewById(R.id.salveButton);

        this.preferences = getSharedPreferences(FILE, MODE_PRIVATE);
        this.editor = preferences.edit();
        salveBtn.setOnClickListener(clickSalvar);

        recuperaValor();

        /*editor.putString("nota", "Pedro de lalala, lalala");
        editor.commit();

        //this.preferences.getString("nota","deu merda!!");
        this.textResultado.setText(this.preferences.getString("nota", "Deu merda!!! Que dia foi isso!!"));*/
    }

    private final Button.OnClickListener clickSalvar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (editText.getText().toString().trim().equals("")) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.nota_vazia), Toast.LENGTH_LONG).show();
            } else{
                editor.putString("nota", editText.getText().toString());
                editor.commit();
                recuperaValor();
            }
        }
    };

    public void recuperaValor(){
        if (preferences.contains("nota")){
            textResultado.setText(preferences.getString("nota", getResources().getString(R.string.valor_default)));
        }
    }

}













//conceitos e linguagens de programalçao : Livro
