package com.example.platzigram.views.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.platzigram.R;
import com.example.platzigram.adapter.PictureAdapterRecyclerView;
import com.example.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        // showToolbar("Hola mundo!", true, view);

        // Inflate the layout for this fragment
        // aqui definimos que el recycler view esta en el layout fragment_home.xml
        // y ahi se encuentra el idPictureRecyclerView
        RecyclerView picturesRecycler = view.findViewById(R.id.idPictureProfile_RecyclerView);

        //aqui defiidmos que el layout manager es el idPicture recycler view .. con el paramentro
        //linear layoutManagger y es de forma vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // aqui se envia el dato de quien es el layout manager .. el nombre del objeto ese se envia
        picturesRecycler.setLayoutManager(linearLayoutManager);

        //especificamos el aadaptador y apartir de aqui se construira
        //si te das cuentan costruira aparte del "cardview_picture"
        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(
                buildPictures(),R.layout.cardview_picture, getActivity());

        // aqui al fragment_home xml .. se le envia el adaptador que vendria a ser el card view, para que apartir
        // de un cardview se genere varios
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);


        return view;
    }


    // aqui vamos agregando cuantos queramos
    public ArrayList<Picture> buildPictures(){
        ArrayList <Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://images.unsplash.com/photo-1528914137830-c85ee162f588?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                "Uriel Ramírez",
                "2 días",
                "3 Me Gusta"));
        pictures.add(new Picture("https://images.unsplash.com/photo-1464002255390-2de63a26c637?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                "Juan Pablo",
                "3 días",
                "10 Me Gusta"));
        pictures.add(new Picture("https://images.unsplash.com/photo-1538097304804-2a1b932466a9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjU1NzQ5fQ&auto=format&fit=crop&w=1050&q=80",
                "Anahi Salgado",
                "2 días",
                "9 Me Gusta"));
        return pictures;
    }

/*
    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar tollbar = view.findViewById(R.id.idToolbarProfile);
        ((AppCompatActivity)getActivity()).setSupportActionBar(tollbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }*/
}
