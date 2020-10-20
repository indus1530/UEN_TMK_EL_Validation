package edu.aku.hassannaqvi.uen_tmk_el.ui.sections;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionF03Binding;
import edu.aku.hassannaqvi.uen_tmk_el.models.Death;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.MainActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;


public class SectionF03Activity extends AppCompatActivity {

    ActivitySectionF03Binding bi;
    private Death death;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f03);
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
        }
    }


    private boolean UpdateDB() {

        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addDeath(death);
        death.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            death.set_UID(death.getDeviceID() + death.get_ID());
            db.updatesDeathColumn(DeathContract.DeathTable.COLUMN_UID, death.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void SaveDraft() throws JSONException {

        death = new Death();
        death.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(new Date().getTime()));
//        death.setUUID(MainApp.form.get_UID());
        death.setUsername(MainApp.userName);
        death.setDeviceID(MainApp.appInfo.getDeviceID());
        death.setDevicetagID(MainApp.appInfo.getTagName());
        death.setAppversion(MainApp.appInfo.getAppVersion());
        /*death.setEb1(MainApp.form.getElb1());
        death.setEb11(MainApp.form.getElb11());*/

        JSONObject json = new JSONObject();

        json.put("raf7a", bi.raf7a.getText().toString());
        json.put("raf7b", bi.raf7b.getText().toString());
        json.put("raf7cd", bi.raf7cd.getText().toString());
        json.put("raf7cm", bi.raf7cm.getText().toString());
        json.put("raf7cy", bi.raf7cy.getText().toString());

        json.put("raf7d", bi.raf7d01.isChecked() ? "1"
                : bi.raf7d02.isChecked() ? "2"
                : bi.raf7d03.isChecked() ? "3"
                : bi.raf7d04.isChecked() ? "4"
                : bi.raf7d05.isChecked() ? "5"
                : "-1");

        json.put("raf7e", bi.raf7e.getText().toString().trim().isEmpty() ? "-1" : bi.raf7e.getText().toString());

        json.put("raf7f", bi.raf7f01.isChecked() ? "1"
                : bi.raf7f02.isChecked() ? "2"
                : bi.raf7f03.isChecked() ? "3"
                : bi.raf7f04.isChecked() ? "4"
                : bi.raf7f05.isChecked() ? "5"
                : bi.raf7f06.isChecked() ? "6"
                : bi.raf7f96.isChecked() ? "96"
                : "-1");

        json.put("raf7f96x", bi.raf7f96x.getText().toString());

        death.setsB(json.toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

}