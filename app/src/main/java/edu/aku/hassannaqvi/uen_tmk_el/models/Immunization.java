package edu.aku.hassannaqvi.uen_tmk_el.models;

import android.database.Cursor;

import androidx.lifecycle.LiveData;

import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_tmk_el.contracts.MWRAContract;

public class Immunization extends LiveData<Immunization> {

    private final String projectName = "UenTmkEl2020";
    private String _ID = "";
    private String _UID = "";
    private String UUID = "";
    private String elb1 = "";
    private String elb11 = "";
    private String fmuid = "";
    private String muid = "";
    private String username = "";
    private String sysdate = "";
    private String type = "";
    private String sC = "-2";
    private String sB = "-2";
    private String endingdatetime = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";

    //For section selection
    private SectionSelection secSelection;


    public Immunization() {
    }


    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }


    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }


    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }


    public String getElb1() {
        return elb1;
    }

    public void setElb1(String elb1) {
        this.elb1 = elb1;
    }


    public String getElb11() {
        return elb11;
    }

    public void setElb11(String elb11) {
        this.elb11 = elb11;
    }


    public String getFmuid() {
        return fmuid;
    }

    public void setFmuid(String fmuid) {
        this.fmuid = fmuid;
    }


    public String getMuid() {
        return muid;
    }

    public void setMuid(String muid) {
        this.muid = muid;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getSysdate() {
        return sysdate;
    }

    public void setSysdate(String sysdate) {
        this.sysdate = sysdate;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getsC() {
        return sC;
    }

    public void setsC(String sC) {
        this.sC = sC;
    }


    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }


    public String getEndingdatetime() {
        return endingdatetime;
    }

    public void setEndingdatetime(String endingdatetime) {
        this.endingdatetime = endingdatetime;
    }


    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }


    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }


    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }


    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;

    }


    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }


    public Immunization Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(MWRAContract.MWRATable.COLUMN_ID);
        this._UID = jsonObject.getString(MWRAContract.MWRATable.COLUMN_UID);
        this.UUID = jsonObject.getString(MWRAContract.MWRATable.COLUMN_UUID);
        this.elb1 = jsonObject.getString(MWRAContract.MWRATable.COLUMN_ELB1);
        this.elb11 = jsonObject.getString(MWRAContract.MWRATable.COLUMN_ELB11);
        this.fmuid = jsonObject.getString(MWRAContract.MWRATable.COLUMN_FMUID);
        this.muid = jsonObject.getString(MWRAContract.MWRATable.COLUMN_MUID);
        this.username = jsonObject.getString(MWRAContract.MWRATable.COLUMN_USERNAME);
        this.sysdate = jsonObject.getString(MWRAContract.MWRATable.COLUMN_SYSDATE);
        this.type = jsonObject.getString(MWRAContract.MWRATable.COLUMN_TYPE);
        this.sC = jsonObject.getString(MWRAContract.MWRATable.COLUMN_SC);
        this.sB = jsonObject.getString(MWRAContract.MWRATable.COLUMN_SB);
        this.deviceID = jsonObject.getString(MWRAContract.MWRATable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(MWRAContract.MWRATable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(MWRAContract.MWRATable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(MWRAContract.MWRATable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(MWRAContract.MWRATable.COLUMN_APPVERSION);

        return this;
    }


    public Immunization Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_UID));
        this.UUID = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_UUID));
        this.elb1 = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_ELB1));
        this.elb11 = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_ELB11));
        this.fmuid = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_FMUID));
        this.muid = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_MUID));
        this.username = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_USERNAME));
        this.sysdate = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_SYSDATE));
        this.deviceID = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_DEVICETAGID));
        this.appversion = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_APPVERSION));
        this.type = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_TYPE));
        this.sC = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_SC));
        this.sB = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_SB));

        return this;
    }


    //TODO: Try this instead of toJSONObject
    @NotNull
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, Immunization.class);
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(MWRAContract.MWRATable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
            json.put(MWRAContract.MWRATable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
            json.put(MWRAContract.MWRATable.COLUMN_UUID, this.UUID == null ? JSONObject.NULL : this.UUID);
            json.put(MWRAContract.MWRATable.COLUMN_ELB1, this.elb1 == null ? JSONObject.NULL : this.elb1);
            json.put(MWRAContract.MWRATable.COLUMN_ELB11, this.elb11 == null ? JSONObject.NULL : this.elb11);
            json.put(MWRAContract.MWRATable.COLUMN_FMUID, this.fmuid == null ? JSONObject.NULL : this.fmuid);
            json.put(MWRAContract.MWRATable.COLUMN_MUID, this.muid == null ? JSONObject.NULL : this.muid);
            json.put(MWRAContract.MWRATable.COLUMN_USERNAME, this.username == null ? JSONObject.NULL : this.username);
            json.put(MWRAContract.MWRATable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
            json.put(MWRAContract.MWRATable.COLUMN_TYPE, this.type == null ? JSONObject.NULL : this.type);

            if (this.sC != null && !this.sC.equals("")) {
                json.put(MWRAContract.MWRATable.COLUMN_SC, new JSONObject(this.sC));
            }
            if (this.sB != null && !this.sB.equals("")) {
                json.put(MWRAContract.MWRATable.COLUMN_SB, new JSONObject(this.sB));
            }

            json.put(MWRAContract.MWRATable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
            json.put(MWRAContract.MWRATable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
            json.put(MWRAContract.MWRATable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

}
