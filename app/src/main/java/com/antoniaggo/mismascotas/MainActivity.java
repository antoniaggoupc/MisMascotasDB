package com.antoniaggo.mismascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.antoniaggo.mismascotas.adapter.PageAdapter;
import com.antoniaggo.mismascotas.fragment.ProfileFragment;
import com.antoniaggo.mismascotas.fragment.RecyclerViewFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    private ImageView img_star;

    private Toolbar toolbar;

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    PageAdapter adapter;

    // private RecyclerView.Adapter pageAdapter;
    private AppBarLayout appBarLayout;

    // The Toolbar will not display the application title unless it is declared as an ActionBar.
// assigning ID of the toolbar to a variable
// Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

    // using toolbar as ActionBar
// Sets the Toolbar to act as the ActionBar for this Activity window.
// Make sure the toolbar exists in the activity and is not null
// setSupportActionBar(toolbar);

    // using toolbar as ActionBar
// Sets the Toolbar to act as the ActionBar for this Activity window.
// Make sure the toolbar exists in the activity and is not null
// setSupportActionBar(toolbar);

    ArrayList<Fragment> fragments = agregarFragments();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments = agregarFragments();
        setupToolbar();
        setupViewPager();
        setupTabLayout();


    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        Intent intent;
        switch (item.getItemId()){
            case R.id.mContact:
                intent = new Intent(this, Formulario_Activity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mAbout:
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onMascotasFavoritas()
    {
        //
        // Para cambiar de pantalla de MainActivity a DetalleContacto
        // al pulsar sobre un ítem de MainActivity
        //
        Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
        //
        // Para enviar los datos de cada contacto a la Activity DetalleContacto
        //
           /* intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(i).getNombre());
            intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(i).getTelefono());
            intent.putExtra(getResources().getString(R.string.pemail), contactos.get(i).getEmail());
            */

        startActivity(intent);
        // Elimino esta Activity para que no se vayan congelando y guardando en background ya
        // que es como se comporta por defecto.  Una activity encima de la otra,ect.
        // Con esta forma de programar sólo tengo siempre una Activity ejecutándose
        // y mi aplicación no se ralentiza a medida que el usuario la va usando
        // ya que no se van superponiendo las activies una encima de la otra
        //
        //finish();
    }

    private ArrayList<Fragment> agregarFragments(){
        fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new ProfileFragment());
        return fragments;
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.fragment_toolbar);
        // Realizamos una validación
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        img_star = findViewById(R.id.imv_star);
        img_star.setOnClickListener(view -> onMascotasFavoritas());

    }

    private void setupViewPager() {
        viewPager2 = findViewById(R.id.viewPager2);
        adapter = new PageAdapter(getSupportFragmentManager(), getLifecycle(), fragments);
        viewPager2.setAdapter(adapter);

    }

    /*
    La integración entre TabLayout y ViewPager2
    es realizada por la clase TabLayoutMediator.
    Su cometido consiste en sincronizar los cambios en ambos elementos.
     */
    private void setupTabLayout() {
        tabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
                    tab.setIcon(PageAdapter.Tab.byPosition(position).icon);
                   // tab.setText(PageAdapter.Tab.byPosition(position).title);
                })
                .attach();
    }


}