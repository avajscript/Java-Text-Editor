module org.example.javafxfirst {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.prefs;

    opens org.example.javafxfirst to javafx.fxml;
    opens org.example.javafxfirst.controllers to javafx.fxml;
    opens org.example.javafxfirst.controllers.dialogs to javafx.fxml;

    exports org.example.javafxfirst;
    exports org.example.javafxfirst.controllers;
    exports org.example.javafxfirst.controllers.dialogs;
}