package com.roles.census.Extra;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.roles.census.Activities.Common.AboutusActivity;
import com.roles.census.Activities.Common.ChangePasswordActivity;
import com.roles.census.Activities.Common.FilterActivity;
import com.roles.census.Activities.Common.IndReportingActivity;
import com.roles.census.Activities.Common.ReportQuackActivity;
import com.roles.census.Adapters.HigherPlanSummAdapter;
import com.roles.census.DataElements.ActionType;
import com.roles.census.DataElements.CouncilType;
import com.roles.census.DataElements.subActionType;
import com.roles.census.Managers.DataManager;
import com.roles.census.Others.CurrentLocation;
import com.roles.census.Others.Logout;
import com.roles.census.R;
import com.roles.census.TabsActivities.DashboardTabs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

public class HigherPlanSummActivity extends AppCompatActivity {


    CurrentLocation gps;
    double cur_latitude;
    double cur_longitude;

    TextInputLayout regNoInput;
    TextInputLayout counTypeInput;
    TextInputLayout counNoInput;
    TextInputLayout Reg_No_lay;
    TextInputLayout fir_layout;
    private Boolean picTaken=false;
    private Boolean picreceved=true;
    private Boolean picAttachement=false;
    Context context;
    int count=0;
    int backcount=0;
    private String filePath=null;
    private Uri filePathURI;
    String visitDate;
    String actionTypeText;
    String actionTypeID;
    String subactionTypeText;
    String subactionTypeID;
    String firtext;
    String firID="0";
    String subactiontseltext;
    String actiontseltext;
    Spinner actionType_spinner;
    Spinner subactionType_spinner;
    Spinner counciltypespiner;
    Spinner fir_spinner;
    ArrayList<ActionType> actionTypeList = null;
    ArrayList<subActionType> subactionType = null;
    ArrayList<ActionType> actionTypeselected = null;
    ArrayList<subActionType> subactionTypeselected=null;
    ArrayList<CouncilType> councilTypes;
    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_PHOTOS = "photos";
    private static final String TAG_MOVIES = "videos";
    private static final String TAG_NOTIFICATIONS = "notifications";
    private static final String TAG_SETTINGS = "settings";
    public static String CURRENT_TAG = TAG_HOME;
    // toolbar titles respected to selected nav menu item
    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private static final String LOG_TAG = "AppUpgrade";
    private String activityTitles;
    private int versionCode = 0;
    int PICK_IMAGE_REQUEST = 111;
    private Uri u=null;
    String appURI = "";
    String time1;
    String MID;
    String MText;
    String MID2;
    String MText2;
    Switch simpleSwitch1;
    String hce_nameText="";
  //  String AddressText="";
   // String HCSP_nameText="";
   // String HCSP_SOText="";
  //  String CNIC_Text="";
 //   String HCSP_ContactText="";
    String Reg_NoText="";
    String coun_NoText="";
    String  final_id="";
    String visited;
    String UploadedBy;
  //  String districtText="";
    //String sectortypetext="";
  //  String hceTypetext="";
//    String HCSPTypeText="";
 //   String RegstatusText="";
//    String counStatusText="";
    String counciltypetext="";
    String counciltypeID="";
//    String RegType="";
    String email=null;
    String password;
    String isEdit;
    String username;
//    String RecordLockedForUpdate="";
//    String total_beds="";
    String index;
    String PlanTitle;

    String  VisitedDate;
    String isFIRSubmit;
   // double latitude;
  //  double longitude;
    EditText coun_NoEdit;
    EditText hce_nameEdit;
    EditText Reg_no_edit;
    DataManager dataManager;
    TextView totalpics;
    TextView newquacktext;
    TextView vistedtext;
    int countPictures=0;
    private DownloadManager downloadManager;
    private long downloadReference;
    int MY_REQUEST_CODE=5;
    private ArrayList<String> _images;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    // private GoogleApiClient client;
    //private static final String urlNavHeaderBg = "http://api.androidhive.info/images/nav-menu-header-bg.jpg";
    //private static final String urlProfileImg = "https://lh3.googleusercontent.com/eCtE_G34M9ygdkmOpYvCag1vBARCmZwnVS6rS5t4JLzJ6QgQSBquM0nuTsCpLhYbKljoyS-txg";
    public static int navItemIndex = -1;

