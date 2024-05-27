module com.github.evgenylizogubov.jshomework13 {
    requires javafx.controls;
    requires javafx.fxml;
    
    
    opens com.github.evgenylizogubov.jshomework13 to javafx.fxml;
    exports com.github.evgenylizogubov.jshomework13;
}