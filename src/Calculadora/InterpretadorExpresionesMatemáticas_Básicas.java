package calculadora;

import java.text.DecimalFormat;

public class InterpretadorExpresionesMatemáticas_Básicas {

    public static void main(String[] args) {
        String expresión = "-3+20/2+1";
        String Resultado = Interpretar(expresión);
        System.out.println("Interpretación: " + Resultado + " de: " + expresión);
        double d = Double.parseDouble(Resultado);
        System.out.println("Número: " + d);
    }

    public static String Interpretar(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            return "0";
        }
        String[] agrupadores = {
            "(", ")", "[", "]", "{", "}"
        };
        for (String agrupador : agrupadores) {
            if (cadena.contains(agrupador)) {
                throw new RuntimeException(
                        "El interpretador no reconoce expresiones con agrupaciones, es muy básico"
                );
            }
        }
        cadena = cadena
                .replace("+-", "-")
                .replace("-+", "-")
                .replace("++", "+")
                .replace("--", "+")
                .replace("*", "×")
                .replace("/", "÷");
        double resultado;
        try {
            resultado = Double.parseDouble(cadena);
        } catch (Exception e) {
            resultado = ObtenerSumas(cadena);
        }
        if (resultado <= Long.MAX_VALUE && resultado >= Long.MAX_VALUE) {
            if (resultado == (long) resultado) {
                return (long) resultado + "";
            }
        }
        return EliminarNotaciónCientifica(resultado).replace(",", ".") + "";
    }

    protected static double ObtenerSumas(String cadena) {
        String[] términos = cadena.split("\\+");
        double[] sumando = new double[términos.length];
        for (int i = 0; i < sumando.length; i++) {
            try {
                double d = Double.parseDouble(términos[i]);
                sumando[i] = d;
            } catch (Exception e) {
                sumando[i] = ObterRestas(términos[i]);
            }
        }
        double suma = 0;
        for (double d : sumando) {
            suma += d;
        }
        return suma;
    }

    protected static double ObterRestas(String cadena) {
        boolean restar = cadena.startsWith("-");
        if (restar) {
            cadena = cadena.substring(1);
        }
        String[] términos = cadena.split("-");
        double[] op = new double[términos.length];
        for (int i = 0; i < op.length; i++) {
            try {
                double d = Double.parseDouble(términos[i]);
                op[i] = d;
            } catch (Exception e) {
                op[i] = ObterMultiplicaciones(términos[i]);
            }
        }
        double resultado = 0;
        for (double d : op) {
            if (restar) {
                resultado -= d;
            } else {
                resultado += d;
                restar = true;
            }
        }
        return resultado;
    }

    protected static double ObterMultiplicaciones(String cadena) {
        String[] términos = cadena.split("×");
        double[] fatores = new double[términos.length];
        for (int i = 0; i < fatores.length; i++) {
            try {
                double d = Double.parseDouble(términos[i]);
                fatores[i] = d;
            } catch (Exception e) {
                fatores[i] = ObterDivisiones(términos[i]);
            }
        }
        double producto = 1;
        for (double d : fatores) {
            producto *= d;
        }
        return producto;
    }

    protected static double ObterDivisiones(String cadena) {
        String[] términos = cadena.split("÷");
        double[] op = new double[términos.length];
        for (int i = 0; i < op.length; i++) {
            try {
                double d = Double.parseDouble(términos[i]);
                op[i] = d;
            } catch (Exception e) {
                System.out.println("Error en: " + términos[i]);
                e.printStackTrace();
                throw new RuntimeException("Ocurrio un error en la interpretación");
            }
        }
        double resultado = 0;
        boolean dividir = false;
        for (double d : op) {
            if (dividir) {
                resultado /= d;
            } else {
                resultado = d;
                dividir = true;
            }
        }
        return resultado;
    }

    public static String EliminarNotaciónCientifica(double Número) {
        String d = "####################################";
        return new DecimalFormat("#." + d + d + d).format(Número);
    }
}
