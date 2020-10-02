package edu.aku.hassannaqvi.uen_tmk_el.ui.sections;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.uen_tmk_el.CONSTANTS;
import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_tmk_el.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionCBinding;
import edu.aku.hassannaqvi.uen_tmk_el.models.Form;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.MainActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.uen_tmk_el.core.MainApp.form;


public class SectionCActivity extends AppCompatActivity {

    ActivitySectionCBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c);
        bi.setCallback(this);
        setupSkip();
    }


    private void setupSkip() {

        /*bi.mf105.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVmf106);
            Clear.clearAllFields(bi.fldGrpCVmf107);
            Clear.clearAllFields(bi.fldGrpCVmf108);
            bi.fldGrpCVmf106.setVisibility(View.GONE);
            bi.fldGrpCVmf107.setVisibility(View.GONE);
            bi.fldGrpCVmf108.setVisibility(View.GONE);

            if (i == bi.mf10501.getId()) {
                bi.fldGrpCVmf107.setVisibility(View.VISIBLE);
            } else if (i == bi.mf10502.getId()) {
                bi.fldGrpCVmf106.setVisibility(View.VISIBLE);
            } else if (i == bi.mf10503.getId()) {
                bi.fldGrpCVmf108.setVisibility(View.VISIBLE);
            }
        });*/

    }


    public void BtnContinue() {
        if (!formValidation()) return;
        SaveDraft();
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


    private void SaveDraft() {

        form = new Form();
        form.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(new Date().getTime()));
        form.setFormtype(CONSTANTS.FORM_MF);
        form.setUsername(MainApp.userName);
        form.setDeviceID(MainApp.appInfo.getDeviceID());
        form.setDevicetagID(MainApp.appInfo.getTagName());
        form.setAppversion(MainApp.appInfo.getAppVersion());

        form.setElc1(bi.elc101.isChecked() ? "1"
                : bi.elc102.isChecked() ? "2"
                : "-1");

        form.setElc2(bi.elc201.isChecked() ? "1"
                : bi.elc202.isChecked() ? "2"
                : "-1");

        form.setElc3(bi.elc3.getText().toString());

        form.setElc4(bi.elc401.isChecked() ? "1"
                : bi.elc402.isChecked() ? "2"
                : "-1");

        /*form.setElc5(bi.elc501x.getText().toString());
        form.setELC502x(bi.elc502x.getText().toString());*/

        form.setElc6(bi.elc601.isChecked() ? "1"
                : bi.elc602.isChecked() ? "2"
                : "-1");

        form.setElc7(bi.elc701.isChecked() ? "1"
                : bi.elc702.isChecked() ? "2"
                : bi.elc703.isChecked() ? "3"
                : bi.elc704.isChecked() ? "4"
                : bi.elc705.isChecked() ? "5"
                : bi.elc706.isChecked() ? "6"
                : bi.elc707.isChecked() ? "7"
                : bi.elc708.isChecked() ? "8"
                : bi.elc796.isChecked() ? "96"
                : "-1");

        form.setElc796(bi.elc796x.getText().toString());

        MainApp.setGPS(this);
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }


}