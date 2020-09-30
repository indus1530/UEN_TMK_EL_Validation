package edu.aku.hassannaqvi.uen_tmk_el.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionE01Binding;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;
public class SectionE01Activity extends AppCompatActivity {

    ActivitySectionE01Binding bi;
    private List<String> usersFullName, ucNames, ucCodes, villageNames, villageCodes;
//    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e01);
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
            startActivity(new Intent(this, SectionE02Activity.class));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {

       /* DatabaseHelper db = MainApp.appInfo.getDbHelper();
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

        json.put("ele1", bi.ele101.isChecked() ? "1"
                : bi.ele102.isChecked() ? "2"
                : bi.ele103.isChecked() ? "3"
                : bi.ele104.isChecked() ? "4"
                : bi.ele105.isChecked() ? "5"
                : bi.ele106.isChecked() ? "6"
                : bi.ele107.isChecked() ? "7"
                : bi.ele108.isChecked() ? "8"
                : bi.ele109.isChecked() ? "9"
                : bi.ele110.isChecked() ? "10"
                : bi.ele111.isChecked() ? "11"
                : bi.ele112.isChecked() ? "12"
                : bi.ele196.isChecked() ? "96"
                :  "-1");

        json.put("ele196x", bi.ele196x.getText().toString());
        json.put("ele2", bi.ele201.isChecked() ? "1"
                : bi.ele202.isChecked() ? "2"
                : bi.ele203.isChecked() ? "3"
                : bi.ele204.isChecked() ? "4"
                : bi.ele205.isChecked() ? "5"
                : bi.ele206.isChecked() ? "6"
                : bi.ele207.isChecked() ? "7"
                : bi.ele208.isChecked() ? "8"
                : bi.ele209.isChecked() ? "9"
                : bi.ele210.isChecked() ? "10"
                : bi.ele211.isChecked() ? "11"
                : bi.ele212.isChecked() ? "12"
                : bi.ele213.isChecked() ? "13"
                : bi.ele214.isChecked() ? "14"
                : bi.ele215.isChecked() ? "15"
                : bi.ele216.isChecked() ? "16"
                : bi.ele296.isChecked() ? "96"
                :  "-1");

        json.put("ele296x", bi.ele296x.getText().toString());
        json.put("ele3", bi.ele301.isChecked() ? "1"
                : bi.ele302.isChecked() ? "2"
                : bi.ele303.isChecked() ? "3"
                : bi.ele304.isChecked() ? "4"
                : bi.ele305.isChecked() ? "5"
                : bi.ele306.isChecked() ? "6"
                : bi.ele307.isChecked() ? "7"
                : bi.ele308.isChecked() ? "8"
                : bi.ele309.isChecked() ? "9"
                : bi.ele310.isChecked() ? "10"
                : bi.ele311.isChecked() ? "11"
                : bi.ele312.isChecked() ? "12"
                : bi.ele313.isChecked() ? "13"
                : bi.ele314.isChecked() ? "14"
                : bi.ele315.isChecked() ? "15"
                : bi.ele316.isChecked() ? "16"
                : bi.ele317.isChecked() ? "17"
                : bi.ele318.isChecked() ? "18"
                : bi.ele319.isChecked() ? "19"
                :  "-1");

        json.put("ele401", bi.ele401.getText().toString());

        json.put("ele5", bi.ele501.isChecked() ? "1"
                : bi.ele502.isChecked() ? "2"
                : bi.ele503.isChecked() ? "3"
                : bi.ele596.isChecked() ? "96"
                :  "-1");

        json.put("ele596x", bi.ele596x.getText().toString());
        json.put("ele6", bi.ele601.isChecked() ? "1"
                : bi.ele602.isChecked() ? "2"
                : bi.ele603.isChecked() ? "3"
                : bi.ele604.isChecked() ? "4"
                : bi.ele696.isChecked() ? "96"
                :  "-1");

        json.put("ele696x", bi.ele696x.getText().toString());
        json.put("ele7", bi.ele701.isChecked() ? "1"
                : bi.ele702.isChecked() ? "2"
                : bi.ele703.isChecked() ? "3"
                : bi.ele704.isChecked() ? "4"
                : bi.ele705.isChecked() ? "5"
                : bi.ele706.isChecked() ? "6"
                : bi.ele707.isChecked() ? "7"
                : bi.ele708.isChecked() ? "8"
                : bi.ele709.isChecked() ? "9"
                : bi.ele710.isChecked() ? "10"
                : bi.ele711.isChecked() ? "11"
                : bi.ele712.isChecked() ? "12"
                : bi.ele796.isChecked() ? "96"
                :  "-1");

        json.put("ele796x", bi.ele796x.getText().toString());
        json.put("ele8a", bi.ele8a01.isChecked() ? "1"
                : bi.ele8a02.isChecked() ? "2"
                :  "-1");

        json.put("ele8b", bi.ele8b01.isChecked() ? "1"
                : bi.ele8b02.isChecked() ? "2"
                :  "-1");

        json.put("ele8c", bi.ele8c01.isChecked() ? "1"
                : bi.ele8c02.isChecked() ? "2"
                :  "-1");

        json.put("ele8d", bi.ele8d01.isChecked() ? "1"
                : bi.ele8d02.isChecked() ? "2"
                :  "-1");

        json.put("ele8e", bi.ele8e01.isChecked() ? "1"
                : bi.ele8e02.isChecked() ? "2"
                :  "-1");

        json.put("ele8f", bi.ele8f01.isChecked() ? "1"
                : bi.ele8f02.isChecked() ? "2"
                :  "-1");

        json.put("ele8g", bi.ele8g01.isChecked() ? "1"
                : bi.ele8g02.isChecked() ? "2"
                :  "-1");

        json.put("ele8h", bi.ele8h01.isChecked() ? "1"
                : bi.ele8h02.isChecked() ? "2"
                :  "-1");

        json.put("ele8i", bi.ele8i01.isChecked() ? "1"
                : bi.ele8i02.isChecked() ? "2"
                :  "-1");

        json.put("ele8j", bi.ele8j01.isChecked() ? "1"
                : bi.ele8j02.isChecked() ? "2"
                :  "-1");

        json.put("ele8k", bi.ele8k01.isChecked() ? "1"
                : bi.ele8k02.isChecked() ? "2"
                :  "-1");

        json.put("ele8l", bi.ele8l01.isChecked() ? "1"
                : bi.ele8l02.isChecked() ? "2"
                :  "-1");

        json.put("ele8m", bi.ele8m01.isChecked() ? "1"
                : bi.ele8m02.isChecked() ? "2"
                :  "-1");

        json.put("ele8n", bi.ele8n01.isChecked() ? "1"
                : bi.ele8n02.isChecked() ? "2"
                :  "-1");

        json.put("ele8o", bi.ele8o01.isChecked() ? "1"
                : bi.ele8o02.isChecked() ? "2"
                :  "-1");

        json.put("ele8p", bi.ele8p01.isChecked() ? "1"
                : bi.ele8p02.isChecked() ? "2"
                :  "-1");

        json.put("ele8q", bi.ele8q01.isChecked() ? "1"
                : bi.ele8q02.isChecked() ? "2"
                :  "-1");

        json.put("ele8r", bi.ele8r01.isChecked() ? "1"
                : bi.ele8r02.isChecked() ? "2"
                :  "-1");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

}