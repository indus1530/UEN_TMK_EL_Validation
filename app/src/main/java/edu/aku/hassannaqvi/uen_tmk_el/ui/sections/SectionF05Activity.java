package edu.aku.hassannaqvi.uen_tmk_el.ui.sections;

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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.contracts.MWRAContract;
import edu.aku.hassannaqvi.uen_tmk_el.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionF05Binding;
import edu.aku.hassannaqvi.uen_tmk_el.models.Death;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.uen_tmk_el.CONSTANTS.C_DEATH_COUNT;

public class SectionF05Activity extends AppCompatActivity {

    ActivitySectionF05Binding bi;
    int count;
    private Death death;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f05);
        bi.setCallback(this);
        setupContent();
    }


    private void setupContent() {
        count = Integer.parseInt(getIntent().getStringExtra(C_DEATH_COUNT));
        setupNextButtonText();
    }

    private boolean setupNextButtonText() {
        if (count > 1) {
            Clear.clearAllFields(bi.GrpName);
            bi.btnContinue.setText("Next Death");
            bi.cmf9b.setFocusable(true);
            return false;
        } else if (count == 1) {
            bi.btnContinue.setText("Next Section");
            return false;
        }
        return true;
    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            if (setupNextButtonText()) {
                finish();
                startActivity(new Intent(this, SectionF06Activity.class));
            }
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addDeath(death);
        death.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            death.set_UID(death.getDeviceID() + death.get_ID());
            db.updatesFormColumn(MWRAContract.MWRATable.COLUMN_UID, death.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        death = new Death();
        death.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(new Date().getTime()));
        death.setUUID(MainApp.form.get_UID());
        death.setUsername(MainApp.userName);
        death.setDeviceID(MainApp.appInfo.getDeviceID());
        death.setDevicetagID(MainApp.appInfo.getTagName());
        death.setAppversion(MainApp.appInfo.getAppVersion());
        death.setElb1(MainApp.form.getElb1());
        death.setElb11(MainApp.form.getElb11());
        death.setType("2");

        JSONObject json = new JSONObject();

        json.put("cmf9a", bi.cmf9a.getText().toString());
        json.put("cmf9b", bi.cmf9b.getText().toString());
        json.put("cmf9c", bi.cmf9c.getText().toString());
        json.put("cmf9d", bi.cmf9d.getText().toString());

        json.put("cmf9e", bi.cmf9e01.isChecked() ? "1"
                : bi.cmf9e02.isChecked() ? "2"
                : "-1");

        json.put("cmf9fd", bi.cmf9fd.getText().toString().trim().isEmpty() ? "-1" : bi.cmf9fd.getText().toString());
        json.put("cmf9fm", bi.cmf9fm.getText().toString().trim().isEmpty() ? "-1" : bi.cmf9fm.getText().toString());
        json.put("cmf9fy", bi.cmf9fy.getText().toString().trim().isEmpty() ? "-1" : bi.cmf9fy.getText().toString());

        json.put("cmf9g", bi.cmf9g01.isChecked() ? "1"
                : bi.cmf9g02.isChecked() ? "2"
                : bi.cmf9g03.isChecked() ? "3"
                : bi.cmf9g04.isChecked() ? "4"
                : bi.cmf9g05.isChecked() ? "5"
                : "-1");

        json.put("cmf9h", bi.cmf9h.getText().toString());

        json.put("cmf9i", bi.cmf9i1.isChecked() ? "1"
                : bi.cmf9i2.isChecked() ? "2"
                : bi.cmf9i3.isChecked() ? "3"
                : bi.cmf9i4.isChecked() ? "4"
                : bi.cmf9i5.isChecked() ? "5"
                : bi.cmf9i6.isChecked() ? "6"
                : bi.cmf9i7.isChecked() ? "7"
                : bi.cmf9i8.isChecked() ? "8"
                : bi.cmf9i96.isChecked() ? "96"
                : "-1");
        json.put("cmf9i96x", bi.cmf9i96x.getText().toString());

        death.setsB(json.toString());

        count++;
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