package edu.aku.hassannaqvi.uen_tmk_el_validation.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.edittextpicker.aliazaz.EditTextPicker;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_tmk_el_validation.R;
import edu.aku.hassannaqvi.uen_tmk_el_validation.contracts.Mwra_ChildrenContract;
import edu.aku.hassannaqvi.uen_tmk_el_validation.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el_validation.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el_validation.databinding.ActivitySectionN02Binding;
import edu.aku.hassannaqvi.uen_tmk_el_validation.models.MWRA_CHILD;
import edu.aku.hassannaqvi.uen_tmk_el_validation.utils.AppUtilsKt;
import edu.aku.hassannaqvi.uen_tmk_el_validation.utils.EndSectionActivity;

import static edu.aku.hassannaqvi.uen_tmk_el_validation.CONSTANTS.CHILD_ANTHRO_TYPE;

public class SectionN02Activity extends AppCompatActivity implements EndSectionActivity {

    ActivitySectionN02Binding bi;
    MWRA_CHILD anthro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_n02);
        bi.setCallback(this);
        setupSkip();
        setupContent();
    }

    private void setupContent() {

        EditTextPicker[] txt210_2013 = new EditTextPicker[]{bi.can10, bi.can11};
        EditTextPicker[] txt214_2017 = new EditTextPicker[]{bi.can14, bi.can15};

        for (EditTextPicker txt : txt210_2013) {
            txt.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (bi.can10.getText().toString().isEmpty() || bi.can11.getText().toString().isEmpty())
                        return;
                    if (!bi.can10.isTextEqualToPattern() || !bi.can11.isTextEqualToPattern())
                        return;
                    if (bi.can10.getText().toString().split(".").length > 1 || bi.can11.getText().toString().split(".").length > 1)
                        return;
                    double value = Math.abs(Double.parseDouble(bi.can10.getText().toString()) - Double.parseDouble(bi.can11.getText().toString()));
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }

        for (EditTextPicker txt : txt214_2017) {

            txt.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (bi.can14.getText().toString().isEmpty() || bi.can15.getText().toString().isEmpty())
                        return;
                    if (!bi.can14.isTextEqualToPattern() || !bi.can15.isTextEqualToPattern())
                        return;
                    if (bi.can14.getText().toString().split(".").length > 1 || bi.can15.getText().toString().split(".").length > 1)
                        return;
                    double value = Math.abs(Double.parseDouble(bi.can14.getText().toString()) - Double.parseDouble(bi.can15.getText().toString()));
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }

    }

    private void setupSkip() {

    }

    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft(true);
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionN01Activity.class));
            } else {
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
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
        anthro.setType(CHILD_ANTHRO_TYPE);
        anthro.setSysdate(MainApp.form.getSysdate());

        JSONObject json = new JSONObject();

        json.put("elb8a", MainApp.form.getElb8a());
        json.put("name", bi.can6.getText().toString());
        json.put("can6", bi.can6.getText().toString());

        json.put("can7", bi.can701.isChecked() ? "1"
                : bi.can702.isChecked() ? "2"
                : bi.can703.isChecked() ? "3"
                : "-1");

        json.put("can8", bi.can801.isChecked() ? "1"
                : bi.can802.isChecked() ? "2"
                : bi.can803.isChecked() ? "3"
                : "-1");

        json.put("can10", bi.can10.getText().toString());

        json.put("can11", bi.can11.getText().toString());

        json.put("can14", bi.can14.getText().toString());

        json.put("can15", bi.can15.getText().toString());

        json.put("status", flag);

        anthro.setsB(json.toString());
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void BtnEnd() {
        if (!Validator.emptyTextBox(this, bi.can6)) return;
        AppUtilsKt.openWarningActivity(this, "Are you sure, you want to end " + bi.can6.getText().toString() + " anthro form?");
    }

    @Override
    public void endSecActivity(boolean flag) {
        try {
            SaveDraft(false);
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionN01Activity.class));
            } else {
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}