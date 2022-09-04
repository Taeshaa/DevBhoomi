package com.example.devbhoomi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapterMurder extends RecyclerView.Adapter<MyAdapterMurder.MyViewHolder> {
    private ShowMurder activity;
    private List<ModelJ> mList;
    //private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public MyAdapterMurder(ShowMurder activity , List<ModelJ> mList){
        this.activity = activity;
        this.mList = mList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_j , parent , false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(mList.get(position).getName());
        holder.category.setText(mList.get(position).getCategory());
        holder.bailable.setText(mList.get(position).getBailable());
        holder.city.setText(mList.get(position).getCity());
        holder.date.setText(mList.get(position).getDate());
        holder.desc.setText(mList.get(position).getDesc());
        holder.age.setText(mList.get(position).getAge());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,category,bailable,city,date,desc,age;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_j);
            category= itemView.findViewById(R.id.category_j);
            bailable = itemView.findViewById(R.id.bailable_j);
            city = itemView.findViewById(R.id.city_j);
            date = itemView.findViewById(R.id.cdate_j);
            desc = itemView.findViewById(R.id.cdesc_j);
            age = itemView.findViewById(R.id.age_j);


        }
    }
}