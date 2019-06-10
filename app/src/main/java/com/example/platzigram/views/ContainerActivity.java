package com.example.platzigram.views;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.platzigram.R;
import com.example.platzigram.views.fragment.HomeFragment;
import com.example.platzigram.views.fragment.ProfileFragment;
import com.example.platzigram.views.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        callBottomBar();
    }


    private  void callBottomBar(){
        // creamos la variable u objeto de "bottom_navigationView.xml"
        BottomNavigationView bottomNavigationView= findViewById(R.id.idBottomNavigationView);

        //Aqui viene el listener, que esta atento al click, cuando se preseionara un buttonNavigationView (Tab) ejemplo
        //hoombe, search, profile ... osea le doy click y esa me hace la logica de cual mostrar
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem _menuItem) {

                int nameMenu=_menuItem.getItemId();

                switch(nameMenu){
                    case R.id.idAction_home:
                        switchFragment(new HomeFragment());
                        break;
                    case R.id.idAction_profile:
                        switchFragment(new ProfileFragment());
                        break;
                    case  R.id.idAction_search:
                        switchFragment(new SearchFragment());
                        break;
                }

                return true;
            }
        });

        //set HomeFragment as Default on first load (Login)
        bottomNavigationView.setSelectedItemId(R.id.idAction_home);
    }

    private void switchFragment(Fragment _fragment){

        getSupportFragmentManager()     //administrar el fragment
                .beginTransaction()     // transaccion para añadir el fragment
                .replace(R.id.idContainer,_fragment)   // aca remplaza el activitycontayner.xml por el home fragment
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE) //estio de la transicion
                .addToBackStack(null)       //para que no haya problemas al momneot de aplicar el estilo de la transicion
                .commit();              //guardar cambios
    }
}


