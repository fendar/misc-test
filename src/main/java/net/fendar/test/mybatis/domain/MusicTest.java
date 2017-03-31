package net.fendar.test.mybatis.domain;

/**
 * Created by zhongchao on 16/4/5.
 */
public class MusicTest {
    private int id;
    private String preName;
    private String preAuthor;

    public int getId() {
        return id;
    }

    public MusicTest setId(int id) {
        this.id = id;
        return this;
    }

    public String getPreName() {
        return preName;
    }

    public MusicTest setPreName(String preName) {
        this.preName = preName;
        return this;
    }

    public String getPreAuthor() {
        return preAuthor;
    }

    public MusicTest setPreAuthor(String preAuthor) {
        this.preAuthor = preAuthor;
        return this;
    }

    @Override
    public String toString() {
        return "MusicTest{" +
                "preName='" + preName + '\'' +
                ", preAuthor='" + preAuthor + '\'' +
                '}';
    }
}
