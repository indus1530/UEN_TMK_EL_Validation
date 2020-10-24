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

import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionN01Binding;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.MainActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

public class SectionN01Activity extends AppCompatActivity {

    ActivitySectionN01Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_n01);
        bi.setCallback(this);
        setupSkip();
    }

    private void setupSkip() {

        bi.can1.setOnCheckedChangeListener((group, id) -> {
            Clear.clearAllFields(bi.fldGrpCVcan2);
            Clear.clearAllFields(bi.fldGrpCVcan3);
            Clear.clearAllFields(bi.fldGrpCVcan4);
            Clear.clearAllFields(bi.fldGrpCVcan5);
            bi.fldGrpCVcan2.setVisibility(View.VISIBLE);
            bi.fldGrpCVcan3.setVisibility(View.VISIBLE);
            bi.fldGrpCVcan4.setVisibility(View.VISIBLE);
            bi.fldGrpCVcan5.setVisibility(View.VISIBLE);
            if (id == bi.can1.getId()) {
                bi.fldGrpCVcan2.setVisibility(View.GONE);
                bi.fldGrpCVcan3.setVisibility(View.GONE);
                bi.fldGrpCVcan4.setVisibility(View.GONE);
                bi.fldGrpCVcan5.setVisibility(View.GONE);
            }
        });


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
            startActivity(new Intent(this, MainActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addForm(form);
        form.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            form.set_UID(form.getDeviceID() + form.get_ID());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, form.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();
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

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

}