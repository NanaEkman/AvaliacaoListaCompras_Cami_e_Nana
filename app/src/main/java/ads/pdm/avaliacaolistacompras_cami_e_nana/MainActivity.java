package ads.pdm.avaliacaolistacompras_cami_e_nana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Camila Devita Basaglia SC3010058 e Nana de Souza Ekman Simões SC3010414

    private Button btnAdiciona;
    private ArrayList<Item> listaItens = new ArrayList<>();
    private AdapterItem adaptador;
    private ListView listaCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdiciona = findViewById(R.id.btnAdiciona);
        btnAdiciona.setOnClickListener(new EscutadorBotaoAdiciona());
        listaCompras = findViewById(R.id.listaCompras);

        adaptador = new AdapterItem(this, listaItens);

        listaCompras.setAdapter(adaptador);

        listaCompras.setOnItemClickListener(new EscutadorLista());

        listaCompras.setOnItemLongClickListener(new EscutadorLista());
    }

    class EscutadorBotaoAdiciona implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), ActivityItem.class);
            startActivityForResult(i, 1);

        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent i) {

        super.onActivityResult(requestCode, resultCode, i);

        if(resultCode == RESULT_OK){
            String nome, marca, quant;

            nome = i.getStringExtra("nome");
            marca = i.getStringExtra("marca");
            quant = i.getStringExtra("quant");

            Item item = new Item(nome, marca, quant);
            listaItens.add(item);
            adaptador.notifyDataSetChanged();


        }

    }

    private class EscutadorLista implements AdapterView.OnItemClickListener,
                                            AdapterView.OnItemLongClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Item item = listaItens.get(i);

            if(item.getComprado().equals("")){
                item.setComprado("* COMPRADO *");
                Toast.makeText(MainActivity.this, "Item comprado!", Toast.LENGTH_SHORT).show();
            }else if(item.getComprado().equals("* COMPRADO *")){
                item.setComprado("");
                Toast.makeText(MainActivity.this, "Compra cancelada!", Toast.LENGTH_SHORT).show();
            }

            adaptador.notifyDataSetChanged();

        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

            listaItens.remove(i);
            adaptador.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Item apagado!", Toast.LENGTH_SHORT).show();

            return true;
        }
    }

}