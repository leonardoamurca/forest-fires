/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provatrabalho;

import java.util.Arrays;

/**
 *
 * @author leonardoamurca
 */
public class BurnX7to9 extends Burn {

    public BurnX7to9(Integer x, Integer y, String month, String day, Double ffmc, Double dmc, Double dc, Double isi, Double temp, Integer rh, Double wind, Double rain, Double area) throws Exception {
        super(x, y, month, day, ffmc, dmc, dc, isi, temp, rh, wind, rain, area);

        try {
            if (x < 7 && x > 9) {
                throw new WrongCoordinateException("Objeto fora intervalo de X! (x >= 7 e x <= 9)");
            }
        } catch (WrongCoordinateException e) {
            LogWriter.writeFileTXT(Arrays.toString(e.getStackTrace()));
        }
    }

}
