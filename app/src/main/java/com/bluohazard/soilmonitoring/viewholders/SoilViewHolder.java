package com.bluohazard.soilmonitoring.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bluohazard.soilmonitoring.R;
import com.bluohazard.soilmonitoring.models.Soil;

public class SoilViewHolder extends RecyclerView.ViewHolder {
    private TextView tvSuhu, tvAir, tvKelembaban, tvOksigen;

    public SoilViewHolder(@NonNull View itemView) {
        super(itemView);

        tvSuhu = itemView.findViewById(R.id.textTemperature);
        tvAir = itemView.findViewById(R.id.textWater);
        tvKelembaban = itemView.findViewById(R.id.textWet);
        tvOksigen = itemView.findViewById(R.id.textWind);
    }

    public void bindToSoil(Soil soil, View.OnClickListener onClickListener) {
        tvSuhu.setText(soil.suhu);
        tvAir.setText(soil.air);
        tvKelembaban.setText(soil.kelembaban);
        tvOksigen.setText(soil.oksigen);
    }
}
