package edu.aku.hassannaqvi.uen_tmk_el.ui.sections;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.uen_tmk_el.CONSTANTS;
import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_tmk_el.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el.core.MainApp;

import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionEBinding;
import edu.aku.hassannaqvi.uen_tmk_el.models.Form;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.uen_tmk_el.core.MainApp.form;
public class SectionE01Activity extends AppCompatActivity {

    ActivitySectionEBinding bi;
    private List<String> usersFullName, ucNames, ucCodes, villageNames, villageCodes;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e);
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

        json.put("ele9a", bi.ele9a01.isChecked() ? "1"
                : bi.ele9a02.isChecked() ? "2"
                :  "-1");

        json.put("ele9b", bi.ele9b01.isChecked() ? "1"
                : bi.ele9b02.isChecked() ? "2"
                :  "-1");

        json.put("ele9c", bi.ele9c01.isChecked() ? "1"
                : bi.ele9c02.isChecked() ? "2"
                :  "-1");

        json.put("ele9d", bi.ele9d01.isChecked() ? "1"
                : bi.ele9d02.isChecked() ? "2"
                :  "-1");

        json.put("ele9e", bi.ele9e01.isChecked() ? "1"
                : bi.ele9e02.isChecked() ? "2"
                :  "-1");

        json.put("ele9f", bi.ele9f01.isChecked() ? "1"
                : bi.ele9f02.isChecked() ? "2"
                :  "-1");

        json.put("ele9g", bi.ele9g01.isChecked() ? "1"
                : bi.ele9g02.isChecked() ? "2"
                :  "-1");

        json.put("ele9h", bi.ele9h01.isChecked() ? "1"
                : bi.ele9h02.isChecked() ? "2"
                :  "-1");

        json.put("ele9i", bi.ele9i01.isChecked() ? "1"
                : bi.ele9i02.isChecked() ? "2"
                :  "-1");

        json.put("ele10", bi.ele1001.isChecked() ? "1"
                : bi.ele1002.isChecked() ? "2"
                :  "-1");

        json.put("ele11", bi.ele1101.isChecked() ? "1"
                : bi.ele1102.isChecked() ? "2"
                : bi.ele1103.isChecked() ? "98"
                :  "-1");

        json.put("ele12", bi.ele1201.isChecked() ? "1"
                : bi.ele1202.isChecked() ? "2"
                : bi.ele1203.isChecked() ? "3"
                :  "-1");

        json.put("ele1201x", bi.ele1201x.getText().toString());
        json.put("ele1202x", bi.ele1202x.getText().toString());
        json.put("ele13", bi.ele1301.isChecked() ? "1"
                : bi.ele1302.isChecked() ? "2"
                :  "-1");

        json.put("ele1401", bi.ele1401.getText().toString());

        json.put("ele1402", bi.ele1402.getText().toString());

        json.put("ele1403", bi.ele1403.getText().toString());

        json.put("ele1404", bi.ele1404.getText().toString());

        json.put("ele1405", bi.ele1405.getText().toString());

        json.put("ele1406", bi.ele1406.getText().toString());

        json.put("ele15", bi.ele1501.isChecked() ? "1"
                : bi.ele1502.isChecked() ? "2"
                : bi.ele15098.isChecked() ? "98"
                :  "-1");

        json.put("ele16", bi.ele1601.isChecked() ? "1"
                : bi.ele1602.isChecked() ? "2"
                : bi.ele1603.isChecked() ? "3"
                : bi.ele1604.isChecked() ? "4"
                : bi.ele1605.isChecked() ? "5"
                : bi.ele1606.isChecked() ? "6"
                : bi.ele1607.isChecked() ? "7"
                : bi.ele1608.isChecked() ? "8"
                : bi.ele1609.isChecked() ? "9"
                : bi.ele1610.isChecked() ? "10"
                : bi.ele1611.isChecked() ? "11"
                : bi.ele1696.isChecked() ? "96"
                :  "-1");

        json.put("ele1696x", bi.ele1696x.getText().toString());
        json.put("ele17", bi.ele1701.isChecked() ? "1"
                : bi.ele1702.isChecked() ? "2"
                : bi.ele1798.isChecked() ? "98"
                :  "-1");

        json.put("ele1701x", bi.ele1701x.getText().toString());
        json.put("ele18", bi.ele1801.isChecked() ? "1"
                : bi.ele1802.isChecked() ? "2"
                : bi.ele1803.isChecked() ? "3"
                : bi.ele1804.isChecked() ? "4"
                : bi.ele1896.isChecked() ? "96"
                :  "-1");

        json.put("ele1896x", bi.ele1896x.getText().toString());
        json.put("ele1901",bi.ele1901.isChecked() ? "1" :"-1");

        json.put("ele1902",bi.ele1902.isChecked() ? "2" :"-1");

        json.put("ele1903",bi.ele1903.isChecked() ? "3" :"-1");

        json.put("ele1904",bi.ele1904.isChecked() ? "4" :"-1");

        json.put("ele1905",bi.ele1905.isChecked() ? "5" :"-1");

        json.put("ele1996",bi.ele1996.isChecked() ? "96" :"-1");

        json.put("ele1996x", bi.ele1996x.getText().toString());
        json.put("ele2001",bi.ele2001.isChecked() ? "1" :"-1");

        json.put("ele2002",bi.ele2002.isChecked() ? "2" :"-1");

        json.put("ele2003",bi.ele2003.isChecked() ? "3" :"-1");

        json.put("ele2096",bi.ele2096.isChecked() ? "96" :"-1");





    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

}