package com.example.devbhoomi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ShowActivity activity;
    private List<Model> mList;
    //private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public MyAdapter(ShowActivity activity , List<Model> mList){
        this.activity = activity;
        this.mList = mList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item , parent , false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(mList.get(position).getName());
        holder.phone.setText(mList.get(position).getPhone());
        holder.officer.setText(mList.get(position).getOfficer());
        holder.desc.setText(mList.get(position).getDesc());
        holder.place.setText(mList.get(position).getPlace());
        holder.time.setText(mList.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,phone,officer,desc,place,time;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_text);
            phone = itemView.findViewById(R.id.phone_text);
            officer = itemView.findViewById(R.id.officer_text);
            desc = itemView.findViewById(R.id.desc_text);
            place = itemView.findViewById(R.id.place_text);
            time = itemView.findViewById(R.id.time_text);

        }
    }
}