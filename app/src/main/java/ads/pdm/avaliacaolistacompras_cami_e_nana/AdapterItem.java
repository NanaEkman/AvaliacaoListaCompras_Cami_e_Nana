package ads.pdm.avaliacaolistacompras_cami_e_nana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterItem extends ArrayAdapter<Item> {

    private Context context;
    private ArrayList<Item> listaItens;

    public AdapterItem(Context context, ArrayList<Item> listaItens) {
        super(context, R.layout.item_lista, listaItens);
        this.context = context;
        this.listaItens = listaItens;
    }


    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View itemView = li.inflate(R.layout.item_lista, parent, false);

        TextView lblNome = itemView.findViewById(R.id.lblProduto);
        TextView lblMarca = itemView.findViewById(R.id.lblMarca);
        TextView lblQuant = itemView.findViewById(R.id.lblQuant);
        TextView lblComprado = itemView.findViewById(R.id.lblComprado);

        lblNome.setText(listaItens.get(position).getNome());
        lblMarca.setText(listaItens.get(position).getMarca());
        lblQuant.setText(listaItens.get(position).getQuant());

        lblComprado.setText(listaItens.get(position).getComprado());

        return itemView;

    }



}
