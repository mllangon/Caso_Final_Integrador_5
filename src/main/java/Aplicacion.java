import Analisis_Genomico.*;
import Analisis_Numerico.*;
import Gestion_Informacion_Cientifica.OrganizadorDocumentos;
import Optimizacion.QuicksortOptimizado;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Aplicacion extends JFrame {
    public Aplicacion() {
        super("Aplicación de Análisis Genómico y Numérico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centrar la ventana

        JTabbedPane tabbedPane = new JTabbedPane();

        // Crear paneles para cada módulo
        JPanel genomicPanel = createGenomicPanel();
        JPanel numericPanel = createNumericPanel();
        JPanel managementPanel = createManagementPanel();
        JPanel optimizationPanel = createOptimizationPanel();

        tabbedPane.addTab("Análisis Genómico", genomicPanel);
        tabbedPane.addTab("Análisis Numérico", numericPanel);
        tabbedPane.addTab("Gestión de Información", managementPanel);
        tabbedPane.addTab("Optimización de Procesos", optimizationPanel);

        add(tabbedPane);
    }

    private JPanel createGenomicPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Funciones Genómicas"));

        JTextField dnaInputField = new JTextField(20);
        JButton countGenesButton = new JButton("Contar Genes");
        JLabel geneCountResult = new JLabel("Genes contados: ");
        panel.add(new JLabel("Secuencia de ADN:"));
        panel.add(dnaInputField);
        panel.add(countGenesButton);
        panel.add(geneCountResult);
        countGenesButton.addActionListener(e -> {
            Conteo conteo = new Conteo();
            int result = conteo.contarGenes(dnaInputField.getText());
            geneCountResult.setText("Genes contados: " + result);
        });

        JTextField numberInputField = new JTextField(5);
        JButton calculateCombinationsButton = new JButton("Calcular Combinaciones");
        JLabel combinationsResult = new JLabel("Combinaciones: ");
        panel.add(new JLabel("Número para combinaciones:"));
        panel.add(numberInputField);
        panel.add(calculateCombinationsButton);
        panel.add(combinationsResult);
        calculateCombinationsButton.addActionListener(e -> {
            Combinaciones combinaciones = new Combinaciones();
            int result = combinaciones.calcularCombinaciones(Integer.parseInt(numberInputField.getText()));
            combinationsResult.setText("Combinaciones: " + result);
        });

        return panel;
    }

    private JPanel createNumericPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Herramientas de Análisis Numérico"));

        JTextField sumInputField = new JTextField(10);
        JButton sumButton = new JButton("Sumatoria");
        JLabel sumResult = new JLabel("Suma: ");
        panel.add(new JLabel("Número para sumatoria:"));
        panel.add(sumInputField);
        panel.add(sumButton);
        panel.add(sumResult);
        sumButton.addActionListener(e -> {
            SumatoriaNumeros sumatoria = new SumatoriaNumeros();
            int result = sumatoria.sumatoria(Integer.parseInt(sumInputField.getText()));
            sumResult.setText("Suma: " + result);
        });

        // Similar implementations for other numeric analysis functions
        // Add components for listing numbers, calculating power, finding maximum, etc.

        return panel;
    }

    private JPanel createManagementPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Gestión de Información Científica"));

        JTextArea documentArea = new JTextArea(10, 30);
        JButton sortDocButton = new JButton("Ordenar Documento");
        JTextArea sortedDocumentArea = new JTextArea(10, 30);
        sortedDocumentArea.setEditable(false);
        panel.add(new JLabel("Documento Original:"));
        panel.add(new JScrollPane(documentArea));
        panel.add(sortDocButton);
        panel.add(new JLabel("Documento Ordenado:"));
        panel.add(new JScrollPane(sortedDocumentArea));
        sortDocButton.addActionListener(e -> {
            OrganizadorDocumentos organizador = new OrganizadorDocumentos();
            String[] sortedLines = organizador.ordenarLineas(documentArea.getText());
            sortedDocumentArea.setText(String.join("\n", sortedLines));
        });

        // Include components for searching texts and managing dates

        return panel;
    }

    private JPanel createOptimizationPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Optimización de Procesos"));

        JTextField inputArrayField = new JTextField(20);
        JButton sortButton = new JButton("Ordenar Array");
        JTextArea resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        panel.add(new JLabel("Introduce números separados por comas:"), BorderLayout.NORTH);
        panel.add(inputArrayField, BorderLayout.CENTER);
        panel.add(sortButton, BorderLayout.EAST);
        panel.add(new JScrollPane(resultArea), BorderLayout.SOUTH);
        sortButton.addActionListener(e -> {
            String[] dataStr = inputArrayField.getText().split(",");
            int[] data = new int[dataStr.length];
            for (int i = 0; i < dataStr.length; i++) {
                data[i] = Integer.parseInt(dataStr[i].trim());
            }
            QuicksortOptimizado quicksort = new QuicksortOptimizado();
            quicksort.sort(data);
            resultArea.setText(Arrays.toString(data));
        });

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Aplicacion().setVisible(true));
    }
}
