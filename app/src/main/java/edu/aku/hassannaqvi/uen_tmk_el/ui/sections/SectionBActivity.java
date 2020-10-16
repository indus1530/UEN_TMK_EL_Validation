package edu.aku.hassannaqvi.uen_tmk_el.ui.sections;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.uen_tmk_el.CONSTANTS;
import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_tmk_el.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionBBinding;
import edu.aku.hassannaqvi.uen_tmk_el.models.Form;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.uen_tmk_el.core.MainApp.form;


public class SectionBActivity extends AppCompatActivity {

    ActivitySectionBBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b);
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
        form.setFormtype(CONSTANTS.FORM_MF);
        form.setUsername(MainApp.userName);
        form.setDeviceID(MainApp.appInfo.getDeviceID());
        form.setDevicetagID(MainApp.appInfo.getTagName());
        form.setAppversion(MainApp.appInfo.getAppVersion());

        JSONObject json = new JSONObject();

        json.put("elb1", bi.elb1.getText().toString());

        json.put("elb2", bi.elb201.isChecked() ? "1"
                : bi.elb202.isChecked() ? "2"
                : bi.elb203.isChecked() ? "3"
                : "-1");

        json.put("elb3", bi.elb3.getText().toString());

        json.put("elb4", bi.elb4.getText().toString());

        json.put("elb5", bi.elb5.getText().toString());

        json.put("elb6", bi.elb601.isChecked() ? "1"
                : bi.elb602.isChecked() ? "2"
                : bi.elb603.isChecked() ? "3"
                : "-1");

        json.put("elb7", bi.elb701.isChecked() ? "1"
                : bi.elb702.isChecked() ? "2"
                : bi.elb703.isChecked() ? "3"
                : bi.elb704.isChecked() ? "4"
                : bi.elb705.isChecked() ? "5"
                : bi.elb706.isChecked() ? "6"
                : bi.elb707.isChecked() ? "7"
                : bi.elb708.isChecked() ? "8"
                : bi.elb709.isChecked() ? "9"
                : bi.elb710.isChecked() ? "10"
                : "-1");

        json.put("elb8", bi.elb8.getText().toString());

        json.put("elb8a", bi.elb8a.getText().toString());

        json.put("elb09", bi.elb0901.isChecked() ? "1"
                : bi.elb0902.isChecked() ? "2"
                : bi.elb0903.isChecked() ? "3"
                : "-1");

        json.put("elb10", bi.elb10.getText().toString());

        json.put("elb11", bi.elb11.getText().toString());

        json.put("elb12", bi.elb12.getText().toString());


        MainApp.setGPS(this);
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }


}