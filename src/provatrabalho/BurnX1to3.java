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
public class BurnX1to3 extends Burn {

    public BurnX1to3(Integer x, Integer y, String month, String day, Double ffmc, Double dmc, Double dc, Double isi, Double temp, Integer rh, Double wind, Double rain, Double area) throws Exception {
        super(x, y, month, day, ffmc, dmc, dc, isi, temp, rh, wind, rain, area);

        try {
            if (x < 1 && x > 3) {
                throw new WrongCoordinateException("Objeto fora intervalo de X! (x >= 1 e x <= 3)");
            }
        } catch (WrongCoordinateException e) {
            LogWriter.writeFileTXT(Arrays.toString(e.getStackTrace()));
        }
    }

}
