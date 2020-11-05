package edu.aku.hassannaqvi.uen_tmk_el_validation.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import edu.aku.hassannaqvi.uen_tmk_el_validation.R;
import edu.aku.hassannaqvi.uen_tmk_el_validation.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_tmk_el_validation.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el_validation.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el_validation.databinding.ActivitySectionHBinding;
import edu.aku.hassannaqvi.uen_tmk_el_validation.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.uen_tmk_el_validation.core.MainApp.form;

public class SectionHActivity extends AppCompatActivity {

    ActivitySectionHBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h);
        bi.setCallback(this);

        setupSkip();
        setupContent();
    }

    private void setupContent() {

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

    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionI01Activity.class));
            } else {
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SH, MainApp.form.getsH());
        return updcount == 1;
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

        json.put("arih4", bi.arih4.getText().toString().trim().isEmpty() ? "-1" : bi.arih4.getText().toString());

        json.put("arih501", bi.arih501.getText().toString());
        json.put("arih502", bi.arih502.getText().toString());

        json.put("arih6", bi.arih6.getText().toString());

        json.put("arih7", bi.arih701.isChecked() ? "1"
                : bi.arih702.isChecked() ? "2"
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
        json.put("arih896x", bi.arih896x.getText().toString().trim().isEmpty() ? "-1" : bi.arih896x.getText().toString());


        json.put("arih10", bi.arih1001.isChecked() ? "1"
                : bi.arih1002.isChecked() ? "2"
                : bi.arih1003.isChecked() ? "3"
                : bi.arih1004.isChecked() ? "4"
                : "-1");

        json.put("arih1201", bi.arih1201.isChecked() ? "1" : "-1");
        json.put("arih1202", bi.arih1202.isChecked() ? "2" : "-1");
        json.put("arih1203", bi.arih1203.isChecked() ? "3" : "-1");
        json.put("arih1204", bi.arih1204.isChecked() ? "4" : "-1");
        json.put("arih1205", bi.arih1205.isChecked() ? "5" : "-1");
        json.put("arih1206", bi.arih1206.isChecked() ? "6" : "-1");
        json.put("arih1207", bi.arih1207.isChecked() ? "7" : "-1");
        json.put("arih1208", bi.arih1208.isChecked() ? "8" : "-1");


        json.put("arih14", bi.arih1401.isChecked() ? "1"
                : bi.arih1402.isChecked() ? "2"
                : "-1");

        json.put("arih26", bi.arih2601.isChecked() ? "1"
                : bi.arih2602.isChecked() ? "2"
                : bi.arih2603.isChecked() ? "3"
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
        json.put("arih3696x", bi.arih3696x.getText().toString().trim().isEmpty() ? "-1" : bi.arih3696x.getText().toString());


        form.setsH(json.toString());
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