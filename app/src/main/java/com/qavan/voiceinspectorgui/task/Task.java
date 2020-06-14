package com.qavan.voiceinspectorgui.task;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(active = true, nameInDb = "TASKS")
public class Task {
    @Id
    private long task_id;
    //CLIENT INFO
    @NotNull     private long n_client_id;
    @NotNull     private String c_client_ls;
    @NotNull     private String c_client_fio;
    @NotNull     private String c_client_address;
    //NOTE
    @NotNull     private String c_client_note;
    //STATUS
    @NotNull     private int c_client_status;
    //NUMBERS OF SIGNERS
    @NotNull     private String c_gvs_id;
    @NotNull     private String c_hvs_id;
    @NotNull     private String c_ele_id;
    //GVS NIGHT
    @NotNull private String c_gvs_night_prev_value;
    @NotNull private String c_gvs_night_current_value;
    @NotNull private String c_gvs_night_prev_date;
    @NotNull private String c_gvs_night_current_date;
    //GVS PEAK
    @NotNull     private String c_gvs_peak_prev_value;
    @NotNull     private String c_gvs_peak_current_value;
    @NotNull     private String c_gvs_peak_prev_date;
    @NotNull     private String c_gvs_peak_current_date;
    //GVS HALF PEAK
    @NotNull     private String c_gvs_half_peak_prev_value;
    @NotNull     private String c_gvs_half_peak_current_value;
    @NotNull     private String c_gvs_half_peak_prev_date;
    @NotNull     private String c_gvs_half_peak_current_date;
    //HVS NIGHT
    @NotNull     private String c_hvs_night_prev_value;
    @NotNull     private String c_hvs_night_current_value;
    @NotNull     private String c_hvs_night_prev_date;
    @NotNull     private String c_hvs_night_current_date;
    //HVS PEAK
    @NotNull     private String c_hvs_peak_prev_value;
    @NotNull     private String c_hvs_peak_current_value;
    @NotNull     private String c_hvs_peak_prev_date;
    @NotNull     private String c_hvs_peak_current_date;
    //HVS HALF PEAK
    @NotNull     private String c_hvs_half_peak_prev_value;
    @NotNull     private String c_hvs_half_peak_current_value;
    @NotNull     private String c_hvs_half_peak_prev_date;
    @NotNull     private String c_hvs_half_peak_current_date;
    //ELECTRICITY NIGHT
    @NotNull     private String c_ele_night_prev_value;
    @NotNull     private String c_ele_night_current_value;
    @NotNull     private String c_ele_night_prev_date;
    @NotNull     private String c_ele_night_current_date;
    //ELECTRICITY PEAK
    @NotNull     private String c_ele_peak_prev_value;
    @NotNull     private String c_ele_peak_current_value;
    @NotNull     private String c_ele_peak_prev_date;
    @NotNull     private String c_ele_peak_current_date;
    //ELECTRICITY HALF PEAK
    @NotNull     private String c_ele_half_peak_prev_value;
    @NotNull     private String c_ele_half_peak_current_value;
    @NotNull     private String c_ele_half_peak_prev_date;
    @NotNull     private String c_ele_half_peak_current_date;

