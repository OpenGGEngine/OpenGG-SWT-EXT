/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opengg.module.swt.input;

import static com.opengg.core.io.input.keyboard.Key.*;
import com.opengg.core.io.input.keyboard.KeyboardController;
import com.opengg.core.io.input.keyboard.KeyboardHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

/**
 *
 * @author Javier
 */
public class SWTKeyboardHandler extends KeyboardHandler implements KeyListener{

    @Override
    public void keyPressed(KeyEvent e) {
        int nkey = SWTToGLFW(e.keyCode);
        if(nkey >= 65535){
            return;
        }
        if(keys[nkey] == false){
            KeyboardController.keyPressed(nkey); 
            keys[nkey] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int nkey = SWTToGLFW(e.keyCode);
        if(nkey >= 65535)
            return;
        if(keys[nkey] == true){
            KeyboardController.keyReleased(nkey); 
            keys[nkey] = false;
        }
    }
    
    public int SWTToGLFW(int key){
        if(key == SWT.SHIFT)
            return KEY_LEFT_SHIFT;
        else if(key == SWT.CONTROL)
            return KEY_LEFT_CONTROL;
        else if(key == SWT.ARROW_UP)
            return KEY_UP;
        else if(key == SWT.ARROW_DOWN)
            return KEY_DOWN;
        else if(key == SWT.ARROW_LEFT)
            return KEY_LEFT;
        else if(key == SWT.ARROW_RIGHT)
            return KEY_RIGHT;
        else if(key == SWT.ALT)
            return KEY_LEFT_ALT;
        else if(key == SWT.TAB)
            return KEY_TAB;
        else if(key == SWT.BS)
            return KEY_BACKSPACE;
        else if(key == SWT.DEL)
            return KEY_DELETE;
        else if(Character.isLetter(key))
            return Character.toUpperCase(key);
        return key;
    }
}
