/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opengg.module.swt.input;

import com.opengg.core.io.input.mouse.MouseButtonHandler;
import com.opengg.core.io.input.mouse.MouseController;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

/**
 *
 * @author Javier
 */
public class SWTMouseButtonHandler extends MouseButtonHandler implements MouseListener{

    @Override
    public void mouseDoubleClick(MouseEvent e) {
        
    }

    @Override
    public void mouseDown(MouseEvent e) {
        buttons[e.button - 1] = true;
        MouseController.buttonPressed(e.button - 1);
    }

    @Override
    public void mouseUp(MouseEvent e) {
        buttons[e.button - 1] = false;
        MouseController.buttonReleased(e.button - 1);
    }
    
}
