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
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionH01Binding;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

public class SectionH01Activity extends AppCompatActivity {

    ActivitySectionH01Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h01);
        bi.setCallback(this);

        setupSkip();
    }

    private void setupSkip() {

        bi.arih1.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != bi.arih101.getId()) {
                Clear.clearAllFields(bi.fldGrpCVarih2);
            }
        });

        bi.arih3.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.arih301.getId()) {
                Clear.clearAllFields(bi.fldGrpSecH01);
            }
        });

        bi.arih7.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.arih701.getId()) {
                Clear.clearAllFields(bi.fldGrpCVarih8);
            }
        });

        bi.arih14.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.arih1402.getId()) {
                Clear.clearAllFields(bi.fldGrpSecH02);
            }
        });

        bi.arih16.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.arih1602.getId()) {
                Clear.clearAllFields(bi.fldGrpSecH03);
            }
        });

        bi.arih21.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.arih2103.getId()) {
                Clear.clearAllFields(bi.fldGrpSecH04);
                Clear.clearAllFields(bi.fldGrpCVarih26);
            }
        });

        bi.arih22.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.arih2202.getId()) {
                Clear.clearAllFields(bi.fldGrpSecH05);
            }
        });

        bi.arih24.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.arih2401.getId()) {
                Clear.clearAllFields(bi.fldGrpCVarih25);
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
            startActivity(new Intent(this, SectionH02Activity.class));
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

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }
}