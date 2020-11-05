package edu.aku.hassannaqvi.uen_tmk_el_validation.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import edu.aku.hassannaqvi.uen_tmk_el_validation.databinding.ActivitySectionLBinding;
import edu.aku.hassannaqvi.uen_tmk_el_validation.utils.AppUtilsKt;

public class SectionLActivity extends AppCompatActivity {

    ActivitySectionLBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_l);
        bi.setCallback(this);
        setupSkip();
        setupContent();
    }

    private void setupContent() {
    }


    private void setupSkip() {

        bi.hwl1.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.llhwl2t4));


        bi.hwl3.setOnCheckedChangeListener(((radioGroup, i) -> {

            Clear.clearAllFields(bi.fldGrpCVhwl4);
            Clear.clearAllFields(bi.fldGrpCVhwl5);
            bi.fldGrpCVhwl4.setVisibility(View.GONE);
            bi.fldGrpCVhwl5.setVisibility(View.GONE);

            if (i == bi.hwl301.getId()) {
                bi.fldGrpCVhwl4.setVisibility(View.VISIBLE);
            } else {
                bi.fldGrpCVhwl5.setVisibility(View.VISIBLE);
            }
        }));


        bi.hwl809.setOnCheckedChangeListener((compoundButton, b) -> {
            Clear.clearAllFields(bi.hwl8check, !b);
        });
    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionN02Activity.class));
            } else {
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SL, MainApp.form.getsL());
        return updcount == 1;
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("hwl1", bi.hwl101.isChecked() ? "1"
                : bi.hwl102.isChecked() ? "2"
                : bi.hwl103.isChecked() ? "3"
                : bi.hwl196.isChecked() ? "96"
                : "-1");

        json.put("hwl196x", bi.hwl196x.getText().toString());
        json.put("hwl2", bi.hwl201.isChecked() ? "1"
                : bi.hwl202.isChecked() ? "2"
                : "-1");

        json.put("hwl3", bi.hwl301.isChecked() ? "1"
                : bi.hwl302.isChecked() ? "2"
                : bi.hwl303.isChecked() ? "3"
                : "-1");

        json.put("hwl401", bi.hwl401.isChecked() ? "1" : "-1");

        json.put("hwl402", bi.hwl402.isChecked() ? "2" : "-1");

        json.put("hwl403", bi.hwl403.isChecked() ? "3" : "-1");

        json.put("hwl404", bi.hwl404.isChecked() ? "4" : "-1");

        json.put("hwl5", bi.hwl501.isChecked() ? "1"
                : bi.hwl502.isChecked() ? "2"
                : "-1");

        json.put("hwl801", bi.hwl801.isChecked() ? "1" : "-1");

        json.put("hwl802", bi.hwl802.isChecked() ? "2" : "-1");

        json.put("hwl803", bi.hwl803.isChecked() ? "3" : "-1");

        json.put("hwl804", bi.hwl804.isChecked() ? "4" : "-1");

        json.put("hwl805", bi.hwl805.isChecked() ? "5" : "-1");

        json.put("hwl806", bi.hwl806.isChecked() ? "6" : "-1");

        json.put("hwl807", bi.hwl807.isChecked() ? "7" : "-1");

        json.put("hwl808", bi.hwl808.isChecked() ? "8" : "-1");

        json.put("hwl809", bi.hwl809.isChecked() ? "9" : "-1");

        json.put("hwl10", bi.hwl1001.isChecked() ? "1"
                : bi.hwl1002.isChecked() ? "2"
                : bi.hwl1003.isChecked() ? "3"
                : bi.hwl1004.isChecked() ? "4"
                : bi.hwl1096.isChecked() ? "96"
                : "-1");

        json.put("hwl1096x", bi.hwl1096x.getText().toString());
        json.put("hwl11", bi.hwl1101.isChecked() ? "1"
                : bi.hwl1102.isChecked() ? "2"
                : bi.hwl1103.isChecked() ? "3"
                : bi.hwl1196.isChecked() ? "96"
                : "-1");

        json.put("hwl1196x", bi.hwl1196x.getText().toString());

        MainApp.form.setsL(json.toString());

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