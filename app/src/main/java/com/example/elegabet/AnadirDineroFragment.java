package com.example.elegabet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnadirDineroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnadirDineroFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnadirDineroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnadirDineroFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnadirDineroFragment newInstance(String param1, String param2) {
        AnadirDineroFragment fragment = new AnadirDineroFragment();
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

    private ImageView flechaIconAtrasHome3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_anadir_dinero, container, false);

        // Obtener la referencia del ImageView
        flechaIconAtrasHome3 = view.findViewById(R.id.flecaiconatrashome3);

        // Configurar el OnClickListener para la navegación
        flechaIconAtrasHome3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar hacia el fragmento FutbolFragment utilizando la ID definida en el action
                Navigation.findNavController(v).navigate(R.id.futbolFragment);
            }
        });

        return view;
    }
}