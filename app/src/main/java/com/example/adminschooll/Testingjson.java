package com.example.adminschooll;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Testingjson extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_testingjson, container, false);
        ListView listView=v.findViewById(R.id.testingjsonlist);
        ArrayAdapter<String> arrayAdapter;
        ArrayList<String> arrayList=new ArrayList<>();
        String json="{\n" +
                "  \"1-A\" : [{\"name\":\"Babu\",\"id\":\"13\"},{\"name\":\"Ba\",\"id\":\"13\"},{\"name\":\"B\",\"id\":\"13\"}]\n" +
                "}";
        String json2="{\n" +
                "  \"1-A\" : {\n" +
                "\n" +
                "  \t\"Mark\" : {\n" +
                "      \"Babu CSE 2021\" : {\n" +
                "        \"English\" : {\n" +
                "          \"Babu CSE 2021\" : 60\n" +
                "        },\n" +
                "        \"Science\" : {\n" +
                "          \"Babu CSE 2021\" : 80\n" +
                "        },\n" +
                "        \"Social Science\" : {\n" +
                "          \"Babu CSE 2021\" : 100\n" +
                "        },\n" +
                "        \"Tamil\" : {\n" +
                "          \"Babu CSE 2021\" : 40\n" +
                "        }\n" +
                "      }\n" +
                "\n" +
                "  }\n" +
                "}";
        try {
            JSONObject jsonObject=new JSONObject(json2);
            JSONObject jsonObject1=jsonObject.getJSONObject("1-A");
            Log.d("1",jsonObject.toString()+"  "+jsonObject1.toString());

           // JSONArray jsonArray=new JSONArray(json);
          /*  for (int i=0;i<jsonObject1.length();i++){
                JSONObject Object=jsonObject1.getJSONObject();
                Log.d("jsonobject",Object.getString("name")+" "+Object.getString("id"));
            }*/
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return v;
    }
}