package com.dev4u.ntc.retrofitdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.dev4u.ntc.retrofitdemo.APIService;
import com.dev4u.ntc.retrofitdemo.ApiUtils;
import com.dev4u.ntc.retrofitdemo.R;
import com.dev4u.ntc.retrofitdemo.model.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mJsonArray, mJsonObject;
    private ListView mLvPost;
    private PostAdapter postAdapter;

    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mJsonArray = (Button) findViewById(R.id.jsonArray);
        mJsonObject = (Button) findViewById(R.id.jsonObject);
        mLvPost = (ListView) findViewById(R.id.lvPost);
        mAPIService = ApiUtils.getAPIService();

        mJsonArray.setOnClickListener(this);
        mJsonObject.setOnClickListener(this);
    }

    private void getRetrofitArray() {
        mAPIService.getPostsDetails().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                try {
                    final List<Post> postList = response.body();
                    postAdapter = new PostAdapter(MainActivity.this, postList);
                    mLvPost.setAdapter(postAdapter);

                    mLvPost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent = new Intent(MainActivity.this, PostDetailActivity.class);
                            intent.putExtra("title", postList.get(i).getTitle());
                            intent.putExtra("content", postList.get(i).getContent());
                            intent.putExtra("nameCa", postList.get(i).getName_ca());
                            intent.putExtra("des", postList.get(i).getDescription());
                            startActivity(intent);
                        }
                    });
                } catch (Exception e) {
                    Log.d("onResponse", "Error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }

   private void getRetrofitObject() {
        mAPIService.getPostDetails().enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                try {
                    final List<Post> postList = new ArrayList<Post>();
                    postList.add(response.body());
                    postAdapter = new PostAdapter(MainActivity.this, postList);
                    mLvPost.setAdapter(postAdapter);

                    mLvPost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent = new Intent(MainActivity.this, PostDetailActivity.class);
                            intent.putExtra("title", postList.get(i).getTitle());
                            intent.putExtra("content", postList.get(i).getContent());
                            intent.putExtra("nameCa", postList.get(i).getName_ca());
                            intent.putExtra("des", postList.get(i).getDescription());
                            startActivity(intent);
                        }
                    });
                } catch (Exception e) {
                    Log.d("onResponse", "Error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jsonArray:
                getRetrofitArray();
                break;
            case R.id.jsonObject:
                getRetrofitObject();
                break;
        }
    }
}
