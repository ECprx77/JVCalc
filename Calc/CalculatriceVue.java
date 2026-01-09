import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Classe Vue - Gère l'interface graphique Swing
 * Utilise le modèle Calculatrice et implémente son listener
 */
public class CalculatriceVue extends JFrame implements Calculatrice.CalculatriceListener {
    
    // Modèle
    private final Calculatrice calculatrice;
    
    // Composants UI
    private JLabel display;
    private JLabel historyDisplay;
    private DefaultListModel<String> historyModel;
    private JList<String> historyList;
    
    // Constantes de couleurs (encapsulation des thèmes)
    private static final Color BG_DARK = new Color(0x1a, 0x1a, 0x1f);
    private static final Color GRAY_WARM = new Color(0x2d, 0x2a, 0x2e);
    private static final Color GRAY_COOL = new Color(0x25, 0x28, 0x30);
    private static final Color GRAY_LIGHT = new Color(0x3d, 0x3a, 0x40);
    private static final Color VIOLET_ACCENT = new Color(0x9d, 0x4e, 0xdd);
    private static final Color VIOLET_HOVER = new Color(0xb5, 0x65, 0xf3);
    private static final Color TEXT_PRIMARY = Color.WHITE;
    private static final Color TEXT_SECONDARY = new Color(0xa0, 0xa0, 0xa5);

    public CalculatriceVue(Calculatrice calculatrice) {
        this.calculatrice = calculatrice;
        this.calculatrice.setListener(this);
        
        initFrame();
        initComponents();
        loadHistoriqueIntoView();
        setupKeyboard();
        
        pack();
        setLocationRelativeTo(null);
    }

    private void loadHistoriqueIntoView() {
        for (String entry : calculatrice.getHistorique()) {
            historyModel.addElement(entry);
        }
    }

