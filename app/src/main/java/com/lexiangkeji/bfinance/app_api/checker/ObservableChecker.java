package com.lexiangkeji.bfinance.app_api.checker;

import android.databinding.Bindable;

public abstract class ObservableChecker extends ObservableModel implements IValidator,IFormValidator {

    public boolean enable;
    String oldContent;


    /**
     * initialize the content
     */
    public void setOldContent(String content){
        this.oldContent = content;
    }


    /**
     * return all the variable the object contains
     */
    public String getContent(){
        return null;
    }

    public void notifyEnable(){
        enable = checkEnable();
    }


    @Override
    public boolean isEdited() {
        return !getContent().equals(oldContent);
    }


    @Bindable
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public abstract boolean checkEnable();


    @Override
    public boolean isValidated() {
        return false;
    }

}
