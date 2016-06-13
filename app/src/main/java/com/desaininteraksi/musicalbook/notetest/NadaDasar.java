package com.desaininteraksi.musicalbook.notetest;

/**
 * Created by Yusfia Hafid A on 4/23/2015.
 */
public class NadaDasar {
    private String nama_not;
    private int oktaf;
    private double frekuensi_bawah;
    private double net_val;
    private double frekuensi_atas;

    public NadaDasar()
    {

    }

    public NadaDasar(String name, int oktaf, double lower_bound, double net,double upper_bound)
    {
        this.nama_not = name;
        this.oktaf = oktaf;
        this.frekuensi_bawah = lower_bound;
        this.net_val = net;
        this.frekuensi_atas = upper_bound;
    }

    public void setNamaNot(String name)
    {
        this.nama_not = name;
    }

    public String getNama()
    {
        return nama_not;
    }

    public void setLowerBound(double lower_bound)
    {
        this.frekuensi_bawah = lower_bound;
    }

    public double getLowerBound()
    {
        return this.frekuensi_bawah;
    }

    public void setUpperBound(double upper_bound)
    {
        this.frekuensi_atas = upper_bound;
    }

    public double getUpperBound(){
        return this.frekuensi_atas;
    }

    public void setOktaf(int o)
    {
        this.oktaf = o;
    }

    public int getOktaf()
    {
        return oktaf;
    }

    public void setNet_val(double o)
    {
        this.net_val = o;
    }

    public double getNet_val()
    {
        return this.net_val;
    }
}
