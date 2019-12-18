package com.bluohazard.soilmonitoring.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bluohazard.soilmonitoring.R;
import com.bluohazard.soilmonitoring.models.Soil;

public class ListSoilViewHolder extends RecyclerView.ViewHolder {
    private TextView tvSuhu, tvAir, tvKelembaban, tvOksigen, tvTanggal;

    public ListSoilViewHolder(@NonNull View itemView) {
        super(itemView);

        tvSuhu = itemView.findViewById(R.id.nilaiInformasiSuhu);
        tvAir = itemView.findViewById(R.id.nilaiInformasiAir);
        tvKelembaban = itemView.findViewById(R.id.nilaiInformasiKelemmbaban);
        tvOksigen = itemView.findViewById(R.id.nilaiInformasiOksigen);
        tvTanggal = itemView.findViewById(R.id.tv_tanggal);
    }

    public void bindToListSoil(Soil soil, View.OnClickListener onClickListener) {
        tvSuhu.setText(soil.suhu + "°");
        tvAir.setText(soil.air + "%");
        tvKelembaban.setText(soil.kelembaban + "%");
        tvOksigen.setText(soil.oksigen + "%");
        tvTanggal.setText(soil.tanggal);
    }
}
