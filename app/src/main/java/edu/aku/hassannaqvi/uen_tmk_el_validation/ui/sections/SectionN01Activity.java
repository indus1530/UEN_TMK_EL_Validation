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

import edu.aku.hassannaqvi.uen_tmk_el_validation.CONSTANTS;
import edu.aku.hassannaqvi.uen_tmk_el_validation.R;
import edu.aku.hassannaqvi.uen_tmk_el_validation.contracts.Mwra_ChildrenContract;
import edu.aku.hassannaqvi.uen_tmk_el_validation.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el_validation.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el_validation.databinding.ActivitySectionN01Binding;
import edu.aku.hassannaqvi.uen_tmk_el_validation.models.MWRA_CHILD;
import edu.aku.hassannaqvi.uen_tmk_el_validation.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_tmk_el_validation.utils.AppUtilsKt;
import edu.aku.hassannaqvi.uen_tmk_el_validation.utils.EndSectionActivity;

public class SectionN01Activity extends AppCompatActivity implements EndSectionActivity {

    ActivitySectionN01Binding bi;
    MWRA_CHILD anthro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_n01);
        bi.setCallback(this);
        setupSkip();
    }

    private void setupSkip() {

        bi.can1.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.can102.getId()) {
                Clear.clearAllFields(bi.ele01check);
            }
        }));

        bi.can4.setOnCheckedChangeListener((group, checkedId) -> {
            Clear.clearAllFields(bi.fldGrpCVcan5);
            bi.fldGrpCVcan5.setVisibility(View.VISIBLE);
            if (checkedId == bi.can402.getId()) {
                bi.fldGrpCVcan5.setVisibility(View.GONE);
            }
        });

    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft(true);
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
        long updcount = db.addMWRACHILD(anthro);
        anthro.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            anthro.set_UID(anthro.getDeviceID() + anthro.get_ID());
            db.updatesMWRAChildColumn(Mwra_ChildrenContract.MWRAChildTable.COLUMN_UID, anthro.get_UID(), anthro.get_ID());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft(boolean flag) throws JSONException {

        anthro = new MWRA_CHILD();
        anthro.setUsername(MainApp.userName);
        anthro.setDeviceID(MainApp.appInfo.getDeviceID());
        anthro.setDevicetagID(MainApp.appInfo.getTagName());
        anthro.setAppversion(MainApp.appInfo.getAppVersion());
        anthro.setElb1(MainApp.form.getElb1());
        anthro.setElb11(MainApp.form.getElb11());
        anthro.setType(CONSTANTS.MWRA_ANTHRO_TYPE);
        anthro.setSysdate(MainApp.form.getSysdate());
        anthro.setUUID(MainApp.form.get_UID());

        JSONObject json = new JSONObject();

        json.put("elb8a", MainApp.form.getElb8a());

        json.put("name", bi.can0.getText().toString());
        json.put("can1", bi.can101.isChecked() ? "1"
                : bi.can102.isChecked() ? "2"
                : "-1");

        json.put("can2", bi.can2.getText().toString());

        json.put("can4", bi.can401.isChecked() ? "1"
                : bi.can402.isChecked() ? "2"
                : bi.can403.isChecked() ? "3"
                : "-1");

        json.put("can5", bi.can501.isChecked() ? "1"
                : bi.can502.isChecked() ? "98"
                : "-1");

        json.put("can501x", bi.can501x.getText().toString());

        json.put("status", flag);

        anthro.setsB(json.toString());
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void BtnEnd() {
        if (!Validator.emptyTextBox(this, bi.can0)) return;
        AppUtilsKt.openWarningActivity(this, "Are you sure, you want to end " + bi.can0.getText().toString() + " anthro form?");
    }

    @Override
    public void endSecActivity(boolean flag) {
        try {
            SaveDraft(false);
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You Can't go back", Toast.LENGTH_LONG).show();
    }
}