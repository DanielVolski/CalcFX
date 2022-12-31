package calcfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class NumpadBtn {
    @FXML private Label labelTest;
    
    public static Button valueOf(String value) {
        return new Button(value);
    }

    public void onClickHandler(ActionEvent event) {
        labelTest.setText(labelTest.getText() + ((Button)event.getSource()).getText());
    }

    public void onClickDelHandler(ActionEvent event) {
        if (!labelTest.getText().isEmpty()) {
            labelTest.setText(labelTest.getText().substring(0, labelTest.getText().length() - 1));
        }
    }
}
