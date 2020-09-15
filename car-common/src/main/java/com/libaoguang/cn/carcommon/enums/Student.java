package com.libaoguang.cn.carcommon.enums;

public enum Student {
    MONDAY(1, "星期一", "星期一各种不在状态"),
    TUESDAY(2, "星期二", "星期二依旧犯困"),
    WEDNESDAY(3, "星期三", "星期三感觉半周终于过去了"),
    THURSDAY(4, "星期四", "星期四期待这星期五"),
    FRIDAY(5, "星期五", "星期五感觉还不错"),
    SATURDAY(6, "星期六", "星期六感觉非常好"),
    SUNDAY(7, "星期日", "星期日感觉周末还没过够。。。");

    Student(int index, String name, String value) {
        this.index = index;
        this.name = name;
        this.value = value;
    }

    private int index;
    private String name;
    private String value;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
