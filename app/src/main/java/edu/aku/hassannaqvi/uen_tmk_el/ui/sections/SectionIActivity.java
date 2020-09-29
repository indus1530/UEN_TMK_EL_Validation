package edu.aku.hassannaqvi.uen_tmk_el.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionIBinding;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;

public class SectionIActivity extends AppCompatActivity {

    ActivitySectionIBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_i);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i);
        bi.setCallback(this);

        setupSkip();
    }

    private void setupSkip() {

        bi.imi1.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.imi101.getId()) {
                Clear.clearAllFields(bi.fldGrpCVimi2);
            }
        });

        /*bi.chg6.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.chg601.getId()) {
                Clear.clearAllFields(bi.fldGrpCVchg7);
            }
        });*/

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

        json.put("imi1", bi.imi101.isChecked() ? "1"
                : bi.imi102.isChecked() ? "2"
                : bi.imi198.isChecked() ? "98"
                : "-1");

        json.put("imi201", bi.imi201.isChecked() ? "1" : "-1");
        json.put("imi202", bi.imi202.isChecked() ? "2" : "-1");
        json.put("imi203", bi.imi203.isChecked() ? "3" : "-1");
        json.put("imi204", bi.imi204.isChecked() ? "4" : "-1");
        json.put("imi205", bi.imi205.isChecked() ? "5" : "-1");
        json.put("imi296", bi.imi296.isChecked() ? "96" : "-1");
        json.put("imi296x", bi.imi296x.getText().toString());

        json.put("imi3", bi.imi301.isChecked() ? "1"
                : bi.imi302.isChecked() ? "2"
                : bi.imi303.isChecked() ? "3"
                : bi.imi304.isChecked() ? "4"
                : "-1");

        json.put("imi4a", bi.imi4a01.isChecked() ? "1"
                : bi.imi4a02.isChecked() ? "2"
                : "-1");

        json.put("imi4asrc", bi.imi4asrc01.isChecked() ? "1"
                : bi.imi4asrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4aplc", bi.imi4aplc01.isChecked() ? "1"
                : bi.imi4aplc02.isChecked() ? "2"
                : bi.imi4aplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4b", bi.imi4b01.isChecked() ? "1"
                : bi.imi4b02.isChecked() ? "2"
                : "-1");

        json.put("imi4bsrc", bi.imi4bsrc01.isChecked() ? "1"
                : bi.imi4bsrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4bplc", bi.imi4bplc01.isChecked() ? "1"
                : bi.imi4bplc02.isChecked() ? "2"
                : bi.imi4bplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4c", bi.imi4c01.isChecked() ? "1"
                : bi.imi4c02.isChecked() ? "2"
                : "-1");

        json.put("imi4csrc", bi.imi4csrc01.isChecked() ? "1"
                : bi.imi4csrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4cplc", bi.imi4cplc01.isChecked() ? "1"
                : bi.imi4cplc02.isChecked() ? "2"
                : bi.imi4cplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4d", bi.imi4d01.isChecked() ? "1"
                : bi.imi4d02.isChecked() ? "2"
                : "-1");

        json.put("imi4dsrc", bi.imi4dsrc01.isChecked() ? "1"
                : bi.imi4dsrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4dplc", bi.imi4dplc01.isChecked() ? "1"
                : bi.imi4dplc02.isChecked() ? "2"
                : bi.imi4dplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4e", bi.imi4e01.isChecked() ? "1"
                : bi.imi4e02.isChecked() ? "2"
                : "-1");

        json.put("imi4esrc", bi.imi4esrc01.isChecked() ? "1"
                : bi.imi4esrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4eplc", bi.imi4eplc01.isChecked() ? "1"
                : bi.imi4eplc02.isChecked() ? "2"
                : bi.imi4eplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4f", bi.imi4f01.isChecked() ? "1"
                : bi.imi4f02.isChecked() ? "2"
                : "-1");

        json.put("imi4fsrc", bi.imi4fsrc01.isChecked() ? "1"
                : bi.imi4fsrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4fplc", bi.imi4fplc01.isChecked() ? "1"
                : bi.imi4fplc02.isChecked() ? "2"
                : bi.imi4fplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4g", bi.imi4g01.isChecked() ? "1"
                : bi.imi4g02.isChecked() ? "2"
                : "-1");

        json.put("imi4gsrc", bi.imi4gsrc01.isChecked() ? "1"
                : bi.imi4gsrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4gplc", bi.imi4gplc01.isChecked() ? "1"
                : bi.imi4gplc02.isChecked() ? "2"
                : bi.imi4gplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4h", bi.imi4h01.isChecked() ? "1"
                : bi.imi4h02.isChecked() ? "2"
                : "-1");

        json.put("imi4hsrc", bi.imi4hsrc01.isChecked() ? "1"
                : bi.imi4hsrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4hplc", bi.imi4hplc01.isChecked() ? "1"
                : bi.imi4hplc02.isChecked() ? "2"
                : bi.imi4hplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4i", bi.imi4i01.isChecked() ? "1"
                : bi.imi4i02.isChecked() ? "2"
                : "-1");

        json.put("imi4isrc", bi.imi4isrc01.isChecked() ? "1"
                : bi.imi4isrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4iplc", bi.imi4iplc01.isChecked() ? "1"
                : bi.imi4iplc02.isChecked() ? "2"
                : bi.imi4iplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4j", bi.imi4j01.isChecked() ? "1"
                : bi.imi4j02.isChecked() ? "2"
                : "-1");

        json.put("imi4jsrc", bi.imi4jsrc01.isChecked() ? "1"
                : bi.imi4jsrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4jplc", bi.imi4jplc01.isChecked() ? "1"
                : bi.imi4jplc02.isChecked() ? "2"
                : bi.imi4jplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4k", bi.imi4k01.isChecked() ? "1"
                : bi.imi4k02.isChecked() ? "2"
                : "-1");

        json.put("imi4ksrc", bi.imi4ksrc01.isChecked() ? "1"
                : bi.imi4ksrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4kplc", bi.imi4kplc01.isChecked() ? "1"
                : bi.imi4kplc02.isChecked() ? "2"
                : bi.imi4kplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4l", bi.imi4l01.isChecked() ? "1"
                : bi.imi4l02.isChecked() ? "2"
                : "-1");

        json.put("imi4lsrc", bi.imi4lsrc01.isChecked() ? "1"
                : bi.imi4lsrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4lplc", bi.imi4lplc01.isChecked() ? "1"
                : bi.imi4lplc02.isChecked() ? "2"
                : bi.imi4lplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4m", bi.imi4m01.isChecked() ? "1"
                : bi.imi4m02.isChecked() ? "2"
                : "-1");

        json.put("imi4msrc", bi.imi4msrc01.isChecked() ? "1"
                : bi.imi4msrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4mplc", bi.imi4mplc01.isChecked() ? "1"
                : bi.imi4mplc02.isChecked() ? "2"
                : bi.imi4mplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4n", bi.imi4n01.isChecked() ? "1"
                : bi.imi4n02.isChecked() ? "2"
                : "-1");

        json.put("imi4nsrc", bi.imi4nsrc01.isChecked() ? "1"
                : bi.imi4nsrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4nplc", bi.imi4nplc01.isChecked() ? "1"
                : bi.imi4nplc02.isChecked() ? "2"
                : bi.imi4nplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4o", bi.imi4o01.isChecked() ? "1"
                : bi.imi4o02.isChecked() ? "2"
                : "-1");

        json.put("imi4osrc", bi.imi4osrc01.isChecked() ? "1"
                : bi.imi4osrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4oplc", bi.imi4oplc01.isChecked() ? "1"
                : bi.imi4oplc02.isChecked() ? "2"
                : bi.imi4oplc03.isChecked() ? "3"
                : "-1");

        json.put("imi4o1", bi.imi4o101.isChecked() ? "1"
                : bi.imi4o102.isChecked() ? "2"
                : "-1");

        json.put("imi4o1src", bi.imi4o1src01.isChecked() ? "1"
                : bi.imi4o1src02.isChecked() ? "2"
                : "-1");

        json.put("imi4o1plc", bi.imi4o1plc01.isChecked() ? "1"
                : bi.imi4o1plc02.isChecked() ? "2"
                : bi.imi4o1plc03.isChecked() ? "3"
                : "-1");

        json.put("imi4p", bi.imi4p01.isChecked() ? "1"
                : bi.imi4p02.isChecked() ? "2"
                : "-1");

        json.put("imi4psrc", bi.imi4psrc01.isChecked() ? "1"
                : bi.imi4psrc02.isChecked() ? "2"
                : "-1");

        json.put("imi4pplc", bi.imi4pplc01.isChecked() ? "1"
                : bi.imi4pplc02.isChecked() ? "2"
                : bi.imi4pplc03.isChecked() ? "3"
                : "-1");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

}