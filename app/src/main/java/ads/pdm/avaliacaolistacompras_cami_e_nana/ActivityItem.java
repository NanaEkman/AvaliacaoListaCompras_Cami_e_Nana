package ads.pdm.avaliacaolistacompras_cami_e_nana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityItem extends AppCompatActivity {
    
    private EditText txtNome;
    private EditText txtMarca;
    private EditText txtQuant;
    private Button btnInsere;
    private Button btnCancela;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        txtNome = findViewById(R.id.txtNome);
        txtMarca = findViewById(R.id.txtMarca);
        txtQuant = findViewById(R.id.txtQuant);
        btnCancela = findViewById(R.id.btnCancela);
        btnInsere = findViewById(R.id.btnInsere);

        btnInsere.setOnClickListener(new EscutadorBotaoInsere());
        btnCancela.setOnClickListener(new EscutadorBotaoCancela());

    }

    class EscutadorBotaoInsere implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            String nome, marca, quant;

            nome = txtNome.getText().toString();
            marca =  txtMarca.getText().toString();
            quant =  txtQuant.getText().toString();

            Intent i = new Intent();

            i.putExtra("nome", nome);
            i.putExtra("marca", marca);
            i.putExtra("quant", quant);

            setResult(RESULT_OK, i);

            finish();

        }
    }

    class EscutadorBotaoCancela implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            Intent i = new Intent();

            setResult(RESULT_CANCELED, i);

            finish();

        }
    }

}