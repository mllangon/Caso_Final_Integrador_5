import Analisis_Genomico.Conteo;
import Analisis_Genomico.Combinaciones;
import Analisis_Numerico.*;
import Gestion_Informacion_Cientifica.OrganizadorDocumentos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplicacion extends JFrame {
    private JTextField dnaInputField;
    private JButton countGenesButton;
    private JLabel geneCountResult;
    private JTextField numberInputField;
    private JButton calculateCombinationsButton;
    private JLabel combinationsResult;

    private JTextField sumInputField;
    private JButton sumButton;
    private JLabel sumResult;
    private JTextField rangeStartField, rangeEndField;
    private JButton listNumbersButton;
    private JTextArea listNumbersResult;
    private JTextField baseInputField, exponentInputField;
    private JButton calculatePowerButton;
    private JLabel powerResult;
    private JTextField dataArrayField;
    private JButton maxButton;
    private JLabel maxResult;

    public Aplicacion() {
        super("Aplicación de Análisis Genómico y Numérico");

        setSize(600, 700);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        // Análisis genómico
        dnaInputField = new JTextField(20);
        countGenesButton = new JButton("Contar Genes");
        geneCountResult = new JLabel("Genes contados: ");
        add(new JLabel("Secuencia de ADN:"));
        add(dnaInputField);
        add(countGenesButton);
        add(geneCountResult);
        countGenesButton.addActionListener(e -> {
            Conteo conteo = new Conteo();
            int result = conteo.contarGenes(dnaInputField.getText());
            geneCountResult.setText("Genes contados: " + result);
        });

        numberInputField = new JTextField(5);
        calculateCombinationsButton = new JButton("Calcular Combinaciones");
        combinationsResult = new JLabel("Combinaciones: ");
        add(new JLabel("Número para combinaciones:"));
        add(numberInputField);
        add(calculateCombinationsButton);
        add(combinationsResult);
        calculateCombinationsButton.addActionListener(e -> {
            Combinaciones combinaciones = new Combinaciones();
            int result = combinaciones.calcularCombinaciones(Integer.parseInt(numberInputField.getText()));
            combinationsResult.setText("Combinaciones: " + result);
        });

        // Herramientas de análisis numérico
        sumInputField = new JTextField(10);
        sumButton = new JButton("Sumatoria");
        sumResult = new JLabel("Suma: ");
        add(new JLabel("Número para sumatoria:"));
        add(sumInputField);
        add(sumButton);
        add(sumResult);
        sumButton.addActionListener(e -> {
            SumatoriaNumeros sumatoria = new SumatoriaNumeros();
            int result = sumatoria.sumatoria(Integer.parseInt(sumInputField.getText()));
            sumResult.setText("Suma: " + result);
        });

        rangeStartField = new JTextField(5);
        rangeEndField = new JTextField(5);
        listNumbersButton = new JButton("Listar Números");
        listNumbersResult = new JTextArea(5, 20);
        listNumbersResult.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listNumbersResult);
        add(new JLabel("Inicio rango:"));
        add(rangeStartField);
        add(new JLabel("Fin rango:"));
        add(rangeEndField);
        add(listNumbersButton);
        add(scrollPane);
        listNumbersButton.addActionListener(e -> {
            ListadoNumeros listado = new ListadoNumeros();
            java.util.List<Integer> numbers = listado.listarNumeros(Integer.parseInt(rangeStartField.getText()), Integer.parseInt(rangeEndField.getText()));
            listNumbersResult.setText(numbers.toString());
        });

        baseInputField = new JTextField(5);
        exponentInputField = new JTextField(5);
        calculatePowerButton = new JButton("Calcular Potencia");
        powerResult = new JLabel("Potencia: ");
        add(new JLabel("Base:"));
        add(baseInputField);
        add(new JLabel("Exponente:"));
        add(exponentInputField);
        add(calculatePowerButton);
        add(powerResult);
        calculatePowerButton.addActionListener(e -> {
            CalculoPotencias calculo = new CalculoPotencias();
            int result = calculo.calcularPotencia(Integer.parseInt(baseInputField.getText()), Integer.parseInt(exponentInputField.getText()));
            powerResult.setText("Potencia: " + result);
        });

        dataArrayField = new JTextField(20);
        maxButton = new JButton("Encontrar Máximo");
        maxResult = new JLabel("Máximo: ");
        add(new JLabel("Datos (separados por coma):"));
        add(dataArrayField);
        add(maxButton);
        add(maxResult);
        maxButton.addActionListener(e -> {
            String[] dataStr = dataArrayField.getText().split(",");
            int[] data = new int[dataStr.length];
            for (int i = 0; i < dataStr.length; i++) {
                data[i] = Integer.parseInt(dataStr[i].trim());
            }
            MaximoValor maximo = new MaximoValor();
            int result = maximo.encontrarMaximo(data);
            maxResult.setText("Máximo: " + result);
        });

        JTextArea documentArea = new JTextArea(10, 30);
        JButton sortButton = new JButton("Ordenar Documento");
        JTextArea sortedDocumentArea = new JTextArea(10, 30);
        sortedDocumentArea.setEditable(false);

        sortButton.addActionListener(e -> {
            OrganizadorDocumentos organizador = new OrganizadorDocumentos();
            String[] sortedLines = organizador.ordenarLineas(documentArea.getText());
            sortedDocumentArea.setText(String.join("\n", sortedLines));
        });

        add(new JLabel("Documento Original:"));
        add(new JScrollPane(documentArea));
        add(sortButton);
        add(new JLabel("Documento Ordenado:"));
        add(new JScrollPane(sortedDocumentArea));

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Aplicacion().setVisible(true));
    }
}
