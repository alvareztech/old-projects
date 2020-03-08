package signozodiacalfx;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextBox;
import javafx.scene.layout.HBox;
import javafx.geometry.VPos;
import javafx.geometry.HPos;

/**
 * @author Daniel
 */

Stage {
    title: "Application title"
    scene: Scene {
        width: 250
        height: 100
        content: [
            VBox {
                nodeVPos: VPos.CENTER
                spacing: 5
                content:
                [
                    HBox {
                        nodeHPos: HPos.CENTER
                        spacing: 5
                        content: [
                            Label {
                                text: "Dia de Nacimiento"
                                font: Font {
                                    size: 14
                                }

                            }
                            TextBox {
                                columns: 5
                                font: Font {
                                    size: 14
                                }

                            }
                        ]
                    }
                    HBox {
                        nodeHPos: HPos.CENTER
                        spacing: 5
                        content: [
                            Label {
                                text: "Mes de Nacimiento"
                                font: Font {
                                    size: 14
                                }

                            }
                            TextBox {
                                columns: 10
                                font: Font {
                                    size: 14
                                }

                            }
                        ]
                    }
                    Button {
                        text: "Aceptar"
                        font: Font {
                            size: 14
                        }
                        action: function()
                        {
                            buttonAction = "Accepted";
                            print("Hola Mundo")
                        }
                        
                    }
                ]
            }

        ]
    }
}