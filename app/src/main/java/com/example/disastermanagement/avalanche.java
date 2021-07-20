package com.example.disastermanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class avalanche extends AppCompatActivity {


    DatabaseReference firebaseDatabase;
    TextView defination,tip1,tip2,tip3,tip4,tip5,tip6,tip7,tip8,tip9;
    ImageView mainimage,image1,image2,image3,image4,image5,image6,image7,image8,image9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avalanche);

        mainimage = (ImageView) findViewById(R.id.avalanche_mainimage);
        defination = (TextView) findViewById(R.id.avalancheDefination);

        tip1 = (TextView) findViewById(R.id.avalanchetip1);
        tip2 = (TextView) findViewById(R.id.avalanchetip2);
        tip3 = (TextView) findViewById(R.id.avalanchetip3);
        tip4 = (TextView) findViewById(R.id.avalanchetip4);
        tip5 = (TextView) findViewById(R.id.avalanchetip5);
        tip6 = (TextView) findViewById(R.id.avalanchetip6);
        tip7 = (TextView) findViewById(R.id.avalanchetip7);
        tip8 = (TextView) findViewById(R.id.avalanchetip8);
        tip9 = (TextView) findViewById(R.id.avalanchetip9);


                image1 = (ImageView) findViewById(R.id.avalanche_image1);
        image2 = (ImageView) findViewById(R.id.avalanche_image2 );
        image3 = (ImageView) findViewById(R.id.avalanche_image3);
        image4 = (ImageView) findViewById(R.id.avalanche_image4);
        image5 = (ImageView) findViewById(R.id.avalanche_image5);
        image6 = (ImageView) findViewById(R.id.avalanche_image6);
        image7 = (ImageView) findViewById(R.id.avalanche_image7);
        image8 = (ImageView) findViewById(R.id.avalanche_image8);
        image9 = (ImageView) findViewById(R.id.avalanche_image9);


        firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Avalanche");


        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Defination = snapshot.child("defination").getValue().toString();
                String Tip1 = snapshot.child("Tip1").getValue().toString();
                String Tip2 = snapshot.child("Tip2").getValue().toString();
                String Tip3 = snapshot.child("Tip3").getValue().toString();
                String Tip4 = snapshot.child("Tip4").getValue().toString();
                String Tip5 = snapshot.child("Tip5").getValue().toString();
                String Tip6 = snapshot.child("Tip6").getValue().toString();
                String Tip7 = snapshot.child("Tip7").getValue().toString();
                String Tip8 = snapshot.child("Tip8").getValue().toString();
                String Tip9 = snapshot.child("Tip9").getValue().toString();

                defination.setText(Defination);
                tip1.setText(Tip1);
                tip2.setText(Tip2);
                tip3.setText(Tip3);
                tip4.setText(Tip4);
                tip5.setText(Tip5);
                tip6.setText(Tip6);
                tip7.setText(Tip7);
                tip8.setText(Tip8);
                tip9.setText(Tip9);


                String Main = snapshot.child("mainimage").getValue().toString();
                Picasso.get().load(Main).into(mainimage);


                String Image1 = snapshot.child("Image1").getValue().toString();
                Picasso.get().load(Image1).into(image1);

                String Image2 = snapshot.child("Image2").getValue().toString();
                Picasso.get().load(Image2).into(image2);

                String Image3 = snapshot.child("Image3").getValue().toString();
                Picasso.get().load(Image3).into(image3);

                String Image4 = snapshot.child("Image4").getValue().toString();
                Picasso.get().load(Image4).into(image4);

                String Image5 = snapshot.child("Image5").getValue().toString();
                Picasso.get().load(Image5).into(image5);

                String Image6 = snapshot.child("Image6").getValue().toString();
                Picasso.get().load(Image6).into(image6);

                String Image7 = snapshot.child("Image7").getValue().toString();
                Picasso.get().load(Image7).into(image7);

                String Image8 = snapshot.child("Image8").getValue().toString();
                Picasso.get().load(Image8).into(image8);

                String Image9 = snapshot.child("Image9").getValue().toString();
                Picasso.get().load(Image9).into(image9);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}