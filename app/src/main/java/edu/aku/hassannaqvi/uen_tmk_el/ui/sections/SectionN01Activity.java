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

import edu.aku.hassannaqvi.uen_tmk_el.CONSTANTS;
import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.contracts.Mwra_ChildrenContract;
import edu.aku.hassannaqvi.uen_tmk_el.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionN01Binding;
import edu.aku.hassannaqvi.uen_tmk_el.models.MWRA_CHILD;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

public class SectionN01Activity extends AppCompatActivity {

    ActivitySectionN01Binding bi;
    MWRA_CHILD mwraChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_n01);
        bi.setCallback(this);
        setupSkip();
        bi.kishName.setText(String.format("Name:%s & Serial no: %s", MainApp.indexKishMWRA.getName().toUpperCase(), MainApp.indexKishMWRA.getSerialno()));
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
        long updcount = db.addMWRACHILD(mwraChild);
        mwraChild.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            mwraChild.set_UID(mwraChild.getDeviceID() + mwraChild.get_ID());
            db.updatesMWRAChildColumn(Mwra_ChildrenContract.MWRAChildTable.COLUMN_UID, mwraChild.get_UID(), mwraChild.get_ID());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        mwraChild = new MWRA_CHILD();
        mwraChild.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(new Date().getTime()));
        mwraChild.setUsername(MainApp.userName);
        mwraChild.setDeviceID(MainApp.appInfo.getDeviceID());
        mwraChild.setDevicetagID(MainApp.appInfo.getTagName());
        mwraChild.setAppversion(MainApp.appInfo.getAppVersion());
        mwraChild.setUUID(MainApp.form.get_UID());
        mwraChild.setElb1(MainApp.form.getElb1());
        mwraChild.setElb11(MainApp.form.getElb11());
        mwraChild.setFmuid(MainApp.indexKishMWRA.getUid());
        mwraChild.setType(CONSTANTS.MWRA_ANTHRO_TYPE);

        JSONObject json = new JSONObject();
        json.put("elb8a", MainApp.form.getElb8a());
        json.put("serial", MainApp.indexKishMWRA.getSerialno());
        json.put("name", MainApp.indexKishMWRA.getName());
        json.put("can1", bi.can101.isChecked() ? "1"
                : bi.can102.isChecked() ? "2"
                : "-1");

        json.put("can2", bi.can2.getText().toString());

        json.put("can3", bi.can3.getText().toString());

        json.put("can4", bi.can401.isChecked() ? "1"
                : bi.can402.isChecked() ? "2"
                : bi.can403.isChecked() ? "3"
                : "-1");

        json.put("can5", bi.can501.isChecked() ? "1"
                : bi.can502.isChecked() ? "98"
                : "-1");

        json.put("can501x", bi.can501x.getText().toString());

        mwraChild.setsB(json.toString());
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