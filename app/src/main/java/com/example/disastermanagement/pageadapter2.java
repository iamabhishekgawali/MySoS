package com.example.disastermanagement;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class pageadapter2 extends FirebaseRecyclerAdapter<model,pageadapter2.holderview> {


    public pageadapter2(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull holderview holder, int position, @NonNull model model) {
        holder.title.setText(model.getValue());
        holder.desp.setText(model.getDesp());
        Glide.with(holder.img.getContext()).load(model.getName()).into(holder.img);
    }

    @NonNull
    @Override
    public holderview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new holderview(view);
    }

    public class holderview extends RecyclerView.ViewHolder{

        ImageView img;
        TextView title;
        TextView desp;
        public holderview(@NonNull final View itemView) {
            super(itemView);
            title=(TextView) itemView.findViewById(R.id.dtitle);
            desp=(TextView) itemView.findViewById(R.id.ddesp);
            img=(ImageView)itemView.findViewById(R.id.dimg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int postition;
                    postition = getAdapterPosition();

                    if(postition == 0) {
                        Intent it = new Intent(itemView.getContext(), Heart_attack.class);
                        itemView.getContext().startActivity(it);
                    }
                    else if(postition == 1)
                    {
                        Intent it = new Intent(itemView.getContext(), Stroke.class);
                        itemView.getContext().startActivity(it);
                    }
                    else if (postition  == 2)
                    {
                        Intent it = new Intent(itemView.getContext(), Chocking.class);
                        itemView.getContext().startActivity(it);
                    }
                    else if(postition == 4)
                    {
                        Intent it = new Intent(itemView.getContext(), Electrocution.class);
                        itemView.getContext().startActivity(it);
                    }

                }
            });
        }

    }
}
