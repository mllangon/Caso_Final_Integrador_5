import Analisis_Genomico.Combinaciones;
import Analisis_Genomico.Conteo;
import Analisis_Numerico.CalculoPotencias;
import Analisis_Numerico.MaximoValor;
import Analisis_Numerico.SumatoriaNumeros;
import Gestion_Informacion_Cientifica.OrganizadorDocumentos;
import Optimizacion.QuicksortOptimizado;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Aplicacion extends JFrame {
    private List<Date> dates = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public Aplicacion() {
        super("Aplicación de Análisis Genómico y Numérico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setLookAndFeel();

        Font generalFont = new Font("SansSerif", Font.PLAIN, 14);
        UIManager.put("Label.font", generalFont);
        UIManager.put("Button.font", generalFont);
        UIManager.put("TabbedPane.font", generalFont);

        JTabbedPane tabbedPane = new JTabbedPane();
        Color backgroundColor = new Color(249, 249, 249);
        Color foregroundColor = new Color(107, 107, 107);

        ImageIcon genomicIcon = new ImageIcon(new ImageIcon("src/main/resources/adn.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        ImageIcon numericIcon = new ImageIcon(new ImageIcon("src/main/resources/numeros.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        ImageIcon managementIcon = new ImageIcon(new ImageIcon("src/main/resources/control.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        ImageIcon optimizationIcon = new ImageIcon(new ImageIcon("src/main/resources/optimizacion.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        JPanel genomicPanel = createGenomicPanel(backgroundColor, foregroundColor);
        JPanel numericPanel = createNumericPanel(backgroundColor, foregroundColor);
        JPanel managementPanel = createManagementPanel(backgroundColor, foregroundColor);
        JPanel optimizationPanel = createOptimizationPanel(backgroundColor, foregroundColor);

        tabbedPane.addTab("Análisis Genómico", genomicIcon, genomicPanel);
        tabbedPane.addTab("Análisis Numérico", numericIcon, numericPanel);
        tabbedPane.addTab("Gestión de Información", managementIcon, managementPanel);
        tabbedPane.addTab("Optimización de Procesos", optimizationIcon, optimizationPanel);
        add(tabbedPane);
    }


    private void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                // handle exception
            }
        }
    }

    private JPanel createGenomicPanel(Color backgroundColor, Color foregroundColor) {
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Funciones Genómicas"));
        panel.setBackground(new Color(229, 255, 204));

        JTextField dnaInputField = new JTextField(20);
        JButton countGenesButton = new JButton("Contar Genes (Debe comenzar con ATG y finalizar con TAG, TAA o TGA)");
        JLabel geneCountResult = new JLabel("Genes contados aparecerán aquí.");
        panel.add(new JLabel("Introduce una secuencia de ADN para contar genes:"));
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
        JLabel combinationsResult = new JLabel("Combinaciones aparecerán aquí.");
        panel.add(new JLabel("Introduce un número para calcular combinaciones genéticas:"));
        panel.add(numberInputField);
        panel.add(calculateCombinationsButton);
        panel.add(combinationsResult);
        calculateCombinationsButton.addActionListener(e -> {
            Combinaciones combinaciones = new Combinaciones();
            int result = combinaciones.calcularCombinaciones(Integer.parseInt(numberInputField.getText()));
            combinationsResult.setText("Combinaciones posibles: " + result);
        });

        return panel;
    }

    private JPanel createNumericPanel(Color backgroundColor, Color foregroundColor) {
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Herramientas de Análisis Numérico"));
        panel.setBackground(new Color(229, 255, 204));

        JTextField sumInputField = new JTextField(10);
        JButton sumButton = new JButton("Calcular Sumatoria");
        JLabel sumResult = new JLabel("Resultado de la sumatoria aparecerá aquí.");
        panel.add(new JLabel("Introduce un número para calcular la sumatoria de números naturales hasta él:"));
        panel.add(sumInputField);
        panel.add(sumButton);
        panel.add(sumResult);
        sumButton.addActionListener(e -> {
            SumatoriaNumeros sumatoria = new SumatoriaNumeros();
            int result = sumatoria.sumatoria(Integer.parseInt(sumInputField.getText()));
            sumResult.setText("Sumatoria hasta " + sumInputField.getText() + " es: " + result);
        });

        JTextField baseInputField = new JTextField(10);
        JTextField exponentInputField = new JTextField(10);
        JButton powerButton = new JButton("Calcular Potencia");
        JLabel powerResult = new JLabel("Resultado de la potencia aparecerá aquí.");
        panel.add(new JLabel("Introduce la base y el exponente para calcular la potencia:"));
        panel.add(baseInputField);
        panel.add(exponentInputField);
        panel.add(powerButton);
        panel.add(powerResult);
        powerButton.addActionListener(e -> {
            CalculoPotencias calculo = new CalculoPotencias();
            int result = calculo.calcularPotencia(Integer.parseInt(baseInputField.getText()), Integer.parseInt(exponentInputField.getText()));
            powerResult.setText("Potencia de " + baseInputField.getText() + "^" + exponentInputField.getText() + " es: " + result);
        });

        JTextField dataArrayField = new JTextField(20);
        JButton maxButton = new JButton("Encontrar Máximo");
        JLabel maxResult = new JLabel("El valor máximo aparecerá aquí.");
        panel.add(new JLabel("Introduce una serie de números separados por comas para encontrar el valor máximo:"));
        panel.add(dataArrayField);
        panel.add(maxButton);
        panel.add(maxResult);
        maxButton.addActionListener(e -> {
            String[] dataStr = dataArrayField.getText().split(",");
            int[] data = new int[dataStr.length];
            for (int i = 0; i < dataStr.length; i++) {
                data[i] = Integer.parseInt(dataStr[i].trim());
            }
            MaximoValor maximo = new MaximoValor();
            int result = maximo.encontrarMaximo(data);
            maxResult.setText("El valor máximo en los datos introducidos es: " + result);
        });

        return panel;
    }

    private JPanel createManagementPanel(Color backgroundColor, Color foregroundColor) {
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Gestión de Información Científica"));
        panel.setBackground(new Color(229, 255, 204));

        JTextArea documentArea = new JTextArea(10, 30);
        JButton sortDocButton = new JButton("Ordenar Documento");
        JTextArea sortedDocumentArea = new JTextArea(10, 30);
        sortedDocumentArea.setEditable(false);
        panel.add(new JLabel("Documento Original (introduce varias líneas):"));
        panel.add(new JScrollPane(documentArea));
        panel.add(sortDocButton);
        panel.add(new JLabel("Documento Ordenado:"));
        panel.add(new JScrollPane(sortedDocumentArea));
        sortDocButton.addActionListener(e -> {
            OrganizadorDocumentos organizador = new OrganizadorDocumentos();
            String[] sortedLines = organizador.ordenarLineas(documentArea.getText());
            sortedDocumentArea.setText(String.join("\n", sortedLines));
        });

        JTextArea dateListArea = new JTextArea(5, 30);
        dateListArea.setEditable(false);
        JTextField dateInputField = new JTextField(10);
        JButton addDateButton = new JButton("Agregar Fecha");
        panel.add(new JLabel("Introduce fechas en formato DD-MM-AAAA para organizar:"));
        panel.add(dateInputField);
        panel.add(addDateButton);
        panel.add(new JScrollPane(dateListArea));
        addDateButton.addActionListener(e -> {
            try {
                Date date = sdf.parse(dateInputField.getText());
                dates.add(date);
                Collections.sort(dates);
                StringBuilder sb = new StringBuilder();
                for (Date d : dates) {
                    sb.append(sdf.format(d)).append("\n");
                }
                dateListArea.setText(sb.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en el formato de la fecha. Usa DD-MM-AAAA.");
            }
        });

        return panel;
    }

    private JPanel createOptimizationPanel(Color backgroundColor, Color foregroundColor) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Optimización de Procesos"));
        panel.setBackground(new Color(229, 255, 204));

        JTextField inputArrayField = new JTextField(20);
        JButton sortButton = new JButton("Ordenar Array");
        JTextArea resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        panel.add(new JLabel("Introduce números separados por comas para ordenar:"), BorderLayout.NORTH);
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
            resultArea.setText("Array ordenado: " + Arrays.toString(data));
        });

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Aplicacion().setVisible(true));
    }
}