    private void initFrame() {
        setTitle("Calculatrice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void initComponents() {
        JPanel mainPanel = createMainPanel();
        JPanel calcPanel = createCalcPanel();
        JPanel historyPanel = createHistoryPanel();
        
        mainPanel.add(calcPanel, BorderLayout.CENTER);
        mainPanel.add(historyPanel, BorderLayout.EAST);
        
        add(mainPanel);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(BG_DARK);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        return panel;
    }

    private JPanel createCalcPanel() {
        JPanel calcPanel = new JPanel(new BorderLayout(0, 10));
        calcPanel.setBackground(BG_DARK);
        
        calcPanel.add(createDisplayPanel(), BorderLayout.NORTH);
        calcPanel.add(createButtonPanel(), BorderLayout.CENTER);
        
        return calcPanel;
    }

    private JPanel createDisplayPanel() {
        JPanel displayPanel = new JPanel(new BorderLayout(0, 5));
        displayPanel.setBackground(BG_DARK);

        historyDisplay = new JLabel("");
        historyDisplay.setFont(new Font("SansSerif", Font.PLAIN, 14));
        historyDisplay.setForeground(TEXT_SECONDARY);
        historyDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        historyDisplay.setPreferredSize(new Dimension(300, 25));

        display = new JLabel("0");
        display.setFont(new Font("SansSerif", Font.PLAIN, 42));
        display.setForeground(TEXT_PRIMARY);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setPreferredSize(new Dimension(300, 60));

        displayPanel.add(historyDisplay, BorderLayout.NORTH);
        displayPanel.add(display, BorderLayout.CENTER);
        
        return displayPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(BG_DARK);

        String[][] buttons = {
            {".", "C", "%", "÷"},
            {"7", "8", "9", "×"},
            {"4", "5", "6", "−"},
            {"1", "2", "3", "+"},
            {"±", "0", "←", "="}
        };

        for (String[] row : buttons) {
            for (String text : row) {
                buttonPanel.add(createButton(text));
            }
        }
        
        return buttonPanel;
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setPreferredSize(new Dimension(67, 58));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Color bgColor = getButtonBackground(text);
        Color hoverColor = getButtonHoverColor(text);
        btn.setBackground(bgColor);
        btn.setForeground(getButtonForeground(text));

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(hoverColor);
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(bgColor);
            }
        });

        btn.addActionListener(e -> handleButton(text));

        return btn;
    }

    private Color getButtonBackground(String text) {
        if (text.equals("=")) return VIOLET_ACCENT;
        if (text.matches("[C%←±]")) return GRAY_WARM;
        return GRAY_COOL;
    }

    private Color getButtonHoverColor(String text) {
        if (text.equals("=")) return VIOLET_HOVER;
        if (text.matches("[C%←±]")) return GRAY_LIGHT;
        return new Color(0x2d, 0x30, 0x38);
    }

    private Color getButtonForeground(String text) {
        if (text.matches("[÷×−+]")) return VIOLET_ACCENT;
        return TEXT_PRIMARY;
    }

    private JPanel createHistoryPanel() {
        historyModel = new DefaultListModel<>();
        historyList = new JList<>(historyModel);
        historyList.setBackground(GRAY_COOL);
        historyList.setForeground(TEXT_PRIMARY);
        historyList.setFont(new Font("SansSerif", Font.PLAIN, 12));
        historyList.setSelectionBackground(VIOLET_ACCENT);
        historyList.setFixedCellHeight(25);

        historyList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String selected = historyList.getSelectedValue();
                    if (selected != null && selected.contains("=")) {
                        String res = selected.substring(selected.lastIndexOf("=") + 1).trim();
                        calculatrice.setInput(res);
                    }
                }
            }
        });

        JScrollPane historyScroll = new JScrollPane(historyList);
        historyScroll.setBorder(null);
        historyScroll.getViewport().setBackground(GRAY_COOL);
        historyScroll.setBackground(BG_DARK);

        JPanel historyPanel = new JPanel(new BorderLayout(0, 5));
        historyPanel.setBackground(BG_DARK);
        historyPanel.setPreferredSize(new Dimension(150, 0));
        historyPanel.setBorder(BorderFactory.createLineBorder(VIOLET_ACCENT));
        historyPanel.add(createHistoryHeader(), BorderLayout.NORTH);
        historyPanel.add(historyScroll, BorderLayout.CENTER);
        
        return historyPanel;
    }

    private JPanel createHistoryHeader() {
        JButton clearHistoryBtn = new JButton("x");
        clearHistoryBtn.setFont(new Font("SansSerif", Font.PLAIN, 12));
        clearHistoryBtn.setForeground(TEXT_SECONDARY);
        clearHistoryBtn.setBackground(BG_DARK);
        clearHistoryBtn.setBorderPainted(false);
        clearHistoryBtn.setFocusPainted(false);
        clearHistoryBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearHistoryBtn.setPreferredSize(new Dimension(25, 20));
        clearHistoryBtn.setToolTipText("Effacer l'historique");
        
        clearHistoryBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                clearHistoryBtn.setForeground(VIOLET_ACCENT);
            }
            public void mouseExited(MouseEvent e) {
                clearHistoryBtn.setForeground(TEXT_SECONDARY);
            }
        });
        
        clearHistoryBtn.addActionListener(e -> {
            calculatrice.clearHistorique();
            historyModel.clear();
        });

        JLabel historyLabel = new JLabel("Historique");
        historyLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
        historyLabel.setForeground(TEXT_SECONDARY);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(BG_DARK);
        header.add(historyLabel, BorderLayout.WEST);
        header.add(clearHistoryBtn, BorderLayout.EAST);
        
        return header;
    }

    private void setupKeyboard() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                char c = e.getKeyChar();
                int code = e.getKeyCode();

                if (c >= '0' && c <= '9') {
                    handleButton(String.valueOf(c));
                } else if (c == '.' || c == ',') {
                    handleButton(".");
                } else if (c == '+') {
                    handleButton("+");
                } else if (c == '-') {
                    handleButton("−");
                } else if (c == '*') {
                    handleButton("×");
                } else if (c == '/') {
                    handleButton("÷");
                } else if (c == '%') {
                    handleButton("%");
                } else if (code == KeyEvent.VK_ENTER || c == '=') {
                    handleButton("=");
                } else if (code == KeyEvent.VK_BACK_SPACE) {
                    handleButton("←");
                } else if (code == KeyEvent.VK_ESCAPE || c == 'c' || c == 'C') {
                    handleButton("C");
                }
                return true;
            }
            return false;
        });
    }

    /**
     * Contrôleur intégré - gère les actions utilisateur
     */
    private void handleButton(String text) {
        switch (text) {
            case "C":
                calculatrice.clear();
                break;
            case "←":
                calculatrice.backspace();
                break;
            case "±":
                calculatrice.toggleSign();
                break;
            case "%":
                calculatrice.percentage();
                break;
            case "÷": case "×": case "−": case "+":
                calculatrice.setOperator(text);
                break;
            case "=":
                calculatrice.calculate();
                break;
            case ".":
                calculatrice.addDecimal();
                break;
            default:
                calculatrice.addDigit(text);
                break;
        }
    }

    // Implémentation de CalculatriceListener (pattern Observer)
    @Override
    public void onDisplayChanged(String value) {
        display.setText(value);
    }

    @Override
    public void onExpressionChanged(String expression) {
        historyDisplay.setText(expression);
    }

    @Override
    public void onHistoryAdded(String entry) {
        historyModel.add(0, entry);
    }
}
