package com.example.code06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] titles = null;
    private String[] authors = null;

    private static final String NEWS_TITLE = "news_title";
    private static final String NEWS_AUTHOR = "news_author";
    public static final String NEWS_ID = "news_id";
     private List<News> newsList = new ArrayList <>();
    private List<Map<String, String>> dataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this ,
        R.layout.list_item , newsList);

         ListView lvNewsList = findViewById(R.id.lv_news_list);

         lvNewsList.setAdapter(newsAdapter);

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,
                dataList, android.R.layout.simple_list_item_2,
                new String[]{NEWS_TITLE, NEWS_AUTHOR},
                new int[]{android.R.id.text1, android.R.id.text2});

        /*ListView lvNewsList = findViewById(R.id.lv_news_list);
        lvNewsList.setAdapter(simpleAdapter);*/


       /*titles = getResources().getStringArray(R.array.titles);
         authors = getResources().getStringArray(R.array.authors);

         ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        MainActivity.this, android.R.layout.simple_list_item_1, titles);

         ListView lvNewsList = findViewById(R.id.lv_news_list);
         lvNewsList.setAdapter(adapter);*/
    }

    private void initData() {
        int length;
        titles = getResources().getStringArray(R.array.titles);
        authors = getResources().getStringArray(R.array.authors);
        TypedArray images = getResources().obtainTypedArray(R.array.images);
        if (titles.length > authors.length) {
            length = authors.length;
        } else {
            length = titles.length;
        }

        for (int i = 0; i < length; i++) {
            News news = new News();
            news.setTitle(titles[i]);
            news.setAuthor(authors[i]);
            news.setImageId(images.getResourceId(i, 0));

            newsList.add(news);
    }
}
}