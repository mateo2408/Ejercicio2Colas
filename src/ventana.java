import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana {
    private JPanel principal;
    private JLabel titulo;
    private JLabel mensaje;
    private JTextField imagen;
    private JButton agregar;
    private JButton eliminarp;
    private JButton eliminaru;
    private JButton anterior;
    private JButton siguiente;

    Imagenes imagenes = new Imagenes();

    public ventana() {
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imagePath = imagen.getText();
                if (!imagePath.isEmpty()) {
                    imagenes.agregarImagen(imagePath);
                    actualizar();
                }
            }
        });
        eliminarp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imagenes.eliminarPrimeraImagen();
                actualizar();
            }
        });
        eliminaru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imagenes.eliminarUltimaImagen();
                actualizar();
            }
        });
        anterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje.setText(imagenes.anteriorImagen());
            }
        });

        siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje.setText(imagenes.siguienteImagen());
            }
        });
    }
    private void actualizar() {
        mensaje.setText(imagenes.presentarImagen());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ventana");
        frame.setContentPane(new ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
