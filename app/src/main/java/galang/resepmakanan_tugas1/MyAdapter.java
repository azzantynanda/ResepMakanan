package galang.resepmakanan_tugas1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by PC on 04/10/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterHolder> {

    String data1[],data2[];
    int img[];
    Context ctx;

    public MyAdapter(Context context,String s1[],String s2[],int i1[]){
        ctx=context;
        data1=s1;
        data2=s2;

        img=i1;


    }

    @Override
    public MyAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myInflator=LayoutInflater.from(ctx);
        View myView = myInflator.inflate(R.layout.my_row,parent,false);
        return new MyAdapterHolder(myView,ctx,data1,data2,img);
    }

    @Override
    public void onBindViewHolder(MyAdapterHolder holder, int position) {
        holder.t1.setText(data1[position]);
        holder.t2.setText(data2[position]);

        holder.myImage.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView t1,t2;
        ImageView myImage;

        String data1[],data2[];
        int img[];

        Context ctx;
        public MyAdapterHolder(View itemView,Context ctx,String s1[],String s2[],int i1[]) {
            super(itemView);
            this.ctx=ctx;
            data1=s1;
            data2=s2;
            img=i1;

            itemView.setOnClickListener(this);
            t1=(TextView)itemView.findViewById(R.id.text1);
            t2=(TextView)itemView.findViewById(R.id.text2);
            myImage=(ImageView)itemView.findViewById(R.id.myImage);


        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            Intent it=new Intent(this.ctx,ResepDetail.class);
            it.putExtra("img_id",img[position]);
            it.putExtra("judul",data1[position]);
            it.putExtra("deskripsi",data2[position]);
            this.ctx.startActivity(it);
        }
    }
}