    public Task(long task_id, @NotNull String c_client_ls,
                @NotNull String c_client_fio, @NotNull String c_client_address,
                @NotNull String c_client_note, int c_client_status, @NotNull String c_gvs_id,
                @NotNull String c_hvs_id, @NotNull String c_ele_id,
                @NotNull String c_gvs_night_prev_value, @NotNull String c_gvs_night_current_value,
                @NotNull String c_gvs_night_prev_date, @NotNull String c_gvs_night_current_date,
                @NotNull String c_gvs_peak_prev_value, @NotNull String c_gvs_peak_current_value,
                @NotNull String c_gvs_peak_prev_date, @NotNull String c_gvs_peak_current_date,
                @NotNull String c_gvs_half_peak_prev_value,
                @NotNull String c_gvs_half_peak_current_value,
                @NotNull String c_gvs_half_peak_prev_date,
                @NotNull String c_gvs_half_peak_current_date,
                @NotNull String c_hvs_night_prev_value, @NotNull String c_hvs_night_current_value,
                @NotNull String c_hvs_night_prev_date, @NotNull String c_hvs_night_current_date,
                @NotNull String c_hvs_peak_prev_value, @NotNull String c_hvs_peak_current_value,
                @NotNull String c_hvs_peak_prev_date, @NotNull String c_hvs_peak_current_date,
                @NotNull String c_hvs_half_peak_prev_value,
                @NotNull String c_hvs_half_peak_current_value,
                @NotNull String c_hvs_half_peak_prev_date,
                @NotNull String c_hvs_half_peak_current_date,
                @NotNull String c_ele_night_prev_value, @NotNull String c_ele_night_current_value,
                @NotNull String c_ele_night_prev_date, @NotNull String c_ele_night_current_date,
                @NotNull String c_ele_peak_prev_value, @NotNull String c_ele_peak_current_value,
                @NotNull String c_ele_peak_prev_date, @NotNull String c_ele_peak_current_date,
                @NotNull String c_ele_half_peak_prev_value,
                @NotNull String c_ele_half_peak_current_value,
                @NotNull String c_ele_half_peak_prev_date,
                @NotNull String c_ele_half_peak_current_date) {
        this.task_id = task_id;
        this.n_client_id = n_client_id;
        this.c_client_ls = c_client_ls;
        this.c_client_fio = c_client_fio;
        this.c_client_address = c_client_address;
        this.c_client_note = c_client_note;
        this.c_client_status = c_client_status;
        this.c_gvs_id = c_gvs_id;
        this.c_hvs_id = c_hvs_id;
        this.c_ele_id = c_ele_id;
        this.c_gvs_night_prev_value = c_gvs_night_prev_value;
        this.c_gvs_night_current_value = c_gvs_night_current_value;
        this.c_gvs_night_prev_date = c_gvs_night_prev_date;
        this.c_gvs_night_current_date = c_gvs_night_current_date;
        this.c_gvs_peak_prev_value = c_gvs_peak_prev_value;
        this.c_gvs_peak_current_value = c_gvs_peak_current_value;
        this.c_gvs_peak_prev_date = c_gvs_peak_prev_date;
        this.c_gvs_peak_current_date = c_gvs_peak_current_date;
        this.c_gvs_half_peak_prev_value = c_gvs_half_peak_prev_value;
        this.c_gvs_half_peak_current_value = c_gvs_half_peak_current_value;
        this.c_gvs_half_peak_prev_date = c_gvs_half_peak_prev_date;
        this.c_gvs_half_peak_current_date = c_gvs_half_peak_current_date;
        this.c_hvs_night_prev_value = c_hvs_night_prev_value;
        this.c_hvs_night_current_value = c_hvs_night_current_value;
        this.c_hvs_night_prev_date = c_hvs_night_prev_date;
        this.c_hvs_night_current_date = c_hvs_night_current_date;
        this.c_hvs_peak_prev_value = c_hvs_peak_prev_value;
        this.c_hvs_peak_current_value = c_hvs_peak_current_value;
        this.c_hvs_peak_prev_date = c_hvs_peak_prev_date;
        this.c_hvs_peak_current_date = c_hvs_peak_current_date;
        this.c_hvs_half_peak_prev_value = c_hvs_half_peak_prev_value;
        this.c_hvs_half_peak_current_value = c_hvs_half_peak_current_value;
        this.c_hvs_half_peak_prev_date = c_hvs_half_peak_prev_date;
        this.c_hvs_half_peak_current_date = c_hvs_half_peak_current_date;
        this.c_ele_night_prev_value = c_ele_night_prev_value;
        this.c_ele_night_current_value = c_ele_night_current_value;
        this.c_ele_night_prev_date = c_ele_night_prev_date;
        this.c_ele_night_current_date = c_ele_night_current_date;
        this.c_ele_peak_prev_value = c_ele_peak_prev_value;
        this.c_ele_peak_current_value = c_ele_peak_current_value;
        this.c_ele_peak_prev_date = c_ele_peak_prev_date;
        this.c_ele_peak_current_date = c_ele_peak_current_date;
        this.c_ele_half_peak_prev_value = c_ele_half_peak_prev_value;
        this.c_ele_half_peak_current_value = c_ele_half_peak_current_value;
        this.c_ele_half_peak_prev_date = c_ele_half_peak_prev_date;
        this.c_ele_half_peak_current_date = c_ele_half_peak_current_date;
    }

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1469429066)
    private transient TaskDao myDao;
    @Generated(hash = 311966831)
    public Task(long task_id, long n_client_id, @NotNull String c_client_ls,
            @NotNull String c_client_fio, @NotNull String c_client_address,
            @NotNull String c_client_note, int c_client_status, @NotNull String c_gvs_id,
            @NotNull String c_hvs_id, @NotNull String c_ele_id,
            @NotNull String c_gvs_night_prev_value, @NotNull String c_gvs_night_current_value,
            @NotNull String c_gvs_night_prev_date, @NotNull String c_gvs_night_current_date,
            @NotNull String c_gvs_peak_prev_value, @NotNull String c_gvs_peak_current_value,
            @NotNull String c_gvs_peak_prev_date, @NotNull String c_gvs_peak_current_date,
            @NotNull String c_gvs_half_peak_prev_value,
            @NotNull String c_gvs_half_peak_current_value,
            @NotNull String c_gvs_half_peak_prev_date,
            @NotNull String c_gvs_half_peak_current_date,
            @NotNull String c_hvs_night_prev_value, @NotNull String c_hvs_night_current_value,
            @NotNull String c_hvs_night_prev_date, @NotNull String c_hvs_night_current_date,
            @NotNull String c_hvs_peak_prev_value, @NotNull String c_hvs_peak_current_value,
            @NotNull String c_hvs_peak_prev_date, @NotNull String c_hvs_peak_current_date,
            @NotNull String c_hvs_half_peak_prev_value,
            @NotNull String c_hvs_half_peak_current_value,
            @NotNull String c_hvs_half_peak_prev_date,
            @NotNull String c_hvs_half_peak_current_date,
            @NotNull String c_ele_night_prev_value, @NotNull String c_ele_night_current_value,
            @NotNull String c_ele_night_prev_date, @NotNull String c_ele_night_current_date,
            @NotNull String c_ele_peak_prev_value, @NotNull String c_ele_peak_current_value,
            @NotNull String c_ele_peak_prev_date, @NotNull String c_ele_peak_current_date,
            @NotNull String c_ele_half_peak_prev_value,
            @NotNull String c_ele_half_peak_current_value,
            @NotNull String c_ele_half_peak_prev_date,
            @NotNull String c_ele_half_peak_current_date) {
        this.task_id = task_id;
        this.n_client_id = n_client_id;
        this.c_client_ls = c_client_ls;
        this.c_client_fio = c_client_fio;
        this.c_client_address = c_client_address;
        this.c_client_note = c_client_note;
        this.c_client_status = c_client_status;
        this.c_gvs_id = c_gvs_id;
        this.c_hvs_id = c_hvs_id;
        this.c_ele_id = c_ele_id;
        this.c_gvs_night_prev_value = c_gvs_night_prev_value;
        this.c_gvs_night_current_value = c_gvs_night_current_value;
        this.c_gvs_night_prev_date = c_gvs_night_prev_date;
        this.c_gvs_night_current_date = c_gvs_night_current_date;
        this.c_gvs_peak_prev_value = c_gvs_peak_prev_value;
        this.c_gvs_peak_current_value = c_gvs_peak_current_value;
        this.c_gvs_peak_prev_date = c_gvs_peak_prev_date;
        this.c_gvs_peak_current_date = c_gvs_peak_current_date;
        this.c_gvs_half_peak_prev_value = c_gvs_half_peak_prev_value;
        this.c_gvs_half_peak_current_value = c_gvs_half_peak_current_value;
        this.c_gvs_half_peak_prev_date = c_gvs_half_peak_prev_date;
        this.c_gvs_half_peak_current_date = c_gvs_half_peak_current_date;
        this.c_hvs_night_prev_value = c_hvs_night_prev_value;
        this.c_hvs_night_current_value = c_hvs_night_current_value;
        this.c_hvs_night_prev_date = c_hvs_night_prev_date;
        this.c_hvs_night_current_date = c_hvs_night_current_date;
        this.c_hvs_peak_prev_value = c_hvs_peak_prev_value;
        this.c_hvs_peak_current_value = c_hvs_peak_current_value;
        this.c_hvs_peak_prev_date = c_hvs_peak_prev_date;
        this.c_hvs_peak_current_date = c_hvs_peak_current_date;
        this.c_hvs_half_peak_prev_value = c_hvs_half_peak_prev_value;
        this.c_hvs_half_peak_current_value = c_hvs_half_peak_current_value;
        this.c_hvs_half_peak_prev_date = c_hvs_half_peak_prev_date;
        this.c_hvs_half_peak_current_date = c_hvs_half_peak_current_date;
        this.c_ele_night_prev_value = c_ele_night_prev_value;
        this.c_ele_night_current_value = c_ele_night_current_value;
        this.c_ele_night_prev_date = c_ele_night_prev_date;
        this.c_ele_night_current_date = c_ele_night_current_date;
        this.c_ele_peak_prev_value = c_ele_peak_prev_value;
        this.c_ele_peak_current_value = c_ele_peak_current_value;
        this.c_ele_peak_prev_date = c_ele_peak_prev_date;
        this.c_ele_peak_current_date = c_ele_peak_current_date;
        this.c_ele_half_peak_prev_value = c_ele_half_peak_prev_value;
        this.c_ele_half_peak_current_value = c_ele_half_peak_current_value;
        this.c_ele_half_peak_prev_date = c_ele_half_peak_prev_date;
        this.c_ele_half_peak_current_date = c_ele_half_peak_current_date;
    }
    @Generated(hash = 733837707)
    public Task() {
    }
    public long getTask_id() {
        return this.task_id;
    }
    public void setTask_id(long task_id) {
        this.task_id = task_id;
    }
    public long getN_client_id() {
        return this.n_client_id;
    }
    public void setN_client_id(long n_client_id) {
        this.n_client_id = n_client_id;
    }
    public String getC_client_ls() {
        return this.c_client_ls;
    }
    public void setC_client_ls(String c_client_ls) {
        this.c_client_ls = c_client_ls;
    }
    public String getC_client_fio() {
        return this.c_client_fio;
    }
    public void setC_client_fio(String c_client_fio) {
        this.c_client_fio = c_client_fio;
    }
    public String getC_client_address() {
        return this.c_client_address;
    }
    public void setC_client_address(String c_client_address) {
        this.c_client_address = c_client_address;
    }
    public String getC_client_note() {
        return this.c_client_note;
    }
    public void setC_client_note(String c_client_note) {
        this.c_client_note = c_client_note;
    }
    public int getC_client_status() {
        return this.c_client_status;
    }
    public void setC_client_status(int c_client_status) {
        this.c_client_status = c_client_status;
    }
    public String getC_gvs_night_prev_value() {
        return this.c_gvs_night_prev_value;
    }
    public void setC_gvs_night_prev_value(String c_gvs_night_prev_value) {
        this.c_gvs_night_prev_value = c_gvs_night_prev_value;
    }
    public String getC_gvs_night_current_value() {
        return this.c_gvs_night_current_value;
    }
    public void setC_gvs_night_current_value(String c_gvs_night_current_value) {
        this.c_gvs_night_current_value = c_gvs_night_current_value;
    }
    public String getC_gvs_night_prev_date() {
        return this.c_gvs_night_prev_date;
    }
    public void setC_gvs_night_prev_date(String c_gvs_night_prev_date) {
        this.c_gvs_night_prev_date = c_gvs_night_prev_date;
    }
    public String getC_gvs_night_current_date() {
        return this.c_gvs_night_current_date;
    }
    public void setC_gvs_night_current_date(String c_gvs_night_current_date) {
        this.c_gvs_night_current_date = c_gvs_night_current_date;
    }
    public String getC_gvs_peak_prev_value() {
        return this.c_gvs_peak_prev_value;
    }
    public void setC_gvs_peak_prev_value(String c_gvs_peak_prev_value) {
        this.c_gvs_peak_prev_value = c_gvs_peak_prev_value;
    }
    public String getC_gvs_peak_current_value() {
        return this.c_gvs_peak_current_value;
    }
    public void setC_gvs_peak_current_value(String c_gvs_peak_current_value) {
        this.c_gvs_peak_current_value = c_gvs_peak_current_value;
    }
    public String getC_gvs_peak_prev_date() {
        return this.c_gvs_peak_prev_date;
    }
    public void setC_gvs_peak_prev_date(String c_gvs_peak_prev_date) {
        this.c_gvs_peak_prev_date = c_gvs_peak_prev_date;
    }
    public String getC_gvs_peak_current_date() {
        return this.c_gvs_peak_current_date;
    }
    public void setC_gvs_peak_current_date(String c_gvs_peak_current_date) {
        this.c_gvs_peak_current_date = c_gvs_peak_current_date;
    }
    public String getC_gvs_half_peak_prev_value() {
        return this.c_gvs_half_peak_prev_value;
    }
    public void setC_gvs_half_peak_prev_value(String c_gvs_half_peak_prev_value) {
        this.c_gvs_half_peak_prev_value = c_gvs_half_peak_prev_value;
    }
    public String getC_gvs_half_peak_current_value() {
        return this.c_gvs_half_peak_current_value;
    }
    public void setC_gvs_half_peak_current_value(
            String c_gvs_half_peak_current_value) {
        this.c_gvs_half_peak_current_value = c_gvs_half_peak_current_value;
    }
    public String getC_gvs_half_peak_prev_date() {
        return this.c_gvs_half_peak_prev_date;
    }
    public void setC_gvs_half_peak_prev_date(String c_gvs_half_peak_prev_date) {
        this.c_gvs_half_peak_prev_date = c_gvs_half_peak_prev_date;
    }
    public String getC_gvs_half_peak_current_date() {
        return this.c_gvs_half_peak_current_date;
    }
    public void setC_gvs_half_peak_current_date(
            String c_gvs_half_peak_current_date) {
        this.c_gvs_half_peak_current_date = c_gvs_half_peak_current_date;
    }
    public String getC_hvs_night_prev_value() {
        return this.c_hvs_night_prev_value;
    }
    public void setC_hvs_night_prev_value(String c_hvs_night_prev_value) {
        this.c_hvs_night_prev_value = c_hvs_night_prev_value;
    }
    public String getC_hvs_night_current_value() {
        return this.c_hvs_night_current_value;
    }
    public void setC_hvs_night_current_value(String c_hvs_night_current_value) {
        this.c_hvs_night_current_value = c_hvs_night_current_value;
    }
    public String getC_hvs_night_prev_date() {
        return this.c_hvs_night_prev_date;
    }
    public void setC_hvs_night_prev_date(String c_hvs_night_prev_date) {
        this.c_hvs_night_prev_date = c_hvs_night_prev_date;
    }
    public String getC_hvs_night_current_date() {
        return this.c_hvs_night_current_date;
    }
    public void setC_hvs_night_current_date(String c_hvs_night_current_date) {
        this.c_hvs_night_current_date = c_hvs_night_current_date;
    }
    public String getC_hvs_peak_prev_value() {
        return this.c_hvs_peak_prev_value;
    }
    public void setC_hvs_peak_prev_value(String c_hvs_peak_prev_value) {
        this.c_hvs_peak_prev_value = c_hvs_peak_prev_value;
    }
    public String getC_hvs_peak_current_value() {
        return this.c_hvs_peak_current_value;
    }
    public void setC_hvs_peak_current_value(String c_hvs_peak_current_value) {
        this.c_hvs_peak_current_value = c_hvs_peak_current_value;
    }
    public String getC_hvs_peak_prev_date() {
        return this.c_hvs_peak_prev_date;
    }
    public void setC_hvs_peak_prev_date(String c_hvs_peak_prev_date) {
        this.c_hvs_peak_prev_date = c_hvs_peak_prev_date;
    }
    public String getC_hvs_peak_current_date() {
        return this.c_hvs_peak_current_date;
    }
    public void setC_hvs_peak_current_date(String c_hvs_peak_current_date) {
        this.c_hvs_peak_current_date = c_hvs_peak_current_date;
    }
    public String getC_hvs_half_peak_prev_value() {
        return this.c_hvs_half_peak_prev_value;
    }
    public void setC_hvs_half_peak_prev_value(String c_hvs_half_peak_prev_value) {
        this.c_hvs_half_peak_prev_value = c_hvs_half_peak_prev_value;
    }
    public String getC_hvs_half_peak_current_value() {
        return this.c_hvs_half_peak_current_value;
    }
    public void setC_hvs_half_peak_current_value(
            String c_hvs_half_peak_current_value) {
        this.c_hvs_half_peak_current_value = c_hvs_half_peak_current_value;
    }
    public String getC_hvs_half_peak_prev_date() {
        return this.c_hvs_half_peak_prev_date;
    }
    public void setC_hvs_half_peak_prev_date(String c_hvs_half_peak_prev_date) {
        this.c_hvs_half_peak_prev_date = c_hvs_half_peak_prev_date;
    }
    public String getC_hvs_half_peak_current_date() {
        return this.c_hvs_half_peak_current_date;
    }
    public void setC_hvs_half_peak_current_date(
            String c_hvs_half_peak_current_date) {
        this.c_hvs_half_peak_current_date = c_hvs_half_peak_current_date;
    }
    public String getC_ele_night_prev_value() {
        return this.c_ele_night_prev_value;
    }
    public void setC_ele_night_prev_value(String c_ele_night_prev_value) {
        this.c_ele_night_prev_value = c_ele_night_prev_value;
    }
    public String getC_ele_night_current_value() {
        return this.c_ele_night_current_value;
    }
    public void setC_ele_night_current_value(String c_ele_night_current_value) {
        this.c_ele_night_current_value = c_ele_night_current_value;
    }
    public String getC_ele_night_prev_date() {
        return this.c_ele_night_prev_date;
    }
    public void setC_ele_night_prev_date(String c_ele_night_prev_date) {
        this.c_ele_night_prev_date = c_ele_night_prev_date;
    }
    public String getC_ele_night_current_date() {
        return this.c_ele_night_current_date;
    }
    public void setC_ele_night_current_date(String c_ele_night_current_date) {
        this.c_ele_night_current_date = c_ele_night_current_date;
    }
    public String getC_ele_peak_prev_value() {
        return this.c_ele_peak_prev_value;
    }
    public void setC_ele_peak_prev_value(String c_ele_peak_prev_value) {
        this.c_ele_peak_prev_value = c_ele_peak_prev_value;
    }
    public String getC_ele_peak_current_value() {
        return this.c_ele_peak_current_value;
    }
    public void setC_ele_peak_current_value(String c_ele_peak_current_value) {
        this.c_ele_peak_current_value = c_ele_peak_current_value;
    }
    public String getC_ele_peak_prev_date() {
        return this.c_ele_peak_prev_date;
    }
    public void setC_ele_peak_prev_date(String c_ele_peak_prev_date) {
        this.c_ele_peak_prev_date = c_ele_peak_prev_date;
    }
    public String getC_ele_peak_current_date() {
        return this.c_ele_peak_current_date;
    }
    public void setC_ele_peak_current_date(String c_ele_peak_current_date) {
        this.c_ele_peak_current_date = c_ele_peak_current_date;
    }
    public String getC_ele_half_peak_prev_value() {
        return this.c_ele_half_peak_prev_value;
    }
    public void setC_ele_half_peak_prev_value(String c_ele_half_peak_prev_value) {
        this.c_ele_half_peak_prev_value = c_ele_half_peak_prev_value;
    }
    public String getC_ele_half_peak_current_value() {
        return this.c_ele_half_peak_current_value;
    }
    public void setC_ele_half_peak_current_value(
            String c_ele_half_peak_current_value) {
        this.c_ele_half_peak_current_value = c_ele_half_peak_current_value;
    }
    public String getC_ele_half_peak_prev_date() {
        return this.c_ele_half_peak_prev_date;
    }
    public void setC_ele_half_peak_prev_date(String c_ele_half_peak_prev_date) {
        this.c_ele_half_peak_prev_date = c_ele_half_peak_prev_date;
    }
    public String getC_ele_half_peak_current_date() {
        return this.c_ele_half_peak_current_date;
    }
    public void setC_ele_half_peak_current_date(
            String c_ele_half_peak_current_date) {
        this.c_ele_half_peak_current_date = c_ele_half_peak_current_date;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    public String getC_gvs_id() {
        return this.c_gvs_id;
    }
    public void setC_gvs_id(String c_gvs_id) {
        this.c_gvs_id = c_gvs_id;
    }
    public String getC_hvs_id() {
        return this.c_hvs_id;
    }
    public void setC_hvs_id(String c_hvs_id) {
        this.c_hvs_id = c_hvs_id;
    }
    public String getC_ele_id() {
        return this.c_ele_id;
    }
    public void setC_ele_id(String c_ele_id) {
        this.c_ele_id = c_ele_id;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1442741304)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTaskDao() : null;
    }
}
