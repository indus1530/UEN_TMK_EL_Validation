package edu.aku.hassannaqvi.uen_tmk_el.ui.sections;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_tmk_el.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionDBinding;
import edu.aku.hassannaqvi.uen_tmk_el.models.Form;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.MainActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.uen_tmk_el.core.MainApp.form;


public class SectionDActivity extends AppCompatActivity {

    ActivitySectionDBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d);
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
            startActivity(new Intent(this, MainActivity.class).putExtra("complete", true));
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

        form = new Form();
        form.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(new Date().getTime()));
        form.setUsername(MainApp.userName);
        form.setDeviceID(MainApp.appInfo.getDeviceID());
        form.setDevicetagID(MainApp.appInfo.getTagName());
        form.setAppversion(MainApp.appInfo.getAppVersion());


        JSONObject json = new JSONObject();
        json.put("mmd1", bi.mmd1.getText().toString());

        json.put("mmd2", bi.mmd2.getText().toString());

        json.put("mmd3", bi.mmd301.isChecked() ? "1"
                : bi.mmd302.isChecked() ? "2"
                : bi.mmd303.isChecked() ? "3"
                : bi.mmd304.isChecked() ? "4"
                : bi.mmd305.isChecked() ? "5"
                : bi.mmd306.isChecked() ? "6"
                : bi.mmd307.isChecked() ? "7"
                : bi.mmd308.isChecked() ? "8"
                : bi.mmd309.isChecked() ? "9"
                : bi.mmd310.isChecked() ? "10"
                : bi.mmd311.isChecked() ? "11"
                : bi.mmd312.isChecked() ? "12"
                : bi.mmd313.isChecked() ? "13"
                : bi.mmd314.isChecked() ? "14"
                : bi.mmd315.isChecked() ? "96"
                : "-1");

        json.put("mmd315x", bi.mmd315x.getText().toString());
        json.put("mmd4", bi.mmd401.isChecked() ? "1"
                : bi.mmd402.isChecked() ? "2"
                : bi.mmd403.isChecked() ? "3"
                : "-1");

        json.put("mmd5", bi.mmd5.getText().toString());

        json.put("mmd601", bi.mmd601.getText().toString());

        json.put("mmd602", bi.mmd602.getText().toString());

        json.put("mmd7", bi.mmd701.isChecked() ? "1"
                : bi.mmd702.isChecked() ? "2"
                : bi.mmd703.isChecked() ? "3"
                : bi.mmd704.isChecked() ? "4"
                : bi.mmd799.isChecked() ? "99"
                : "-1");

        //json.put("mmd08", bi.mmd08.getText().toString());

        json.put("mmd0801", bi.mmd0801.getText().toString());
        //json.put("mmd9", bi.mmd9.getText().toString());

        json.put("mmd901", bi.mmd901.getText().toString());
        json.put("mmd10", bi.mmd1001.isChecked() ? "1"
                : bi.mmd1002.isChecked() ? "2"
                : "-1");

        json.put("mmd11", bi.mmd1100.isChecked() ? "0"
                : bi.mmd1101.isChecked() ? "1"
                : bi.mmd1102.isChecked() ? "2"
                : bi.mmd1103.isChecked() ? "3"
                : bi.mmd1104.isChecked() ? "4"
                : bi.mmd1105.isChecked() ? "5"
                : bi.mmd1106.isChecked() ? "6"
                : bi.mmd1107.isChecked() ? "7"
                : bi.mmd1108.isChecked() ? "8"
                : bi.mmd1109.isChecked() ? "9"
                : bi.mmd1110.isChecked() ? "10"
                : bi.mmd1111.isChecked() ? "11"
                : bi.mmd1112.isChecked() ? "12"
                : bi.mmd1113.isChecked() ? "13"
                : bi.mmd1114.isChecked() ? "14"
                : bi.mmd1115.isChecked() ? "15"
                : bi.mmd1116.isChecked() ? "16"
                : bi.mmd1117.isChecked() ? "17"
                : bi.mmd1118.isChecked() ? "18"
                : bi.mmd1119.isChecked() ? "19"
                : bi.mmd1120.isChecked() ? "20"
                : bi.mmd1198.isChecked() ? "98"
                : bi.mmd1199.isChecked() ? "99"
                : "-1");

        json.put("mmd12", bi.mmd1201.isChecked() ? "1"
                : bi.mmd1202.isChecked() ? "2"
                : bi.mmd1203.isChecked() ? "3"
                : bi.mmd1204.isChecked() ? "4"
                : bi.mmd1205.isChecked() ? "5"
                : bi.mmd1206.isChecked() ? "6"
                : bi.mmd1207.isChecked() ? "7"
                : bi.mmd1208.isChecked() ? "8"
                : bi.mmd1209.isChecked() ? "9"
                : bi.mmd1210.isChecked() ? "10"
                : bi.mmd1211.isChecked() ? "11"
                : bi.mmd1212.isChecked() ? "12"
                : bi.mmd1213.isChecked() ? "99"
                : bi.mmd1299.isChecked() ? "99"
                : "-1");

        json.put("mmd13", bi.mmd1302.isChecked() ? "1"
                : bi.mmd1303.isChecked() ? "2"
                : "-1");

        json.put("mmd14", bi.mmd14.getText().toString());

        json.put("mmd15", bi.mmd15.getText().toString());

        json.put("mmd16", bi.mmd16.getText().toString());

        form.setsD(json.toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }


    public void showTooltipView(View view) {
        AppUtilsKt.showTooltip(this, view);
    }

}