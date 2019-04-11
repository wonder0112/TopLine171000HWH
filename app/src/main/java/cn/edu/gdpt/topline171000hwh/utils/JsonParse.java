package cn.edu.gdpt.topline171000hwh.utils;

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

}
