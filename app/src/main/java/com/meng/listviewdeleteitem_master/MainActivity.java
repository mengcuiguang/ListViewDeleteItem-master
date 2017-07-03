package com.meng.listviewdeleteitem_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupList();
    }

    private void setupList() {
        ListView listView = (ListView) findViewById(R.id.list);
        adapter = new ListAdapter(this, createList(20));
        listView.setAdapter(adapter);
    }

    private List<String> createList(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i + 1 + "碗胡辣汤");
        }
        return list;
    }
}
