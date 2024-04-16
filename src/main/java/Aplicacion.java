import Analisis_Genomico.Conteo;
import Analisis_Genomico.Combinaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplicacion extends JFrame {
    private JTextField dnaInputField;
    private JButton countGenesButton;
    private JLabel geneCountResult;
    private JTextArea instructionsGenes;

    private JTextField numberInputField;
    private JButton calculateCombinationsButton;
    private JLabel combinationsResult;
    private JTextArea instructionsCombinations;

    public Aplicacion() {
        super("Aplicación de Análisis Genómico");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel para el conteo de genes
        JPanel genePanel = new JPanel();
        genePanel.setLayout(new FlowLayout());
        dnaInputField = new JTextField(20);
        countGenesButton = new JButton("Contar Genes");
        geneCountResult = new JLabel("Resultado: ");
        instructionsGenes = new JTextArea("Introduce una secuencia de ADN para contar los genes.\nUsa ATG como inicio y TAG, TAA, TGA como finales válidos.");
        instructionsGenes.setEditable(false);
        instructionsGenes.setOpaque(false);

        genePanel.add(new JLabel("ADN:"));
        genePanel.add(dnaInputField);
        genePanel.add(countGenesButton);
        genePanel.add(geneCountResult);
        genePanel.add(instructionsGenes);

        add(genePanel);

        countGenesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dna = dnaInputField.getText();
                Conteo conteo = new Conteo();
                int result = conteo.contarGenes(dna);
                geneCountResult.setText("Resultado: " + result);
            }
        });

        // Panel para cálculo de combinaciones
        JPanel combinationsPanel = new JPanel();
        combinationsPanel.setLayout(new FlowLayout());
        numberInputField = new JTextField(10);
        calculateCombinationsButton = new JButton("Calcular Combinaciones");
        combinationsResult = new JLabel("Resultado: ");
        instructionsCombinations = new JTextArea("Introduce un número para calcular combinaciones genéticas basadas en un modelo simplificado.");
        instructionsCombinations.setEditable(false);
        instructionsCombinations.setOpaque(false);

        combinationsPanel.add(new JLabel("Número:"));
        combinationsPanel.add(numberInputField);
        combinationsPanel.add(calculateCombinationsButton);
        combinationsPanel.add(combinationsResult);
        combinationsPanel.add(instructionsCombinations);

        add(combinationsPanel);

        calculateCombinationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(numberInputField.getText());
                    Combinaciones combinaciones = new Combinaciones();
                    int result = combinaciones.calcularCombinaciones(n);
                    combinationsResult.setText("Resultado: " + result);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Aplicacion().setVisible(true);
            }
        });
    }
}
