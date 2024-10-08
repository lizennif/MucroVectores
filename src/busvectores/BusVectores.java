package busvectores;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class BusVectores {

    public static void main(String[] args) {
        int asignar1[], asignar2[], asiento = 0, numAsiento, opc, cualAsiento = 0, cual = 0;
        asignar1 = new int[10];
        asignar2 = new int[10];
        String estado1[], estado2[], salida, hayPasajeros = "NO";
        estado1 = new String[10];
        estado2 = new String[10];
        JTextArea hoja = new JTextArea();
        boolean encontrado = false;

        for (numAsiento = 0; numAsiento < 10; numAsiento++) {
            asiento++;
            asignar1[numAsiento] = asiento;
            estado1[numAsiento] = "Vacío";
            estado2[numAsiento] = "Vacío";
        }
        for (numAsiento = 0; numAsiento < 10; numAsiento++) {
            asiento++;
            asignar2[numAsiento] = asiento;
        }
        opc = Integer.parseInt(JOptionPane.showInputDialog("BIENVENIDO!\nElija una opción:\n1.Ver asientos"
                + "\n2.Elegir un asiento\n3.Cambiar de asiento\n4.Bajarse del autobus\n5.Mostrar registro\nCualquier otro número para salir"));
        while (opc > 0 && opc < 6) {
            switch (opc) {
                case 1: //Mostrar el bus
                    salida = "";
                    for (numAsiento = 0; numAsiento < 10; numAsiento++) {
                        salida = salida + asignar1[numAsiento] + ". " + estado1[numAsiento] + "\t" + asignar2[numAsiento] + ". " + estado2[numAsiento] + "\n";
                    }
                    hoja.setText(salida);
                    JOptionPane.showMessageDialog(null, hoja);
                    break;
                case 2://Vender asiento
                    salida = "";
                    for (numAsiento = 0; numAsiento < 10; numAsiento++) {
                        salida = salida + asignar1[numAsiento] + ". " + estado1[numAsiento] + "\t" + asignar2[numAsiento] + ". " + estado2[numAsiento] + "\n";
                    }
                    salida = salida + "\n¿Qué asiento desea ocupar?";
                    hoja.setText(salida);
                    cual = Integer.parseInt(JOptionPane.showInputDialog(hoja));
                    if (cual > 0 && cual <= 10) {
                        cualAsiento=0;
                        for (numAsiento = 0; numAsiento < 10; numAsiento++) {
                            if (cual == asignar1[numAsiento]) {
                                encontrado = true;
                                cualAsiento = (asignar1[numAsiento]-1);
                            } else {
                                if (cual == asignar2[numAsiento]) {
                                    encontrado = true;
                                    cualAsiento = (asignar2[numAsiento]-1);
                                }
                            }
                        }
                        if (encontrado = true) {
                            if (cualAsiento >= 0 && cualAsiento <= 10) {
                                if (estado1[cualAsiento].equals("Vacío")) {
                                    estado1[cualAsiento] = "Intermedio";
                                    JOptionPane.showMessageDialog(null, "Asiento asignado");
                                } else {
                                    if (estado1[cualAsiento].equals("Intermedio")) {
                                        estado1[cualAsiento] = "Ocupado";
                                        JOptionPane.showMessageDialog(null, "Asiento asignado");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Ese asiento está OCUPADO");
                                    }
                                }
                            } else {
                                if (cualAsiento > 10 && cualAsiento <= 20) {
                                    if (estado2[cualAsiento].equals("Vacío")) {
                                        estado2[cualAsiento] = "Intermedio";
                                    } else {
                                        if (estado2[cualAsiento].equals("Intermedio")) {
                                            estado2[cualAsiento] = "Ocupado";
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Ese asiento está OCUPADO");
                                        }
                                    }
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ese asiento no existe");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Asiento equivocado");
                    }

                    break;
                case 3://Cambiar de asiento

                    hayPasajeros = "NO";
                    for (numAsiento = 0; numAsiento < 10; numAsiento++) {
                        if (!estado1[numAsiento].equals("Vacío") || !estado2[numAsiento].equals("Vacío")) {
                            hayPasajeros = "SI";
                        }
                    }
                    if (hayPasajeros.equals("SI")) {
                        salida = "";
                        for (numAsiento = 0; numAsiento < 10; numAsiento++) {
                            salida = salida + asignar1[numAsiento] + ". " + estado1[numAsiento] + "\t" + asignar2[numAsiento] + ". " + estado2[numAsiento] + "\n";
                        }
                        hoja.setText(salida);
                        cualAsiento = Integer.parseInt(JOptionPane.showInputDialog(hoja));
                    } else {
                        JOptionPane.showMessageDialog(null, "Aún no hay nadie en el autobús");
                    }

                    break;
                case 4://Bajarse del bus
                    break;
                case 5://Mostrar registro
                    break;
            }

            opc = Integer.parseInt(JOptionPane.showInputDialog("BIENVENIDO!\nElija una opción:\n1.Ver asientos"
                    + "\n2.Elegir un asiento\n3.Cambiar de asiento\n4.Bajarse del autobus\n5.Mostrar registro\nCualquier otro número para salir"));
        }

    }

}
