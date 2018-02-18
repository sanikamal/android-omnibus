package com.ruatech.sanikamal.welcomemessage;

import java.util.Date;

/**
 * Created by Sani Kamal on 13-Jan-18.
 */

public class ItemList {
    private String wish;
    private Date date;

    public ItemList(String wish, Date date) {
        super();
        this.wish = wish;
        this.date = date;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
