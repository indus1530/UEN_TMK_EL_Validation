package edu.aku.hassannaqvi.uen_tmk_el_validation.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_tmk_el_validation.R;
import edu.aku.hassannaqvi.uen_tmk_el_validation.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_tmk_el_validation.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el_validation.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el_validation.databinding.ActivitySectionJBinding;
import edu.aku.hassannaqvi.uen_tmk_el_validation.utils.AppUtilsKt;

public class SectionJActivity extends AppCompatActivity {

    ActivitySectionJBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j);
        bi.setCallback(this);
        setupSkip();
    }

    private void setupSkip() {
        bi.bfj6.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.llbfj7));
        bi.bfj10.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.fldGrpCVbfj11));
        bi.bfj26.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (bi.bfj2602.isChecked()) {
                Clear.clearAllFields(bi.llbfj26);
            }
        }));
    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionKActivity.class));
            } else {
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SJ, MainApp.form.getsJ());
        return updcount == 1;
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("bfj1ca", bi.bfj1ca.getText().toString());

        json.put("bfj1ma", bi.bfj1ma.getText().toString());

        json.put("bfj2", bi.bfj201.isChecked() ? "1"
                : bi.bfj202.isChecked() ? "2"
                : bi.bfj203.isChecked() ? "3"
                : bi.bfj204.isChecked() ? "4"
                : bi.bfj205.isChecked() ? "5"
                : bi.bfj206.isChecked() ? "6"
                : bi.bfj207.isChecked() ? "7"
                : bi.bfj208.isChecked() ? "8"
                : bi.bfj209.isChecked() ? "9"
                : bi.bfj210.isChecked() ? "10"
                : bi.bfj211.isChecked() ? "11"
                : bi.bfj212.isChecked() ? "12"
                : bi.bfj296.isChecked() ? "96"
                : "-1");
        json.put("bfj296x", bi.bfj296x.getText().toString());

        json.put("bfj3", bi.bfj3m.isChecked() ? ""
                : bi.bfj3h.isChecked() ? ""
                : bi.bfj3d.isChecked() ? ""
                : bi.bfj3666.isChecked() ? "66"
                : bi.bfj398.isChecked() ? "98"
                : "-1");

        json.put("bfj3mx", bi.bfj3mx.getText().toString());
        json.put("bfj3hx", bi.bfj3hx.getText().toString());
        json.put("bfj3dx", bi.bfj3dx.getText().toString());


        json.put("bfj6", bi.bfj601.isChecked() ? "1"
                : bi.bfj602.isChecked() ? "2"
                : "-1");


        json.put("bfj801", bi.bfj801.isChecked() ? "1" : "-1");
        json.put("bfj802", bi.bfj802.isChecked() ? "2" : "-1");
        json.put("bfj803", bi.bfj803.isChecked() ? "3" : "-1");
        json.put("bfj804", bi.bfj804.isChecked() ? "4" : "-1");
        json.put("bfj805", bi.bfj805.isChecked() ? "5" : "-1");
        json.put("bfj806", bi.bfj806.isChecked() ? "6" : "-1");
        json.put("bfj807", bi.bfj807.isChecked() ? "7" : "-1");
        json.put("bfj808", bi.bfj808.isChecked() ? "8" : "-1");
        json.put("bfj809", bi.bfj809.isChecked() ? "9" : "-1");
        json.put("bfj896", bi.bfj896.isChecked() ? "96" : "-1");
        json.put("bfj896x", bi.bfj896x.getText().toString());


        json.put("bfj18", bi.bfj1801.isChecked() ? "1"
                : bi.bfj1802.isChecked() ? "2"
                : bi.bfj1898.isChecked() ? "98"
                : "-1");

        json.put("bfj9", bi.bfj901.isChecked() ? "1"
                : bi.bfj902.isChecked() ? "2"
                : "-1");

        json.put("bfj10", bi.bfj1001.isChecked() ? "1"
                : bi.bfj1002.isChecked() ? "2"
                : "-1");

        json.put("bfj11", bi.bfj1101.isChecked() ? "1"
                : bi.bfj1102.isChecked() ? "2"
                : bi.bfj1198.isChecked() ? "98"
                : "-1");

        json.put("bfj1101x", bi.bfj1101x.getText().toString());
        json.put("bfj1102x", bi.bfj1102x.getText().toString());
        json.put("bfj12", bi.bfj1201.isChecked() ? "1"
                : bi.bfj1202.isChecked() ? "2"
                : bi.bfj1203.isChecked() ? "1"
                : bi.bfj1298.isChecked() ? "98"
                : "-1");

        json.put("bfj1201x", bi.bfj1201x.getText().toString());
        json.put("bfj1202x", bi.bfj1202x.getText().toString());

        json.put("bfj19a", bi.bfj19a01.isChecked() ? "1"
                : bi.bfj19a02.isChecked() ? "2"
                : bi.bfj19a98.isChecked() ? "98"
                : "-1");
        json.put("bfj19a01x", bi.bfj19a01x.getText().toString());

        json.put("bfj19b", bi.bfj19b01.isChecked() ? "1"
                : bi.bfj19b02.isChecked() ? "2"
                : bi.bfj19b98.isChecked() ? "98"
                : "-1");
        json.put("bfj19b01x", bi.bfj19b01x.getText().toString());

        json.put("bfj19c", bi.bfj19c01.isChecked() ? "1"
                : bi.bfj19c02.isChecked() ? "2"
                : bi.bfj19c98.isChecked() ? "98"
                : "-1");
        json.put("bfj19c01x", bi.bfj19c01x.getText().toString());

        json.put("bfj19d", bi.bfj19d01.isChecked() ? "1"
                : bi.bfj19d02.isChecked() ? "2"
                : bi.bfj19d98.isChecked() ? "98"
                : "-1");
        json.put("bfj19d01x", bi.bfj19d01x.getText().toString());

        json.put("bfj19e", bi.bfj19e01.isChecked() ? "1"
                : bi.bfj19e02.isChecked() ? "2"
                : bi.bfj19e98.isChecked() ? "98"
                : "-1");
        json.put("bfj19e01x", bi.bfj19e01x.getText().toString());

        json.put("bfj19f", bi.bfj19f01.isChecked() ? "1"
                : bi.bfj19f02.isChecked() ? "2"
                : bi.bfj19f98.isChecked() ? "98"
                : "-1");
        json.put("bfj19f01x", bi.bfj19f01x.getText().toString());

        json.put("bfj19g", bi.bfj19g01.isChecked() ? "1"
                : bi.bfj19g02.isChecked() ? "2"
                : bi.bfj19g98.isChecked() ? "98"
                : "-1");
        json.put("bfj19g01x", bi.bfj19g01x.getText().toString());

        json.put("bfj19h", bi.bfj19h01.isChecked() ? "1"
                : bi.bfj19h02.isChecked() ? "2"
                : bi.bfj19h98.isChecked() ? "98"
                : "-1");
        json.put("bfj19h01x", bi.bfj19h01x.getText().toString());

        json.put("bfj19i", bi.bfj19i01.isChecked() ? "1"
                : bi.bfj19i02.isChecked() ? "2"
                : bi.bfj19i98.isChecked() ? "98"
                : "-1");
        json.put("bfj19i01x", bi.bfj19i01x.getText().toString());

        json.put("bfj13", bi.bfj1301.isChecked() ? ""
                : bi.bfj1302.isChecked() ? ""
                : bi.bfj1303.isChecked() ? "1"
                : "-1");

        json.put("bfj1301x", bi.bfj1301x.getText().toString());
        json.put("bfj1302x", bi.bfj1302x.getText().toString());

        json.put("bfj26", bi.bfj2601.isChecked() ? "1"
                : bi.bfj2601.isChecked() ? "2"
                : "-1");

        MainApp.form.setsJ(json.toString());

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You Can't go back", Toast.LENGTH_LONG).show();
    }
}