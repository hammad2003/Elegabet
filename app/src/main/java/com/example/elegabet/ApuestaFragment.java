package com.example.elegabet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ApuestaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ApuestaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ApuestaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ApuestaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ApuestaFragment newInstance(String param1, String param2) {
        ApuestaFragment fragment = new ApuestaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ImageView flechaIconAtrasHome2;
    private ImageButton btnPlus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apuesta, container, false);

        // Obtener la referencia del ImageView
        flechaIconAtrasHome2 = view.findViewById(R.id.flecaiconatrashome2);
        btnPlus = view.findViewById(R.id.btnPlus);

        // Configurar el OnClickListener para la navegación
        flechaIconAtrasHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar hacia el fragmento FutbolFragment utilizando la ID definida en el action
                Navigation.findNavController(v).navigate(R.id.apuesta_to_fultbol);
            }
        });

        // Configurar el OnClickListener para el botón btnPlus
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar hacia el fragmento AnadirDineroFragment utilizando la ID definida en el action
                Navigation.findNavController(v).navigate(R.id.apuesta_to_anadir_dinero);
            }
        });

        return view;
    }
}