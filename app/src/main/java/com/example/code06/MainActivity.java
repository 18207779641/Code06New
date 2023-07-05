package com.example.code06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListAdapter;
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

    private NewsAdapter newsAdapter = null;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.lv_news_list);
        initData();

        MyDbOpenHelper myDbHelper = new MyDbOpenHelper(MainActivity.this);
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Cursor cursor1 = db.query(
                NewsContract.NewsEntry.TABLE_NAME ,
                 null , null , null , null , null , null);

        List<News> newsList = new ArrayList <>();

        int titleIndex = cursor1.getColumnIndex(
                 NewsContract.NewsEntry.COLUMN_NAME_TITLE);
        int authorIndex = cursor1.getColumnIndex(
                 NewsContract.NewsEntry.COLUMN_NAME_AUTHOR);
        int imageIndex = cursor1.getColumnIndex(
                NewsContract.NewsEntry.COLUMN_NAME_IMAGE);

        while (cursor1.moveToNext()) {
            News news = new News();

            String title = cursor1.getString(titleIndex);
            String author = cursor1.getString(authorIndex);
            String image = cursor1.getString(imageIndex);

            Bitmap bitmap = BitmapFactory.decodeStream(
                    getClass().getResourceAsStream("/" + image));

            news.setTitle(title);
            news.setAuthor(author);
            news.setImage(bitmap);
            newsList.add(news);
        }
        NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this ,
                R.layout.list_item , newsList);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(newsAdapter);

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

//        for (int i = 0; i < length; i++) {
//            News news = new News();
//            news.setTitle(titles[i]);
//            news.setAuthor(authors[i]);
//            news.setImageId(images.getResourceId(i, 0));
//
//            newsList.add(news);
//    }
}
}