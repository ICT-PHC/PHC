package com.roles.census.Managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.roles.census.DataElements.Action;
import com.roles.census.DataElements.ActionType;
import com.roles.census.DataElements.CouncilType;
import com.roles.census.DataElements.Distance;
import com.roles.census.DataElements.District;
import com.roles.census.DataElements.Division;
import com.roles.census.DataElements.OrgType;
import com.roles.census.DataElements.PWSDistrict;
import com.roles.census.DataElements.PWSOrgType;
import com.roles.census.DataElements.RegStatus;
import com.roles.census.DataElements.Role;
import com.roles.census.DataElements.SectorType;
import com.roles.census.DataElements.Tehsil;
import com.roles.census.DataElements.UpdateStatL1;
import com.roles.census.DataElements.UpdateStatL2;
import com.roles.census.DataElements.subActionType;

import java.util.ArrayList;

/**
 * Created by PHC_ICT on 1/27/2018.
 */

public class DatabaseManager {


    private static final int DATABASE_VERSION = 7;
    private static final String DATABASE_NAME = "CIMAllDropDown.db";
    public static final String DISTRICT = "District";
    private static final String TAG_DISTRICT_ID = "Dis_District_id";
    private static final String TAG_DISTRICT_DIV = "Dis_Division";
    private static final String TAG_DISTRICT = "Dis_District";
    public static final String TEHSIL = "Tehsil";
    private static final String TAG_TEHSIL_ID = "Teh_Tehsil_id";
    private static final String TAG_TDISTRICT = "Teh_District";
    private static final String TAG_TEHSIL = "Teh_Tehsil";
    public static final String SECTORTYPE = "SectorType";
    private static final String TAG_SECTORTYPE_ID = "Sec_SectorType_id";
    private static final String TAG_SECTORTYPE = "Sec_SectorType";
    public static final String COUNCILTYPE = "CouncilType";
    private static final String TAG_COUNCILTYPE_ID = "Coun_CouncilType_id";
    private static final String TAG_COUNCILTYPE = "Coun_CouncilType";
    public static final String ORGTYPE = "OrgType";
    private static final String TAG_ORGTYPE_ID = "Org_OrgType_id";
    private static final String TAG_ORGTYPE = "Org_OrgType";
    public static final String UPDATESTATL1 = "Updatestatus";
    private static final String TAG_UpdatedStatus_ID = "Update_Status_id";
    private static final String TAG_UpdatedStatus = "Update_Status";
    public static final String UPDATESTATL2 = "Substatus";
    private static final String TAG_SubStatus_ID = "Sub_Status_id";
    private static final String TAG_SubStatus = "Sub_Status";
    public static final String DISTANCE = "distance";
    private static final String TAG_Distance_ID = "Distance_id";
    private static final String TAG_Distance = "Distance";
    public static final String REGSTATUS = "Regstatus";
    private static final String TAG_RegStatus_ID = "Reg_Status_id";
    private static final String TAG_RegStatus ="Reg_Status";
    public static final String ACTIONS = "Actions";
    private static final String TAG_Action_ID = "Action_id";
    private static final String TAG_Action= "Actioncol";

    public static final String ACTIONSTYPE = "Actionstype";
    private static final String TAG_ActionType_ID = "Actiontype_id";
    private static final String TAG_ActionType= "Actiontype";
    private static final String TAG_FIR= "Fir_id";
    private static final String TAG_Cat_Def = "Cat_def";
    private static final String TAG_CatRole_ID= "Cat_Roleid";
    private static final String TAG_CatStatus_ID = "Cat_Statusid";

    public static final String SUBACTIONSTYPE = "Subactions";
    private static final String TAG_SubActionType_ID = "Subactiontype_id";
    private static final String TAG_Sub_ActionType= "Subactiontype";
    private static final String TAG_Sub_catActionID= "Subcatactiontype";
    private static final String TAG_Sub_Roleid= "Sub_Roleid";
    private static final String TAG_Sub_statusid= "Sub_Statusid";

    public static final String DIVISION = "Division";
    private static final String  TAG_Division_ID= "division_id";
    private static final String TAG_Division = "divisions";

