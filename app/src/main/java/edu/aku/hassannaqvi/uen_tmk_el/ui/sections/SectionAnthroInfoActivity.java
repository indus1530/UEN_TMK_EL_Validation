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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.uen_tmk_el.R;
import edu.aku.hassannaqvi.uen_tmk_el.contracts.Mwra_ChildrenContract;
import edu.aku.hassannaqvi.uen_tmk_el.contracts.VillageContract;
import edu.aku.hassannaqvi.uen_tmk_el.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk_el.core.MainApp;
import edu.aku.hassannaqvi.uen_tmk_el.databinding.ActivitySectionAnthroInfoBinding;
import edu.aku.hassannaqvi.uen_tmk_el.models.BLRandom;
import edu.aku.hassannaqvi.uen_tmk_el.models.MWRA_CHILD;
import edu.aku.hassannaqvi.uen_tmk_el.utils.AppUtilsKt;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static edu.aku.hassannaqvi.uen_tmk_el.CONSTANTS.VILLAGES_DATA;
import static edu.aku.hassannaqvi.uen_tmk_el.core.MainApp.appInfo;


public class SectionAnthroInfoActivity extends AppCompatActivity {

    ActivitySectionAnthroInfoBinding bi;
    BLRandom bl;
    MWRA_CHILD anthro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_anthro_info);
        bi.setCallback(this);
        setupSkip();
        VillageContract village = (VillageContract) getIntent().getSerializableExtra(VILLAGES_DATA);
        bi.elb1.setText(village.getCluster_code());
        bi.elb6.setText(getTalukaName(Integer.parseInt(MainApp.SELECTED_UC.getTaluka_code())));
        bi.elb7.setText(MainApp.SELECTED_UC.getUc_name());
        bi.elb8.setText(village.getVillage_name());
        bi.elb8a.setText(village.getVillage_code());
    }

    private String getTalukaName(int index) {
        switch (index) {
            case 1:
                return "Tando Mohammad Khan";
            case 2:
                return "Tando Ghulam Hyder";
            case 3:
                return "Bulri Shah Karim";
            default:
                return "Not Found";
        }
    }


    private void setupSkip() {

    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionCActivity.class));
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


    private void SaveDraft() throws JSONException {

        anthro = new MWRA_CHILD();
        anthro.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(new Date().getTime()));
        anthro.setUsername(MainApp.userName);
        anthro.setDeviceID(MainApp.appInfo.getDeviceID());
        anthro.setDevicetagID(MainApp.appInfo.getTagName());
        anthro.setAppversion(MainApp.appInfo.getAppVersion());
        anthro.setElb1(bi.elb1.getText().toString());
        anthro.setElb11(bi.elb11.getText().toString());

        MainApp.setGPS(this);
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

    public void CheckHH(View v) {
        resetVariables(View.VISIBLE);
    }

    private void resetVariables(int visibility) {
        bi.fldGrpElb11.setVisibility(visibility);
        Clear.clearAllFields(bi.fldGrpElb11);
    }

    public void elb11OnTextChanged(CharSequence s, int start, int before, int count) {
        resetVariables(View.GONE);
    }


    //Reactive Streams
    private Observable<BLRandom> getBLRandom() {
        return Observable.create(emitter -> {
            emitter.onNext(appInfo.getDbHelper().getHHFromBLRandom(bi.elb8a.getText().toString(), bi.elb11.getText().toString()));
            emitter.onComplete();
        });
    }

    //Getting data from db
    public void gettingAreaData() {
        getBLRandom()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BLRandom>() {
                    Disposable disposable;

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(@NonNull BLRandom blRandom) {
                        bl = blRandom;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        disposable.dispose();
                    }

                    @Override
                    public void onComplete() {
                        disposable.dispose();
                    }
                });
    }


}