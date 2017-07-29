package com.fengjian.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
/*
 *   Telegram channel Url  : https://telegram.me/Iranandroidtutorial
 * 
 *  Web site : http://forum.androidtutorial.ir/
 * 
 * 
 * 
 */
public class DragListActivity extends Activity {
    
    private static List<String> list = null;
    private DragListAdapter adapter = null;
    
    public static List<String> groupKey= new ArrayList<String>();
    private List<String> navList = new ArrayList<String>();
    private List<String> moreList = new ArrayList<String>();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_list_activity);
        
        initData();
        
        DragListView dragListView = (DragListView)findViewById(R.id.drag_list);
        adapter = new DragListAdapter(this, list);
        dragListView.setAdapter(adapter);
    }
    
    public void initData(){
        list = new ArrayList<String>();
        
       
        groupKey.add("Seven");
        groupKey.add("7up");
        
        for(int i=0; i<5; i++){
            navList.add("hi"+i);
        }
        list.add("Test");
        list.addAll(navList);
        
        for(int i=0; i<8; i++){
            moreList.add("androidtutorial"+i);
        }
        list.add("ir");
        list.addAll(moreList);
    }
    
    public static class DragListAdapter extends ArrayAdapter<String>{

        public DragListAdapter(Context context, List<String> objects) {
            super(context, 0, objects);
        }
        
        public List<String> getList(){
            return list;
        }
        
        @Override
        public boolean isEnabled(int position) {
            if(groupKey.contains(getItem(position))){
              
                return false;
            }
            return super.isEnabled(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            
            View view = convertView;
            if(groupKey.contains(getItem(position))){
                view = LayoutInflater.from(getContext()).inflate(R.layout.drag_list_item_tag, null);
            }else{
                view = LayoutInflater.from(getContext()).inflate(R.layout.drag_list_item, null);
            }
            
            TextView textView = (TextView)view.findViewById(R.id.drag_list_item_text);
            textView.setText(getItem(position));
            
            return view;
        }
    }
}