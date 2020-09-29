package edu.aku.hassannaqvi.uen_tmk_el.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionGBinding;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

public class SectionGActivity extends AppCompatActivity {

    ActivitySectionGBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g);
        bi.setCallback(this);

        setupSkip();
    }

    private void setupSkip() {

        bi.chg1.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != bi.chg101.getId()) {
                Clear.clearAllFields(bi.fldGrpSecG01);
            }
        });

        bi.chg6.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.chg601.getId()) {
                Clear.clearAllFields(bi.fldGrpCVchg7);
            }
        });

        bi.chg13.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.chg1302.getId()) {
                Clear.clearAllFields(bi.fldGrpSecG02);
            }
        });

        bi.chg15.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.chg1502.getId()) {
                Clear.clearAllFields(bi.fldGrpSecG03);
            }
        });

        bi.chg20.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.chg2003.getId()) {
                Clear.clearAllFields(bi.fldGrpSecG04);
            }
        });

        bi.chg21.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.chg2102.getId()) {
                Clear.clearAllFields(bi.fldGrpSecG05);
            }
        });

        bi.chg23.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.chg2301.getId()) {
                Clear.clearAllFields(bi.fldGrpCVchg24);
            }
        });

        bi.chg32.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.chg3202.getId()) {
                Clear.clearAllFields(bi.fldGrpSecG06);
            }
        });

        bi.chg33.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.chg3302.getId()) {
                Clear.clearAllFields(bi.fldGrpCVchg34);
            }
        });

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

        json.put("chg1", bi.chg101.isChecked() ? "1"
                : bi.chg102.isChecked() ? "2"
                : bi.chg198.isChecked() ? "98"
                : "-1");

        json.put("chg2", bi.chg2.getText().toString());

        json.put("chg301", bi.chg301.getText().toString());
        json.put("chg302", bi.chg302.getText().toString());

        json.put("chg4", bi.chg401.isChecked() ? "1"
                : bi.chg402.isChecked() ? "2"
                : "-1");
        json.put("chg401x", bi.chg401x.getText().toString());

        json.put("chg5", bi.chg501.isChecked() ? "1"
                : bi.chg502.isChecked() ? "2"
                : bi.chg598.isChecked() ? "98"
                : "-1");

        json.put("chg6", bi.chg601.isChecked() ? "1"
                : bi.chg602.isChecked() ? "2"
                : bi.chg698.isChecked() ? "98"
                : "-1");

        json.put("chg701", bi.chg701.isChecked() ? "1" : "-1");
        json.put("chg702", bi.chg702.isChecked() ? "2" : "-1");
        json.put("chg703", bi.chg703.isChecked() ? "3" : "-1");
        json.put("chg704", bi.chg704.isChecked() ? "4" : "-1");
        json.put("chg705", bi.chg705.isChecked() ? "5" : "-1");
        json.put("chg706", bi.chg706.isChecked() ? "6" : "-1");
        json.put("chg707", bi.chg707.isChecked() ? "7" : "-1");
        json.put("chg708", bi.chg708.isChecked() ? "8" : "-1");
        json.put("chg796", bi.chg796.isChecked() ? "96" : "-1");
        json.put("chg796x", bi.chg796x.getText().toString());

        json.put("chg8", bi.chg8.getText().toString());

        json.put("chg9", bi.chg901.isChecked() ? "1"
                : bi.chg902.isChecked() ? "2"
                : bi.chg903.isChecked() ? "3"
                : bi.chg904.isChecked() ? "4"
                : "-1");

        json.put("chg10", bi.chg1001.isChecked() ? "1"
                : bi.chg1002.isChecked() ? "2"
                : bi.chg1003.isChecked() ? "3"
                : bi.chg1004.isChecked() ? "4"
                : bi.chg1005.isChecked() ? "5"
                : bi.chg1006.isChecked() ? "6"
                : bi.chg1007.isChecked() ? "7"
                : bi.chg1008.isChecked() ? "8"
                : bi.chg1009.isChecked() ? "9"
                : bi.chg1010.isChecked() ? "10"
                : bi.chg1011.isChecked() ? "11"
                : "-1");

        json.put("chg1101", bi.chg1101.isChecked() ? "1" : "-1");
        json.put("chg1102", bi.chg1102.isChecked() ? "2" : "-1");
        json.put("chg1103", bi.chg1103.isChecked() ? "3" : "-1");
        json.put("chg1104", bi.chg1104.isChecked() ? "4" : "-1");
        json.put("chg1105", bi.chg1105.isChecked() ? "5" : "-1");
        json.put("chg1106", bi.chg1106.isChecked() ? "6" : "-1");
        json.put("chg1107", bi.chg1107.isChecked() ? "7" : "-1");
        json.put("chg1108", bi.chg1108.isChecked() ? "8" : "-1");
        json.put("chg1109", bi.chg1109.isChecked() ? "9" : "-1");
        json.put("chg1110", bi.chg1110.isChecked() ? "10" : "-1");

        json.put("chg12", bi.chg1201.isChecked() ? "1"
                : bi.chg1202.isChecked() ? "2"
                : "-1");

        json.put("chg13", bi.chg1301.isChecked() ? "1"
                : bi.chg1302.isChecked() ? "2"
                : "-1");

        json.put("chg14", bi.chg1401.isChecked() ? "1"
                : bi.chg1402.isChecked() ? "2"
                : bi.chg1403.isChecked() ? "3"
                : "-1");

        json.put("chg15", bi.chg1501.isChecked() ? "1"
                : bi.chg1502.isChecked() ? "2"
                : "-1");

        json.put("chg16", bi.chg1601.isChecked() ? "1"
                : bi.chg1602.isChecked() ? "2"
                : bi.chg1603.isChecked() ? "3"
                : bi.chg1604.isChecked() ? "4"
                : bi.chg1605.isChecked() ? "5"
                : bi.chg1696.isChecked() ? "96"
                : "-1");
        json.put("chg1696x", bi.chg1696x.getText().toString());

        json.put("chg17", bi.chg1701.isChecked() ? "1"
                : bi.chg1702.isChecked() ? "2"
                : bi.chg1703.isChecked() ? "3"
                : "-1");

        json.put("chg18", bi.chg1801.isChecked() ? "1"
                : bi.chg1802.isChecked() ? "2"
                : bi.chg1803.isChecked() ? "3"
                : bi.chg1804.isChecked() ? "4"
                : bi.chg1805.isChecked() ? "5"
                : "-1");

        json.put("chg1901", bi.chg1901.isChecked() ? "1" : "-1");
        json.put("chg1902", bi.chg1902.isChecked() ? "2" : "-1");
        json.put("chg1903", bi.chg1903.isChecked() ? "3" : "-1");
        json.put("chg1904", bi.chg1904.isChecked() ? "4" : "-1");
        json.put("chg1905", bi.chg1905.isChecked() ? "5" : "-1");
        json.put("chg1906", bi.chg1906.isChecked() ? "6" : "-1");
        json.put("chg1907", bi.chg1907.isChecked() ? "7" : "-1");
        json.put("chg1908", bi.chg1908.isChecked() ? "8" : "-1");

        json.put("chg20", bi.chg2001.isChecked() ? "1"
                : bi.chg2002.isChecked() ? "2"
                : bi.chg2003.isChecked() ? "3"
                : "-1");

        json.put("chg2001x", bi.chg2001x.getText().toString());
        json.put("chg2002x", bi.chg2002x.getText().toString());

        json.put("chg21", bi.chg2101.isChecked() ? "1"
                : bi.chg2102.isChecked() ? "2"
                : "-1");

        json.put("chg22", bi.chg22.getText().toString());

        json.put("chg23", bi.chg2301.isChecked() ? "1"
                : bi.chg2302.isChecked() ? "2"
                : bi.chg2303.isChecked() ? "3"
                : "-1");

        json.put("chg2401", bi.chg2401.isChecked() ? "1" : "-1");
        json.put("chg2402", bi.chg2402.isChecked() ? "2" : "-1");
        json.put("chg2403", bi.chg2403.isChecked() ? "3" : "-1");
        json.put("chg2404", bi.chg2404.isChecked() ? "4" : "-1");
        json.put("chg2405", bi.chg2405.isChecked() ? "5" : "-1");
        json.put("chg2406", bi.chg2406.isChecked() ? "6" : "-1");
        json.put("chg2407", bi.chg2407.isChecked() ? "7" : "-1");

        json.put("chg25", bi.chg2501.isChecked() ? "1"
                : bi.chg2502.isChecked() ? "2"
                : bi.chg2503.isChecked() ? "3"
                : "-1");

        json.put("chg26", bi.chg2601.isChecked() ? "1"
                : bi.chg2602.isChecked() ? "2"
                : "-1");
        json.put("chg2601x", bi.chg2601x.getText().toString());

        json.put("chg27", bi.chg2701.isChecked() ? "1"
                : bi.chg2702.isChecked() ? "2"
                : bi.chg2703.isChecked() ? "3"
                : bi.chg2704.isChecked() ? "4"
                : bi.chg2705.isChecked() ? "5"
                : bi.chg2706.isChecked() ? "6"
                : bi.chg2707.isChecked() ? "7"
                : bi.chg2708.isChecked() ? "8"
                : bi.chg2709.isChecked() ? "9"
                : bi.chg2796.isChecked() ? "96"
                : "-1");
        json.put("chg2796x", bi.chg2796x.getText().toString());

        json.put("chg28", bi.chg2801.isChecked() ? "1"
                : bi.chg2802.isChecked() ? "98"
                : "-1");
        json.put("chg2801x", bi.chg2801x.getText().toString());

        json.put("chg29", bi.chg2901.isChecked() ? "1"
                : bi.chg2902.isChecked() ? "98"
                : "-1");
        json.put("chg2901x", bi.chg2901x.getText().toString());

        json.put("chg30", bi.chg3001.isChecked() ? "1"
                : bi.chg3002.isChecked() ? "98"
                : "-1");
        json.put("chg3001x", bi.chg3001x.getText().toString());

        json.put("chg31", bi.chg3101.isChecked() ? "1"
                : bi.chg3102.isChecked() ? "2"
                : bi.chg3103.isChecked() ? "3"
                : bi.chg3104.isChecked() ? "4"
                : bi.chg3196.isChecked() ? "96"
                : "-1");
        json.put("chg3196x", bi.chg3196x.getText().toString());

        json.put("chg32", bi.chg3201.isChecked() ? "1"
                : bi.chg3202.isChecked() ? "2"
                : "-1");

        json.put("chg33", bi.chg3301.isChecked() ? "1"
                : bi.chg3302.isChecked() ? "2"
                : "-1");

        json.put("chg3401", bi.chg3401.isChecked() ? "1" : "-1");
        json.put("chg3402", bi.chg3402.isChecked() ? "2" : "-1");
        json.put("chg3403", bi.chg3403.isChecked() ? "3" : "-1");
        json.put("chg3404", bi.chg3404.isChecked() ? "4" : "-1");
        json.put("chg3405", bi.chg3405.isChecked() ? "5" : "-1");
        json.put("chg3406", bi.chg3406.isChecked() ? "6" : "-1");
        json.put("chg3407", bi.chg3407.isChecked() ? "7" : "-1");
        json.put("chg3408", bi.chg3408.isChecked() ? "8" : "-1");
        json.put("chg3409", bi.chg3409.isChecked() ? "9" : "-1");
        json.put("chg3410", bi.chg3410.isChecked() ? "10" : "-1");
        json.put("chg3411", bi.chg3411.isChecked() ? "11" : "-1");
        json.put("chg3412", bi.chg3412.isChecked() ? "12" : "-1");
        json.put("chg3496", bi.chg3496.isChecked() ? "96" : "-1");
        json.put("chg3496x", bi.chg3496x.getText().toString());


    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

}