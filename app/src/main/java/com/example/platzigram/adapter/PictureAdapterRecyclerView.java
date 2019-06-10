package com.example.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.platzigram.R;
import com.example.platzigram.model.Picture;
import com.example.platzigram.views.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

//2
//inicializacos el picure view holder, pero por defecto agarra el pictureAapterViewHolder, por que es el padre

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder> {

    private ArrayList<Picture> pictures; // esta es la cantidad de listas que abra ene recycler view
    private int resource;  // nuestro card view e layout
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }




    @NonNull
    @Override // aca inflamos card view, para que se duplique el card view
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource, viewGroup, false);
        return new PictureViewHolder(view);
    }

    @Override
    //  aqui se envia deacuerdia a la posiciion con el 'i'
    //si te das cuenta envia los datos que se obtiene
    //en pocas palabras retorna la posicion
    public void onBindViewHolder(@NonNull PictureViewHolder pictureViewHolder, int i) {
        Picture picture = pictures.get(i);
        pictureViewHolder.usernameCard.setText(picture.getUserName());
        pictureViewHolder.timeCard.setText(picture.getTime());
        pictureViewHolder.likeNumberCard.setText(picture.getLikeNumber());

        //aaqui esta la parte del Picasso, el cual remplazara la iamgen para que sea unade internet
        Picasso.get().load(picture.getPicture()).into(pictureViewHolder.pictureCard);



        // cada que le de click a idPicture card, se abrirar picture detail Activity
        //aqui es la modificacion que se hara para enviar la foto en el activity_picture_detail.xml
        pictureViewHolder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);
                activity.startActivity(intent);
            }
        });

    }

    @Override //la cantidad que mide el array
    public int getItemCount() {
        return pictures.size();
    }


    // 1.
    //aqui se instancia cada objeto que tiene el card view, como el picture card, text view
    // Esto se concentra en un card a la vez

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        // todos los view que conformen el card view
        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumberCard;

        //este es el constructor
        public PictureViewHolder(View itemView){
            super(itemView);
            //como el constrcutor, pero aca se usa el identificador donde se encuentran estos views
            pictureCard = itemView.findViewById(R.id.idPictureCard);
            usernameCard = itemView.findViewById(R.id.idUserNameCard);
            timeCard = itemView.findViewById(R.id.idTimeCard);
            likeNumberCard = itemView.findViewById(R.id.idLikeNumberCard);
        }
    }
}
