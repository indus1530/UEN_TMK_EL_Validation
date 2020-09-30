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
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionJ02Binding;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

public class SectionJ02Activity extends AppCompatActivity {

    ActivitySectionJ02Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j02);
        bi.setCallback(this);
        setupSkip();
    }

    private void setupSkip() {

    }

    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addForm(form);
        form.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            form.set_UID(form.getDeviceID() + form.get_ID());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, form.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

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
                : "-1");

        json.put("bfj22", bi.bfj2201.isChecked() ? "1"
                : bi.bfj2202.isChecked() ? "2"
                : bi.bfj2203.isChecked() ? "3"
                : bi.bfj2296.isChecked() ? "96"
                : "-1");

        json.put("bfj23", bi.bfj2301.isChecked() ? "1"
                : bi.bfj2302.isChecked() ? "2"
                : bi.bfj2303.isChecked() ? "3"
                : bi.bfj2396.isChecked() ? "96"
                : "-1");

        json.put("bfj13", bi.bfj1301.isChecked() ? ""
                : bi.bfj1302.isChecked() ? ""
                : bi.bfj1303.isChecked() ? "1"
                : "-1");

        json.put("bfj1301x", bi.bfj1301x.getText().toString());
        json.put("bfj1302x", bi.bfj1302x.getText().toString());
        json.put("bfj1401", bi.bfj1401.isChecked() ? "1" : "-1");

        json.put("bfj1402", bi.bfj1402.isChecked() ? "2" : "-1");

        json.put("bfj1403", bi.bfj1403.isChecked() ? "3" : "-1");

        json.put("bfj1404", bi.bfj1404.isChecked() ? "4" : "-1");

        json.put("bfj1405", bi.bfj1405.isChecked() ? "5" : "-1");

        json.put("bfj1406", bi.bfj1406.isChecked() ? "6" : "-1");

        json.put("bfj1407", bi.bfj1407.isChecked() ? "7" : "-1");

        json.put("bfj1408", bi.bfj1408.isChecked() ? "8" : "-1");

        json.put("bfj1409", bi.bfj1409.isChecked() ? "9" : "-1");

        json.put("bfj1410", bi.bfj1410.isChecked() ? "10" : "-1");

        json.put("bfj1411", bi.bfj1411.isChecked() ? "11" : "-1");

        json.put("bfj1412", bi.bfj1412.isChecked() ? "12" : "-1");

        json.put("bfj1496", bi.bfj1496.isChecked() ? "96" : "-1");

        json.put("bfj24", bi.bfj2401.isChecked() ? ""
                : bi.bfj2402.isChecked() ? "2"
                : bi.bfj2498.isChecked() ? "98"
                : "-1");

        json.put("bfj2401x", bi.bfj2401x.getText().toString());

        json.put("bfj25a", bi.bfj25a01.isChecked() ? "1"
                : bi.bfj25a02.isChecked() ? "2"
                : bi.bfj25a98.isChecked() ? "98"
                : "-1");

        json.put("bfj25b", bi.bfj25b01.isChecked() ? "1"
                : bi.bfj25b02.isChecked() ? "2"
                : bi.bfj25b98.isChecked() ? "98"
                : "-1");

        json.put("bfj25c", bi.bfj25c01.isChecked() ? "1"
                : bi.bfj25c02.isChecked() ? "2"
                : bi.bfj25c98.isChecked() ? "98"
                : "-1");

        json.put("bfj25d", bi.bfj25d01.isChecked() ? "1"
                : bi.bfj25d02.isChecked() ? "2"
                : bi.bfj25d98.isChecked() ? "98"
                : "-1");

        json.put("bfj25e", bi.bfj25e01.isChecked() ? "1"
                : bi.bfj25e02.isChecked() ? "2"
                : bi.bfj25e98.isChecked() ? "98"
                : "-1");

        json.put("bfj25f", bi.bfj25f01.isChecked() ? "1"
                : bi.bfj25f02.isChecked() ? "2"
                : bi.bfj25f98.isChecked() ? "98"
                : "-1");

        json.put("bfj25g", bi.bfj25g01.isChecked() ? "1"
                : bi.bfj25g02.isChecked() ? "2"
                : bi.bfj25g98.isChecked() ? "98"
                : "-1");

        json.put("bfj25h", bi.bfj25h01.isChecked() ? "1"
                : bi.bfj25h02.isChecked() ? "2"
                : bi.bfj25h98.isChecked() ? "98"
                : "-1");

        json.put("bfj25i", bi.bfj25i01.isChecked() ? "1"
                : bi.bfj25i02.isChecked() ? "2"
                : bi.bfj25i98.isChecked() ? "98"
                : "-1");

        json.put("bfj25j", bi.bfj25j01.isChecked() ? "1"
                : bi.bfj25j02.isChecked() ? "2"
                : bi.bfj25j03.isChecked() ? "98"
                : "-1");

        json.put("bfj25k", bi.bfj25k01.isChecked() ? "1"
                : bi.bfj25k02.isChecked() ? "2"
                : bi.bfj25k98.isChecked() ? "98"
                : "-1");

        json.put("bfj25l", bi.bfj25l01.isChecked() ? "1"
                : bi.bfj25l02.isChecked() ? "2"
                : bi.bfj25l98.isChecked() ? "98"
                : "-1");

        json.put("bfj25m", bi.bfj25m01.isChecked() ? "1"
                : bi.bfj25m02.isChecked() ? "2"
                : bi.bfj25m98.isChecked() ? "98"
                : "-1");

        json.put("bfj25n", bi.bfj25n01.isChecked() ? "1"
                : bi.bfj25n02.isChecked() ? "2"
                : bi.bfj25n98.isChecked() ? "98"
                : "-1");

        json.put("bfj25o", bi.bfj25o01.isChecked() ? "1"
                : bi.bfj25o02.isChecked() ? "2"
                : bi.bfj25o98.isChecked() ? "98"
                : "-1");

        json.put("bfj25p", bi.bfj25p01.isChecked() ? "1"
                : bi.bfj25p02.isChecked() ? "2"
                : bi.bfj25p98.isChecked() ? "98"
                : "-1");

        json.put("bfj25q", bi.bfj25q01.isChecked() ? "1"
                : bi.bfj25q02.isChecked() ? "2"
                : bi.bfj25q03.isChecked() ? "98"
                : "-1");

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

}