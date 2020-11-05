package edu.aku.hassannaqvi.uen_tmk_el_validation.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import edu.aku.hassannaqvi.uen_tmk_el_validation.databinding.ActivitySectionGBinding;
import edu.aku.hassannaqvi.uen_tmk_el_validation.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.uen_tmk_el_validation.core.MainApp.form;

public class SectionGActivity extends AppCompatActivity {

    ActivitySectionGBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g);
        bi.setCallback(this);

        setupContent();
        setupSkip();
    }

    private void setupContent() {

    }

    private void setupSkip() {

        bi.chg1.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != bi.chg101.getId()) {
                Clear.clearAllFields(bi.fldGrpSecG01);
                bi.fldGrpSecG01.setVisibility(View.GONE);
            } else {
                bi.fldGrpSecG01.setVisibility(View.VISIBLE);
            }
        });

        bi.chg6.setOnCheckedChangeListener((group, checkedId) -> {
            Clear.clearAllFields(bi.chg7cv);
            Clear.clearAllFields(bi.llchg8);
        });

        bi.chg32.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.chg3202.getId()) {
                Clear.clearAllFields(bi.fldGrpSecG06);
                bi.fldGrpSecG06.setVisibility(View.GONE);
            } else {
                bi.fldGrpSecG06.setVisibility(View.VISIBLE);
            }
        });

        bi.chg33.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.chg3302.getId()) {
                Clear.clearAllFields(bi.fldGrpCVchg34);
                bi.fldGrpCVchg34.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVchg34.setVisibility(View.VISIBLE);
            }
        });

    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionHActivity.class));
            } else {
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SG, MainApp.form.getsG());
        return updcount == 1;
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


        json.put("chg9", bi.chg901.isChecked() ? "1"
                : bi.chg902.isChecked() ? "2"
                : bi.chg903.isChecked() ? "3"
                : bi.chg904.isChecked() ? "4"
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


        json.put("chg13", bi.chg1301.isChecked() ? "1"
                : bi.chg1302.isChecked() ? "2"
                : "-1");

        json.put("chg25", bi.chg2501.isChecked() ? "1"
                : bi.chg2502.isChecked() ? "2"
                : bi.chg2503.isChecked() ? "3"
                : "-1");

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
        json.put("chg3496x", bi.chg3496x.getText().toString().trim().isEmpty() ? "-1" : bi.chg3496x.getText().toString());

        form.setsG(json.toString());

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