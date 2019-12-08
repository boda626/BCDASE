package com.example.pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Berry;

public class Poke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Intent intent = getIntent();
        int input = intent.getIntExtra("input", 1);
        startSearch(input);
    }

    private void startSearch(int input) {
        TextView idValue = findViewById(R.id.idValue);
        TextView nameValue = findViewById(R.id.nameValue);
        TextView growthTimeValue = findViewById(R.id.growthTimeValue);
        TextView maxHarvestValue = findViewById(R.id.maxHarvestValue);
        TextView naturalGiftPowerValue = findViewById(R.id.naturalGiftPowerValue);
        TextView sizeValue = findViewById(R.id.sizeValue);
        TextView smoothnessValue = findViewById(R.id.smoothnessValue);
        TextView soilDrynessValue = findViewById(R.id.soilDrynessValue);
        PokeApi api = new PokeApiClient();
        Berry berry = api.getBerry(input);
        idValue.setText("" + berry.getId());
        nameValue.setText("" + berry.getName());
        growthTimeValue.setText("" + berry.getGrowthTime());
        maxHarvestValue.setText("" + berry.getMaxHarvest());
        naturalGiftPowerValue.setText("" + berry.getNaturalGiftPower());
        sizeValue.setText("" + berry.getSize());
        smoothnessValue.setText("" + berry.getSmoothness());
        soilDrynessValue.setText("" + berry.getSoilDryness());
    }
}
