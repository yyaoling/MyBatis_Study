package com.atguigu.mybatis.pojo;

public class Dept {
    private Integer did;
    private String depeName;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDepeName() {
        return depeName;
    }

    public void setDepeName(String depeName) {
        this.depeName = depeName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", depeName='" + depeName + '\'' +
                '}';
    }
}
