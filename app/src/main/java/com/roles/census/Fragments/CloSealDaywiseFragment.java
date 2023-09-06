package com.roles.census.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.roles.census.Adapters.Datewise_SummAdapter;
import com.roles.census.R;

import java.util.ArrayList;
import java.util.HashMap;


public class CloSealDaywiseFragment extends Fragment {
    String jsonStr = null;
    ListView listView;
    ArrayList<HashMap<String, String>> indtabresult;
    ArrayList<HashMap<String, String>> closedsealedlist;
    String Vistdate;
    ProgressDialog pDialog;
    int count=1;
    String email,password,username,isEdit,PlanTitle;
    TextView totaltext;
    int Total=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.datewise_summlist, container, false);

        pDialog = new ProgressDialog(getActivity());
        totaltext = (TextView) rootView.findViewById(R.id.totaltext);
        listView = (ListView) rootView.findViewById(R.id.list);
        final Bundle args = getArguments();
        indtabresult= (ArrayList<HashMap<String, String>>) args.getSerializable("indtabresult");
        email= args.getString("email");
        password= args.getString("password");
        username= args.getString("username");
        isEdit= args.getString("isEdit");
        Vistdate=args.getString("Vistdate");
        PlanTitle=args.getString("PlanTitle");
        closedsealedlist=new ArrayList<HashMap<String, String>>();
            for (int i = 0; i < indtabresult.size(); i++) {
                if (indtabresult.get(i).get("PKID").equals("3") && indtabresult.get(i).get("VisitDate").equals(Vistdate)) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("index", String.valueOf(count));
                    map.put("CategoryDesc", indtabresult.get(i).get("CategoryDesc"));
                    map.put("ID", indtabresult.get(i).get("ID"));
                    map.put("PKID", indtabresult.get(i).get("PKID"));
                    map.put("TotalSealed", indtabresult.get(i).get("TotalSealed"));
                    map.put("TypeDesc", indtabresult.get(i).get("TypeDesc"));
                    map.put("VisitDate", indtabresult.get(i).get("VisitDate"));
                    Total = Total + Integer.parseInt(indtabresult.get(i).get("TotalSealed"));
                    closedsealedlist.add(map);
                    count++;
                }
            }

        totaltext.setText("Close Sealed: " +Total);
        Total=0;
        Datewise_SummAdapter datewise_summAdapter =new Datewise_SummAdapter(getContext(),closedsealedlist,email,password,username,isEdit,PlanTitle);
        listView.setAdapter(datewise_summAdapter);
        datewise_summAdapter.notifyDataSetChanged();
        return rootView;
    }


}
