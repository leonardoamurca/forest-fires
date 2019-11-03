/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provatrabalho;

/**
 *
 * @author leonardoamurca
 */
public class Burn {

    private Integer x;
    private Integer y;
    private String month;
    private String day;
    private Double ffmc;
    private Double dmc;
    private Double dc;
    private Double isi;
    private Double temp;
    private Integer rh;
    private Double wind;
    private Double rain;
    private Double area;

    public Burn(Integer x, Integer y, String month, String day, Double ffmc, Double dmc, Double dc, Double isi, Double temp, Integer rh, Double wind, Double rain, Double area) {
        this.x = x;
        this.y = y;
        this.month = month;
        this.day = day;
        this.ffmc = ffmc;
        this.dmc = dmc;
        this.dc = dc;
        this.isi = isi;
        this.temp = temp;
        this.rh = rh;
        this.wind = wind;
        this.rain = rain;
        this.area = area;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public Double getFfmc() {
        return ffmc;
    }

    public Double getDmc() {
        return dmc;
    }

    public Double getDc() {
        return dc;
    }

    public Double getIsi() {
        return isi;
    }

    public Double getTemp() {
        return temp;
    }

    public Integer getRh() {
        return rh;
    }

    public Double getWind() {
        return wind;
    }

    public Double getRain() {
        return rain;
    }

    public Double getArea() {
        return area;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setFfmc(Double ffmc) {
        this.ffmc = ffmc;
    }

    public void setDmc(Double dmc) {
        this.dmc = dmc;
    }

    public void setDc(Double dc) {
        this.dc = dc;
    }

    public void setIsi(Double isi) {
        this.isi = isi;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public void setRh(Integer rh) {
        this.rh = rh;
    }

    public void setWind(Double wind) {
        this.wind = wind;
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Burn{" + "x=" + x + ", y=" + y + ", month=" + month + ", day=" + day + ", ffmc=" + ffmc + ", dmc=" + dmc + ", dc=" + dc + ", isi=" + isi + ", temp=" + temp + ", rh=" + rh + ", wind=" + wind + ", rain=" + rain + ", area=" + area + '}';
    }

}
