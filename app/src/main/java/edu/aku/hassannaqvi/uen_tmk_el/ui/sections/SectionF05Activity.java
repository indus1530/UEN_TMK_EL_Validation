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

import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionF05Binding;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.MainActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

public class SectionF05Activity extends AppCompatActivity {

    ActivitySectionF05Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f05);
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

        MainApp.form.setsF(json.toString());

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