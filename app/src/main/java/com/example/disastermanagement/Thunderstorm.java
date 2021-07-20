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

public class Thunderstorm extends AppCompatActivity {

    DatabaseReference firebaseDatabase;
    TextView defination,tip1,tip2,tip3,tip4,tip5,tip6,tip7,tip8,tip9,tip10;
    ImageView mainimage,image1,image2,image3,image4,image5,image6,image7,image8,image9,image10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thunderstorm);


        mainimage = (ImageView) findViewById(R.id.tt_mainimage);
        defination = (TextView) findViewById(R.id.ttDefination);


        tip1 = (TextView)findViewById(R.id.tttip1);
        tip2 = (TextView)findViewById(R.id.tttip2);
        tip3 = (TextView)findViewById(R.id.tttip3);
        tip4 = (TextView)findViewById(R.id.tttip4);
        tip5 = (TextView)findViewById(R.id.tttip5);
        tip6 = (TextView)findViewById(R.id.tttip6);
        tip7 = (TextView)findViewById(R.id.tttip7);
        tip8 = (TextView)findViewById(R.id.tttip8);
        tip9 = (TextView)findViewById(R.id.tttip9);
        tip10 = (TextView)findViewById(R.id.tttip10);


        image1 = (ImageView) findViewById(R.id.tt_image1);
        image2= (ImageView)findViewById(R.id.tt_image2);
        image3 = (ImageView)findViewById(R.id.tt_image3);
        image4 = (ImageView)findViewById(R.id.tt_image4);
        image5 = (ImageView)findViewById(R.id.tt_image5);
        image6 = (ImageView)findViewById(R.id.tt_image6);
        image7 = (ImageView)findViewById(R.id.tt_image7);
        image8 = (ImageView)findViewById(R.id.tt_image8);
        image9 = (ImageView)findViewById(R.id.tt_image9);
        image10 = (ImageView)findViewById(R.id.tt_image10);



        firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Thunderstorm");

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
                String Tip10 = snapshot.child("Tip10").getValue().toString();

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
                tip10.setText(Tip10);


                String Main = snapshot.child("mainimage").getValue().toString();
                Picasso.get().load(Main).into(mainimage);


                String Image1 = snapshot.child("image1").getValue().toString();
                Picasso.get().load(Image1).into(image1);

                String Image2 = snapshot.child("image2").getValue().toString();
                Picasso.get().load(Image2).into(image2);

                String Image3 = snapshot.child("image3").getValue().toString();
                Picasso.get().load(Image3).into(image3);

                String Image4 = snapshot.child("image4").getValue().toString();
                Picasso.get().load(Image4).into(image4);

                String Image5 = snapshot.child("image5").getValue().toString();
                Picasso.get().load(Image5).into(image5);

                String Image6 = snapshot.child("image6").getValue().toString();
                Picasso.get().load(Image6).into(image6);

                String Image7 = snapshot.child("image7").getValue().toString();
                Picasso.get().load(Image7).into(image7);

                String Image8 = snapshot.child("image8").getValue().toString();
                Picasso.get().load(Image8).into(image8);

                String Image9 = snapshot.child("image9").getValue().toString();
                Picasso.get().load(Image9).into(image9);

                String Image10 = snapshot.child("image10").getValue().toString();
                Picasso.get().load(Image10).into(image10);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
