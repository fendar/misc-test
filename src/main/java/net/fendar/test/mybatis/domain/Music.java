package net.fendar.test.mybatis.domain;

/**
 * Created by zhongchao on 16/4/12.
 */
public class Music {
    private int id;
    private String name;
    private String author;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
