public class Main {
    /**
     * método para devolver la puntuación de tenis
     */

    private static final int PUNTUACION_MAXIMA = 4;
    private static final String[] PUNTUACIONES_IGUALES = {"Love-All","Fifteen-All","Thirty-All", "Forty-All", "Deuce"};
    private static final String[] PUNTUACIONES_DIFERENTES = {"Advantage player1", "Advantage player2", "Win for player1", "Win for player2"};

    private static String jugadoresConLaMismaPuntuacion(int puntuacion){
        return PUNTUACIONES_IGUALES[puntuacion];
    }

    private static String jugadorConMasPuntuacion(int minusResult){
        if (minusResult == 1)       return PUNTUACIONES_DIFERENTES[0];
        else if (minusResult == -1) return PUNTUACIONES_DIFERENTES[1];
        else if (minusResult >= 2)  return PUNTUACIONES_DIFERENTES[2];
        else                        return PUNTUACIONES_DIFERENTES[3];
    }

    private static String jugadorVentaja(int puntuacionTemporal, int puntuacionJugador1, int puntuacionJugador2){
        String mensajeSalida = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1){
                puntuacionTemporal = puntuacionJugador1;
            }
            else {
                mensajeSalida += "-";
                puntuacionTemporal = puntuacionJugador2;
            }
            switch (puntuacionTemporal) {
                case 0:
                    mensajeSalida += "Love";
                    break;
                case 1:
                    mensajeSalida += "Fifteen";
                    break;
                case 2:
                    mensajeSalida += "Thirty";
                    break;
                case 3:
                    mensajeSalida += "Forty";
                    break;
            }
        }
        return mensajeSalida;
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