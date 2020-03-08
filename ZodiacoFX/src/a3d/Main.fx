package a3d;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.stage.AppletStageExtension;
import javafx.scene.input.MouseEvent;
import javax.swing.text.Style;
import javafx.stage.StageStyle;
import javafx.scene.paint.LinearGradient;

Stage {
    title: "ZodiacoFX | Daniel Alvarez"
    scene: Scene {
        width: 250
        height: 120
        var eti1: Label = Label {
                    layoutX: 20
                    layoutY: 20
                    text: "Dia de Nacimiento"
                }
        var eti2: Label = Label {
                    layoutX: 20
                    layoutY: 50
                    text: "Mes de Nacimiento"
                }
        var cbxDia: ChoiceBox = ChoiceBox {
                    layoutX: 130
                    layoutY: 20
                    items: [1..31]
                }
        var cbxMes: ChoiceBox = ChoiceBox {
                    layoutX: 130
                    layoutY: 50
                    items: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre']
                }
        var boton: Button = Button {
                    layoutX: 70
                    layoutY: 80
                    text: "Signo Zodiacal"
                    action: function() {
                        var dia = cbxDia.selectedIndex + 1;
                        var mes = cbxMes.selectedIndex + 1;
                        var signo;
                        if (mes == 1)
                            if (dia > 21) {
                                signo = "ACUARIO";
                            } else
                                signo = "CAPRICORNIO";
                        if (mes == 2)
                            if (dia > 19) {
                                signo = "PISCIS";
                            } else
                                signo = "ACUARIO";
                        if (mes == 3)
                            if (dia > 20) {
                                signo = "ARIES";
                            } else
                                signo = "PISCIS";
                        if (mes == 4)
                            if (dia > 20) {
                                signo = "TAURO";
                            } else
                                signo = "ARIES";
                        if (mes == 5)
                            if (dia > 21) {
                                signo = "GEMINIS";
                            } else
                                signo = "TAURO";
                        if (mes == 6)
                            if (dia > 20) {
                                signo = "CANCER";
                            } else
                                signo = "GEMINIS";
                        if (mes == 7)
                            if (dia > 22) {
                                signo = "LEO";
                            } else
                                signo = "CANCER";
                        if (mes == 8)
                            if (dia > 21) {
                                signo = "VIRGO";
                            } else
                                signo = "LEO";
                        if (mes == 9)
                            if (dia > 22) {
                                signo = "LIBRA";
                            } else
                                signo = "VIRGO";
                        if (mes == 10)
                            if (dia > 22) {
                                signo = "ESCORPION";
                            } else
                                signo = "LIBRA";
                        if (mes == 11)
                            if (dia > 21) {
                                signo = "SAGITARIO";
                            } else
                                signo = "ESCORPION";
                        if (mes == 12)
                            if (dia > 21) {
                                signo = "CAPRICORNIO";
                            } else
                                signo = "SAGITARIO";
                        Alert.inform("Su signo zodiacal es {signo}.");
                    }
                }
        content: [cbxDia, cbxMes, eti1, eti2, boton]
    }
}
