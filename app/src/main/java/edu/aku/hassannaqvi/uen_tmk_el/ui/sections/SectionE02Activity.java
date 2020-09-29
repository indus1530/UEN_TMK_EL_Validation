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
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionE02Binding;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

public class SectionE02Activity extends AppCompatActivity {

    ActivitySectionE02Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i);
        bi.setCallback(this);

        setupSkip();
    }

    private void setupSkip() {

        /*bi.imi1.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.imi101.getId()) {
                Clear.clearAllFields(bi.fldGrpCVimi2);
            }
        });*/

        /*bi.chg6.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.chg601.getId()) {
                Clear.clearAllFields(bi.fldGrpCVchg7);
            }
        });*/

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

        json.put("ele9a", bi.ele9a01.isChecked() ? "1"
                : bi.ele9a02.isChecked() ? "2"
                : "-1");

        json.put("ele9b", bi.ele9b01.isChecked() ? "1"
                : bi.ele9b02.isChecked() ? "2"
                : "-1");

        json.put("ele9c", bi.ele9c01.isChecked() ? "1"
                : bi.ele9c02.isChecked() ? "2"
                : "-1");

        json.put("ele9d", bi.ele9d01.isChecked() ? "1"
                : bi.ele9d02.isChecked() ? "2"
                : "-1");

        json.put("ele9e", bi.ele9e01.isChecked() ? "1"
                : bi.ele9e02.isChecked() ? "2"
                : "-1");

        json.put("ele9f", bi.ele9f01.isChecked() ? "1"
                : bi.ele9f02.isChecked() ? "2"
                : "-1");

        json.put("ele9g", bi.ele9g01.isChecked() ? "1"
                : bi.ele9g02.isChecked() ? "2"
                : "-1");

        json.put("ele9h", bi.ele9h01.isChecked() ? "1"
                : bi.ele9h02.isChecked() ? "2"
                : "-1");

        json.put("ele9i", bi.ele9i01.isChecked() ? "1"
                : bi.ele9i02.isChecked() ? "2"
                : "-1");

        json.put("ele10", bi.ele1001.isChecked() ? "1"
                : bi.ele1002.isChecked() ? "2"
                : "-1");

        json.put("ele11", bi.ele1101.isChecked() ? "1"
                : bi.ele1102.isChecked() ? "2"
                : bi.ele1103.isChecked() ? "98"
                : "-1");

        json.put("ele12", bi.ele1201.isChecked() ? "1"
                : bi.ele1202.isChecked() ? "2"
                : bi.ele1203.isChecked() ? "3"
                : "-1");

        json.put("ele1201x", bi.ele1201x.getText().toString());
        json.put("ele1202x", bi.ele1202x.getText().toString());
        json.put("ele13", bi.ele1301.isChecked() ? "1"
                : bi.ele1302.isChecked() ? "2"
                : "-1");

        json.put("ele1401", bi.ele1401.getText().toString());

        json.put("ele1402", bi.ele1402.getText().toString());

        json.put("ele1403", bi.ele1403.getText().toString());

        json.put("ele1404", bi.ele1404.getText().toString());

        json.put("ele1405", bi.ele1405.getText().toString());

        json.put("ele1406", bi.ele1406.getText().toString());

        json.put("ele15", bi.ele1501.isChecked() ? "1"
                : bi.ele1502.isChecked() ? "2"
                : bi.ele15098.isChecked() ? "98"
                : "-1");

        json.put("ele16", bi.ele1601.isChecked() ? "1"
                : bi.ele1602.isChecked() ? "2"
                : bi.ele1603.isChecked() ? "3"
                : bi.ele1604.isChecked() ? "4"
                : bi.ele1605.isChecked() ? "5"
                : bi.ele1606.isChecked() ? "6"
                : bi.ele1607.isChecked() ? "7"
                : bi.ele1608.isChecked() ? "8"
                : bi.ele1609.isChecked() ? "9"
                : bi.ele1610.isChecked() ? "10"
                : bi.ele1611.isChecked() ? "11"
                : bi.ele1696.isChecked() ? "96"
                : "-1");

        json.put("ele1696x", bi.ele1696x.getText().toString());
        json.put("ele17", bi.ele1701.isChecked() ? "1"
                : bi.ele1702.isChecked() ? "2"
                : bi.ele1798.isChecked() ? "98"
                : "-1");

        json.put("ele1701x", bi.ele1701x.getText().toString());
        json.put("ele18", bi.ele1801.isChecked() ? "1"
                : bi.ele1802.isChecked() ? "2"
                : bi.ele1803.isChecked() ? "3"
                : bi.ele1804.isChecked() ? "4"
                : bi.ele1896.isChecked() ? "96"
                : "-1");

        json.put("ele1896x", bi.ele1896x.getText().toString());
        json.put("ele1901", bi.ele1901.isChecked() ? "1" : "-1");

        json.put("ele1902", bi.ele1902.isChecked() ? "2" : "-1");

        json.put("ele1903", bi.ele1903.isChecked() ? "3" : "-1");

        json.put("ele1904", bi.ele1904.isChecked() ? "4" : "-1");

        json.put("ele1905", bi.ele1905.isChecked() ? "5" : "-1");

        json.put("ele1996", bi.ele1996.isChecked() ? "96" : "-1");

        json.put("ele1996x", bi.ele1996x.getText().toString());
        json.put("ele2001", bi.ele2001.isChecked() ? "1" : "-1");

        json.put("ele2002", bi.ele2002.isChecked() ? "2" : "-1");

        json.put("ele2003", bi.ele2003.isChecked() ? "3" : "-1");

        json.put("ele2096", bi.ele2096.isChecked() ? "96" : "-1");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

}