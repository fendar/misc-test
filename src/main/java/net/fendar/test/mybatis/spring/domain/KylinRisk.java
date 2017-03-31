package net.fendar.test.mybatis.spring.domain;

/**
 * Created by zhongchao on 16/6/3.
 */
public class KylinRisk {
    private String recipientPhone;
    private long wmPoiId;

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public long getWmPoiId() {
        return wmPoiId;
    }

    public void setWmPoiId(long wmPoiId) {
        this.wmPoiId = wmPoiId;
    }

    @Override
    public String toString() {
        return "KylinRisk{" +
                "recipientPhone='" + recipientPhone + '\'' +
                ", wmPoiId=" + wmPoiId +
                '}';
    }
}
