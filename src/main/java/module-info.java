module de.kozdemir.javaFXTaschenrechner {
    requires javafx.controls;
    requires javafx.fxml;

    opens de.kozdemir.javaFXTaschenrechner to javafx.fxml;
    opens de.kozdemir.javaFXTaschenrechner.controller to javafx.fxml;
    exports de.kozdemir.javaFXTaschenrechner;        
   
}
