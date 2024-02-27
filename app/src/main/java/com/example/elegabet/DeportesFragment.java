package com.example.elegabet;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeportesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeportesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeportesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeportesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeportesFragment newInstance(String param1, String param2) {
        DeportesFragment fragment = new DeportesFragment();
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

    private LinearLayout Suuuu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toolbar mainToolbar = requireActivity().findViewById(R.id.toolbar);
        mainToolbar.setTitle("ELEGABET");

        View view = inflater.inflate(R.layout.fragment_deportes, container, false);

        // Obtener referencia al LinearLayout
        Suuuu = view.findViewById(R.id.suuuu);

        // Configurar OnClickListener para el LinearLayout
        Suuuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar al fragmento infoPartidoFragment
                Navigation.findNavController(v).navigate(R.id.futbolFragment);
            }
        });

        return view;
    }
}