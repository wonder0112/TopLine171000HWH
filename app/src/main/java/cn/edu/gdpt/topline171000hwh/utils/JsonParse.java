package cn.edu.gdpt.topline171000hwh.utils;

import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.edu.gdpt.topline171000hwh.bean.NewsBean;

public class JsonParse {//单例模式 单个对象（对象产生：构造方法）
    public static JsonParse instance=getInstance();
    private JsonParse() {//构造方法私有化，类外部不能调用，就是不能创建对象
    }
    public static JsonParse getInstance(){
        if(instance==null){
            instance=new JsonParse();
        }
        return instance;
    }
     public List<NewsBean> getAdList(String json){
          Gson gson=new Gson();
          Type listType=new TypeToken<List<NewsBean>>(){
         }.getType();

          List<NewsBean> adList=gson.fromJson(json,listType);
          return adList;
     }


}
