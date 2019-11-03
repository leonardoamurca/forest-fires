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
public class BurnX4to6 extends Burn {

    public BurnX4to6(Integer x, Integer y, String month, String day, Double ffmc, Double dmc, Double dc, Double isi, Double temp, Integer rh, Double wind, Double rain, Double area) throws Exception {
        super(x, y, month, day, ffmc, dmc, dc, isi, temp, rh, wind, rain, area);

        try {
            if (x < 4 && x > 6) {
                throw new WrongCoordinateException("Objeto fora intervalo de X! (x >= 4 e x <= 6)");
            }
        } catch (WrongCoordinateException e) {
            LogWriter.writeFileTXT(Arrays.toString(e.getStackTrace()));
        }
    }

}
