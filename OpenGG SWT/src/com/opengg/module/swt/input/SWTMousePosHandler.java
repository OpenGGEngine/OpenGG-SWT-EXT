/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opengg.module.swt.input;

import com.opengg.core.io.input.mouse.MousePosHandler;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;

/**
 *
 * @author Javier
 */
public class SWTMousePosHandler extends MousePosHandler implements MouseMoveListener{
    
    double x, y;
    
    @Override
    public void mouseMove(MouseEvent e) {
        x = e.x;
        y = e.y;
        
    }
    
}
