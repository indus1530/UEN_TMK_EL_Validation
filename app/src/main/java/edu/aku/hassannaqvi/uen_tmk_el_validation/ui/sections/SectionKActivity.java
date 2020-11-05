package edu.aku.hassannaqvi.uen_tmk_el_validation.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import edu.aku.hassannaqvi.uen_tmk_el_validation.R;
import edu.aku.hassannaqvi.uen_tmk_el_validation.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_tmk_el_validation.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el_validation.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el_validation.databinding.ActivitySectionKBinding;
import edu.aku.hassannaqvi.uen_tmk_el_validation.utils.AppUtilsKt;

public class SectionKActivity extends AppCompatActivity {

    ActivitySectionKBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k);
        bi.setCallback(this);
        setupSkip();

    }


    private void setupSkip() {
    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionLActivity.class));
            } else {
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SK, MainApp.form.getsK());
        return updcount == 1;
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("wsk1", bi.wsk101.isChecked() ? "1"
                : bi.wsk102.isChecked() ? "2"
                : bi.wsk103.isChecked() ? "3"
                : bi.wsk104.isChecked() ? "4"
                : bi.wsk105.isChecked() ? "5"
                : bi.wsk106.isChecked() ? "6"
                : bi.wsk107.isChecked() ? "7"
                : bi.wsk108.isChecked() ? "8"
                : bi.wsk109.isChecked() ? "9"
                : bi.wsk110.isChecked() ? "10"
                : bi.wsk111.isChecked() ? "11"
                : bi.wsk112.isChecked() ? "12"
                : bi.wsk113.isChecked() ? "13"
                : bi.wsk114.isChecked() ? "14"
                : bi.wsk115.isChecked() ? "15"
                : bi.wsk196.isChecked() ? "96"
                : "-1");

        json.put("wsk196x", bi.wsk196x.getText().toString());

        json.put("wsk9", bi.wsk901.isChecked() ? "1"
                : bi.wsk902.isChecked() ? "2"
                : bi.wsk903.isChecked() ? "3"
                : bi.wsk904.isChecked() ? "4"
                : bi.wsk905.isChecked() ? "5"
                : bi.wsk906.isChecked() ? "6"
                : bi.wsk907.isChecked() ? "7"
                : bi.wsk996.isChecked() ? "96"
                : "-1");

        json.put("wsk996x", bi.wsk996x.getText().toString());
        json.put("wsk10", bi.wsk1001.isChecked() ? "1"
                : bi.wsk1002.isChecked() ? "2"
                : bi.wsk1003.isChecked() ? "3"
                : bi.wsk1004.isChecked() ? "4"
                : bi.wsk1005.isChecked() ? "5"
                : bi.wsk1006.isChecked() ? "6"
                : bi.wsk1096.isChecked() ? "96"
                : "-1");

        json.put("wsk1096x", bi.wsk1096x.getText().toString());
        json.put("wsk11", bi.wsk1101.isChecked() ? "1"
                : bi.wsk1102.isChecked() ? "2"
                : bi.wsk1103.isChecked() ? "3"
                : bi.wsk1104.isChecked() ? "4"
                : bi.wsk1105.isChecked() ? "5"
                : bi.wsk1106.isChecked() ? "6"
                : bi.wsk1107.isChecked() ? "7"
                : bi.wsk1108.isChecked() ? "8"
                : bi.wsk1109.isChecked() ? "9"
                : bi.wsk1110.isChecked() ? "10"
                : bi.wsk1111.isChecked() ? "11"
                : "-1");


        json.put("wsk16", bi.wsk1601.isChecked() ? "1"
                : bi.wsk1602.isChecked() ? "2"
                : bi.wsk1603.isChecked() ? "3"
                : bi.wsk1604.isChecked() ? "4"
                : bi.wsk1605.isChecked() ? "96"
                : "-1");

        json.put("wsk1605x", bi.wsk1605x.getText().toString());

        MainApp.form.setsK(json.toString());
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