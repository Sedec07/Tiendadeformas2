import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Clase abstracta Forma
abstract class Forma {
    // Método abstracto para calcular el área
    public abstract double area();
}

// Clase Circulo que extiende Forma
class Circulo extends Forma {
    private final double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI * radio * radio;
    }

    @Override
    public String toString() {
        return "Círculo de radio " + radio + ", área: " + area();
    }
}

// Clase Rectangulo que extiende Forma
class Rectangulo extends Forma {
    private final double ancho;
    private final double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double area() {
        return ancho * alto;
    }

    @Override
    public String toString() {
        return "Rectángulo de ancho " + ancho + " y alto " + alto + ", área: " + area();
    }
}

// Clase principal Tiendadeformas2 con GUI
public class Tiendadeformas2 extends JFrame {
    private final ArrayList<Forma> formas;
    private final JTextArea textArea;

    public Tiendadeformas2() {
        formas = new ArrayList<>();
        setTitle("Tienda de Formas Geométricas");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Área de texto para mostrar las formas y sus áreas
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Panel de botones
        JPanel panel = new JPanel();
        JButton btnCirculo = new JButton("Agregar Círculo");
        JButton btnRectangulo = new JButton("Agregar Rectángulo");

        // Acción para agregar un círculo
        btnCirculo.addActionListener((ActionEvent e) -> {
            String input = JOptionPane.showInputDialog("Ingrese el radio del círculo:");
            if (input != null && !input.isEmpty()) {
                try {
                    double radio = Double.parseDouble(input);
                    formas.add(new Circulo(radio));
                    actualizarTextArea();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                }
            }
        });

        // Acción para agregar un rectángulo
        btnRectangulo.addActionListener((ActionEvent e) -> {
            String inputAncho = JOptionPane.showInputDialog("Ingrese el ancho del rectángulo:");
            String inputAlto = JOptionPane.showInputDialog("Ingrese el alto del rectángulo:");
            if (inputAncho != null && inputAlto != null && !inputAncho.isEmpty() && !inputAlto.isEmpty()) {
                try {
                    double ancho = Double.parseDouble(inputAncho);
                    double alto = Double.parseDouble(inputAlto);
                    formas.add(new Rectangulo(ancho, alto));
                    actualizarTextArea();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese números válidos.");
                }
            }
        });

        panel.add(btnCirculo);
        panel.add(btnRectangulo);
        add(panel, BorderLayout.SOUTH);
    }

    // Método para actualizar el área de texto con la información de las formas
    private void actualizarTextArea() {
        textArea.setText("");
        for (Forma forma : formas) {
            textArea.append(forma.toString() + "\n");
        }
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tiendadeformas2 Tienda;
            Tienda = new Tiendadeformas2();
            Tienda.setVisible(true);
        });/ /*
    */
    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        Tiendadeformas2 Tienda = new Tiendadeformas2();
        Tienda.setVisible(true);
    });
}

    }

