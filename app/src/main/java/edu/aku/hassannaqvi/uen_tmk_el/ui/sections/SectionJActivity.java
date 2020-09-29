package edu.aku.hassannaqvi.uen_tmk_el.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_tmk_el.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionJBinding;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.uen_tmk_el.core.MainApp.form;

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

    }

    public void BtnContinue() throws JSONException {
        if (!formValidation()) return;
        SaveDraft();
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addForm(form);
        form.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            form.set_UID(form.getDeviceID() + form.get_ID());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, form.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("bfj1", bi.bfj1.getText().toString());

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
                :  "-1");

        json.put("bfj296x", bi.bfj296x.getText().toString());
        json.put("bfj3", bi.bfj3m.isChecked() ? ""
                : bi.bfj3h.isChecked() ? ""
                : bi.bfj3d.isChecked() ? ""
                : bi.bfj3666.isChecked() ? "666"
                : bi.bfj398.isChecked() ? "98"
                : "-1");

        json.put("bfj3mx", bi.bfj3mx.getText().toString());
        json.put("bfj3hx", bi.bfj3hx.getText().toString());
        json.put("bfj3dx", bi.bfj3dx.getText().toString());

        /*json.put("bfj4", bi.bfj401.isChecked() ? "1"
                : bi.bfj402.isChecked() ? "2"
                :  "-1");*/

        json.put("bfj501", bi.bfj501.isChecked() ? "1" : "-1");

        json.put("bfj502", bi.bfj502.isChecked() ? "2" : "-1");

        json.put("bfj503", bi.bfj503.isChecked() ? "3" : "-1");

        json.put("bfj504", bi.bfj504.isChecked() ? "4" : "-1");

        json.put("bfj505",bi.bfj505.isChecked() ? "5" :"-1");

        json.put("bfj506",bi.bfj506.isChecked() ? "6" :"-1");

        json.put("bfj507",bi.bfj507.isChecked() ? "7" :"-1");

        json.put("bfj508",bi.bfj508.isChecked() ? "8" :"-1");

        json.put("bfj6", bi.bfj601.isChecked() ? "1"
                : bi.bfj602.isChecked() ? "2"
                :  "-1");

        json.put("bfj701",bi.bfj701.isChecked() ? "1" :"-1");

        json.put("bfj702",bi.bfj702.isChecked() ? "2" :"-1");

        json.put("bfj703",bi.bfj703.isChecked() ? "3" :"-1");

        json.put("bfj704",bi.bfj704.isChecked() ? "4" :"-1");

        json.put("bfj705",bi.bfj705.isChecked() ? "5" :"-1");

        json.put("bfj706",bi.bfj706.isChecked() ? "6" :"-1");

        json.put("bfj707",bi.bfj707.isChecked() ? "7" :"-1");

        json.put("bfj708",bi.bfj708.isChecked() ? "8" :"-1");

        json.put("bfj796",bi.bfj796.isChecked() ? "96" :"-1");

        json.put("bfj796x", bi.bfj796x.getText().toString());
        json.put("bfj8", bi.bfj801.isChecked() ? "1"
                : bi.bfj802.isChecked() ? "2"
                : bi.bfj803.isChecked() ? "3"
                : bi.bfj804.isChecked() ? "4"
                : bi.bfj805.isChecked() ? "5"
                : bi.bfj806.isChecked() ? "6"
                : bi.bfj807.isChecked() ? "7"
                : bi.bfj808.isChecked() ? "8"
                : bi.bfj809.isChecked() ? "9"
                : bi.bfj896.isChecked() ? "96"
                :  "-1");

        json.put("bfj896x", bi.bfj896x.getText().toString());
        json.put("bfj15a", bi.bfj15a01.isChecked() ? "1"
                : bi.bfj15a02.isChecked() ? "2"
                : bi.bfj15a98.isChecked() ? "98"
                :  "-1");

        json.put("bfj15b", bi.bfj15b01.isChecked() ? "1"
                : bi.bfj15b02.isChecked() ? "2"
                : bi.bfj15b98.isChecked() ? "98"
                :  "-1");

        json.put("bfj15c", bi.bfj15c01.isChecked() ? "1"
                : bi.bfj15c02.isChecked() ? "2"
                : bi.bfj15c98.isChecked() ? "98"
                :  "-1");

        json.put("bfj16", bi.bfj1601.isChecked() ? "1"
                : bi.bfj1602.isChecked() ? "2"
                : bi.bfj1698.isChecked() ? "98"
                :  "-1");

        json.put("bfj1601x", bi.bfj1601x.getText().toString());
        json.put("bfj17", bi.bfj1701.isChecked() ? "1"
                : bi.bfj1702.isChecked() ? "2"
                : bi.bfj1703.isChecked() ? "98"
                :  "-1");

        json.put("bfj18", bi.bfj1801.isChecked() ? "1"
                : bi.bfj1802.isChecked() ? "2"
                : bi.bfj1898.isChecked() ? "98"
                :  "-1");

        json.put("bfj9", bi.bfj901.isChecked() ? "1"
                : bi.bfj902.isChecked() ? "2"
                :  "-1");

        json.put("bfj10", bi.bfj1001.isChecked() ? "1"
                : bi.bfj1002.isChecked() ? "2"
                :  "-1");

        json.put("bfj11", bi.bfj1101.isChecked() ? "1"
                : bi.bfj1102.isChecked() ? "2"
                : bi.bfj1198.isChecked() ? "98"
                :  "-1");

        json.put("bfj1101x", bi.bfj1101x.getText().toString());
        json.put("bfj1102x", bi.bfj1102x.getText().toString());
        json.put("bfj12", bi.bfj1201.isChecked() ? "1"
                : bi.bfj1202.isChecked() ? "2"
                : bi.bfj1203.isChecked() ? "3"
                : bi.bfj1298.isChecked() ? "98"
                :  "-1");

        json.put("bfj1201x", bi.bfj1201x.getText().toString());
        json.put("bfj1202x", bi.bfj1202x.getText().toString());
        json.put("bfj19a", bi.bfj19a01.isChecked() ? "1"
                : bi.bfj19a02.isChecked() ? "2"
                : bi.bfj19a98.isChecked() ? "98"
                :  "-1");

        json.put("bfj19b", bi.bfj19b01.isChecked() ? "1"
                : bi.bfj19b02.isChecked() ? "2"
                : bi.bfj19b98.isChecked() ? "98"
                :  "-1");

        json.put("bfj19c", bi.bfj19c01.isChecked() ? "1"
                : bi.bfj19c02.isChecked() ? "2"
                : bi.bfj19c98.isChecked() ? "98"
                :  "-1");

        json.put("bfj19d", bi.bfj19d01.isChecked() ? "1"
                : bi.bfj19d02.isChecked() ? "2"
                : bi.bfj19d98.isChecked() ? "98"
                :  "-1");

        json.put("bfj19e", bi.bfj19e01.isChecked() ? "1"
                : bi.bfj19e02.isChecked() ? "2"
                : bi.bfj19e98.isChecked() ? "98"
                :  "-1");

        json.put("bfj19f", bi.bfj19f01.isChecked() ? "1"
                : bi.bfj19f02.isChecked() ? "2"
                : bi.bfj19f98.isChecked() ? "98"
                :  "-1");

        json.put("bfj19g", bi.bfj19g01.isChecked() ? "1"
                : bi.bfj19g02.isChecked() ? "2"
                : bi.bfj19g98.isChecked() ? "98"
                :  "-1");

        json.put("bfj19h", bi.bfj19h01.isChecked() ? "1"
                : bi.bfj19h02.isChecked() ? "2"
                : bi.bfj19h98.isChecked() ? "98"
                :  "-1");

        json.put("bfj19i", bi.bfj19i01.isChecked() ? "1"
                : bi.bfj19i02.isChecked() ? "2"
                : bi.bfj19i98.isChecked() ? "98"
                :  "-1");

        json.put("bfj20a01", bi.bfj20a01.getText().toString());

        json.put("bfj20b01", bi.bfj20b01.getText().toString());

        json.put("bfj20c01", bi.bfj20c01.getText().toString());

        json.put("bfj20d01", bi.bfj20d01.getText().toString());

        json.put("bfj20e01", bi.bfj20e01.getText().toString());

        json.put("bfj20f01", bi.bfj20f01.getText().toString());

        json.put("bfj20g01", bi.bfj20g01.getText().toString());

        json.put("bfj20h01", bi.bfj20h01.getText().toString());

        json.put("bfj20i01", bi.bfj20i01.getText().toString());

        json.put("bfj21", bi.bfj2101.isChecked() ? "1"
                : bi.bfj2102.isChecked() ? "2"
                : bi.bfj2198.isChecked() ? "98"
                :  "-1");

        json.put("bfj22", bi.bfj2201.isChecked() ? "1"
                : bi.bfj2202.isChecked() ? "2"
                : bi.bfj2203.isChecked() ? "3"
                : bi.bfj2296.isChecked() ? "96"
                :  "-1");

        json.put("bfj23", bi.bfj2301.isChecked() ? "1"
                : bi.bfj2302.isChecked() ? "2"
                : bi.bfj2303.isChecked() ? "3"
                : bi.bfj2396.isChecked() ? "96"
                :  "-1");

        json.put("bfj13", bi.bfj1301.isChecked() ? ""
                : bi.bfj1302.isChecked() ? ""
                : bi.bfj1303.isChecked() ? "1"
                :  "-1");

        json.put("bfj1301x", bi.bfj1301x.getText().toString());
        json.put("bfj1302x", bi.bfj1302x.getText().toString());
        json.put("bfj1401",bi.bfj1401.isChecked() ? "1" :"-1");

        json.put("bfj1402",bi.bfj1402.isChecked() ? "2" :"-1");

        json.put("bfj1403",bi.bfj1403.isChecked() ? "3" :"-1");

        json.put("bfj1404",bi.bfj1404.isChecked() ? "4" :"-1");

        json.put("bfj1405",bi.bfj1405.isChecked() ? "5" :"-1");

        json.put("bfj1406",bi.bfj1406.isChecked() ? "6" :"-1");

        json.put("bfj1407",bi.bfj1407.isChecked() ? "7" :"-1");

        json.put("bfj1408",bi.bfj1408.isChecked() ? "8" :"-1");

        json.put("bfj1409",bi.bfj1409.isChecked() ? "9" :"-1");

        json.put("bfj1410",bi.bfj1410.isChecked() ? "10" :"-1");

        json.put("bfj1411",bi.bfj1411.isChecked() ? "11" :"-1");

        json.put("bfj1412",bi.bfj1412.isChecked() ? "12" :"-1");

        json.put("bfj1496",bi.bfj1496.isChecked() ? "96" :"-1");

        json.put("bfj24", bi.bfj2401.isChecked() ? ""
                : bi.bfj2402.isChecked() ? "2"
                : bi.bfj2498.isChecked() ? "98"
                :  "-1");

        json.put("bfj2401x", bi.bfj2401x.getText().toString());
        json.put("bfj25a", bi.bfj25a01.isChecked() ? "1"
                : bi.bfj25a02.isChecked() ? "2"
                : bi.bfj25a98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25b", bi.bfj25b01.isChecked() ? "1"
                : bi.bfj25b02.isChecked() ? "2"
                : bi.bfj25b98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25c", bi.bfj25c01.isChecked() ? "1"
                : bi.bfj25c02.isChecked() ? "2"
                : bi.bfj25c98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25d", bi.bfj25d01.isChecked() ? "1"
                : bi.bfj25d02.isChecked() ? "2"
                : bi.bfj25d98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25e", bi.bfj25e01.isChecked() ? "1"
                : bi.bfj25e02.isChecked() ? "2"
                : bi.bfj25e98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25f", bi.bfj25f01.isChecked() ? "1"
                : bi.bfj25f02.isChecked() ? "2"
                : bi.bfj25f98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25g", bi.bfj25g01.isChecked() ? "1"
                : bi.bfj25g02.isChecked() ? "2"
                : bi.bfj25g98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25h", bi.bfj25h01.isChecked() ? "1"
                : bi.bfj25h02.isChecked() ? "2"
                : bi.bfj25h98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25i", bi.bfj25i01.isChecked() ? "1"
                : bi.bfj25i02.isChecked() ? "2"
                : bi.bfj25i98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25j", bi.bfj25j01.isChecked() ? "1"
                : bi.bfj25j02.isChecked() ? "2"
                : bi.bfj25j03.isChecked() ? "98"
                :  "-1");

        json.put("bfj25k", bi.bfj25k01.isChecked() ? "1"
                : bi.bfj25k02.isChecked() ? "2"
                : bi.bfj25k98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25l", bi.bfj25l01.isChecked() ? "1"
                : bi.bfj25l02.isChecked() ? "2"
                : bi.bfj25l98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25m", bi.bfj25m01.isChecked() ? "1"
                : bi.bfj25m02.isChecked() ? "2"
                : bi.bfj25m98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25n", bi.bfj25n01.isChecked() ? "1"
                : bi.bfj25n02.isChecked() ? "2"
                : bi.bfj25n98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25o", bi.bfj25o01.isChecked() ? "1"
                : bi.bfj25o02.isChecked() ? "2"
                : bi.bfj25o98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25p", bi.bfj25p01.isChecked() ? "1"
                : bi.bfj25p02.isChecked() ? "2"
                : bi.bfj25p98.isChecked() ? "98"
                :  "-1");

        json.put("bfj25q", bi.bfj25q01.isChecked() ? "1"
                : bi.bfj25q02.isChecked() ? "2"
                : bi.bfj25q03.isChecked() ? "98"
                :  "-1");

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }
}