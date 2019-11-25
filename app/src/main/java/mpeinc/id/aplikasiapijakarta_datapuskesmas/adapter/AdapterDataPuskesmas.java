package mpeinc.id.aplikasiapijakarta_datapuskesmas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mpeinc.id.aplikasiapijakarta_datapuskesmas.R;
import mpeinc.id.aplikasiapijakarta_datapuskesmas.models.DataItem;

public class AdapterDataPuskesmas extends RecyclerView.Adapter<AdapterDataPuskesmas.MyViewHolder> {

    Context context;
    List<DataItem> itemDataPuskesmas;

    public AdapterDataPuskesmas(Context context, List<DataItem> itemDataPuskesmas) {
        this.context = context;
        this.itemDataPuskesmas = itemDataPuskesmas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_datapuskesmas, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int posisi) {

        holder.txtid_puskesmas.setText("Id Puskesmas : " + Integer.toString(itemDataPuskesmas.get(posisi).getId()));
        holder.txtnama_puskesmas.setText("Nama Puskesmas : " + itemDataPuskesmas.get(posisi).getNamaPuskesmas());
        holder.txtalamat_puskesmas.setText("Alamat Puskesmas : " + itemDataPuskesmas.get(posisi).getLocation().getAlamat());
        holder.txtemail_puskesmas.setText("Email Puskesmas : " + itemDataPuskesmas.get(posisi).getEmail());
        holder.txtkodekota_puskesmas.setText("Kode Kota Puskesmas : " + Integer.toString(itemDataPuskesmas.get(posisi).getKodeKota()));

        Double lokasi_berdasarkan_long = itemDataPuskesmas.get(posisi).getLocation().getLongitude();
        Double lokasi_berdasarkan_lat = itemDataPuskesmas.get(posisi).getLocation().getLatitude();
        String nama_puskesmas = itemDataPuskesmas.get(posisi).getNamaPuskesmas();
        String alamat_puskesmas = itemDataPuskesmas.get(posisi).getLocation().getAlamat();
        String email_puskesmas = itemDataPuskesmas.get(posisi).getEmail();
        String id_puskesmas = Integer.toString(itemDataPuskesmas.get(posisi).getId());
        String kodekota_puskesmas = Integer.toString(itemDataPuskesmas.get(posisi).getKodeKota());
        String kepala_puskesmas = itemDataPuskesmas.get(posisi).getKepalaPuskesmas();
        String kodekec_puskesmas = Integer.toString(itemDataPuskesmas.get(posisi).getKodeKecamatan());
        String kodekel_puskesmas = Long.toString(itemDataPuskesmas.get(posisi).getKodeKelurahan());
        String telpon_puskesmas = Integer.toString(itemDataPuskesmas.get(posisi).getTelepon());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Data yang anda pilih adalah puskesmas dengan ID " + Integer.toString(itemDataPuskesmas.get(posisi).getId()), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemDataPuskesmas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtid_puskesmas, txtnama_puskesmas, txtalamat_puskesmas, txtemail_puskesmas, txtkodekota_puskesmas;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtid_puskesmas = (TextView)itemView.findViewById(R.id.txtID_puskesmas);
            txtnama_puskesmas = (TextView)itemView.findViewById(R.id.txtNAMA_puskesmas);
            txtalamat_puskesmas = (TextView)itemView.findViewById(R.id.txtLOKASI_puskesmas);
            txtemail_puskesmas = (TextView)itemView.findViewById(R.id.txtEMAIL_puskesmas);
            txtkodekota_puskesmas = (TextView)itemView.findViewById(R.id.txtKODEKOTA_puskesmas);
        }
    }
}
