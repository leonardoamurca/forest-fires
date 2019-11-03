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
public class ProvaTrabalho {

    public static void main(String[] args) throws Exception {
        FileHandler file = new FileHandler();

        file.getDataAndSave();

        file.generateReport("monthly-burns");
        file.generateReport("get-burns-qtd-by-day-of-the-week");

    }

}
