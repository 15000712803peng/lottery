package com.cai.newc.ui.activity;

import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.cai.newc.R;
import com.cai.newc.adapter.CommentsAdapter;
import com.cai.newc.base.BaseActivity;
import com.cai.newc.model.Comment;
import com.cai.newc.model.ImageNews;
import com.cai.newc.model.NewsBase;
import com.cai.newc.model.TextNews;
import com.cai.newc.ui.view.BottomShareDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/15 0015.
 */

public class NewsActivity extends BaseActivity{

    @Bind(R.id.news_content)
    LinearLayout contentParent;
    List<NewsBase> news = new ArrayList<>();
    @Bind(R.id.list_comment)
    ListView commentList;
    List<Comment> commentsData = new ArrayList<>();
    @Override
    public int layout() {
        return R.layout.activity_news;
    }

    @Override
    public void loadData() {
        TextNews textNews = new TextNews();
        textNews.setContent("举个例子，如果一个中国球员在联赛严重犯规，造成比较恶劣的影响大家都声讨。 你是足协官员或者体育总局官员你怎么看？官员会说要净");
        news.add(textNews);
        ImageNews imageNews = new ImageNews();
        imageNews.setImage(R.mipmap.fnn);
        news.add(imageNews);
        TextNews textNews2 = new TextNews();
        textNews2.setContent("本人爱好防守，有次遇到个极品，球传到他那就没有出来的了，他还投篮稀烂，十有八九都铁了，看不过去，就问他怎么不传球，他奇葩的回答，他说你的防守那么好，那我就是投手，投不进不怕，就是要把手感要投出来，尼玛我当时就吐血了，这是什么逻辑。。。");
        news.add(textNews2);
        //==============================
        Comment c1 = new Comment();
        c1.setCreatedDate("刚刚");
        c1.setNickName("我就是个球迷");
        c1.setComment("本人爱好防守，有次遇到个极品，球传到他那就没有出来的了，他还投篮稀烂，十有八九都铁了，看不过去，就问他怎么不传球，他奇葩的回答，他说你的防守那么好，那我就是投手，投不进不怕，就是要把手感要投出来，尼玛我当时就吐血了，这是什么逻辑。。。");
        commentsData.add(c1);
        Comment c2 = new Comment();
        c2.setCreatedDate("3分钟前");
        c2.setNickName("滚滚滚球");
        c2.setComment("没见过那么6的文章");
        commentsData.add(c2);
    }

    @Override
    public void initViews() {
        loadNews(news);
        commentList.setAdapter(new CommentsAdapter(commentsData,this));
        commentList.addFooterView(getLayoutInflater().inflate(R.layout.comments_footer,null));
    }

    @Override
    public void onMessage(Message msg) {

    }

   public void back(View view){
       finish();
   }

    private void loadNews(List<NewsBase> news){
        for(NewsBase n : news){
            switch (n.getType()){
                case NewsBase.TYPE_TXT:
                    TextNews textNews = (TextNews) n;
                    View textView = getLayoutInflater().inflate(R.layout.news_text,null);
                    TextView newsText = (TextView) textView.findViewById(R.id.txt);
                    newsText.setText(textNews.getContent());
                    contentParent.addView(textView);
                    break;
                case NewsBase.TYPE_IMAGE:
                    ImageNews imageNews = (ImageNews) n;
                    View imageView = getLayoutInflater().inflate(R.layout.news_image,null);
                    ImageView image= (ImageView) imageView.findViewById(R.id.img);
                    image.setImageResource(imageNews.getImage());
                    contentParent.addView(imageView);
                    break;
            }
        }
    }

    public void share(View view){
        new BottomShareDialog(this).builder().show();
    }
}
