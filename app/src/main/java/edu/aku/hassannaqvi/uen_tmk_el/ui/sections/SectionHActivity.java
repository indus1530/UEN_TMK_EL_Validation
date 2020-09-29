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
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionHBinding;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

public class SectionHActivity extends AppCompatActivity {

    ActivitySectionHBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_h);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h);
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

        json.put("arih1", bi.arih101.isChecked() ? "1"
                : bi.arih102.isChecked() ? "2"
                : bi.arih198.isChecked() ? "3"
                : "-1");

        json.put("arih2", bi.arih2.getText().toString());

        json.put("arih3", bi.arih301.isChecked() ? "1"
                : bi.arih302.isChecked() ? "2"
                : bi.arih303.isChecked() ? "98"
                : "-1");

        json.put("arih4", bi.arih4.getText().toString());

        json.put("arih501", bi.arih501.getText().toString());
        json.put("arih502", bi.arih502.getText().toString());

        json.put("arih6", bi.arih6.getText().toString());

        json.put("arih7", bi.arih701.isChecked() ? "1"
                : bi.arih702.isChecked() ? "2"
                : bi.arih798.isChecked() ? "98"
                : "-1");

        json.put("arih801", bi.arih801.isChecked() ? "1" : "-1");
        json.put("arih802", bi.arih802.isChecked() ? "2" : "-1");
        json.put("arih803", bi.arih803.isChecked() ? "3" : "-1");
        json.put("arih804", bi.arih804.isChecked() ? "4" : "-1");
        json.put("arih805", bi.arih805.isChecked() ? "5" : "-1");
        json.put("arih806", bi.arih806.isChecked() ? "6" : "-1");
        json.put("arih807", bi.arih807.isChecked() ? "7" : "-1");
        json.put("arih808", bi.arih808.isChecked() ? "8" : "-1");
        json.put("arih896", bi.arih896.isChecked() ? "96" : "-1");

        json.put("arih9", bi.arih9.getText().toString());

        json.put("arih10", bi.arih1001.isChecked() ? "1"
                : bi.arih1002.isChecked() ? "2"
                : bi.arih1003.isChecked() ? "3"
                : bi.arih1004.isChecked() ? "4"
                : "-1");

        json.put("arih11", bi.arih1101.isChecked() ? "1"
                : bi.arih1102.isChecked() ? "2"
                : bi.arih1103.isChecked() ? "3"
                : bi.arih1104.isChecked() ? "4"
                : bi.arih1105.isChecked() ? "5"
                : bi.arih1106.isChecked() ? "6"
                : bi.arih1107.isChecked() ? "7"
                : bi.arih1108.isChecked() ? "8"
                : bi.arih1109.isChecked() ? "9"
                : bi.arih1110.isChecked() ? "10"
                : bi.arih1111.isChecked() ? "11"
                : "-1");

        json.put("arih1201", bi.arih1201.isChecked() ? "1" : "-1");
        json.put("arih1202", bi.arih1202.isChecked() ? "2" : "-1");
        json.put("arih1203", bi.arih1203.isChecked() ? "3" : "-1");
        json.put("arih1204", bi.arih1204.isChecked() ? "4" : "-1");
        json.put("arih1205", bi.arih1205.isChecked() ? "5" : "-1");
        json.put("arih1206", bi.arih1206.isChecked() ? "6" : "-1");
        json.put("arih1207", bi.arih1207.isChecked() ? "7" : "-1");
        json.put("arih1208", bi.arih1208.isChecked() ? "8" : "-1");

        json.put("arih13", bi.arih1301.isChecked() ? "1"
                : bi.arih1302.isChecked() ? "2"
                : "-1");

        json.put("arih14", bi.arih1401.isChecked() ? "1"
                : bi.arih1402.isChecked() ? "2"
                : "-1");

        json.put("arih15", bi.arih1501.isChecked() ? "1"
                : bi.arih1502.isChecked() ? "2"
                : bi.arih1503.isChecked() ? "3"
                : "-1");

        json.put("arih16", bi.arih1601.isChecked() ? "1"
                : bi.arih1602.isChecked() ? "2"
                : "-1");

        json.put("arih17", bi.arih1701.isChecked() ? "1"
                : bi.arih1702.isChecked() ? "2"
                : bi.arih1703.isChecked() ? "3"
                : bi.arih1704.isChecked() ? "4"
                : bi.arih1796.isChecked() ? "96"
                : "-1");

        json.put("arih18", bi.arih1801.isChecked() ? "1"
                : bi.arih1802.isChecked() ? "2"
                : bi.arih1803.isChecked() ? "3"
                : "-1");

        json.put("arih19", bi.arih1901.isChecked() ? "1"
                : bi.arih1902.isChecked() ? "2"
                : bi.arih1903.isChecked() ? "3"
                : bi.arih1904.isChecked() ? "4"
                : bi.arih1905.isChecked() ? "5"
                : "-1");

        json.put("arih2001", bi.arih2001.isChecked() ? "1" : "-1");
        json.put("arih2002", bi.arih2002.isChecked() ? "2" : "-1");
        json.put("arih2003", bi.arih2003.isChecked() ? "3" : "-1");
        json.put("arih2004", bi.arih2004.isChecked() ? "4" : "-1");
        json.put("arih2005", bi.arih2005.isChecked() ? "5" : "-1");
        json.put("arih2006", bi.arih2006.isChecked() ? "6" : "-1");
        json.put("arih2007", bi.arih2007.isChecked() ? "7" : "-1");

        json.put("arih21", bi.arih2101.isChecked() ? ""
                : bi.arih2102.isChecked() ? ""
                : bi.arih2103.isChecked() ? "666"
                : "-1");
        json.put("arih2101x", bi.arih2101x.getText().toString());
        json.put("arih2102x", bi.arih2102x.getText().toString());

        json.put("arih22", bi.arih2201.isChecked() ? "1"
                : bi.arih2202.isChecked() ? "2"
                : bi.arih2203.isChecked() ? "3"
                : "-1");

        json.put("arih23", bi.arih23.getText().toString());

        json.put("arih24", bi.arih2401.isChecked() ? "1"
                : bi.arih2402.isChecked() ? "2"
                : "-1");

        json.put("arih2501", bi.arih2501.isChecked() ? "1" : "-1");
        json.put("arih2502", bi.arih2502.isChecked() ? "2" : "-1");
        json.put("arih2503", bi.arih2503.isChecked() ? "3" : "-1");
        json.put("arih2504", bi.arih2504.isChecked() ? "4" : "-1");
        json.put("arih2505", bi.arih2505.isChecked() ? "5" : "-1");
        json.put("arih2506", bi.arih2506.isChecked() ? "6" : "-1");
        json.put("arih2507", bi.arih2507.isChecked() ? "7" : "-1");

        json.put("arih26", bi.arih2601.isChecked() ? "1"
                : bi.arih2602.isChecked() ? "2"
                : bi.arih2603.isChecked() ? "3"
                : "-1");

        json.put("arih27", bi.arih2701.isChecked() ? "1"
                : bi.arih2702.isChecked() ? "98"
                : "-1");
        json.put("arih2701x", bi.arih2701x.getText().toString());

        json.put("arih28", bi.arih2801.isChecked() ? "1"
                : bi.arih2802.isChecked() ? "98"
                : "-1");
        json.put("arih2801x", bi.arih2801x.getText().toString());

        json.put("arih29", bi.arih2901.isChecked() ? "1"
                : bi.arih2902.isChecked() ? "2"
                : bi.arih2903.isChecked() ? "3"
                : bi.arih2904.isChecked() ? "4"
                : bi.arih2905.isChecked() ? "5"
                : bi.arih2906.isChecked() ? "6"
                : bi.arih2907.isChecked() ? "7"
                : bi.arih2908.isChecked() ? "8"
                : bi.arih2909.isChecked() ? "9"
                : bi.arih2996.isChecked() ? "96"
                : "-1");
        json.put("arih2996x", bi.arih2996x.getText().toString());

        json.put("arih30", bi.arih3001.isChecked() ? ""
                : bi.arih3002.isChecked() ? "98"
                : "-1");
        json.put("arih3001x", bi.arih3001x.getText().toString());

        json.put("arih31", bi.arih3101.isChecked() ? "1"
                : bi.arih3102.isChecked() ? "2"
                : bi.arih3198.isChecked() ? "98"
                : "-1");

        json.put("arih32", bi.arih3201.isChecked() ? "1"
                : bi.arih3202.isChecked() ? "2"
                : bi.arih3298.isChecked() ? "98"
                : "-1");

        json.put("arih33", bi.arih3301.isChecked() ? "1"
                : bi.arih3302.isChecked() ? "2"
                : bi.arih3398.isChecked() ? "98"
                : "-1");

        json.put("arih34", bi.arih3401.isChecked() ? ""
                : bi.arih3402.isChecked() ? "98"
                : "-1");
        json.put("arih3401x", bi.arih3401x.getText().toString());

        json.put("arih35", bi.arih3501.isChecked() ? "1"
                : bi.arih3502.isChecked() ? "2"
                : bi.arih3503.isChecked() ? "3"
                : bi.arih3504.isChecked() ? "4"
                : bi.arih3596.isChecked() ? "96"
                : "-1");

        json.put("arih3601", bi.arih3601.isChecked() ? "1" : "-1");
        json.put("arih3602", bi.arih3602.isChecked() ? "2" : "-1");
        json.put("arih3603", bi.arih3603.isChecked() ? "3" : "-1");
        json.put("arih3604", bi.arih3604.isChecked() ? "4" : "-1");
        json.put("arih3605", bi.arih3605.isChecked() ? "5" : "-1");
        json.put("arih3606", bi.arih3606.isChecked() ? "6" : "-1");
        json.put("arih3607", bi.arih3607.isChecked() ? "7" : "-1");
        json.put("arih3608", bi.arih3608.isChecked() ? "8" : "-1");
        json.put("arih3609", bi.arih3609.isChecked() ? "9" : "-1");
        json.put("arih3610", bi.arih3610.isChecked() ? "10" : "-1");
        json.put("arih3611", bi.arih3611.isChecked() ? "11" : "-1");
        json.put("arih3696", bi.arih3696.isChecked() ? "96" : "-1");
        json.put("arih3696x", bi.arih3696x.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }
}