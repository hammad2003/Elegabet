package com.example.elegabet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IniciarSesionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IniciarSesionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IniciarSesionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IniciarSesionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IniciarSesionFragment newInstance(String param1, String param2) {
        IniciarSesionFragment fragment = new IniciarSesionFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_iniciar_sesion, container, false);

        // Configurar OnClickListener para el texto "¿Has olvidado tu contraseña?"
        View btnOlvidarContrasena = view.findViewById(R.id.IStxtHasolvidadot);
        btnOlvidarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar al fragmento de inicio
                Navigation.findNavController(v).navigate(R.id.login_to_olvidar_contrasena);
            }
        });


        // Configurar OnClickListener para el botón "INICIAR SESIÓN"
        View btnIniciarSesion = view.findViewById(R.id.ISbtnIniciarSesin);
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar al fragmento de inicio
                Navigation.findNavController(v).navigate(R.id.login_to_home);
            }
        });


        // Configurar OnClickListener para el botón "CREAR AHORA"
        View btnCrearAhora = view.findViewById(R.id.ISbtnInsasdiciarSesin);
        btnCrearAhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar al fragmento de restablecimiento de contraseña
                Navigation.findNavController(v).navigate(R.id.login_to_registro);
            }
        });

        return view;
    }
}