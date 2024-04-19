public class Main {
    /**
     * método para devolver la puntuación de tenis
     */

    private static final int PUNTUACION_MAXIMA = 4;

    private static String jugadoresConLaMismaPuntuacion(int puntuacion){
        return switch (puntuacion){
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            case 3 -> "Forty-All";
            default -> "Deuce";
        };
    }

    private static String jugadorConMasPuntuacion(int minusResult){
        if (minusResult == 1)       return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2)  return "Win for player1";
        else                        return "Win for player2";
    }

    private static String jugadorVentaja(int tempScore, int puntuacionJugador1, int puntuacionJugador2){
        String mensajeSalida = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1){
                tempScore = puntuacionJugador1;
            }
            else {
                mensajeSalida += "-";
                tempScore = puntuacionJugador2;
            }
            switch (tempScore) {
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