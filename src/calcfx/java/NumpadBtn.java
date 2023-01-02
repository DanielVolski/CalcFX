package calcfx.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class NumpadBtn {
    @FXML private TextArea expression;
    
    public static Button valueOf(String value) {
        return new Button(value);
    }

    public void onClickHandler(ActionEvent event) {
        expression.setText(expression.getText() + ((Button)event.getSource()).getText());
    }

    public void onClickDelHandler(ActionEvent event) {
        if (!expression.getText().isEmpty())
            expression.setText(expression.getText().substring(0, expression.getText().length() - 1));
    }

    public void onClickEquals(ActionEvent event) {
        if (!expression.getText().isEmpty())
        {
            String teste = Evaluator.evaluate(expression.getText()).toString();
            if (teste.charAt(teste.length() - 1) == '0' && teste.charAt(teste.length() - 2) == '.') {
                teste = teste.substring(0, teste.length() - 2);
            }
            expression.setText(teste);
        }
    }
}
