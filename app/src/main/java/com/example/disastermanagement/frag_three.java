package com.example.disastermanagement;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import org.w3c.dom.Text;


public class frag_three extends Fragment {


    TextView number_1,number_2,number_3,hospitals,bloodbanks,firestation,medical,police,ambulance;
    FirebaseFirestore fstr;
    FirebaseAuth firebaseAuth;
    String userID;

    ImageView img1,img2,img3;
    private static final int REQUEST_CALL = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_three,container,false);



        hospitals = (TextView) view.findViewById(R.id.hospitals);
        bloodbanks = (TextView) view.findViewById(R.id.bloodbank);
        firestation = (TextView)view.findViewById(R.id.fire);
        medical = (TextView)view.findViewById(R.id.medical);
        police = (TextView) view.findViewById(R.id.policestation);
        ambulance = (TextView) view.findViewById(R.id.callambulance);

        number_1 = (TextView) view.findViewById(R.id.number1);
        number_2 = (TextView) view.findViewById(R.id.number2);
        number_3 = (TextView) view.findViewById(R.id.number3);


        img1 = (ImageView)view.findViewById(R.id.number1_image);
        img2 = (ImageView)view.findViewById(R.id.number2_image);
        img3 = (ImageView)view.findViewById(R.id.number3_image);


        fstr = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        userID = firebaseAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fstr.collection("users").document(userID);


        documentReference.addSnapshotListener(getActivity(), new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable final DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirebaseFirestoreException e) {
                number_1.setText(documentSnapshot.getString("phone1"));
                number_2.setText(documentSnapshot.getString("phone2"));
                number_3.setText(documentSnapshot.getString("phone3"));

                img1.setOnClickListener(new View.OnClickListener() {
                    String number  = number_1.getText().toString().trim();
                    @Override

                    public void onClick(View v) {
                        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                        {
                            requestPermissions(new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
                        }
                        else
                        {
                            startActivity(new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+number)));
                        }
                    }
                });



                img2.setOnClickListener(new View.OnClickListener() {
                    String number  = number_2.getText().toString().trim();
                    @Override
                    public void onClick(View v) {
                        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                        {
                            requestPermissions(new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
                        }
                        else
                        {
                            startActivity(new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+number)));
                        }
                    }
                });


                img3.setOnClickListener(new View.OnClickListener() {
                    String number  = number_3.getText().toString().trim();
                    @Override
                    public void onClick(View v) {
                        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                        {
                            requestPermissions(new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
                        }
                        else
                        {
                            startActivity(new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+number)));
                        }
                    }
                });


                ambulance.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                        {
                            requestPermissions(new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
                        }
                        else
                        {
                            startActivity(new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+"108")));
                        }
                    }
                });
            }



        });




hospitals.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=hospital");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
});



bloodbanks.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Blood bank");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
});

firestation.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Fire station");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
});


medical.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Medical");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
});


police.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Police station");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
});


        return view;
    }


    public  void phoneclock(String number)
    {

        System.out.println(number);
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }
        else
        {
            startActivity(new Intent(Intent.ACTION_CALL,Uri.parse("tel:+"+number)));
        }

    }

    public  void logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getActivity(),LoginForm.class));
    }
}
