package com.example.devbhoomi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder> {
    private ShowCases activity;
    private List<ModelCase> mList;
    //private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public MyAdapter1(ShowCases activity , List<ModelCase> mList){
        this.activity = activity;
        this.mList = mList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.itemdrug , parent , false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(mList.get(position).getName());
        holder.phone.setText(mList.get(position).getPhone());
        holder.age.setText(mList.get(position).getAge());
        holder.drug.setText(mList.get(position).getDrug());
        holder.place.setText(mList.get(position).getCity());
        holder.quant.setText(mList.get(position).getQuantity());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,phone,age,quant,place,drug;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_drug);
            phone = itemView.findViewById(R.id.phone_drug);
            age = itemView.findViewById(R.id.age_drug);
            quant = itemView.findViewById(R.id.quant_drug);
            place = itemView.findViewById(R.id.place_drug);
            drug = itemView.findViewById(R.id.drug_drug);

        }
    }
}
