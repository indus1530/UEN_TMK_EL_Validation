package edu.aku.hassannaqvi.uen_tmk_el.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_tmk_el.contracts.Mwra_ChildrenContract;
import edu.aku.hassannaqvi.uen_tmk_el.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionN02Binding;
import edu.aku.hassannaqvi.uen_tmk_el.models.MWRA_CHILD;
import edu.aku.hassannaqvi.uen_tmk_el.ui.other.MainActivity;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;
import edu.aku.hassannaqvi.uen_tmk_el.utils.EndSectionActivity;

import static edu.aku.hassannaqvi.uen_tmk_el.CONSTANTS.ADD_ANTHRO;
import static edu.aku.hassannaqvi.uen_tmk_el.ui.sections.SectionAnthroInfoActivity.childListU5;

public class SectionN02Activity extends AppCompatActivity implements EndSectionActivity {

    ActivitySectionN02Binding bi;
    MWRA_CHILD anthro;
    FamilyMembersContract selectedChild;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_n02);
        bi.setCallback(this);
        setupSkip();
        setupContent();
    }

    private void setupContent() {

        bi.btnContinue.setText(childListU5.size() > 1 ? "Next Child" : "Next Section");
        anthro = (MWRA_CHILD) getIntent().getSerializableExtra(ADD_ANTHRO);

        List<String> items = new ArrayList<String>() {
            {
                add("....");
            }
        };

        for (FamilyMembersContract item : childListU5)
            items.add(item.getName());

        bi.can6.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items));
        bi.can6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) return;
                position = i - 1;
                selectedChild = childListU5.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void setupSkip() {

        bi.can9.setOnCheckedChangeListener((group, checkedId) -> {
            Clear.clearAllFields(bi.llcan10t21);
            bi.llcan10t21.setVisibility(View.GONE);
            if (checkedId == bi.can901.getId()) {
                bi.llcan10t21.setVisibility(View.VISIBLE);
            }
        });


        bi.can12.setOnCheckedChangeListener((group, checkedId) -> {
            Clear.clearAllFields(bi.fldGrpCVcan13);
            bi.fldGrpCVcan13.setVisibility(View.VISIBLE);
            if (checkedId == bi.can1202.getId()) {
                bi.fldGrpCVcan13.setVisibility(View.GONE);
            }
        });


        bi.can16.setOnCheckedChangeListener((group, checkedId) -> {
            Clear.clearAllFields(bi.fldGrpCVcan17);
            bi.fldGrpCVcan17.setVisibility(View.VISIBLE);
            if (checkedId == bi.can1602.getId()) {
                bi.fldGrpCVcan17.setVisibility(View.GONE);
            }
        });


        bi.can20.setOnCheckedChangeListener((group, checkedId) -> {
            Clear.clearAllFields(bi.fldGrpCVcan21);
            bi.fldGrpCVcan21.setVisibility(View.VISIBLE);
            if (checkedId == bi.can2002.getId()) {
                bi.fldGrpCVcan21.setVisibility(View.GONE);
            }
        });

    }

    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft(true);
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, childListU5.size() > 0 ? SectionN02Activity.class : MainActivity.class).putExtra(ADD_ANTHRO, anthro));
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
            db.updatesFamilyMemberColumn(FamilyMembersContract.MemberTable.COLUMN_KISH_SELECTED, "2", selectedChild);
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft(boolean flag) throws JSONException {

        anthro.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(new Date().getTime()));
        anthro.setFmuid(selectedChild.getUid());
        anthro.setUUID(selectedChild.getUuid());

        JSONObject json = new JSONObject();

        json.put("serial", selectedChild.getSerialno());
        json.put("name", bi.can6.getSelectedItem().toString());
        json.put("can6", bi.can6.getSelectedItem().toString());

        json.put("can7", bi.can701.isChecked() ? "1"
                : bi.can702.isChecked() ? "2"
                : bi.can703.isChecked() ? "3"
                : "-1");

        json.put("can8", bi.can801.isChecked() ? "1"
                : bi.can802.isChecked() ? "2"
                : bi.can803.isChecked() ? "3"
                : "-1");

        json.put("can9", bi.can901.isChecked() ? "1"
                : bi.can902.isChecked() ? "2"
                : bi.can903.isChecked() ? "3"
                : "-1");

        json.put("can10", bi.can10.getText().toString());

        json.put("can11", bi.can11.getText().toString());

        json.put("can12", bi.can1201.isChecked() ? "1"
                : bi.can1202.isChecked() ? "2"
                : "-1");

        json.put("can13", bi.can13.getText().toString());

        json.put("can14", bi.can14.getText().toString());

        json.put("can15", bi.can15.getText().toString());

        json.put("can16", bi.can1601.isChecked() ? "1"
                : bi.can1602.isChecked() ? "2"
                : "-1");

        json.put("can17", bi.can17.getText().toString());

        json.put("can18", bi.can18.getText().toString());

        json.put("can19", bi.can19.getText().toString());

        json.put("can20", bi.can2001.isChecked() ? "1"
                : bi.can2002.isChecked() ? "2"
                : "-1");

        json.put("can21", bi.can21.getText().toString());

        json.put("status", flag);

        anthro.setsB(json.toString());

        childListU5.remove(position);
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void BtnEnd() {
        AppUtilsKt.openWarningActivity(this, "Are you sure, you want to end " + selectedChild.getName().toUpperCase() + " anthro form?");
    }

    @Override
    public void endSecActivity(boolean flag) {
        if (!Validator.emptySpinner(this, bi.can6)) return;
        try {
            SaveDraft(false);
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, childListU5.size() > 0 ? SectionN02Activity.class : MainActivity.class).putExtra(ADD_ANTHRO, anthro));
            } else {
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}