package galang.resepmakanan_tugas1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by PC on 04/10/2017.
 */

public class ResepDetail extends AppCompatActivity {
    ImageView imageView;
    TextView txt_judul,txt_deskripsi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//As up
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resep_detail);
        imageView=(ImageView) findViewById(R.id.img_detail);
        txt_judul=(TextView) findViewById(R.id.judul_detail);
        txt_deskripsi=(TextView) findViewById(R.id.deskripsi_detail);
        imageView.setImageResource(getIntent().getIntExtra("img_id",00));
        txt_judul.setText(getIntent().getStringExtra("judul"));
        txt_deskripsi.setText(getIntent().getStringExtra("deskripsi"));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
