package br.com.teravalt.demonaviagtiondrawer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.teravalt.demonaviagtiondrawer.R;

import static android.R.attr.breadCrumbShortTitle;
import static android.R.attr.onClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormularioFragment extends Fragment implements View.OnClickListener {

    public EditText etValor1, etValor2;
    public TextView tvResultado;
    public Button btSomar, btSubtrair, btMultiplicar, btDividir;

    public FormularioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_formulario,container,false);

        etValor1 = (EditText)v.findViewById(R.id.etValor1);
        etValor2 = (EditText)v.findViewById(R.id.etValor2);
        tvResultado = (TextView)v.findViewById(R.id.tvResultado);

        btSomar = (Button)v.findViewById(R.id.btSomar);
        btSubtrair = (Button)v.findViewById(R.id.btSubtrair);
        btDividir = (Button)v.findViewById(R.id.btDividir);
        btMultiplicar = (Button)v.findViewById(R.id.btMultiplicar);

        btSomar.setOnClickListener(this);
        btSubtrair.setOnClickListener(this);
        btDividir.setOnClickListener(this);
        btMultiplicar.setOnClickListener(this);

        return v;
    }

    public void onClick(View v){
        int resultado = 0;

        if(etValor1.getText().toString().trim().equals("")){
            Toast.makeText(getContext(),"Informa o valor 1",Toast.LENGTH_SHORT).show();
            return;
        }
        if(etValor2.getText().toString().trim().equals("")){
            Toast.makeText(getContext(),"Informa o valor 2",Toast.LENGTH_SHORT).show();
        }

        int v1 = Integer.parseInt(etValor1.getText().toString().trim());
        int v2 = Integer.parseInt(etValor2.getText().toString().trim());

        switch (v.getId()){
            case R.id.btSomar:
                resultado = v1 + v2;
                break;
            case R.id.btSubtrair:
                resultado = v1 - v2;
                break;
            case R.id.btDividir:
                resultado = v1 / v2;
                break;
            case R.id.btMultiplicar:
                resultado = v1 * v2;
                break;
        }

        tvResultado.setText(String.valueOf(resultado));

    }



}
