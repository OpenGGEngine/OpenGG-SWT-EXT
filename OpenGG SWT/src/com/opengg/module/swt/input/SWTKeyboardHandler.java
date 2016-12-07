/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opengg.module.swt.input;

import com.opengg.core.io.input.keyboard.KeyboardController;
import com.opengg.core.io.input.keyboard.KeyboardHandler;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

/**
 *
 * @author Javier
 */
public class SWTKeyboardHandler extends KeyboardHandler implements KeyListener{

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.keyCode] = true;
        KeyboardController.keyPressed(e.keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.keyCode] = false;
        KeyboardController.keyReleased(e.keyCode);
    }
    
}
