/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk.util;

import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.TimelineBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorAdjustBuilder;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 *
 * @author nick
 */
public class FXutils {

    private static final double SCALE = 1.3; // коэффициент увеличения
    private static final double DURATION = 300; // время анимации в мс

    public static Node createButton(Class cls, String iconName, final Runnable action, boolean withReflection) {
        // загружаем картинку
        final ImageView node;
        node = new ImageView(new Image(cls.getResource(iconName).toString()));

        // создаём анимацию увеличения картинки      
        final ScaleTransition animationGrow = new ScaleTransition(Duration.valueOf("" + DURATION + "ms"), node);
        animationGrow.setToX(SCALE);
        animationGrow.setToY(SCALE);

        // и уменьшения
        final ScaleTransition animationShrink = new ScaleTransition(Duration.valueOf("" + DURATION + "ms"), node);
        animationShrink.setToX(1);
        animationShrink.setToY(1);

        final Reflection effect = new Reflection();
        if (withReflection) {
            // добавляем эффект отражения
            node.setEffect(effect);
        }

        final ColorAdjust effectPressed = ColorAdjustBuilder.create().brightness(-0.5d).build();
        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                // в обработчике нажатия применяем эффект. Тут имеется следующая тонкость: это уже второй эффект для кнопки,
                // поэтому мы его выставляем не напрямую, а как input для первого эффекта
                effect.setInput(effectPressed);
                // создаём Timeline, который через 300 мс отключит затемнение.
                TimelineBuilder.create().keyFrames(new KeyFrame(Duration.valueOf("300ms"), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        effect.setInput(null);
                    }
                })).build().play();
            }
        });

        // обработчик нажатия мыши
        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                action.run();
            }
        });
        // при наведении курсора мы запускаем анимацию увеличения кнопки
        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                node.toFront();
                animationShrink.stop();
                animationGrow.playFromStart();
            }
        });
        // когда курсор сдвигается -- запускаем анимацию уменьшения
        node.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                animationGrow.stop();
                animationShrink.playFromStart();
            }
        });
        return node;
    }

    public static Node createButton(Class cls, String iconName, final Runnable action) {
        return createButton(cls, iconName, action, false);
    }

    public static void RestrictNumbersOnly(final TextField tf) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("|[-\\+]?|[-\\+]?\\d+\\,?|[-\\+]?\\d+\\,?\\d+")) {
                    tf.setText(oldValue);
                }
            }
        });
    }

    public static void RestrictNumbersFields(TextField[] tl) {
        for (TextField tf : tl) {
            if (tf != null) {
                RestrictNumbersOnly(tf);
            }
        }
    }

    public static void setAutyoCompleteCombos(ComboBox[] cbs) {
        for (ComboBox cb : cbs) {
            if (cb != null) {
                new AutoCompleteComboBoxListener(cb);
                cb.getItems().clear();
            }
        }
    }
    
    public static void clearTextFields(TextInputControl[] tl) {
        for (TextInputControl tc : tl) {
            if (tc != null) {
                tc.setText("");
            }
        }
    }
}
