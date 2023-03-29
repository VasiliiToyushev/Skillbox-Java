import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel mainPanel;
    private JButton collapseButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public MainForm() {
        collapseButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (collapseButton.getText().equals("Collapse")){
                    if (textArea1.getText().length() == 0 ||
                            textArea2.getText().length() == 0 ||
                            textArea3.getText().length() == 0) {
                        JOptionPane.showMessageDialog(
                                mainPanel,
                                "Введите данные",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE
                        );
                    } else {
                        JOptionPane.showMessageDialog(
                                mainPanel,
                                textArea1.getText() + " " +
                                        textArea2.getText() + " " +
                                        textArea3.getText(),
                                "ok",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        collapseButton.setText("Expand");
                    }
            }
            else if (collapseButton.getText().equals("Expand")){
                    if (textArea1.getText().length() == 0 ||
                            textArea2.getText().length() == 0 ||
                            textArea3.getText().length() == 0) {
                        JOptionPane.showMessageDialog(
                                mainPanel,
                                "Введите данные",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE
                        );
                    } else {
                        JOptionPane.showMessageDialog(
                                mainPanel,
                                textArea1.getText() + " " +
                                        textArea2.getText() + " " +
                                        textArea3.getText(),
                                "ok",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        collapseButton.setText("Collapse");
                    }
                }
            }
        });
    }
}
