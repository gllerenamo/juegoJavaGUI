import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends JFrame{
    private JButton btn2;
    private JButton btn4;
    private JButton btn5;
    private JButton btn7;
    private JButton btn8;
    private JButton btn3;
    private JButton btn6;
    private JButton btn9;
    private JButton btn1;
    private JPanel panel;
    protected JButton [][] botones = {
            {btn1, btn2, btn3},
            {btn4, btn5, btn6},
            {btn7, btn8, btn9}
    } ;
    private boolean turnoJ1 = true;
    public Tablero() {
        super("Tic Tac Toe");
        setContentPane(panel);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        for (JButton[] fila : botones) {
            for (JButton boton: fila) {
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton origen = (JButton) e.getSource();
                        if (!(origen.getText().equals("X") || origen.getText().equals("O"))) {
                            if (turnoJ1) boton.setText("X");
                            else boton.setText("O");
                            if (comprobarJuegoTerminado()) {
                                determinarGanador();
                            }
                            turnoJ1 = !turnoJ1;
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La casilla ya está ocupada, selecciona otra");
                        }
                    }
                });
            }
        }
    }
    public boolean comprobarJuegoTerminado() {
        return(comprobarTableroLleno() || comprobarTresEnLinea());
    }
    public boolean comprobarTableroLleno() {
        for (JButton[] fila : botones) {
            for (JButton boton: fila) {
                if (!(boton.getText().equals("X") || boton.getText().equals("O"))) return false;
            }
        }
        return true;
    }
    public boolean comprobarTresEnLinea() {
        String m = "X";	// jugador 1

        //bucle una vez para cada jugador(un turno de juego)
        for(int i = 0; i < 2; i++)
        {
            // comprobar todas las combinaciones ganadoras
            // pasando por el centro
            if(botones[1][1].getText().equals(m))
            {
                if(botones[0][1].getText().equals(m) && botones[2][1].getText().equals(m))
                    return true;	// columna central
                if(botones[0][2].getText().equals(m) && botones[2][0].getText().equals(m))
                    return true;	// diagonal /
                if(botones[1][2].getText().equals(m) && botones[1][0].getText().equals(m))
                    return true;	// fila central
                if(botones[2][2].getText().equals(m) && botones[0][0].getText().equals(m))
                    return true;	// diagonal \
            }
            // comprobar todas las combinaciones ganadoras pasando
            //Esquina superior izquierda
            if(botones[0][0].getText().equals(m))
            {
                if(botones[0][1].getText().equals(m) && botones[0][2].getText().equals(m))
                    return true;	// Fila superior
                if(botones[1][0].getText().equals(m) && botones[2][0].getText().equals(m))
                    return true;	// columna izquierda
            }
            // comprobar todas las combinaciones ganadoras pasando
            // esquina inferior derecha
            if(botones[2][2].getText().equals(m))
            {
                if(botones[1][2].getText().equals(m) && botones[0][2].getText().equals(m))
                    return true;	// columna derecha
                if(botones[2][1].getText().equals(m) && botones[2][0].getText().equals(m))
                    return true;	// fila inferior
            }

            m = "O";	//Cambiar al jugador 2
        }
        return false;
    }
    public void determinarGanador() {
        if (comprobarTresEnLinea()) {
            if (turnoJ1) //p1Turn representa el turno del jugador
                JOptionPane.showMessageDialog(rootPane, "Felicitaciones jugador 1 gano el juego.\nGracias por jugar");
            else
                JOptionPane.showMessageDialog(rootPane, "Felicitaciones jugador 2 gano el juego.\nGracias por jugar");
        } else
            JOptionPane.showMessageDialog(rootPane, "El juego termino en empate.\nGracias por jugar");
    }
    public void paint(Graphics g) {
        g.drawLine(265, 50, 265, 560);
        g.drawLine(535, 50, 535, 560);
        g.drawLine(40, 220, 760, 220);
        g.drawLine(40, 410, 7601, 410);
    }
}
