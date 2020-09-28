package edu.aku.hassannaqvi.uen_tmk_el.ui.sections;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.uen_tmk_el.CONSTANTS;
import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_tmk_el.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionDBinding;
import edu.aku.hassannaqvi.uen_tmk_el.models.Form;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.uen_tmk_el.core.MainApp.form;


public class SectionDActivity extends AppCompatActivity {

    ActivitySectionDBinding bi;
    private List<String> usersFullName, ucNames, ucCodes, villageNames, villageCodes;
    private DatabaseHelper db;

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
        SaveDraft();
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


    private void SaveDraft() {

        form = new Form();
        form.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime()));
        form.setFormtype(CONSTANTS.FORM_MP);
        form.setUsername(MainApp.userName);
        form.setDeviceID(MainApp.appInfo.getDeviceID());
        form.setDevicetagID(MainApp.appInfo.getTagName());
        form.setAppversion(MainApp.appInfo.getAppVersion());


        form.setMmd1(bi.mmd1.getText().toString());

        form.setMmd2(bi.mmd2.getText().toString());

        form.setMmd3(bi.mmd301.isChecked() ? "1"
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

        form.setMmd315(bi.mmd315x.getText().toString());

        form.setMmd4(bi.mmd401.isChecked() ? "1"
                : bi.mmd402.isChecked() ? "2"
                : bi.mmd403.isChecked() ? "3"
                : "-1");

        form.setMmd5(bi.mmd5.getText().toString());

        form.setMmd6(bi.mmd6.getText().toString());

        form.setMmd7(bi.mmd701.getText().toString());
        form.setMmd7(bi.mmd702.getText().toString());
        form.setMmd7(bi.mmd703.getText().toString());
        form.setMmd08(bi.mmd0801.getText().toString());
        form.setMmd08(bi.mmd0802.getText().toString());
        form.setMmd16(bi.mmd1601.isChecked() ? "1"
                : bi.mmd1602.isChecked() ? "2"
                : "-1");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

}