    public static final String ROLE = "Role";
    private static final String  TAG_Role_ID= "role_id";
    private static final String TAG_Role = "role_name";

    public static final String PWSDISTRICT = "PWSdistrict";
    private static final String  TAG_PWSdistrict_ID= "PWSdistrict_id";
    private static final String TAG_PWSdistrict = "PWSdistrictName";

    public static final String PWSORGTYPE = "PWSorg";
    private static final String  TAG_PWSorg_ID= "PWSorg_id";
    private static final String TAG_PWSorg = "PWSorgType";

    DatabaseHelper openHelper;
    Context context;
    private SQLiteDatabase database;

    public DatabaseManager(Context context){

        this.context = context;
        openHelper = new DatabaseHelper(context);
        database = openHelper.getWritableDatabase();

    }

    public void saveDistrict(District district) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_DISTRICT_ID,district.getDistrict_id());
        contentValues.put(TAG_DISTRICT_DIV,district.getDistrict_div());
        contentValues.put(TAG_DISTRICT,district.getDistrict());
       // database.update(DISTRICT, contentValues, "Dis_District_id="+ district.getDistrict_id(), null);
        database.insert(DISTRICT, null, contentValues);

    }

    public void saveTehsil(Tehsil tehsil) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_TEHSIL_ID,tehsil.getTehsil_id());
        contentValues.put(TAG_TDISTRICT,tehsil.getTdistrict());
        contentValues.put(TAG_TEHSIL,tehsil.getTehsil());
        //database.update(TEHSIL, contentValues, "Teh_Tehsil_id="+ tehsil.getTehsil_id(), null);
        database.insert(TEHSIL, null, contentValues);

    }
    public void saveSectorType(SectorType sectorType) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_SECTORTYPE_ID,sectorType.getSectorType_id());
        contentValues.put(TAG_SECTORTYPE,sectorType.getSectorType());
        database.update(SECTORTYPE, contentValues, "Sec_SectorType_id="+ sectorType.getSectorType_id(), null);
        database.insert(SECTORTYPE, null, contentValues);

    }
    public void saveCouncilType(CouncilType councilType) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_COUNCILTYPE_ID,councilType.getSectorType_id());
        contentValues.put(TAG_COUNCILTYPE,councilType.getCouncilType());
       // database.update(COUNCILTYPE, contentValues, "Coun_CouncilType_id="+ councilType.getSectorType_id(), null);
        database.insert(COUNCILTYPE, null, contentValues);

    }
    public void saveOrgType(OrgType orgType) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_ORGTYPE_ID,orgType.getOrgType_id());
        contentValues.put(TAG_ORGTYPE,orgType.getOrgType());
        database.update(ORGTYPE, contentValues, "Org_OrgType_id="+ orgType.getOrgType_id(), null);
        database.insert(ORGTYPE, null, contentValues);

    }
    public void saveUpdateStatus(UpdateStatL1 updateStatL1) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_UpdatedStatus_ID,updateStatL1.getUpdatedStatL1_Id());
        contentValues.put(TAG_UpdatedStatus,updateStatL1.getUpdatedStatL1());
       // database.update(UPDATESTATL1, contentValues, "Update_Status_id="+ updateStatL1.getUpdatedStatL1_Id(), null);
        database.insert(UPDATESTATL1, null, contentValues);
    }

    public void saveSubStatus(UpdateStatL2 updateStatL2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_SubStatus_ID,updateStatL2.getUpdatedStatL2_Id());
        contentValues.put(TAG_SubStatus,updateStatL2.getUpdatedStatL2());
        database.update(UPDATESTATL2, contentValues, "Sub_Status_id="+ updateStatL2.getUpdatedStatL2_Id(), null);
        database.insert(UPDATESTATL2, null, contentValues);

    }
    public void saveDistance(Distance distance) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_Distance_ID,distance.getDistance_id());
        contentValues.put(TAG_Distance,distance.getDistance());
        //database.update(UPDATESTATL2, contentValues, "Sub_Status_id="+ updateStatL2.getUpdatedStatL2_Id(), null);
        database.insert(DISTANCE, null, contentValues);

    }
    public void saveRegStatus(RegStatus regStatus) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_RegStatus_ID,regStatus.getRegStatus_id());
        contentValues.put(TAG_RegStatus,regStatus.getRegStatus());
      //  database.update(UPDATESTATL2, contentValues, "Sub_Status_id="+ updateStatL2.getUpdatedStatL2_Id(), null);
        database.insert(REGSTATUS, null, contentValues);

    }
    public void saveAction(Action action) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_Action_ID,action.getAction_id());
        contentValues.put(TAG_Action,action.getAction());
        //database.update(UPDATESTATL2, contentValues, "Sub_Status_id="+ updateStatL2.getUpdatedStatL2_Id(), null);
        database.insert(ACTIONS, null, contentValues);

    }

    public void saveActiontype(ActionType actiontype) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_ActionType_ID,actiontype.getActionType_Id());
        contentValues.put(TAG_ActionType,actiontype.getActionType());
        contentValues.put(TAG_FIR,actiontype.getFIRAssociated());
        contentValues.put(TAG_Cat_Def,actiontype.getCatDefinition());
        contentValues.put(TAG_CatRole_ID,actiontype.getCatRoleID());
        contentValues.put(TAG_CatStatus_ID,actiontype.getCatStatusID());

        //database.update(UPDATESTATL2, contentValues, "Sub_Status_id="+ updateStatL2.getUpdatedStatL2_Id(), null);
        database.insert(ACTIONSTYPE, null, contentValues);

    }
    public void savesubActiontype(subActionType subActionType) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_SubActionType_ID,subActionType.getSubActionType_Id());
        contentValues.put(TAG_Sub_catActionID,subActionType.getSubcatActionType_Id());
        contentValues.put(TAG_Sub_ActionType,subActionType.getSubactionType());
        contentValues.put(TAG_Sub_Roleid,subActionType.getSubRoleID());
        contentValues.put(TAG_Sub_statusid,subActionType.getSubStatusID());

        //database.update(UPDATESTATL2, contentValues, "Sub_Status_id="+ updateStatL2.getUpdatedStatL2_Id(), null);
        database.insert(SUBACTIONSTYPE, null, contentValues);

    }
    public void savedivision(Division division) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_Division_ID,division.getDivision_id());
        contentValues.put(TAG_Division,division.getDivision());
        //database.update(UPDATESTATL2, contentValues, "Sub_Status_id="+ updateStatL2.getUpdatedStatL2_Id(), null);
        database.insert(DIVISION, null, contentValues);

    }
    public void saveRole(Role role) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_Role_ID,role.getRole_Id());
        contentValues.put(TAG_Role,role.getRoleName());
       // database.update(UPDATESTATL2, contentValues, "Sub_Status_id="+ updateStatL2.getUpdatedStatL2_Id(), null);
        database.insert(ROLE, null, contentValues);

    }
    public void savePWSdistrict(PWSDistrict pwsDistrict) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_PWSdistrict_ID,pwsDistrict.getDistrict_id());
        contentValues.put(TAG_PWSdistrict,pwsDistrict.getDistrict());
        //database.update(UPDATESTATL2, contentValues, "Sub_Status_id="+ updateStatL2.getUpdatedStatL2_Id(), null);
        database.insert(PWSDISTRICT, null, contentValues);

    }
    public void savePWSOrg(PWSOrgType pwsOrgType) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG_PWSorg_ID,pwsOrgType.getOrgType_id());
        contentValues.put(TAG_PWSorg,pwsOrgType.getOrgType());
        //database.update(UPDATESTATL2, contentValues, "Sub_Status_id="+ updateStatL2.getUpdatedStatL2_Id(), null);
        database.insert(PWSORGTYPE, null, contentValues);

    }



    public ArrayList<Division> getDivision() {
        String selectQuery = "SELECT * FROM " + DIVISION;

        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<Division> divisions =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                divisions.add(new Division(
                        cursor.getString(cursor.getColumnIndex("division_id")),
                        cursor.getString(cursor.getColumnIndex("divisions"))


                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return divisions;
    }

   public ArrayList<District> getDistrictList(String division) {
       String selectQuery=null;
       if(division.equals("Please Select")) {
           selectQuery = "SELECT * FROM " + DISTRICT;
       }
       else {
           selectQuery = "SELECT * FROM " + DISTRICT + " WHERE Dis_Division='" + division + "' UNION SELECT * FROM "  + DISTRICT +  " WHERE Dis_District='Please Select'" ;

       }

        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<District> districts =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                districts.add(new District(
                        cursor.getString(cursor.getColumnIndex("Dis_District_id")),
                        cursor.getString(cursor.getColumnIndex("Dis_Division")),
                        cursor.getString(cursor.getColumnIndex("Dis_District"))


                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return districts;
    }
    public ArrayList<Tehsil> getTehsilList(String district) {
        String selectQuery=null;
        if(district.equals("Please Select")){
            selectQuery = "SELECT * FROM " + TEHSIL;
        }
        else {
            selectQuery = "SELECT * FROM " + TEHSIL + " WHERE Teh_District='" + district + "' UNION SELECT * FROM "  + TEHSIL +  " WHERE Teh_Tehsil='Please Select'" ;
        }

        database  = openHelper.getReadableDatabase();
        Cursor cursor      = database.rawQuery(selectQuery, null);
        ArrayList<Tehsil> tehsils =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                tehsils.add(new Tehsil(
                        cursor.getString(cursor.getColumnIndex("Teh_Tehsil_id")),
                        cursor.getString(cursor.getColumnIndex("Teh_District")),
                        cursor.getString(cursor.getColumnIndex("Teh_Tehsil"))

                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return tehsils;
    }

    public String getActionID(String action) {
        String selectQuery=null;


            selectQuery = "SELECT * FROM " + ACTIONS + " WHERE Actioncol='" + action+"'";


        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        String action_id=null;
        if(cursor.moveToFirst() || cursor.getCount() >= -1) {
            do {
                action_id = cursor.getString(cursor.getColumnIndex("Action_id"));

            } while (cursor.moveToNext());
        }
        cursor.close();

        return action_id;
    }

    public ArrayList<SectorType> getSectorTypeList() {
        String selectQuery = "SELECT * FROM " + SECTORTYPE;
        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<SectorType> sectorTypes =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                sectorTypes.add(new SectorType(
                        cursor.getString(cursor.getColumnIndex("Sec_SectorType_id")),
                        cursor.getString(cursor.getColumnIndex("Sec_SectorType"))


                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return sectorTypes;
    }
    public ArrayList<CouncilType> getCouncilTypeList() {
        String selectQuery = "SELECT * FROM " + COUNCILTYPE;
        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<CouncilType> councilTypes =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                councilTypes.add(new CouncilType(
                        cursor.getString(cursor.getColumnIndex("Coun_CouncilType_id")),
                        cursor.getString(cursor.getColumnIndex("Coun_CouncilType"))


                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return councilTypes;
    }
    public ArrayList<OrgType> getOrgTypeList() {
        String selectQuery = "SELECT * FROM " + ORGTYPE;
        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<OrgType> orgTypes =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                orgTypes.add(new OrgType(
                        cursor.getString(cursor.getColumnIndex("Org_OrgType_id")),
                        cursor.getString(cursor.getColumnIndex("Org_OrgType"))


                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return orgTypes;
    }
    public ArrayList<UpdateStatL1> getUpdateStatus() {
        String selectQuery = "SELECT * FROM " + UPDATESTATL1;
        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<UpdateStatL1> updateStatL1s =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                updateStatL1s.add(new UpdateStatL1(
                        cursor.getString(cursor.getColumnIndex("Update_Status_id")),
                        cursor.getString(cursor.getColumnIndex("Update_Status"))


                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return updateStatL1s;
    }
    public ArrayList<UpdateStatL2> getSubStatus() {
        String selectQuery = "SELECT * FROM " + UPDATESTATL2;
        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<UpdateStatL2> updateStatL2s =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                updateStatL2s.add(new UpdateStatL2(
                        cursor.getString(cursor.getColumnIndex("Sub_Status_id")),
                        cursor.getString(cursor.getColumnIndex("Sub_Status"))


                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return updateStatL2s;
    }
    public ArrayList<Distance> getdistance() {
        String selectQuery = "SELECT * FROM " + DISTANCE;
        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<Distance> distances =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                distances.add(new Distance(
                        cursor.getString(cursor.getColumnIndex("Distance_id")),
                        cursor.getString(cursor.getColumnIndex("Distance"))


                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return distances;
    }





    public ArrayList<RegStatus> getRegStatus() {
        String selectQuery = "SELECT * FROM " + REGSTATUS;
        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<RegStatus> regStatuses =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                regStatuses.add(new RegStatus(
                        cursor.getString(cursor.getColumnIndex("Reg_Status_id")),
                        cursor.getString(cursor.getColumnIndex("Reg_Status"))


                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return regStatuses;
    }
    public ArrayList<Action> getActions() {
        String selectQuery = "SELECT * FROM " + ACTIONS;
        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<Action> actions =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                actions.add(new Action(
                        cursor.getString(cursor.getColumnIndex("Action_id")),
                        cursor.getString(cursor.getColumnIndex("Actioncol"))


                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return actions;
    }

    public ArrayList<ActionType> getActionType(String Roleid) {

        String selectQuery = "SELECT * FROM " + ACTIONSTYPE + " WHERE Cat_Roleid='" + Roleid + "' UNION SELECT * FROM "  + ACTIONSTYPE +  " WHERE Actiontype_id='0'" ;
        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<ActionType> actions =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                actions.add(new ActionType(
                        cursor.getString(cursor.getColumnIndex("Actiontype_id")),
                        cursor.getString(cursor.getColumnIndex("Actiontype")),
                        cursor.getString(cursor.getColumnIndex("Fir_id")),
                        cursor.getString(cursor.getColumnIndex("Cat_def")),
                        cursor.getString(cursor.getColumnIndex("Cat_Roleid")),
                        cursor.getString(cursor.getColumnIndex("Cat_Statusid"))


                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return actions;
    }
    public ArrayList<Role> getRoles() {

        String selectQuery = "SELECT * FROM " + ROLE;
        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<Role> roles =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                roles.add(new Role(
                        cursor.getString(cursor.getColumnIndex("role_id")),
                        cursor.getString(cursor.getColumnIndex("role_name"))
                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return roles;
    }
    public ArrayList<subActionType> getsubActiontype(String actiontypeid , String Roleid) {

        String selectQuery=null;

            selectQuery = "SELECT * FROM " + SUBACTIONSTYPE + " WHERE Subcatactiontype='" + actiontypeid +  "' and Sub_Roleid='"+ Roleid +"'  UNION SELECT * FROM "  + SUBACTIONSTYPE +  " WHERE Subactiontype_id='0'" ;


        database  = openHelper.getReadableDatabase();
        Cursor cursor      = database.rawQuery(selectQuery, null);
        ArrayList<subActionType> tehsils =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                tehsils.add(new subActionType(
                        cursor.getString(cursor.getColumnIndex("Subactiontype_id")),
                        cursor.getString(cursor.getColumnIndex("Subcatactiontype")),
                        cursor.getString(cursor.getColumnIndex("Subactiontype")),
                        cursor.getString(cursor.getColumnIndex("Sub_Roleid")),
                        cursor.getString(cursor.getColumnIndex("Sub_Statusid"))



                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return tehsils;
    }
    public ArrayList<subActionType> getsubActionselected(String actiontypeid) {

        String selectQuery=null;

        selectQuery = "SELECT * FROM " + SUBACTIONSTYPE + " WHERE Subactiontype_id='" + actiontypeid+"'";


        database  = openHelper.getReadableDatabase();
        Cursor cursor      = database.rawQuery(selectQuery, null);
        ArrayList<subActionType> tehsils =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                tehsils.add(new subActionType(
                        cursor.getString(cursor.getColumnIndex("Subactiontype_id")),
                        cursor.getString(cursor.getColumnIndex("Subcatactiontype")),
                        cursor.getString(cursor.getColumnIndex("Subactiontype")),
                        cursor.getString(cursor.getColumnIndex("Sub_Roleid")),
                        cursor.getString(cursor.getColumnIndex("Sub_Statusid"))

                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return tehsils;
    }
    public ArrayList<ActionType> getActionselected(String actiontypeid) {

        String selectQuery = "SELECT * FROM " + ACTIONSTYPE + " WHERE Actiontype_id='" + actiontypeid+"'";
        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<ActionType> actions =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                actions.add(new ActionType(
                        cursor.getString(cursor.getColumnIndex("Actiontype_id")),
                        cursor.getString(cursor.getColumnIndex("Actiontype")),
                        cursor.getString(cursor.getColumnIndex("Fir_id")),
                        cursor.getString(cursor.getColumnIndex("Cat_def")),
                        cursor.getString(cursor.getColumnIndex("Cat_Roleid")),
                        cursor.getString(cursor.getColumnIndex("Cat_Statusid"))

                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return actions;
    }
    public ArrayList<PWSDistrict> getPWSDistrict() {

        String selectQuery = "SELECT * FROM " + PWSDISTRICT;
        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<PWSDistrict> pwsdistrictss =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                pwsdistrictss.add(new PWSDistrict(
                        cursor.getString(cursor.getColumnIndex("PWSdistrict_id")),
                        cursor.getString(cursor.getColumnIndex("PWSdistrictName"))
                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return pwsdistrictss;
    }
    public ArrayList<PWSOrgType> getPWSorgType() {

        String selectQuery = "SELECT * FROM " + PWSORGTYPE;
        database  = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ArrayList<PWSOrgType> pwsOrgTypes =new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                pwsOrgTypes.add(new PWSOrgType(
                        cursor.getString(cursor.getColumnIndex("PWSorg_id")),
                        cursor.getString(cursor.getColumnIndex("PWSorgType"))
                ));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return pwsOrgTypes;
    }

    public void delete(int count){

       // openHelper.onUpgrade(database,DATABASE_VERSION,DATABASE_VERSION);
      if(count==0){
            database.execSQL("delete from "+ DISTRICT);
        }
        if(count==1){
            database.execSQL("delete from "+ TEHSIL);
        }
        if(count==2){
            database.execSQL("delete from "+ SECTORTYPE);
        }
        if(count==3){
            database.execSQL("delete from "+ COUNCILTYPE);
        }
        if(count==4){
            database.execSQL("delete from "+ ORGTYPE);
        }

        if(count==5){
            database.execSQL("delete from "+ DISTANCE);
        }
        if(count==6){
            database.execSQL("delete from "+ REGSTATUS);
        }
        if(count==7){
            database.execSQL("delete from "+ ACTIONSTYPE);
        }
        if(count==8){
            database.execSQL("delete from "+ SUBACTIONSTYPE);
        }
        if(count==9){
            database.execSQL("delete from "+ DIVISION);
        }
        if(count==10){
            database.execSQL("delete from "+ UPDATESTATL1);
        }
        if(count==11){
            database.execSQL("delete from "+ ROLE);
        }
        if(count==12){
            database.execSQL("delete from "+ UPDATESTATL2);
        }
        if(count==13){
            database.execSQL("delete from "+ ACTIONS);
        }
        if(count==14){
            database.execSQL("delete from "+ PWSDISTRICT);
        }
        if(count==15){
            database.execSQL("delete from "+ PWSORGTYPE);
        }
    }

    public DatabaseManager open() throws SQLException {
        openHelper = new DatabaseHelper(context);
        database = openHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (openHelper != null) {
            openHelper.close();
        }
    }

    private class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            // TODO Auto-generated constructor stub
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase database) {

            // TODO Auto-generated method stub
            database.execSQL(" CREATE TABLE " + DIVISION + " ( "
                    + TAG_Division_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_Division + " TEXT ) "


            );
            database.execSQL(" CREATE TABLE " + DISTRICT + " ( "
                    + TAG_DISTRICT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_DISTRICT_DIV + " TEXT, "
                    + TAG_DISTRICT + " TEXT ) "


            );
            database.execSQL(" CREATE TABLE " + TEHSIL + " ( "
                    + TAG_TEHSIL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_TDISTRICT + " TEXT, "
                    + TAG_TEHSIL + " TEXT ) "
                   // + "FOREIGN KEY(category_id) REFERENCES Category(category_id) )"
            );
            database.execSQL(" CREATE TABLE " + SECTORTYPE + " ( "
                    + TAG_SECTORTYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_SECTORTYPE + " TEXT ) "


            );
            database.execSQL(" CREATE TABLE " + COUNCILTYPE + " ( "
                    + TAG_COUNCILTYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_COUNCILTYPE + " TEXT ) "


            );
            database.execSQL(" CREATE TABLE " + ORGTYPE + " ( "
                    + TAG_ORGTYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_ORGTYPE + " TEXT ) "


            );
            database.execSQL(" CREATE TABLE " + UPDATESTATL1 + " ( "
                    + TAG_UpdatedStatus_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_UpdatedStatus + " TEXT ) "


            );
            database.execSQL(" CREATE TABLE " + UPDATESTATL2 + " ( "
                    + TAG_SubStatus_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_SubStatus + " TEXT ) "


            );
            database.execSQL(" CREATE TABLE " + DISTANCE + " ( "
                    + TAG_Distance_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_Distance + " TEXT ) "


            );
            database.execSQL(" CREATE TABLE " + REGSTATUS + " ( "
                    + TAG_RegStatus_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_RegStatus + " TEXT ) "


            );
            database.execSQL(" CREATE TABLE " + ACTIONS + " ( "
                    + TAG_Action_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_Action + " TEXT ) "


            );
            database.execSQL(" CREATE TABLE " + ROLE + " ( "
                    + TAG_Role_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_Role + " TEXT ) "


            );
            database.execSQL(" CREATE TABLE " + ACTIONSTYPE + " ( "
                    + TAG_ActionType_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_ActionType + " TEXT , "
                    + TAG_FIR + " INTEGER , "
                    + TAG_Cat_Def + " TEXT , "
                    + TAG_CatRole_ID + " INTEGER , "
                    + TAG_CatStatus_ID + " INTEGER ) "



            );
            database.execSQL(" CREATE TABLE " + SUBACTIONSTYPE + " ( "
                    + TAG_SubActionType_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_Sub_catActionID + " INTEGER, "
                    + TAG_Sub_ActionType + " TEXT,  "
                    + TAG_Sub_Roleid + " INTEGER, "
                    + TAG_Sub_statusid + " INTEGER ) "



            );
            database.execSQL(" CREATE TABLE " + PWSDISTRICT + " ( "
                    + TAG_PWSdistrict_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_PWSdistrict + " TEXT ) "


            );
            database.execSQL(" CREATE TABLE " + PWSORGTYPE + " ( "
                    + TAG_PWSorg_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TAG_PWSorg + " TEXT ) "


            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
            database.execSQL(" DROP TABLE IF EXISTS "+  DISTRICT);
            database.execSQL(" DROP TABLE IF EXISTS "+  TEHSIL);
            database.execSQL(" DROP TABLE IF EXISTS "+  SECTORTYPE);
            database.execSQL(" DROP TABLE IF EXISTS "+  COUNCILTYPE);
            database.execSQL(" DROP TABLE IF EXISTS "+  ORGTYPE);
            database.execSQL(" DROP TABLE IF EXISTS "+  UPDATESTATL1);
            database.execSQL(" DROP TABLE IF EXISTS "+  UPDATESTATL2);
            database.execSQL(" DROP TABLE IF EXISTS "+  DISTANCE);
            database.execSQL(" DROP TABLE IF EXISTS "+  REGSTATUS);
            database.execSQL(" DROP TABLE IF EXISTS "+  ACTIONS);
            database.execSQL(" DROP TABLE IF EXISTS "+  ACTIONSTYPE);
            database.execSQL(" DROP TABLE IF EXISTS "+  SUBACTIONSTYPE);
            database.execSQL(" DROP TABLE IF EXISTS "+  ROLE);
            database.execSQL(" DROP TABLE IF EXISTS "+  PWSDISTRICT);
            database.execSQL(" DROP TABLE IF EXISTS "+  PWSORGTYPE);
            onCreate(database);
        }
    }

}