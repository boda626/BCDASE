package com.example.pokeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText searchBar = findViewById(R.id.searchBar);
        Button berrySearch = findViewById(R.id.berrySearch);
        final Button pokeSearch = findViewById(R.id.pokemonSearch);
        pokeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputStr = searchBar.getText().toString();
                if (inputStr.length() == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Search bar can not be empty!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    try {
                        int input = Integer.parseInt(inputStr);
                        if (input > 807 || input < 1) {
                            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                            alertDialog.setTitle("POKEMON DOES NOT EXIST");
                            alertDialog.setMessage("The given index does not exist! Please enter a valid index.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                        } else {
                            Intent intent = new Intent(MainActivity.this, pokemonSearch.class);
                            intent.putExtra("input", input);
                            startActivity(intent);
                        }
                    } catch (Exception e) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("NOT AN INDEX");
                        alertDialog.setMessage("Please enter an index!");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                }
            }
        });
        berrySearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputStr = searchBar.getText().toString();
                if (inputStr.length() == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Search bar can not be empty!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    try {
                        int input = Integer.parseInt(inputStr);
                        if (input > 64 || input < 1) {
                            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                            alertDialog.setTitle("BERRY DOES NOT EXIST");
                            alertDialog.setMessage("The given index does not exist! Please enter a valid index.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                        } else {
                            Intent intent = new Intent(MainActivity.this, Poke.class);
                            intent.putExtra("input", input);
                            startActivity(intent);
                        }
                    } catch (Exception e) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("NOT AN INDEX");
                        alertDialog.setMessage("Please enter an index!");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                }
            }
        });
    }
}
