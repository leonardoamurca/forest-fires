/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provatrabalho;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardoamurca
 */
public class AllBurns {

    private static AllBurns instance = null;

    private ArrayList<Stack<Burn>> monthlyBurns;
    private List<String> headers;

    private AllBurns() {
        monthlyBurns = new ArrayList<>();
        headers = new ArrayList<>();

        this.initializeStacks();
    }

    public void initializeStacks() {
        for (int i = 0; i < 12; i++) {
            monthlyBurns.add(i, new Stack<>());
        }
    }

    public static AllBurns getInstance() {

        if (instance == null) {
            instance = new AllBurns();
        }

        return instance;
    }

    public ArrayList<Stack<Burn>> getMonthlyBurns() {
        return monthlyBurns;
    }

    public void insertMonthlyBurns(Burn burn) {

        switch (burn.getMonth()) {
            case "jan":
                monthlyBurns.get(0).push(burn);
                break;
            case "feb":
                monthlyBurns.get(1).push(burn);
                break;
            case "mar":
                monthlyBurns.get(2).push(burn);
                break;
            case "apr":
                monthlyBurns.get(3).push(burn);
                break;
            case "may":
                monthlyBurns.get(4).push(burn);
                break;
            case "jun":
                monthlyBurns.get(5).push(burn);
                break;
            case "jul":
                monthlyBurns.get(6).push(burn);
                break;
            case "aug":
                monthlyBurns.get(7).push(burn);
                break;
            case "sep":
                monthlyBurns.get(8).push(burn);
                break;
            case "oct":
                monthlyBurns.get(9).push(burn);
                break;
            case "nov":
                monthlyBurns.get(10).push(burn);
                break;
            case "dec":
                monthlyBurns.get(11).push(burn);
                break;
            default:

        }
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;

    }

}