    ArrayList<HashMap<String, String>> mylist;
    ProgressDialog pDialog;
    String jsonStr;
    String jsonStr2;
    String imagepath,PlanStartDate,PlanEndDate;
    EditText txtDateTime;
    Calendar myCalendar;
    EditText comments;
    String commentText;
    Spinner date_spinner;
    int actionposition;
    int subactionposition;
    int firposition;
    int councilposition;
    Bundle saveinstance;
    String strtdatetext, enddatetext,Vistdate;
    ListView listView;
    TextView hce_name;
    String RoleID;
    ArrayAdapter<String> actionadapter;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allteam_vists_list);
        context = this;



        pDialog = new ProgressDialog(context);
        listView = (ListView) findViewById(R.id.list);
        hce_name = (TextView) findViewById(R.id.hce_name);
        date_spinner = (Spinner)  findViewById(R.id.date_spinner);
        Intent intent = getIntent();

        email = (String) intent.getSerializableExtra("email");
        password = (String) intent.getSerializableExtra("password");
        username = (String) intent.getSerializableExtra("username");
        isEdit = (String) intent.getSerializableExtra("isEdit");
        PlanTitle = (String) intent.getSerializableExtra("PlanTitle");
        PlanStartDate= (String) intent.getSerializableExtra("PlanStartDate");
        PlanEndDate= (String) intent.getSerializableExtra("PlanEndDate");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gps = new CurrentLocation(context);
        mHandler = new Handler();
        TextView t2 = (TextView) findViewById(R.id.text2);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtWebsite = (TextView) navHeader.findViewById(R.id.website);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);
  /*      BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*/
        // load toolbar titles from string resources
        activityTitles = getResources().getString(R.string.nav_aqc_plansumm);
        SharedPreferences prefs = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
        String isStat = prefs.getString("isStat", null);//"No name defined" is the default value.
        RoleID = prefs.getString("RoleID", null); //0 is the default value.
        if(RoleID.equals("1")) {
            navigationView.getMenu().findItem(R.id.nav_actiondesc).setVisible(true);
            if (isStat.equals("true")) {
                navigationView.getMenu().findItem(R.id.nav_actionsummary).setVisible(true);


            } else {
                navigationView.getMenu().findItem(R.id.nav_actionsummary).setVisible(false);
            }
        }
        else {
            navigationView.getMenu().findItem(R.id.nav_actiondesc).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_actionsummary).setVisible(false);
        }
        loadNavHeader();
        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
        String ackwardDate = PlanStartDate;
        String ackwardRipOff = ackwardDate.replace("/Date(", "").replace("+0500", "").replace(")/", "");
        Long timeInMillis = Long.valueOf(ackwardRipOff);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        Date d= new Date(timeInMillis);
        strtdatetext=new SimpleDateFormat("dd-MMM-yyyy").format(calendar.getTime()).toString();

        String ackwardDate2 = PlanEndDate;
        String ackwardRipOff2 = ackwardDate2.replace("/Date(", "").replace("+0500", "").replace(")/", "");
        Long timeInMillis2 = Long.valueOf(ackwardRipOff2);
        calendar.setTimeInMillis(timeInMillis2);
        Date d2= new Date(timeInMillis2);
        enddatetext=new SimpleDateFormat("dd-MMM-yyyy").format(calendar.getTime()).toString();
        hce_name.setText(PlanTitle);
        Date stdate = new Date(timeInMillis);
        Date endate = new Date(timeInMillis2);
        ArrayAdapter<String> dateadapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, getDatesBetween(stdate,endate)) {
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the spinner collapsed item (non-popup item) as a text view
                TextView tv = (TextView) super.getView(position, convertView, parent);

                // Set the text color of spinner item
              //  tv.setTextColor(Color.WHITE);

                // Return the view
                return tv;
            }


            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return true;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) super.getDropDownView(position,convertView,parent);

                // Set the text color of drop down items
           /*     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    tv.setTextColor(Color.BLACK);
                }else {
                    tv.setTextColor(Color.WHITE);
                }
*/
                if (position == 0) {
                    // Set the hint text color gray
                /*    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        tv.setTextColor(Color.BLACK);
                    }else {
                        tv.setTextColor(Color.WHITE);
                    }*/
                } else {
                    //convertView.setBackgroundColor(Color.WHITE);
                    //((TextView) parent.getChildAt(position)).setTextColor(Color.WHITE);
                /*    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        tv.setTextColor(Color.BLACK);
                    }else {
                        tv.setTextColor(Color.WHITE);
                    }*/
                }
                return tv;
            }
        };
        dateadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
   /*     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            date_spinner.setPopupBackgroundResource(R.drawable.spinner);
        }*/
        date_spinner.setAdapter(dateadapter);
        date_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                Vistdate = parent.getItemAtPosition(position).toString();
                DateFormat formatter;
                if (Vistdate != null && Vistdate!="All") {
                    formatter = new SimpleDateFormat("dd-MMM-yyyy");
                    Date date2 = null;
                    try {
                        date2 = (Date) formatter.parse(Vistdate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    SimpleDateFormat newFormat = new SimpleDateFormat("M/d/yyyy");
                    if (date2 != null)
                        Vistdate = newFormat.format(date2);

                }
                pDialog.setMessage("Loading Data, Please wait...");
                pDialog.setCancelable(false);
                pDialog.show();
                String url = getDirectionsUrl(Vistdate);
                DownloadTask downloadTask = new DownloadTask();
                //Start downloading json data from Google Directions API
                downloadTask.execute(url);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    public ArrayList<String> getDatesBetween(
            Date startDate, Date endDate) {

        List<Date> datesInRange = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endDate);
        ArrayList<String> counciltypelist = new ArrayList<String>();
        counciltypelist.add("All");
        while (calendar.before(endCalendar)) {
            Date result = calendar.getTime();
            SimpleDateFormat newFormat = new SimpleDateFormat("dd-MMM-yyyy");
            String finalString = "";
            if (result != null)
                finalString = newFormat.format(result);
            counciltypelist.add(finalString);
            datesInRange.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        counciltypelist.add(enddatetext);
        return counciltypelist;
    }
    private void loadNavHeader() {
        // name, website

        txtName.setText(username);
        txtWebsite.setText(email);

        // loading header background image
       /* Glide.with(this).load(urlNavHeaderBg)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgNavHeaderBg);

        // Loading profile image
        Glide.with(this).load(urlProfileImg)
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgProfile);

        // showing dot next to notifications label
        navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);*/
    }

    /***
     * Returns respected fragment that user
     * selected from navigation menu
     */
    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
              setToolbarTitle();

        // if user select the current navigatiokn menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            // show or hide the fab button
            // toggleFab();
            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        // show or hide the fab button
        //toggleFab();

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }


    private HomeFragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                // home
             /*   Intent i = new Intent(context, Login_Activity.class);
                startActivity(i);*/
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                // photos
                PhotosFragment photosFragment = new PhotosFragment();
                return photosFragment;
            case 2:
                // movies fragment
                VideosFragment videosFragment = new VideosFragment();
                return videosFragment;
            case 3:
                // notifications fragment
                NotificationFragment notificationsFragment = new NotificationFragment();
                return notificationsFragment;

            case 4:
                // settings fragment
                SettingFragment settingsFragment = new SettingFragment();
                return settingsFragment;
            default:
                return new HomeFragment();
        }
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(false);
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
               case R.id.nav_home:
                   startActivity(new Intent(context, FilterActivity.class).putExtra("email",email).putExtra("password",password).putExtra("username", username).putExtra("isEdit", isEdit));
                   drawer.closeDrawers();
                   return true;
                    case R.id.nav_reportquack:
                        startActivity(new Intent(context, ReportQuackActivity.class).putExtra("email",email).putExtra("password",password).putExtra("username", username).putExtra("isEdit", isEdit));
                        drawer.closeDrawers();
                        return true;
                    case R.id.nav_actionsummary:
                        SharedPreferences prefs = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
                        String isStat = prefs.getString("isStat", null);//"No name defined" is the default value.
                        String UserID = prefs.getString("UserID", null); //0 is the default value.
                        if(isStat.equals("true")) {
                            startActivity(new Intent(context, DashboardTabs.class).putExtra("email",email).putExtra("password",password).putExtra("username", username).putExtra("isEdit", isEdit));
                            drawer.closeDrawers();
                        }
                        else {
                            Toast.makeText(context, "You are not authorised!", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.nav_resetPassword:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(context, ChangePasswordActivity.class).putExtra("email",email).putExtra("password",password));
                        drawer.closeDrawers();
                       // return true;
                    case R.id.nav_actiondesc:
                        startActivity(new Intent(context, IndReportingActivity.class).putExtra("email",email).putExtra("password",password).putExtra("username", username).putExtra("isEdit", isEdit));
                        drawer.closeDrawers();

         /*               AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                        alertDialog.setTitle("Change Password");
                        final EditText oldPass = new EditText(context);
                        final EditText newPass = new EditText(context);
                        final EditText confirmPass = new EditText(context);


                        oldPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        newPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        confirmPass.setTransformationMethod(PasswordTransformationMethod.getInstance());

                        oldPass.setHint("Old Password");
                        newPass.setHint("New Password");
                        confirmPass.setHint("Confirm Password");
                        LinearLayout ll=new LinearLayout(context);
                        ll.setOrientation(LinearLayout.VERTICAL);
                        ll.addView(oldPass);
                        ll.addView(newPass);
                        ll.addView(confirmPass);
                        alertDialog.setView(ll);
                        alertDialog.setPositiveButton("Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                      String oldpas=  oldPass.getText().toString();
                                        String newPas = newPass.getText().toString();
                                        String confirmPas =confirmPass.getText().toString();
                                        if(newPas.equals(confirmPas) && oldpas.equals(password)){
                                            ChangePassword changePassword=new ChangePassword(context,email,newPas);
                                            dialog.cancel();
                                        }
                                        else {
                                            Toast.makeText(context, "Password not matched", Toast.LENGTH_SHORT).show();
                                        }


                                    }
                                });
                        alertDialog.setNegativeButton("No",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert11 = alertDialog.create();
                        alert11.show();*/
                        return true;



                    case R.id.nav_about_us:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(context, AboutusActivity.class));
                        drawer.closeDrawers();
                        return true;
                    case R.id.nav_Logout:
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure to exit CIM?")
                                .setTitle("Exit")
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // launch new intent instead of loading fragment
                                        startActivity(new Intent(context, Logout.class));
                                        drawer.closeDrawers();
                                    }
                                })
                                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                        return true;
                    //default:
                     //   navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

  /*      else {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Do you really want to navigate away from this screen? Changes made will not be effective")
                    .setTitle("Warning")
                    .setCancelable(false)
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            backcount=1;
                            onBackPressed();
                        }
                    })
                    .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();


        }
*/
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

     /*   // show menu only when home fragment is selected
        if (navItemIndex == 0) {
           // getMenuInflater().inflate(R.menu.menu_main, menu);
        }

        // when fragment is notifications, load the menu created for notifications
        if (navItemIndex == 3) {
            getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        }*/
        return true;
    }



    private class DownloadTask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
                Log.d("Background Task data", data.toString());
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();
            jsonStr = result;
            // Invokes the thread for parsing the JSON data
            parserTask.execute();

        }
    }

    private String getDirectionsUrl(String vsdate) {

        // Building the url to the web service
        String baseurl = context.getResources().getString(R.string.baseurl);
        String token= context.getResources().getString(R.string.token);
        String url =null;
if(vsdate.equals("All")) {
    url = baseurl + "GetLatestVisitsPlanTitleWise?strToken=" + token + "&strDataTitle=" + PlanTitle+"&RoleID="+RoleID;
}
else {
    url = baseurl + "GetLatestVisitsPlanTitle_DateWise?strToken=" + token + "&strDataTitle="+PlanTitle+"&VisitDate="+vsdate+"&RoleID="+RoleID;
}

        url = url.replaceAll(" ", "%20");

        return url;
    }

    private String downloadUrl(String strUrl) throws IOException {


        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();
            int statusCode = urlConnection.getResponseCode();


            if (statusCode >= 200 && statusCode < 400) {
                // Create an InputStream in order to extract the response object
                iStream = urlConnection.getInputStream();
            } else {
                iStream = urlConnection.getErrorStream();
            }
            //iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    private class ParserTask extends AsyncTask<Object, Object, ArrayList<HashMap<String, String>>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog


        }

        @Override
        protected ArrayList<HashMap<String, String>> doInBackground(Object... arg0) {

            // Making a request to url and getting response

            if (jsonStr != null) {
                try {
                    JSONArray json = new JSONArray(jsonStr);
// ...
                    mylist = new ArrayList<HashMap<String, String>>();
                    for (int i = 0; i < json.length(); i++) {
                        HashMap<String, String> map = new HashMap<String, String>();
                        JSONObject e = json.getJSONObject(i);
                            map.put("index", String.valueOf(i+1));
                            map.put("ClosedSealedTotal", e.getString("ClosedSealedTotal"));
                            map.put("District", e.getString("District"));
                            map.put("DistrictID", e.getString("DistrictID"));
                            map.put("FunctionalSealedTotal", e.getString("FunctionalSealedTotal"));
                            map.put("NotSealedTotal", e.getString("NotSealedTotal"));
                            map.put("PlanID", e.getString("PlanID"));
                            map.put("Team", e.getString("Team"));
                            map.put("TeamNo", e.getString("TeamNo"));
                            map.put("TotalFIR", e.getString("TotalFIR"));
                            map.put("TotalImages", e.getString("TotalImages"));
                            map.put("TotalVisits", e.getString("TotalVisits"));
                        map.put("PlanStartDate", e.getString("PlanStartDate"));
                        map.put("PlanEndDate", e.getString("PlanEndDate"));
                        mylist.add(map);
                    }

                    // adding contact to contact list
                    //contactList.add(contact);

                } catch (final JSONException e) {

                    e.printStackTrace();


                }
            } else {
                Log.e("exception", "Couldn't get json from server.");
            }

            return mylist;
        }

        @Override
        protected void onPostExecute(final ArrayList<HashMap<String, String>> result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();
            if(result!=null && result.size()>0) {
                HigherPlanSummAdapter adapter = new HigherPlanSummAdapter(context, result,hce_nameText, email, password, username, isEdit,PlanTitle);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
            else {

                Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();

            }
        }

    }

}
