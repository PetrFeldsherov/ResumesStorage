package com.by.petrfeldsherov.resumes.ui;

public enum ConsoleCommandFormat {
    LIST("list", 1), SIZE("size", 1), SAVE("save", 2), DELETE("delete", 2), GET("get", 2), CLEAR("clear", 1);

    private String keyWord;
    private int minArguments;
    private int maxArguments;

    private ConsoleCommandFormat(String keyWord, int minArguments, int maxArguments) {
	this.keyWord = keyWord;
	this.minArguments = minArguments;
	this.maxArguments = maxArguments;
    }

    private ConsoleCommandFormat(String keyWord, int minMaxArguments) {
	this(keyWord, minMaxArguments, minMaxArguments);
    }

    public String getKeyWord() {
	return keyWord;
    }

    public boolean parametersAreValid(String[] commandParameters) {
	return commandParameters.length + 1 >= minArguments && commandParameters.length + 1 <= maxArguments;
    }

}
