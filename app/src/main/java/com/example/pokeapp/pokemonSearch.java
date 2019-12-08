package com.example.pokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class pokemonSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_search);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Intent intent = getIntent();
        int input = intent.getIntExtra("input", 1);
        startSearch(input);
    }
    private void startSearch(int input) {
        TextView pokemonID = findViewById(R.id.pokemonID);
        TextView pokemonName = findViewById(R.id.pokemonName);
        TextView baseExperience = findViewById(R.id.baseExperience);
        TextView height = findViewById(R.id.height);
        TextView isDefault = findViewById(R.id.isDefault);
        TextView order = findViewById(R.id.order);
        TextView weight = findViewById(R.id.weight);
        TextView type = findViewById(R.id.type);
        TextView type20 = findViewById(R.id.type20);
        TextView type2 = findViewById(R.id.type2);
        type20.setVisibility(View.GONE);
        type2.setVisibility(View.GONE);
        PokeApi api = new PokeApiClient();
        Pokemon pokemon = api.getPokemon(input);
        pokemonID.setText("" + pokemon.getId());
        pokemonName.setText("" + pokemon.getName());
        baseExperience.setText("" + pokemon.getBaseExperience());
        height.setText("" + pokemon.getHeight());
        isDefault.setText("" + pokemon.isDefault());
        order.setText("" + pokemon.getOrder());
        weight.setText("" + pokemon.getWeight());
        type.setText("" + pokemon.getTypes().get(0).getType().getName());
        if (pokemon.getTypes().size() > 1) {
            type2.setText("" + pokemon.getTypes().get(1).getType().getName());
            type2.setVisibility(View.VISIBLE);
            type20.setVisibility(View.VISIBLE);
        }
        ImageView image = findViewById(R.id.imageView);
        try {
            String url = pokemon.getSprites().getFrontDefault();
            image.setImageBitmap(new getImage().execute(new String[]{url}).get());
        } catch (Exception e) {
            image.setVisibility(View.GONE);
        }

    }
    public class getImage extends AsyncTask<String, Void, Bitmap> {
        URL myFileUrl = null;
        Bitmap bmImg = null;
        protected Bitmap doInBackground(String... args) {
            try {
                myFileUrl = new URL(args[0]);
                HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
                conn.setDoInput(true);
                conn.connect();
                InputStream is = conn.getInputStream();
                bmImg = BitmapFactory.decodeStream(is);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("error", "there was an error");
            }
            return bmImg;
        }
    }
}
