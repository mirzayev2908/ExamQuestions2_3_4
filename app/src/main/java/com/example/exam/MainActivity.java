package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import com.example.exam.adapter.CustomAdapter;
import com.example.exam.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    int code;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            code = 3;
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            code = 1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new GridLayoutManager(context,code));

        List <Member> members = membersList();
        refreshAdapter(members);
    }

    private List<Member> membersList() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 15; i++){
            members.add(new Member());
        }
        return members;
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter customAdapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(customAdapter);



        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                GridLayoutManager layoutManager = GridLayoutManager.class.cast(recyclerView.getLayoutManager());
                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();

                boolean endHasBeenReached = lastVisible + 5 >= totalItemCount;
                if (totalItemCount > 0 && endHasBeenReached) {
                    Toast.makeText(context, "This is bottom", Toast.LENGTH_LONG).show();
                    customAdapter.setMembers(membersList());
                }
            }
        });


    }




}