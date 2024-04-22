public class Main {
    /**
     * método para devolver la puntuación de tenis
     */

    private static final int PUNTUACION_MAXIMA = 4;
    private static final String[] PUNTUACIONES_IGUALES = {"Love-All","Fifteen-All","Thirty-All", "Forty-All", "Deuce"};
    private static final String[] PUNTUACIONES_VENTAJA = {"Advantage player1", "Advantage player2", "Win for player1", "Win for player2"};
    private static final String[] PUNTUACIONES_DIFERENTES = {"Love", "Fifteen", "Thirty", "Forty"};

    private static String jugadoresConLaMismaPuntuacion(int puntuacion){
        return PUNTUACIONES_IGUALES[puntuacion];
    }

    private static String jugadorConMasPuntuacion(int minusResult){
        if (minusResult == 1)       return PUNTUACIONES_VENTAJA[0];
        else if (minusResult == -1) return PUNTUACIONES_VENTAJA[1];
        else if (minusResult >= 2)  return PUNTUACIONES_VENTAJA[2];
        else                        return PUNTUACIONES_VENTAJA[3];
    }

    private static String jugadorVentaja(int puntuacionTemporal, int puntuacionJugador1, int puntuacionJugador2){
        StringBuilder mensajeSalida = new StringBuilder();
        for (int i = 1; i < 3; i++) {
            if (i == 1){
                puntuacionTemporal = puntuacionJugador1;
            }
            else {
                mensajeSalida.append("-");
                puntuacionTemporal = puntuacionJugador2;
            }
            mensajeSalida.append(PUNTUACIONES_DIFERENTES[puntuacionTemporal]);
        }
        return mensajeSalida.toString();
    }


    public static String getScore(int puntuacionJugador1, int puntuacionJugador2) {
        String mensajeSalida = "";
        int tempScore = 0;

        if (puntuacionJugador1 == puntuacionJugador2) {
            mensajeSalida = jugadoresConLaMismaPuntuacion(puntuacionJugador1);
        } else if (puntuacionJugador1 >= PUNTUACION_MAXIMA || puntuacionJugador2 >= PUNTUACION_MAXIMA) {
            int resultadoMinimo = puntuacionJugador1 - puntuacionJugador2;
            mensajeSalida = jugadorConMasPuntuacion(resultadoMinimo);
        } else {
            mensajeSalida = jugadorVentaja(tempScore ,puntuacionJugador1, puntuacionJugador2);
        }
        return mensajeSalida;
    }


}