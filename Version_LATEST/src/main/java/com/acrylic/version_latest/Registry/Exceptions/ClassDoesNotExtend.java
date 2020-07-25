package com.acrylic.version_latest.Registry.Exceptions;

public class ClassDoesNotExtend extends Exception{

    private String classToExtend;
    private String issue;

    public ClassDoesNotExtend(String issue, String classToExtend) {
        this.classToExtend = classToExtend;
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "Class does not extend " + classToExtend + ". " + issue;
    }
}
