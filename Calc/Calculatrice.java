import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * Classe Modèle - Gère toute la logique de calcul
 * Suit le principe de responsabilité unique (SRP)
 */
public class Calculatrice {
    private static final String HISTORY_FILE = "historique.txt";
    private String currentInput;
    private String operator;
    private double result;
    private boolean startNewInput;
    private String fullExpression;
    private List<String> historique;

    // Interface pour notifier les changements (pattern Observer)
    public interface CalculatriceListener {
        void onDisplayChanged(String value);
        void onExpressionChanged(String expression);
        void onHistoryAdded(String entry);
    }

    private CalculatriceListener listener;

    public Calculatrice() {
        this.historique = new ArrayList<>();
        loadHistorique();
        clear();
    }

    // Sauvegarde l'historique dans un fichier
    public void saveHistorique() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(HISTORY_FILE))) {
            for (String entry : historique) {
                writer.println(entry);
            }
        } catch (IOException e) {
            System.err.println("Erreur sauvegarde historique: " + e.getMessage());
        }
    }

    // Charge l'historique depuis le fichier
    private void loadHistorique() {
        File file = new File(HISTORY_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    historique.add(line);
                }
            } catch (IOException e) {
                System.err.println("Erreur chargement historique: " + e.getMessage());
            }
        }
    }

    public void setListener(CalculatriceListener listener) {
        this.listener = listener;
    }

    // Getters
    public String getCurrentInput() {
        return currentInput;
    }

    public String getFullExpression() {
        return fullExpression;
    }

    public List<String> getHistorique() {
        return new ArrayList<>(historique);
    }

    // Actions
    public void clear() {
        currentInput = "";
        operator = "";
        result = 0;
        startNewInput = true;
        fullExpression = "";
        notifyDisplayChanged("0");
        notifyExpressionChanged("");
    }

    public void clearHistorique() {
        historique.clear();
        saveHistorique();
    }

    public void backspace() {
        if (currentInput.length() > 0) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            notifyDisplayChanged(currentInput.isEmpty() ? "0" : currentInput);
        }
    }

    public void toggleSign() {
        if (!currentInput.isEmpty() && !currentInput.equals("0")) {
            if (currentInput.startsWith("-")) {
                currentInput = currentInput.substring(1);
            } else {
                currentInput = "-" + currentInput;
            }
            notifyDisplayChanged(currentInput);
        }
    }

    public void percentage() {
        if (!currentInput.isEmpty()) {
            double value = Double.parseDouble(currentInput) / 100;
            currentInput = formatResult(value);
            notifyDisplayChanged(currentInput);
        }
    }

    public void setOperator(String op) {
        if (!currentInput.isEmpty()) {
            if (!operator.isEmpty()) {
                calculateIntermediate();
                fullExpression += " " + op + " ";
            } else {
                result = Double.parseDouble(currentInput);
                fullExpression = currentInput + " " + op + " ";
            }
            notifyExpressionChanged(fullExpression);
            operator = op;
            currentInput = "";
            startNewInput = true;
        } else if (!operator.isEmpty()) {
            operator = op;
            fullExpression = fullExpression.substring(0, fullExpression.length() - 3) + " " + op + " ";
            notifyExpressionChanged(fullExpression);
        }
    }

    private boolean divisionByZero = false;

    private void calculateIntermediate() {
        if (!currentInput.isEmpty()) {
            double operand = Double.parseDouble(currentInput);
            
            // Check division par zéro
            if (operator.equals("÷") && operand == 0) {
                divisionByZero = true;
                notifyDisplayChanged("Erreur");
                return;
            }
            
            fullExpression += currentInput;
            result = executeOperation(result, operand, operator);
            notifyDisplayChanged(formatResult(result));
        }
    }

    private double executeOperation(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "−": return a - b;
            case "×": return a * b;
            case "÷": return b != 0 ? a / b : 0;
            default: return a;
        }
    }

    public void calculate() {
        if (!operator.isEmpty() && !currentInput.isEmpty()) {
            calculateIntermediate();
            
            // Si division par zéro, reset
            if (divisionByZero) {
                divisionByZero = false;
                operator = "";
                currentInput = "";
                fullExpression = "";
                startNewInput = true;
                return;
            }
            
            fullExpression += " = " + formatResult(result);
            notifyExpressionChanged(fullExpression);
            
            // Ajouter à l'historique
            historique.add(0, fullExpression);
            saveHistorique();
            if (listener != null) {
                listener.onHistoryAdded(fullExpression);
            }
            
            currentInput = formatResult(result);
            operator = "";
            startNewInput = true;
            fullExpression = "";
        }
    }

    public void addDecimal() {
        if (startNewInput) {
            currentInput = "0.";
            startNewInput = false;
        } else if (!currentInput.contains(".")) {
            currentInput += ".";
        }
        notifyDisplayChanged(currentInput);
    }

    public void addDigit(String digit) {
        if (startNewInput) {
            currentInput = digit;
            startNewInput = false;
        } else {
            currentInput += digit;
        }
        notifyDisplayChanged(currentInput);
    }

    public void setInput(String value) {
        currentInput = value;
        startNewInput = true;
        notifyDisplayChanged(value);
    }

    private String formatResult(double value) {
        // Arrondi à 12 décimales pour éviter les erreurs de virgule flottante
        value = Math.round(value * 1e12) / 1e12;
        
        if (value == (long) value && Math.abs(value) < Long.MAX_VALUE) {
            return String.valueOf((long) value);
        }
        
        String str = String.valueOf(value);
        if (str.contains(".") && str.length() > 14) {
            str = str.substring(0, 14);
            while (str.endsWith("0")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.endsWith(".")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    // Méthodes de notification
    private void notifyDisplayChanged(String value) {
        if (listener != null) {
            listener.onDisplayChanged(value);
        }
    }

    private void notifyExpressionChanged(String expression) {
        if (listener != null) {
            listener.onExpressionChanged(expression);
        }
    }
}
