package com.gu.cheng.talklife.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Guangcheng.Zhang on 2016/6/5 17:01.
 * Email:zhang411988153@163.com
 */
public class NewsBean implements Parcelable{


    private String title;
    private String content;
    private String img_width;
    private String full_title;
    private String pdate;
    private String src;
    private String img_length;
    private String img;
    private String url;
    private String pdate_src;

    /**
     * 必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
     * @param in
     */
    protected NewsBean(Parcel in) {
        title = in.readString();
        content = in.readString();
        img_width = in.readString();
        full_title = in.readString();
        pdate = in.readString();
        src = in.readString();
        img_length = in.readString();
        img = in.readString();
        url = in.readString();
        pdate_src = in.readString();
    }


    /**
     *  1.必须实现Parcelable.Creator接口,否则在获取Person数据的时候，会报错，如下：
     *   android.os.BadParcelableException:
     *  Parcelable protocol requires a Parcelable.Creator object called  CREATOR on class com.um.demo.Person
     *  2.这个接口实现了从Percel容器读取Person数据，并返回Person对象给逻辑层使用
     *  3.实现Parcelable.Creator接口对象名必须为CREATOR，不如同样会报错上面所提到的错；
     *  4.在读取Parcel容器里的数据事，必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
     *  5.反序列化对象
     */
    public static final Creator<NewsBean> CREATOR = new Creator<NewsBean>() {
        @Override
        public NewsBean createFromParcel(Parcel in) {
            return new NewsBean(in);
        }

        @Override
        public NewsBean[] newArray(int size) {
            return new NewsBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     *
     * 1.必须按成员变量声明的顺序封装数据，不然会出现获取数据出错
     * 2.序列化对象
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(img_width);
        dest.writeString(full_title);
        dest.writeString(pdate);
        dest.writeString(src);
        dest.writeString(img_length);
        dest.writeString(img);
        dest.writeString(url);
        dest.writeString(pdate_src);
    }

    public boolean isEmpty(){
        return (title == null || "".equals(title))
                &&(content == null || "".equals(content))
                &&(img_width == null || "".equals(img_width))
                && (full_title == null || "".equals(full_title))
                &&(pdate == null || "".equals(pdate))
                &&(src == null || "".equals(src))
                &&(img_length == null || "".equals(img_length))
                &&(img == null || "".equals(img))
                &&(url == null || "".equals(url))
                &&(pdate_src == null || "".equals(pdate_src));
    }

    @Override
    public String toString() {
        return "News with title "+full_title;
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImg_width() {
        return img_width;
    }

    public String getFull_title() {
        return full_title;
    }

    public String getPdate() {
        return pdate;
    }

    public String getSrc() {
        return src;
    }

    public String getImg_length() {
        return img_length;
    }

    public String getImg() {
        return img;
    }

    public String getUrl() {
        return url;
    }

    public String getPdate_src() {
        return pdate_src;
    }

}
